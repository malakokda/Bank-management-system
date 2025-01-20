/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author malak
 */
public  class Savings extends Account {
 public Savings() {
        super(); // Call the no-argument constructor of Account
       // this.state = "Savings";
 }
 public Savings(String accnum, String name, String mail, String balance, String mobnum, String date, String state) {
        super(accnum, name, mail, balance, mobnum, date, state);
    }
    
   
 @Override
 public  String takefrom(double balance,double amount)    {
    
    balance = balance-amount;
    String mybalance=String.valueOf(balance);
   
    return mybalance;
}
 @Override
  public int transfer(String fromacc, String toacc ,String amount){
          readfile();
        if (fromacc.equals(toacc)) {
            return 4;//will quit the method and send it to the Gui to display that there will be no transfer as theyare the same account
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String format = now.format(formatter);
        int x = 5;
        try {

            if (!ispresentaccno(fromacc)) {
                x = 1;
                return x;
            }
            if (!ispresentaccno(toacc)) {
                x = 2;
                return x;
            }
           
 double money = tonumber(amount);
  if(money==3){return 3;}
            if (money > 10000) {
                x = 3;
                return x;
            }
             int y = equaltoaccnum(fromacc);
            String b = saveaccounts.get(y).getBalance();
            double mybalance1 = tonumber(b);
            if (mybalance1 > money){
                mybalance1 = mybalance1-money;
                String balance=String.valueOf(mybalance1);
                saveaccounts.get(y).setBalance(balance);
             int yy = equaltoaccnum(toacc);
            String bb = saveaccounts.get(yy).getBalance();
            double mybalance2 = tonumber(bb);
            mybalance2 = mybalance2+money; 
             String fBalance = String.valueOf(mybalance2);
              saveaccounts.get(yy).setBalance(balance);
            x = 0;
            writefile();
            transaction t1 = new transaction(fromacc, "Transfer from", amount+"", format, "Transfer " + amount+" to "+toacc);
            transaction t2 = new transaction(toacc, "Transfer to", amount+"", format, "Transfer " + amount+" from "+fromacc);
            trans.add(t1);
            trans.add(t2);
            transHistory.add(t1);
            transHistory.add(t2);
            createtxt(t1);
            createtxt(t2);
            }
            else{return 6;}
              } catch (Exception e) {
            System.out.println("Error found 2" + e.getMessage());
            return 5;
        } 
    return x;
}
    @Override
    public int applyinterset() {
int x=5;      
        try{   //LocalDateTime now = LocalDateTime.now();
          //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //String ftime = now.format(formatter);

   
        readfile();
        int s= saveaccounts.size();
       // System.out.println(s);
      //  saveaccounts.clear();
        for(int i=0;i<s;i++)
        { readfile();//we re read the file because writfile method clears save accounts after it finishesso in the loop it will check all the accounts in the file without it an index out of bond exception will appear after the first saving account
            int z=0;
          if(  saveaccounts.get(i).getState().equals("Savings")&&saveaccounts.get(i) != null)
          {z++;
          
              String date = saveaccounts.get(i).getDate();
              DateTimeFormatter  form= DateTimeFormatter.ofPattern("dd-MM-yyyy");
              long difference = ChronoUnit.MONTHS.between(LocalDate.parse(date,form), LocalDate.now());
              if(difference>=4){
              
          String money = saveaccounts.get(i).getBalance();
          double amount = tonumber(money);
          amount = amount +(amount*0.05);
          String ss=Double.toString(amount);
          //System.out.println(ss);
          saveaccounts.get(i).setBalance(ss);
          writefile();
          x=0;
           System.out.println(z);

                               }
          }
        }}catch (Exception e) {
            System.out.println("Error found "+ e.getMessage());
        e.printStackTrace();}
       // System.out.println(x);
              return x;
    }
}
