package dao;

import java.io.Serializable;

public class CategoryDAO implements Serializable {

    private static final long serialVersionUID = 1L; // Đảm bảo tính tương thích khi tuần tự hóa
    private static int idCounter = 1; // Bộ đếm tự động tăng cho categoryID

    private String categoryID; // ID của danh mục
    private String categoryName; // Tên danh mục
    private String categoryDescription; // Mô tả danh mục

    // Constructor không tham số
    public CategoryDAO() {
        this.categoryID = String.valueOf(idCounter++);
    }

    // Constructor có tham số (không bao gồm ID)
    public CategoryDAO(String categoryName, String categoryDescription) {
        this.categoryID = String.valueOf(idCounter++);
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    // Constructor đầy đủ tham số (bao gồm ID)
    public CategoryDAO(String categoryID, String categoryName, String categoryDescription) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    // Getter và Setter
    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    // Phương thức hiển thị thông tin danh mục
    @Override
    public String toString() {
        return "CategoryDAO{"
                + "categoryID='" + categoryID + '\''
                + ", categoryName='" + categoryName + '\''
                + ", categoryDescription='" + categoryDescription + '\''
                + '}';
    }
}
