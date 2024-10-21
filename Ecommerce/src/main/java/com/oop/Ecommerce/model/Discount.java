package com.oop.Ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId;

    @NotBlank(message = "Discount code is mandatory")
    private String discountCode; // Mã giảm giá

    @NotNull(message = "Percentage off is mandatory")
    private Double percentageOff; // Phần trăm giảm giá

    @NotNull(message = "Valid from date is mandatory")
    @Temporal(TemporalType.DATE) // Đánh dấu kiểu thời gian là DATE
    private Date validFrom; // Ngày bắt đầu hiệu lực

    @NotNull(message = "Valid until date is mandatory")
    @Temporal(TemporalType.DATE) // Đánh dấu kiểu thời gian là DATE
    private Date validUntil; // Ngày kết thúc hiệu lực

    // Constructor mặc định
    public Discount() {}

    // Constructor với tất cả các thuộc tính
    public Discount(String discountCode, Double percentageOff, Date validFrom, Date validUntil) {
        this.discountCode = discountCode;
        this.percentageOff = percentageOff;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    // Getters và Setters
    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getPercentageOff() {
        return percentageOff;
    }

    public void setPercentageOff(Double percentageOff) {
        this.percentageOff = percentageOff;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}
