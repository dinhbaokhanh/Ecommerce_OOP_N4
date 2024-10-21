package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @NotNull(message = "Product is mandatory")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product; // Mối quan hệ với Product

    @NotNull(message = "Quantity is mandatory")
    private Integer quantity; // Số lượng sản phẩm

    @NotNull(message = "Total price is mandatory")
    private Double totalPrice; // Tổng giá cho sản phẩm (có thể được tính toán từ quantity và price của sản phẩm)

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order; // Mối quan hệ với Order

    // Constructor mặc định
    public OrderItem() {}

    // Constructor với tất cả các thuộc tính (trừ order)
    public OrderItem(Product product, Integer quantity, Double totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters và Setters
    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
