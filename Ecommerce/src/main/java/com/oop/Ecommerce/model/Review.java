package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NotNull(message = "Customer is mandatory")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "userId")
    private Customer customer; // Mối quan hệ với Customer

    @NotNull(message = "Product is mandatory")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product; // Mối quan hệ với Product

    @NotBlank(message = "Comment is mandatory")
    private String comment; // Nhận xét của khách hàng

    @NotNull(message = "Rating is mandatory")
    @Positive(message = "Rating must be positive")
    private Integer rating; // Điểm đánh giá (có thể từ 1 đến 5)

    // Constructor mặc định
    public Review() {}

    // Constructor với tất cả các thuộc tính
    public Review(Customer customer, Product product, String comment, Integer rating) {
        this.customer = customer;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    // Phương thức thêm đánh giá
    public void addReview(Customer customer, Product product, String comment, Integer rating) {
        this.customer = customer;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    // Phương thức chỉnh sửa đánh giá
    public void editReview(String comment, Integer rating) {
        this.comment = comment;
        this.rating = rating;
    }

    // Getters và Setters
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
