/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class UserBalanceDAO implements Serializable {

    private static final long serialVersionUID = 1L;  // Add a version UID for serialization compatibility
    public static int idCounter = 1;

    private String userID;
    private Double balance;

    public UserBalanceDAO() {
    }

    public UserBalanceDAO(String userID, Double balance) {
        this.userID = userID;
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
