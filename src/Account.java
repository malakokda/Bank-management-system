/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malak
 */
public abstract class Account {

    String accnum;
    String name;
    String mail;
    String balance;
    String mobnum;
    String date;
    String state;
    private static ArrayList<String> stringuser = new ArrayList<>();
    private static ArrayList<String> stringpass = new ArrayList<>();
    static ArrayList<Account> saveaccounts = new ArrayList<>();
    static ArrayList<transaction> trans = new ArrayList<>();
    static ArrayList<transaction> transHistory = new ArrayList<>();

    public Account() {
        this.accnum = "";
        this.name = "";
        this.mail = "";
        this.balance = "";
        this.mobnum = "";
        this.date = "";
        this.state = "";
    }

    public Account(String accnum, String name, String mail, String balance, String mobnum, String date, String state) {
        this.accnum = accnum;
        this.name = name;
        this.mail = mail;
        this.balance = balance;
        this.mobnum = mobnum;
        this.date = date;
        this.state = state;
    }

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
public double getdoublebalance(){
    return Double.parseDouble(balance);
}
    public Date getParsedDate() {//make date from string to date format to get compared with other dates for sorting
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");//format in the form of dd-mm-yyyy
            return sdf.parse(date); // Parse the date string to Date object
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    }

    public static ArrayList<Account> getarray() {
        saveaccounts.clear();
        readfile();
        return saveaccounts;
    }

