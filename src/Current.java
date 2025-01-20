/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author malak
 */
public class  Current extends Account {
public Current() {
        super(); // Call the no-argument constructor of Account
       // this.state = "Current";
}
    public Current(String accnum, String name, String mail, String balance, String mobnum, String date, String state) {
        super(accnum, name, mail, balance, mobnum, date, state);
    }
    @Override
    public  String takefrom(double balance,double amount)    {
    double newAmount = amount +10;
    if(amount <1000){balance = balance -newAmount;}
    else if (amount>1000||amount ==1000){ balance = balance-amount;}
    String mybalance=String.valueOf(balance);
   
    return mybalance;
}
@Override
    public int transfer(String fromacc,String toacc,String amount){
            readfile();
        if (fromacc.equals(toacc)) {
            return 4;
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
                double newmoney = money +10;//adding 10$fees for currentaccounts
                mybalance1 = mybalance1-newmoney;
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
            transaction t1 = new transaction(fromacc, "Transfer", amount+" + 10$ fees", format, "Transfer " + amount+" to "+toacc);
            transaction t2 = new transaction(toacc, "Transfer", amount, format, "Transfer " + amount+" from "+fromacc);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
