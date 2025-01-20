/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject;

/**
 *
 * @author malak
 */
public class transaction {
    String Accnum;
    String type;
    String Amount;
    String date;
    String details;

    public transaction(String Accnum, String type, String Amount, String date, String details) {
        this.Accnum = Accnum;
        this.type = type;
        this.Amount = Amount;
        this.date = date;
        this.details = details;
    }

    public String getAccnum() {
        return Accnum;
    }
    public String getType() {
        return type;
    }
    public String getAmount() {
        return Amount;
    }
    public String getDate() {
        return date;
    }
    public String getDetails() {
        return details;
    }

    public void setAccnum(String Accnum) {
        this.Accnum = Accnum;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAmount(String Amount) {
        this.Amount = Amount;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDetails(String details) {
        this.details = details;
    }
     @Override
    public String toString() {
        return Accnum + "," + type + "," + Amount + "," + date + "," + details ;
    }
}
