/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Huy
 */
public class TransactionDTO implements Serializable {

    private static final long serialVersionUID = 1L; // Đảm bảo tính tương thích khi tuần tự hóa
    private static int idCounter = 1; // Bộ đếm tự động tăng cho categoryID

    private String purchaseID;
    private String userID;
    private String userName;
    private String userPhone;
    private String productID;
    private String productName;
    private Integer productPurchaseQuantity;
    private Double productPrice;
    private Double totalPrice;
    private String purchaseDate;
    private String address;
    private String receivedDate;
    private String supplierName;
    private String status;

    // Constructor không tham số
    public TransactionDTO() {
    }

    // Constructor đầy đủ tham số
    public TransactionDTO(String purchaseID, String userID, String userName,
            String userPhone, String productID, String productName,
            Integer productPurchaseQuantity, Double productPrice,
            String purchaseDate, String address, String receivedDate, String supplierName, String status) {
        this.purchaseID = purchaseID;
        this.userID = userID;
        this.userName = userName;
        this.userPhone = userPhone;
        this.productID = productID;
        this.productName = productName;
        this.productPurchaseQuantity = productPurchaseQuantity;
        this.productPrice = productPrice;
        this.totalPrice = this.productPurchaseQuantity * this.productPrice;
        this.purchaseDate = purchaseDate;
        this.address = address;
        this.receivedDate = receivedDate;
        this.supplierName = supplierName;
        this.status = status;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        TransactionDTO.idCounter = idCounter;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPurchaseQuantity() {
        return productPurchaseQuantity;
    }

    public void setProductPurchaseQuantity(Integer productPurchaseQuantity) {
        this.productPurchaseQuantity = productPurchaseQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
