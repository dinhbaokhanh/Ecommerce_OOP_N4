package dao;

import java.io.Serializable;

public class ProductDAO implements Serializable {

    private static final long serialVersionUID = 1L; // Đảm bảo khả năng tương thích khi serialize
    private static int idCounter = 1; // Bộ đếm tự động tăng cho productID

    private String productID;
    private String productName;
    private String productCategory;
    private Integer quantity;
    private Double price;
    private String productImageUrl;

    // Constructor mặc định
    public ProductDAO() {
        this.productID = String.valueOf(idCounter++);
    }

    // Constructor đầy đủ tham số (trừ productID tự động tạo)
    public ProductDAO(String productName, String productCategory, Integer quantity, Double price) {
        this.productID = String.valueOf(idCounter++);
        this.productName = productName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.price = price;
    }

    // Constructor đầy đủ tham số (bao gồm productID)
    public ProductDAO(String productID, String productName, String productCategory, Integer quantity, Double price) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.price = price;
        this.productImageUrl = "C:\\Users\\Huy\\Downloads\\OOP-PROJECT-SHOP\\Shopping Management System\\src\\productImages\\account_dark.png";
    }

    public ProductDAO(String productID, String productName, String productCategory, Integer quantity, Double price, String productImageUrl) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.price = price;
        this.productImageUrl = productImageUrl;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    // Getter và Setter cho các thuộc tính
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Phương thức tính tổng giá trị sản phẩm (quantity * price)
    public Double getTotalValue() {
        return this.quantity * this.price;
    }

    // Phương thức toString để hiển thị thông tin đối tượng
    @Override
    public String toString() {
        return "ProductDAO{"
                + "productID='" + productID + '\''
                + ", productName='" + productName + '\''
                + ", productCategory='" + productCategory + '\''
                + ", quantity=" + quantity
                + ", price=" + price
                + ", totalValue=" + getTotalValue()
                + '}';
    }
}
