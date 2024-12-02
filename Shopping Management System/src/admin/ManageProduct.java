/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import user.Login;
import java.awt.Image;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author admin
 */
public class ManageProduct extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    private Login login;
    private AdminDashboard adminDashboard;

    private List<ProductDAO> productList;
    private static final String FILE_NAME_PRODUCT = "PRODUCT.DAT";

    private List<CategoryDAO> categoryList;
    private static final String FILE_NAME_CATEGORY = "CATEGORY.DAT";

    private DefaultTableModel model;
    private ProductDAO product = new ProductDAO();

    public ManageProduct() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDataProduct();
        LoadDataCategory();
        model = (DefaultTableModel) tblProduct.getModel();
    }

    public ManageProduct(Login login, AdminDashboard adminDashboard) {
        this();
        this.login = login;
        this.adminDashboard = adminDashboard;
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100); // Cột hình ảnh
        loadCategoryToComboBox();
        addProductToTable();
        txtProductID.setText(getIdIncreased());
    }

    private void LoadDataProduct() {
        File file = new File(FILE_NAME_PRODUCT);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_PRODUCT); ObjectInputStream ois = new ObjectInputStream(fis)) {
                productList = (List<ProductDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            productList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void LoadDataCategory() {
        File file = new File(FILE_NAME_CATEGORY);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_CATEGORY); ObjectInputStream ois = new ObjectInputStream(fis)) {
                categoryList = (List<CategoryDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            categoryList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void loadCategoryToComboBox() {
        for (CategoryDAO category : categoryList) {
            String tmp = "";
            tmp += category.getCategoryName() + " " + category.getCategoryDescription();
            cbProductCategory.addItem(tmp);
        }
    }

    public void addProductToTable() {
        for (ProductDAO product : productList) {
            // Chuyển đường dẫn thành ImageIcon
            ImageIcon imageIcon = new ImageIcon(product.getProductImageUrl());

            // Điều chỉnh kích thước ảnh để hiển thị đầy đủ trong ô (100x100)
            Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);

            Object[] newRow = {
                product.getProductID(),
                product.getProductName(),
                product.getProductCategory(),
                product.getQuantity(),
                product.getPrice(),
                imageIcon // Thêm ImageIcon đã thay đổi kích thước vào bảng
            };

            model.addRow(newRow);
        }

        // Đặt renderer cho cột hình ảnh
        TableColumn imageColumn = tblProduct.getColumnModel().getColumn(5);  // Giả sử cột hình ảnh là cột thứ 6 (index 5)
        imageColumn.setCellRenderer(new ImageRenderer());

        // Thiết lập kích thước cột cho hình ảnh
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100);  // Đảm bảo cột hình ảnh có chiều rộng đủ
        tblProduct.setRowHeight(100); // Thiết lập chiều cao dòng cho phù hợp với hình ảnh
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                JLabel label = new JLabel((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);  // Canh giữa hình ảnh
                return label;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    private String getIdIncreased() {
        String tmp = "";
        if (productList.size() > 0) {
            Integer tmpIdCounter = Integer.parseInt(productList.get(productList.size() - 1).getProductID());
            tmpIdCounter += 1;
            tmp = tmpIdCounter.toString();
        } else {
            tmp = "1";
        }
        return tmp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        txtProductID = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtProductQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cbProductCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAddImage = new javax.swing.JButton();
        lbImageUrl = new javax.swing.JLabel();
        txtImageUrl = new javax.swing.JTextField();
        btnNewID = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Category", "Quantity", "Price", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        txtSearchQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchQueryActionPerformed(evt);
            }
        });

        txtProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIDActionPerformed(evt);
            }
        });

        txtProductQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductQuantityActionPerformed(evt);
            }
        });

        jLabel1.setText("Product ID");

        jLabel2.setText("Product Name");

        jLabel3.setText("Category");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        cbProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel5.setText("Quantity");

        jLabel6.setText("Price");

        btnSearch.setText("Search By Name:");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAddImage.setText("Add Image");
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        lbImageUrl.setText("ImageUrl");

        btnNewID.setText("Generate New ID");
        btnNewID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete)
                                    .addComponent(btnSave))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnClear)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(55, 55, 55)
                                .addComponent(btnNewID))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddImage))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtImageUrl, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtProductPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtProductQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbProductCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtProductName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtProductID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSearch)
                            .addGap(41, 41, 41)
                            .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnNewID))
                        .addGap(2, 2, 2)
                        .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbImageUrl)
                    .addComponent(btnAddImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductIDActionPerformed

    private void txtProductQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductQuantityActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (tblProduct.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Choose a Product First!", "Warning", 2);
        } else {
            int confirm = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure to delete this Product?", "Delete Product", JOptionPane.OK_CANCEL_OPTION, 0);
            if (confirm == JOptionPane.OK_OPTION) {
                String currentProductID = txtProductID.getText();
                for (int i = 0; i < productList.size(); i++) {
                    ProductDAO tmpProduct = productList.get(i);
                    if (tmpProduct.getProductID().equals(currentProductID)) {
                        productList.remove(i);
                        login.setProductListData(productList);
                        JOptionPane.showMessageDialog(rootPane, "Xoa Product thanh cong!");
                        txtProductID.setText("");
                        adminDashboard.setTotalProductsNew();
                        clear();
                        model.setRowCount(0);
                        addProductToTable();
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "ok");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchQueryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchQueryActionPerformed

    public boolean isSignUpInformationCreateValid() {
        for (ProductDAO product : productList) {
            if (product.getProductID().equals(txtProductID.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Product ID already exists", "Warning", 2);
                return false;
            }
        }
        if (txtProductName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Category Name is required", "Warning", 2);
            return false;
        }
        if (cbProductCategory.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Category is needed", "Warning", 2);
            return false;
        }
        if (txtProductQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Quantity is required", "Warning", 2);
            return false;
        }
        if (txtProductPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Price is required", "Warning", 2);
            return false;
        }
        if (txtImageUrl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Image is required", "Warning", 2);
            return false;
        }
        return true;
    }

    private void clear() {
        txtProductName.setText("");
        cbProductCategory.setSelectedIndex(-1);
        txtProductQuantity.setText("");
        txtProductPrice.setText("");
        txtImageUrl.setText("");
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (isSignUpInformationCreateValid()) {
            String id = txtProductID.getText();
            String productName = txtProductName.getText();
            String productCategory = cbProductCategory.getSelectedItem().toString();
            Integer productQuantity = Integer.parseInt(txtProductQuantity.getText());
            Double productPrice = Double.parseDouble(txtProductPrice.getText());
            String productImageUrl = txtImageUrl.getText();
            productList.add(new ProductDAO(id, productName, productCategory, productQuantity, productPrice, productImageUrl));
            login.setProductListData(productList);
            JOptionPane.showMessageDialog(rootPane, "Them Product thanh cong!");
            adminDashboard.setTotalProductsNew();
            model.setRowCount(0);
            addProductToTable();
            clear();
            txtProductID.setText(getIdIncreased());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchByName(String searchQuery) {
        model.setRowCount(0);

        for (ProductDAO product : productList) {
            if (product.getProductName().toLowerCase().contains(searchQuery.toLowerCase())) {
                ImageIcon imageIcon = new ImageIcon(product.getProductImageUrl());

                // Điều chỉnh kích thước ảnh để hiển thị đầy đủ trong ô (100x100)
                Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);

                Object[] newRow = {
                    product.getProductID(),
                    product.getProductName(),
                    product.getProductCategory(),
                    product.getQuantity(),
                    product.getPrice(),
                    imageIcon // Thêm ImageIcon đã thay đổi kích thước vào bảng
                };
                model.addRow(newRow);
            }
        }

        // Đặt renderer cho cột hình ảnh
        TableColumn imageColumn = tblProduct.getColumnModel().getColumn(5);  // Giả sử cột hình ảnh là cột thứ 6 (index 5)
        imageColumn.setCellRenderer(new ImageRenderer());

        // Thiết lập kích thước cột cho hình ảnh
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100);  // Đảm bảo cột hình ảnh có chiều rộng đủ
        tblProduct.setRowHeight(100); // Thiết lập chiều cao dòng cho phù hợp với hình ảnh
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String searchQuery = txtSearchQuery.getText().trim();

        // Gọi hàm tìm kiếm nếu người dùng nhập tên
        if (!searchQuery.isEmpty()) {
            searchByName(searchQuery);
        } else {
            model.setRowCount(0);
            addProductToTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblProduct.getSelectedRow();

        // Đảm bảo rằng dòng được chọn hợp lệ
        if (rowIndex != -1) {
            // Lấy mô hình dữ liệu của bảng
            DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();

            // Gán giá trị từ các cột của dòng được chọn vào các JTextField
            txtProductID.setText(model.getValueAt(rowIndex, 0).toString());
            txtProductName.setText(model.getValueAt(rowIndex, 1).toString());
            cbProductCategory.setSelectedItem(model.getValueAt(rowIndex, 2).toString());
            txtProductQuantity.setText(model.getValueAt(rowIndex, 3).toString());
            txtProductPrice.setText(model.getValueAt(rowIndex, 4).toString());
            txtImageUrl.setText(model.getValueAt(rowIndex, 5).toString());
        }
    }//GEN-LAST:event_tblProductMouseClicked

    public boolean isSignUpInformationChangeValid() {
        if (txtProductName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Product Name is required", "Warning", 2);
            return false;
        }
        if (cbProductCategory.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Category is needed", "Warning", 2);
            return false;
        }
        if (txtProductQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Product Quantity is required", "Warning", 2);
            return false;
        }
        if (txtProductPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Product Price is required", "Warning", 2);
            return false;
        }
        if (txtImageUrl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Image is required", "Warning", 2);
            return false;
        }
        return true;
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (isSignUpInformationChangeValid()) {
            String productID = txtProductID.getText();
            String newProductName = txtProductName.getText();
            String newProductCategory = cbProductCategory.getSelectedItem().toString();
            Integer newProductQuantity = Integer.parseInt(txtProductQuantity.getText());
            Double newProductPrice = Double.parseDouble(txtProductPrice.getText());
            String productImageUrl = txtImageUrl.getText();
            for (int i = 0; i < productList.size(); i++) {
                ProductDAO product = productList.get(i);
                if (product.getProductID().equals(productID)) {
                    product.setProductName(newProductName);
                    product.setProductCategory(newProductCategory);
                    product.setQuantity(newProductQuantity);
                    product.setPrice(newProductPrice);
                    product.setProductImageUrl(productImageUrl);
                    JOptionPane.showMessageDialog(rootPane, "Sua thong tin thanh cong!");
                    txtProductID.setText("");
                    txtProductName.setText("");
                    cbProductCategory.setSelectedIndex(-1);
                    txtProductQuantity.setText("");
                    txtProductPrice.setText("");
                    txtImageUrl.setText("");
                    tblProduct.clearSelection();
                    login.setProductListData(productList);
                    adminDashboard.setTotalProductsNew();
                    model.setRowCount(0);
                    addProductToTable();
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtProductID.setText("");
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        // Đặt thư mục mặc định là thư mục productImages
        File productImagesDir = new File("src/productImages"); // Đảm bảo rằng đường dẫn là đúng
        if (!productImagesDir.exists()) {
            JOptionPane.showMessageDialog(null, "Folder not found.");
            return;
        }

        fileChooser.setCurrentDirectory(productImagesDir); // Đặt thư mục hiện tại là productImages

        // Chỉ cho phép chọn tệp (không phải thư mục)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Mở cửa sổ chọn tệp
        String newProductImageUrl = "";
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            newProductImageUrl = selectedFile.getAbsolutePath();
        }

        txtImageUrl.setText(newProductImageUrl);
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnNewIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewIDActionPerformed
        // TODO add your handling code here:
        txtProductID.setText(getIdIncreased());
    }//GEN-LAST:event_btnNewIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewID;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbProductCategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImageUrl;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtImageUrl;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtSearchQuery;
    // End of variables declaration//GEN-END:variables
}
