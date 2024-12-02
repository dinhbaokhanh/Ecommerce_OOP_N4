/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;

/**
 *
 * @author Huy
 */
public class SupplierDAO implements Serializable {

    private static final long serialVersionUID = 1L;  // Add a version UID for serialization compatibility
    public static int idCounter = 1;
    private String supplierID;
    private String supplierName;
    private String supplierEmail;
    private String supplierPassword;
    private String supplierPhone;
    private String supplierAddress;

    // Default constructor
    public SupplierDAO() {
        this.supplierID = String.valueOf(idCounter++);
    }

    // Constructor with all fields except ID
    public SupplierDAO(String supplierName, String supplierEmail, String supplierPassword, String supplierPhone, String supplierAddress) {
        this.supplierID = String.valueOf(idCounter++);
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPassword = supplierPassword;
        this.supplierPhone = supplierPhone;
        this.supplierAddress = supplierAddress;
    }

    // Constructor with ID and all other fields
    public SupplierDAO(String supplierID, String supplierName, String supplierEmail, String supplierPassword, String supplierPhone, String supplierAddress) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPassword = supplierPassword;
        this.supplierPhone = supplierPhone;
        this.supplierAddress = supplierAddress;
    }

    // Getter and Setter methods
    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierPassword() {
        return supplierPassword;
    }

    public void setSupplierPassword(String supplierPassword) {
        this.supplierPassword = supplierPassword;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
}
