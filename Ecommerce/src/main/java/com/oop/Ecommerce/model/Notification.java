package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId; // Khóa chính cho bảng Notification

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "userId")
    private Customer customer; // Mối quan hệ với khách hàng

    private String message; // Nội dung thông báo

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate; // Ngày gửi thông báo

    // Constructor mặc định
    public Notification() {}

    // Constructor với tất cả các thuộc tính
    public Notification(Customer customer, String message, Date sentDate) {
        this.customer = customer;
        this.message = message;
        this.sentDate = sentDate;
    }

    // Getters và Setters
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
}
