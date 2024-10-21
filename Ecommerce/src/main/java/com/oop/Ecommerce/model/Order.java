package com.oop.Ecommerce.model;

public class Order {
    private String orderId;
    private String orderDate;
    private String status;
    private String shipping;

    public Order() {
    }

    public Order(String orderDate, String status, String shipping) {
        this.orderDate = orderDate;
        this.status = status;
        this.shipping = shipping;
    }

    public Order(String orderId, String orderDate, String status, String shipping) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.shipping = shipping;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
}
