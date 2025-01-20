/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author malak
 */
public class Fproject {
 
 
 
 
   /* private static ArrayList<String> stringuser = new ArrayList<>();
    private static ArrayList<String> stringpass = new ArrayList<>();
    private static ArrayList<Account> saveaccounts = new ArrayList<>();
    String accnum;
    String name;
    String mail;
    String balance;
    String mobnum;
    String date;
    String state;

    public String getAccnum() {
        return accnum;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getBalance() {
        return balance;
    }

    public String getMobnum() {
        return mobnum;
    }

    public String getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setMobnum(String mobnum) {
        this.mobnum = mobnum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setState(String state) {
        this.state = state;
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

 /*   public static void readfromfileuser() {

        try {
            File f = new File("users.txt");
            Scanner s = new Scanner(f);
            Scanner scan = new Scanner(System.in);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] std = data.split(" ");
                String fuser = std[0].trim();
                String fpass = std[1].trim();
                stringuser.add(fuser);
                stringpass.add(fpass);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found ");
        } catch (Exception e) {
            System.out.println("Error found ");
        }

    }

  public static void readfile() {

        try {
            saveaccounts.clear();
            File f = new File("accounts.txt");
            Scanner s = new Scanner(f);
            Scanner scan = new Scanner(System.in);
            while (s.hasNextLine()) {

                String data = s.nextLine();

                if (data.isEmpty()) {
                    continue;
                }

                String[] std = data.split(",");
                if (std.length < 7) {
                    System.out.println("Skipping malformed line: " + data);
                    continue;
                }
                String accnumber = std[0].trim();
                String name = std[1].trim();
                String email = std[2].trim();
                String money = std[3].trim();
                String phnumber = std[4].trim();
                String date = std[5].trim();
                String state = std[6].trim();
                if(state.equals("Savings")){ Account newacc = new Savings(accnumber, name, email, money, phnumber, date, state);
                 saveaccounts.add(newacc);}
                if(state.equals("Current")){ Account newacc = new Current(accnumber, name, email, money, phnumber, date, state);
                 saveaccounts.add(newacc);}
               // Account newacc = new Account(accnumber, name, email, money, phnumber, date, state);
               
            }
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found2 ");
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
        }

    }

    public static void writefile() {

        System.out.println("Contents of saveaccounts: " + saveaccounts);
        try {
            File f = new File("accounts.txt");
            FileWriter fw = new FileWriter(f, false);
            try (BufferedWriter Writer = new BufferedWriter(fw);) //  PrintWriter pw = new PrintWriter(fw)) 
            {
                int w = saveaccounts.size();
                for (int i = 0; i < w; i++) {
                    Writer.write(saveaccounts.get(i).toString());
                    Writer.newLine();
                }
            }
            saveaccounts.clear();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found2 ");
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
        }
    }

   public static int add(String name, String Email, String number, String type) {
        int x = 0;
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedTime = now.format(formatter);

            File f = new File("accounts.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            String a = accnum();
            pw.print(a + ",");
            pw.print(name + ",");
            pw.print(Email + ",");
            pw.print("0" + ",");
            pw.print(number + ",");
            pw.print(formattedTime + ",");
            pw.println(type);
            pw.close();
            saveaccounts.clear();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found1 ");
            x = 1;
        } catch (Exception e) {
            System.out.println("Error found1 " + e.getMessage());
            x = 1;
        }
        return x;
    }

    public static String accnum() {
        readfile();
        Random r = new Random();
        String resultstring;

        StringBuilder ss = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = r.nextInt(10);
            ss.append(index);
        }
        resultstring = ss.toString();
        return resultstring;
    }

    public static boolean check(String user, String pass) {
        boolean x = false;
        readfromfileuser();
        for (int i = 0; i < stringuser.size(); i++) {
            if (user.equals(stringuser.get(i)) && pass.equals(stringpass.get(i))) {
                x = true;
                break;
            }
        }
        return x;
    }

    public static int modify(String accnumTOm, String tomodify, String n) throws IOException {
        int x = 3;
        readfile();
        if (!ispresentaccno(accnumTOm)) {
            x = 1;
            return x;
        }
        int y = equaltoaccnum(accnumTOm);
        //System.out.println(y);
        if (!(y == -1)) {
            if (tomodify.equals("Name")) {
                if (isValidName(n)) {
                    saveaccounts.get(y).setName(n);
                    x = 0;
                }
            } else {
                System.out.println("not name");
            }
            if (tomodify.equals("Mobile_number")) {
                if (isValidphone(n)) {
                    saveaccounts.get(y).setMobnum(n);
                    x = 0;
                }
            } else {
                System.out.println("not number");
            }
            if (tomodify.equals("Email_address")) {
                if (isValidEmail(n)) {
                    saveaccounts.get(y).setMail(n);
                    x = 0;

                }
            } else {
                System.out.println("not email");
            }
        }
        if (x == 0) {
//        System.out.println("Contents of saveaccounts: " + saveaccounts);
            writefile();
            /*   File f = new File("accounts.txt");
FileWriter fw = new FileWriter(f, false);
try (  BufferedWriter Writer = new BufferedWriter(fw);)
//  PrintWriter pw = new PrintWriter(fw))
{
int w = saveaccounts.size();
for (int i = 0; i < w; i++) {
Writer.write(saveaccounts.get(i).toString());
Writer.newLine();
}   }
        }

        return x;

    }

    public static int withdraw(String accnumtowd, String amount) {
        int x = 5;
        try {
            readfile();
            if (!ispresentaccno(accnumtowd)) {
                x = 1;
                return x;
            }
            double money = tonumber(amount);
            if (money > 10000) {
                x = 2;
                return x;
            }
            int y = equaltoaccnum(accnumtowd);
            String b = saveaccounts.get(y).getBalance();
            double mybalance = tonumber(b);
            if (mybalance > money) {
                if (saveaccounts.get(y).getState().equals("Savings")) {
                    String z = Savings.takefrom(mybalance, money);
                    saveaccounts.get(y).setBalance(z);
                } else if (saveaccounts.get(y).getState().equals("Current")) {
                    String zz = Current.takefrom(mybalance, money);
                    saveaccounts.get(y).setBalance(zz);
                }
                x = 0;
                if (saveaccounts.get(y).getState().equals("Current") && money < 1000) {
                    x = 10;
                }
                writefile();
            } else {
                x = 4;
            }
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        }
        return x;
    }

    public static int deposit(String accnumtowd, String amount) {
        int x = 5;
        try {

            readfile();
            if (!ispresentaccno(accnumtowd)) {
                x = 1;
                return x;
            }
            double money = tonumber(amount);
            if (money > 10000) {
                x = 2;
                return x;
            }
            int y = equaltoaccnum(accnumtowd);
            String b = saveaccounts.get(y).getBalance();
            double mybalance = tonumber(b);
            double finalBalance = mybalance + money;
            String fBalance = String.valueOf(finalBalance);
            saveaccounts.get(y).setBalance(fBalance);
            x = 0;
            // System.out.println(deposit +saveaccounts);
            writefile();
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        }
        return x;
    }

    public static int transfer(String fromacc, String toacc, String amount) {
        int x = 5;
        try { readfile();
            if (!ispresentaccno(fromacc)) {
                x = 1;
                return x;
            }
            if (!ispresentaccno(toacc)) {
                x = 2;
                return x;
            }
            int y = withdraw(fromacc, amount);
            int z = deposit(toacc, amount);
            if (y == 0 || y == 10) {
                if (z == 0) {
                    x = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        }

        return x;
    }

    public static int closeacc(String accnum) {
        int x = 0;

        readfile();

        if (!ispresentaccno(accnum)) {
            x = 1;
            return x;
        }
        int z = equaltoaccnum(accnum); //get the index of user in the arraylist
        if (!saveaccounts.get(z).getBalance().equals("0")) {
            x = 2;
            return x;
        }
        if (x == 0) {
            saveaccounts.remove(z);
            writefile();
        }
        return x;
    }

    public static int equaltoaccnum(String accnumTOm) {

        int y = -1;
        for (int i = 0; i < saveaccounts.size(); i++) {
            if (saveaccounts.get(i).getAccnum().equals(accnumTOm)) {
                y = i;
            }

        }
        return y;
    }

    public static boolean ispresentaccno(String tolook) {

        boolean x = false;
        for (Account account : saveaccounts) {
            if (account.getAccnum().equals(tolook)) {
                x = true;
            }
        }
        return x;
    }

    public static boolean isValidphone(String phone) {
        if (phone == null) {
            return false;
        }
        if (phone.length() != 11) {
            return false;
        }
        String p1 = phone.substring(0, 3);
        if (!(p1.equals("010") || p1.equals("011") || p1.equals("012") || p1.equals("015"))) {
            return false;
        }

        return phone.matches("[0-9]+");
    }

    public static boolean isValidEmail(String email) {
        //need to check if email is already with other account or not 
        if (email == null) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }
        String p1 = parts[0];
        String p2 = parts[1];
        if (p1.length() < 4 || p1.length() > 15) {
            return false;
        }
        if (p1.contains(",")) {
            return false;
        }

        if (!(p2.equals("hotmail.com") || p2.equals("gmail.com") || p2.equals("icloud.com") || (p2.equals("outlook.com")))) {
            return false;
        }

        return true;
    }

    public static boolean isValidName(String name) {

        if (name == null) {
            return false;
        }
        return name.matches("^[a-zA-Z\s]+$");
    }

    public static double tonumber(String amount) {
        double number = Double.parseDouble(amount);
        return number;
    }*/
}
