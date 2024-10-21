package com.oop.Ecommerce.model;

import jakarta.persistence.*;

@Entity
public class ShippingTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackingId;

    private String trackingNumber; // Số theo dõi

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order; // Mối quan hệ với đơn hàng

    private String shippingMethod; // Phương thức vận chuyển

    private String carrier; // Nhà vận chuyển

    private String status; // Trạng thái (ví dụ: "In Transit", "Delivered")

    // Constructor mặc định
    public ShippingTracker() {}

    // Constructor với tất cả các thuộc tính
    public ShippingTracker(String trackingNumber, Order order, String shippingMethod, String carrier, String status) {
        this.trackingNumber = trackingNumber;
        this.order = order;
        this.shippingMethod = shippingMethod;
        this.carrier = carrier;
        this.status = status;
    }

    // Getters và Setters
    public Long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Long trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
