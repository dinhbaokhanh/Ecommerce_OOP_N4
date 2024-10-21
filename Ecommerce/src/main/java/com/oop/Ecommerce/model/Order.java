package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotNull(message = "Customer is mandatory")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "userId")
    private User customer; // Mối quan hệ với User (khách hàng)

    @NotNull(message = "Order date is mandatory")
    private LocalDate orderDate;

    @NotNull(message = "Status is mandatory")
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // Enum để lưu trạng thái của đơn hàng

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> items; // Danh sách các OrderItem

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment; // Thông tin thanh toán

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id", referencedColumnName = "shippingId")
    private ShippingTracker shipping; // Thông tin giao hàng

    // Constructors, Getters, Setters không có phương thức logic
    public Order() {}

    public Order(User customer, LocalDate orderDate, OrderStatus status, List<OrderItem> items, Payment payment, ShippingTracker shipping) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.items = items;
        this.payment = payment;
        this.shipping = shipping;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ShippingTracker getShipping() {
        return shipping;
    }

    public void setShipping(ShippingTracker shipping) {
        this.shipping = shipping;
    }
}
