/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package user;

import admin.AdminDashboard;
import admin.ManageProduct;
import dao.CategoryDAO;
import dao.ProductDAO;
import dao.TransactionDTO;
import dao.UserBalanceDAO;
import dao.UserDAO;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author admin
 */
public class Purchase extends javax.swing.JFrame {

    private Login login;
    private UserDAO user;
    private ProductDAO product;
    private UserBalanceDAO userBalance;

    private List<ProductDAO> productList;
    private static final String FILE_NAME_PRODUCT = "PRODUCT.DAT";

    private List<TransactionDTO> transactionList = new ArrayList<>();

    private List<TransactionDTO> transactionListMain = new ArrayList<>();
    private static final String FILE_NAME_TRANSACTION = "TRANSACTION.DAT";

    private List<UserBalanceDAO> userBalanceList;
    private static final String FILE_NAME_USERBALANCE = "USERBALANCE.DAT";

    private DefaultTableModel productModel;
    private DefaultTableModel transactionModel;

    private UserDashboard userDashboard;

    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDataProduct();
        LoadDataTransaction();
        LoadDataUserBalance();
        productModel = (DefaultTableModel) tblProduct.getModel();
        txtPurchaseID.setText(getIdIncreased());
        transactionModel = (DefaultTableModel) tblTransaction.getModel();
    }

    public Purchase(Login login, UserDAO user, UserDashboard userDashboard) {
        this();
        this.login = login;
        this.user = user;
        this.userDashboard = userDashboard;
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100); // Cột hình ảnh
        addProductToTable();

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

    private void LoadDataTransaction() {
        File file = new File(FILE_NAME_TRANSACTION);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_TRANSACTION); ObjectInputStream ois = new ObjectInputStream(fis)) {
                transactionListMain = (List<TransactionDTO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            transactionListMain = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
        }
    }

    private void LoadDataUserBalance() {
        File file = new File(FILE_NAME_USERBALANCE);
        if (file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(FILE_NAME_USERBALANCE); ObjectInputStream ois = new ObjectInputStream(fis)) {
                userBalanceList = (List<UserBalanceDAO>) ois.readObject();  // Đọc danh sách người dùng từ tệp
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            userBalanceList = new ArrayList<>();  // Nếu tệp rỗng, khởi tạo danh sách trống
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

            productModel.addRow(newRow);
        }

        // Đặt renderer cho cột hình ảnh
        TableColumn imageColumn = tblProduct.getColumnModel().getColumn(5);  // Giả sử cột hình ảnh là cột thứ 6 (index 5)
        imageColumn.setCellRenderer(new Purchase.ImageRenderer());

        // Thiết lập kích thước cột cho hình ảnh
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100);  // Đảm bảo cột hình ảnh có chiều rộng đủ
        tblProduct.setRowHeight(100); // Thiết lập chiều cao dòng cho phù hợp với hình ảnh
    }

    public void addTransactionToTable() {
        for (TransactionDTO transaction : transactionList) {
            Object[] newRow = {
                transaction.getPurchaseID(),
                transaction.getProductID(),
                transaction.getProductName(),
                transaction.getProductPurchaseQuantity(),
                transaction.getProductPrice(),
                transaction.getTotalPrice()
            };
            transactionModel.addRow(newRow);
        }
    }

    private String getIdIncreased() {
        String tmp = "";
        if (transactionList.size() > 0) {
            Integer tmpIdCounter = Integer.parseInt(transactionList.get(transactionList.size() - 1).getPurchaseID());
            tmpIdCounter += 1;
            tmp = tmpIdCounter.toString();
        } else if (transactionListMain.size() > 0) {
            Integer tmpIdCounter = Integer.parseInt(transactionListMain.get(transactionListMain.size() - 1).getPurchaseID());
            tmpIdCounter += 1;
            tmp = tmpIdCounter.toString();
        } else {
            tmp = "1";
        }
        return tmp;
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
        tblTransaction = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        txtSearchQuery = new javax.swing.JTextField();
        txtPurchaseID = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtProductQuantity = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Product ID", "Product Name", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTransaction);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Category", "Quantity", "Price", "ProductImage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane2.setViewportView(tblProduct);

        btnAdd.setBackground(new java.awt.Color(0, 107, 189));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transaction_light.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnPurchase.setBackground(new java.awt.Color(0, 107, 189));
        btnPurchase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPurchase.setForeground(new java.awt.Color(255, 255, 255));
        btnPurchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/box_light.png"))); // NOI18N
        btnPurchase.setText("PURCHASE");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Purchase ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Product Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel5.setText("Total:");

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnSearch.setText("Search By Product Name:");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(txtPurchaseID)
                                    .addComponent(txtProductQuantity))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPurchase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(96, 96, 96)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addGap(29, 29, 29)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jButton1))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPurchaseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)))
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPurchase)
                        .addGap(12, 12, 12)
                        .addComponent(btnClear)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInformationValid() {
        // Kiểm tra xem PurchaseID đã tồn tại trong danh sách giao dịch chưa
        for (TransactionDTO transaction : transactionList) {
            if (transaction.getPurchaseID().equals(txtPurchaseID.getText())) {
                JOptionPane.showMessageDialog(rootPane, "ID already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Kiểm tra xem tên sản phẩm có bị bỏ trống không
        if (txtProductName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Product Name is required", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Kiểm tra xem người dùng có chọn sản phẩm không
        int selectedRow = tblProduct.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy giá trị tồn kho từ cột 3 (giả sử là cột chứa số lượng tồn kho)
            Object tmpProductInStock = tblProduct.getValueAt(selectedRow, 3);
            int productInStock = 0;

            // Kiểm tra kiểu dữ liệu tồn kho và chuyển đổi
            if (tmpProductInStock instanceof Integer) {
                productInStock = (Integer) tmpProductInStock;
            } else if (tmpProductInStock instanceof String) {
                try {
                    productInStock = Integer.parseInt((String) tmpProductInStock);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Invalid stock value", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            // Kiểm tra số lượng sản phẩm người dùng nhập vào có hợp lệ không
            try {
                int enteredQuantity = Integer.parseInt(txtProductQuantity.getText());
                if (enteredQuantity > productInStock) {
                    JOptionPane.showMessageDialog(rootPane, "Not enough stock available", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Invalid quantity entered", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            Object tmpProductPrice = tblProduct.getValueAt(selectedRow, 4);
            Double productPrice = (Double) tmpProductPrice;
            double tmpUserBalance = (double) 0;
            for (UserBalanceDAO userBalanceDAO : userBalanceList) {
                if (userBalanceDAO.getUserID().equals(this.user.getUserID())) {
                    tmpUserBalance = userBalanceDAO.getBalance();
                    break;
                }
            }
            int tmpEnteredQuantity = Integer.parseInt(txtProductQuantity.getText());
            if (tmpEnteredQuantity * productPrice > tmpUserBalance) {
                JOptionPane.showMessageDialog(rootPane, "Please Add More Balance", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a product first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private void clear() {
        txtProductName.setText("");
        txtProductQuantity.setText("");
        tblProduct.clearSelection();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (isInformationValid()) {
            String purchaseID = txtPurchaseID.getText();
            String userID = user.getUserID();
            String userName = user.getUsername();
            String userPhone = user.getPhoneNumber();
            String productID = product.getProductID();
            String productName = product.getProductName();
            Integer productPurchaseQuantity = Integer.parseInt(txtProductQuantity.getText());
            Double productPrice = product.getPrice();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String purchaseDate = currentDate.format(formatter);
            String address = user.getAddress();
            String receivedDate = "tbd";
            String supplierName = "tbd";
            String status = "pending";

            transactionList.add(new TransactionDTO(purchaseID, userID, userName, userPhone, productID, productName,
                    productPurchaseQuantity, productPrice, purchaseDate, address, receivedDate, supplierName, status));

            JOptionPane.showMessageDialog(rootPane, "Them transaction thanh cong!");

            transactionModel.setRowCount(0);
            addTransactionToTable();
            clear();
            txtPurchaseID.setText(getIdIncreased());
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblProduct.getSelectedRow();

        // Đảm bảo rằng dòng được chọn hợp lệ
        if (rowIndex != -1) {
            // Lấy mô hình dữ liệu của bảng
            DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();

            // Gán giá trị từ các cột của dòng được chọn vào các JTextField
            txtProductName.setText(model.getValueAt(rowIndex, 1).toString());

            // Lấy các giá trị khác từ bảng và tạo đối tượng ProductDAO
            String productID = model.getValueAt(rowIndex, 0).toString(); // Cột 0 là productID
            String productName = model.getValueAt(rowIndex, 1).toString(); // Cột 1 là productName
            String productCategory = model.getValueAt(rowIndex, 2).toString(); // Cột 2 là productCategory
            Integer quantity = Integer.parseInt(model.getValueAt(rowIndex, 3).toString()); // Cột 3 là quantity
            Double price = Double.parseDouble(model.getValueAt(rowIndex, 4).toString()); // Cột 4 là price

            // Tạo đối tượng ProductDAO từ các giá trị vừa lấy được
            ProductDAO selectedProduct = new ProductDAO(productID, productName, productCategory, quantity, price);

            // Cập nhật đối tượng productDAO hiện tại (giả sử bạn có một thuộc tính productDAO)
            this.product = selectedProduct;

            // (Tuỳ chọn) Cập nhật các trường hợp khác như hiển thị giá trị của sản phẩm đã chọn
            // txtProductName.setText(selectedProduct.getProductName()); // Ví dụ
            // txtProductCategory.setText(selectedProduct.getProductCategory());
        }
    }//GEN-LAST:event_tblProductMouseClicked

    private void searchByName(String searchQuery) {
        productModel.setRowCount(0);

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
                productModel.addRow(newRow);
            }
        }

        // Đặt renderer cho cột hình ảnh
        TableColumn imageColumn = tblProduct.getColumnModel().getColumn(5);  // Giả sử cột hình ảnh là cột thứ 6 (index 5)
        imageColumn.setCellRenderer(new Purchase.ImageRenderer());

        // Thiết lập kích thước cột cho hình ảnh
        tblProduct.getColumnModel().getColumn(5).setPreferredWidth(100);  // Đảm bảo cột hình ảnh có chiều rộng đủ
        tblProduct.setRowHeight(100); // Thiết lập chiều cao dòng cho phù hợp với hình ảnh
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String searchQuery = txtSearchQuery.getText().trim();

        // Gọi hàm tìm kiếm nếu người dùng nhập tên
        if (!searchQuery.isEmpty()) {
            searchByName(searchQuery);
        } else {
            productModel.setRowCount(0);
            addProductToTable();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        // TODO add your handling code here:
        if (transactionList.size() > 0) {
            Map<String, Integer> m1 = new HashMap<>();
            for (TransactionDTO transactionDTO : transactionList) {
                if (!m1.containsKey(transactionDTO.getProductID())) {
                    m1.put(transactionDTO.getProductID(), transactionDTO.getProductPurchaseQuantity());
                } else {
                    m1.put(transactionDTO.getProductID(), m1.get(transactionDTO.getProductID())
                            + transactionDTO.getProductPurchaseQuantity());
                }
            }

            for (int i = 0; i < productList.size(); i++) {
                ProductDAO tmpProduct = productList.get(i);
                if (m1.containsKey(tmpProduct.getProductID())) {
                    if (tmpProduct.getQuantity() < m1.get(tmpProduct.getProductID())) {
                        JOptionPane.showMessageDialog(rootPane, "khong du so luong ton kho");
                        m1.clear();
                        return;
                    } else {
                        tmpProduct.setQuantity(tmpProduct.getQuantity() - m1.get(tmpProduct.getProductID()));
                    }
                }
            }
            login.setProductListData(productList);
            login.setTransactionListData(transactionList);

            Double totalPrice = (double) 0;
            for (TransactionDTO transactionDTO : transactionList) {
                totalPrice += transactionDTO.getTotalPrice();
            }

            String currentUserID = this.user.getUserID();
            for (int i = 0; i < userBalanceList.size(); i++) {
                UserBalanceDAO tmpUserBalanceDAO = userBalanceList.get(i);
                if (tmpUserBalanceDAO.getUserID().equals(currentUserID)) {
                    this.userBalance = tmpUserBalanceDAO;
                    tmpUserBalanceDAO.setBalance(tmpUserBalanceDAO.getBalance() - totalPrice);
                    break;
                }
            }

            login.setUserBalanceListDataReplace(userBalanceList);
            JOptionPane.showMessageDialog(rootPane, "Mua hang thanh cong!");
            productModel.setRowCount(0);
            addProductToTable();
            transactionModel.setRowCount(0);
            transactionList.clear();
            userDashboard.setAfterPurchaseSuccess(userBalance);
            clear();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hay chon san pham truoc khi mua!");
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
        transactionModel.setRowCount(0);
        transactionList.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtPurchaseID;
    private javax.swing.JTextField txtSearchQuery;
    // End of variables declaration//GEN-END:variables
}
