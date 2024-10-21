package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @NotNull(message = "Product is mandatory")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product; // Mối quan hệ với Product

    @NotNull(message = "Quantity is mandatory")
    private Integer quantity; // Số lượng sản phẩm trong giỏ hàng

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    private Cart cart; // Mối quan hệ với Cart

    // Constructor mặc định
    public CartItem() {}

    // Constructor với tất cả các thuộc tính (trừ cart)
    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters và Setters
    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
