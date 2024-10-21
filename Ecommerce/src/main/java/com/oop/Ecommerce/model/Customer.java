package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {

    @NotBlank(message = "Shipping address is mandatory")
    private String shippingAddress; // Địa chỉ giao hàng

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderHistory = new ArrayList<>(); // Lịch sử đơn hàng

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart; // Giỏ hàng của khách hàng

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>(); // Danh sách đánh giá của khách hàng

    // Constructor mặc định
    public Customer() {}

    public Customer(String userId, String name, String email, String password, Role role, String shippingAddress) {
        super(userId, name, email, password, role); // Gọi constructor của lớp cha (User)
        this.shippingAddress = shippingAddress;
    }

    public Customer(String name, String email, String password, Role role, String shippingAddress) {
        super(name, email, password, role); // Gọi constructor của lớp cha (User)
        this.shippingAddress = shippingAddress;
    }

    // Getters và Setters
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
        review.setCustomer(this); // Thiết lập khách hàng cho đánh giá
    }
}
