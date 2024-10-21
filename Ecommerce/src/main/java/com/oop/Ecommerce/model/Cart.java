package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @NotNull(message = "Customer is mandatory")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "userId")
    private User customer; // Mối quan hệ với User (khách hàng)

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems; // Danh sách các mặt hàng trong giỏ hàng

    // Constructor mặc định
    public Cart() {}

    // Constructor với tất cả các thuộc tính
    public Cart(User customer, List<CartItem> cartItems) {
        this.customer = customer;
        this.cartItems = cartItems;
    }

    // Getters và Setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