    public static ArrayList<transaction> historyy() {
        return trans;
    }
    public static int readtrans(String accnum){
        int x=5;
        readfile();
        if (!ispresentaccno(accnum)) {
            x = 3;
            return x;}
       
        String filename= accnum+".txt";
         
         try {
            
            File f = new File(filename);
            if(f.exists()&&f.isFile()){
            Scanner s = new Scanner(f);
            Scanner scan = new Scanner(System.in);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] std = data.split(",");
                String accnumber = std[0].trim();
                //if(accnumber.length()!=10){return 2;}
                //for(int i=0;i<accnumber.length();i++){if(!Character.isDigit(accnumber.charAt(i))){break;}}
                String amount = std[1].trim();
                //if(tonumber(amount)==3){return 2;}
                String ttype = std[2].trim();
                // if(ttype){}
                String datee = std[3].trim();
                String details = std[4].trim();
               transaction t1 = new transaction(accnum, ttype,amount,datee,details );
            trans.add(t1);
           // transHistory.add(t1);
             x= 0;
            
            }
           
        }else{return 6; }}catch (FileNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            x=1;
        }
            return x;
    }
    public static void readfile() {

        try {
            saveaccounts.clear();
            File f = new File("accounts.txt");
            //  f.setWritable(true, true);
            Scanner s = new Scanner(f);
            Scanner scan = new Scanner(System.in);
            while (s.hasNextLine()) {

                String data = s.nextLine();

                String[] std = data.split(",");
                if (std.length < 7) {
                    System.out.println("Skipping malformed line: " + data);
                    continue;
                }
                String accnumber = std[0].trim();
                if(accnumber.length()!=10){break;}
                for(int i=0;i<accnumber.length();i++){if(!Character.isDigit(accnumber.charAt(i))){break;}}
                String name = std[1].trim();
                if(!isValidName(name)){break;}
                String name1 = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                String email = std[2].trim();
                if(!isValidEmail(email)){break;}
                String money = std[3].trim();
                if(tonumber(money)==3){break;}
                String phnumber = std[4].trim();
                if(!isValidphone(phnumber)){break;}
                String date = std[5].trim();
                String state = std[6].trim();
                if (state.equals("Savings")) {
                    Account newacc = new Savings(accnumber, name1, email, money, phnumber, date, state);
                    saveaccounts.add(newacc);
                   // System.out.println("Contents of saveaccounts: " + saveaccounts);
                }
                if (state.equals("Current")) {
                    Account newacc = new Current(accnumber, name1, email, money, phnumber, date, state);
                    saveaccounts.add(newacc);
                }
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

      //  System.out.println("Contents of saveaccounts: " + saveaccounts);
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
    public static void readfromfileuser() {

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
    public static boolean check(String user, String pass) {//for login to check if username and password found or not
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
    public static void createtxt(transaction r) {
        int s = trans.size();
        for (int i = 0; i < s; i++) {
            transaction rr = trans.get(i);
            File file = new File(rr.getAccnum() + ".txt");
            String t = rr.getAccnum() + "," + rr.getAmount() + "," + rr.getType() + "," + rr.getDate() + "," + rr.getDetails();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(t);
                writer.newLine();
                System.out.println(t);

            } catch (IOException ex) {
                Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            }
        }trans.clear();

    }
    public static int checkstate(String accnum){//check if account savings or current account
    readfile();
    int x=5;
    int s=saveaccounts.size();
    for(int i=0;i<s;i++){
        if(saveaccounts.get(i).getAccnum().equals(accnum)){
            if(saveaccounts.get(i).getState().equals("Savings")){x=2; return x;}
            else{x=3; return x;}
        
        
        }else{x=1;}
    }
    return x;
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
            String name1 = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            String a = accnum();
            pw.print(a + ",");
            pw.print(name1 + ",");
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
                    String name1 = n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
                    saveaccounts.get(y).setName(name1);
                    x = 0;
                } else {
                    x = 6;
                    //System.out.println("not name");
                }
            }
            if (tomodify.equals("Mobile_number")) {
                if (isValidphone(n)) {
                    saveaccounts.get(y).setMobnum(n);
                    x = 0;
                } else {
                    x = 7;
                    // System.out.println("not number");
                }
            }
            if (tomodify.equals("Email_address")) {
                if (isValidEmail(n)) {
                    saveaccounts.get(y).setMail(n);
                    x = 0;

                } else {
                    x = 8;
                    //System.out.println("not email");
                }
            }
        }
        if (x == 0) {
//        System.out.println("Contents of saveaccounts: " + saveaccounts);
            writefile();
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
    public static int withdraw(String accnumtowd, String amount) {
        int x = 5;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String format = now.format(formatter);
        try {
            readfile();
            if (!ispresentaccno(accnumtowd)) {
                x = 1;
                return x;
            }
            double money = tonumber(amount);
             if(money==3){return 3;}
            if (money > 10000) {
                x = 2;
                return x;
            }
            int y = equaltoaccnum(accnumtowd);
            String b = saveaccounts.get(y).getBalance();
            double mybalance = tonumber(b);
            if (mybalance > money) {
                if (saveaccounts.get(y).getState().equals("Savings")) {
                    Account s = new Savings();
                    String z = s.takefrom(mybalance, money);
                    saveaccounts.get(y).setBalance(z);
                  
                } else if (saveaccounts.get(y).getState().equals("Current")) {
                    Account ss = new Current();
                    String zz = ss.takefrom(mybalance, money);
                    saveaccounts.get(y).setBalance(zz);
                 
                }
                x = 0;
                if (saveaccounts.get(y).getState().equals("Current") && money < 1000) {
                    x = 10;
                }
                writefile();
                transaction t = new transaction(accnumtowd, "Withdraw", amount, format, "withdraw " + amount);
                trans.add(t);
                transHistory.add(t);
                createtxt(t);}
else {
                x = 4;
            }
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        }
        return x;
    }
    public static int deposit(String accnumtod, String amount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String format = now.format(formatter);
        int x = 5;
        try {

            readfile();
            if (!ispresentaccno(accnumtod)) {
                x = 1;
                return x;
            }
            if (amount.isEmpty()) {
                x = 7;
                return x;
            }
            double money = tonumber(amount);
            if(money==3){return 3;}
            if (money > 10000) {
                x = 2;
                return x;
            }
            int y = equaltoaccnum(accnumtod);
            String b = saveaccounts.get(y).getBalance();
            double mybalance = tonumber(b);
            double finalBalance = mybalance + money;
            String fBalance = String.valueOf(finalBalance);
            saveaccounts.get(y).setBalance(fBalance);
            x = 0;
            writefile();
            transaction t = new transaction(accnumtod, "Deposit", amount, format, "Deposit " + amount);
            trans.add(t);
             transHistory.add(t);
            createtxt(t);
        } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        }
        return x;
    }
    public abstract int transfer(String fromacc,String toacc,String amount);
    
    public static ArrayList<Account> searchh(String ns) {//for Gui search
        readfile();//
        ArrayList<Account> found = new ArrayList<>();
        int s = saveaccounts.size();
        String ns1 = ns.toLowerCase();
        for (int i = 0; i < s; i++) {
            String ds = saveaccounts.get(i).getName().toLowerCase();
            if (ds.contains(ns1)) {//||saveaccounts.get(i).getName().equals(ns1)
                found.add(saveaccounts.get(i)); //found is the arraylist we send to the gui
            }
        }
        return found;
    }

    public abstract int applyinterset();

    public static int equaltoaccnum(String accnumTOm) { //used  to check for the needed account number and return index of it in the arraylist of the accounts

        int y = -1;
        for (int i = 0; i < saveaccounts.size(); i++) {
            if (saveaccounts.get(i).getAccnum().equals(accnumTOm)) {
                y = i;
            }

        }
        return y;
    }

    public static String accnum() {// generate acc num of 10 random digits for new accounts 
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
        try {
            double number = Double.parseDouble(amount);
              return number;
        } catch (NumberFormatException ex) {
            return 3;
        }
      
    }

    public abstract String takefrom(double balance, double amount);

    @Override
    public String toString() {
        return accnum + "," + name + "," + mail + "," + balance + "," + mobnum + "," + date + "," + state;
    }
}
