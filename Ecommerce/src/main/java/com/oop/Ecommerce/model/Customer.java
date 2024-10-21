package com.oop.Ecommerce.model;


public class Customer extends User{

    private String shippingAddress;

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Customer(int userId, String name, String email, String password, Role role) {
        super(userId, name, email, password, role);
    }
}
