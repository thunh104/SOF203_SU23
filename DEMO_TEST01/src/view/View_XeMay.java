package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XeMay;
import service.XeMayService;

public class View_XeMay extends javax.swing.JFrame {

    private XeMayService service = new XeMayService();
    private List<XeMay> listXM = new ArrayList<>();
    private int index = -1;
    private XeMay xm = new XeMay();
    private DefaultTableModel dtm = new DefaultTableModel();

    public View_XeMay() {
        initComponents();
        cboSoLuong.removeAllItems();
        for (int i = 0; i <= 3000; i++) {
            cboSoLuong.addItem(String.valueOf(i));
        }
        cboTrangThai.removeAllItems();
        String[] tt = {
            "0 - Hết hàng",
            "1- Còn hàng"
        };
        for (String t : tt) {
            cboTrangThai.addItem(t);
        }
        this.setLocationRelativeTo(null);
        this.fillTable(service.getAll());
    }

    void fillTable(List<XeMay> list) {
        dtm = (DefaultTableModel) tbXeMay.getModel();
        dtm.setRowCount(0);
        for (XeMay xm : list) {
            dtm.addRow(xm.toDataRow());
        }
    }

    void showData(int index) {
        XeMay xm = service.getAll().get(index);
        txtMaXe.setText(xm.getMaXe().trim());
        txtTenXe.setText(xm.getTenXe().trim());
        cboTrangThai.setSelectedItem(xm.isTrangThai());
        txtGiaBan.setText(String.valueOf(xm.getGiaBan()));
        txtGiaNhap.setText(String.valueOf(xm.getGiaNhap()));
        cboSoLuong.setSelectedItem(String.valueOf(xm.getSoLuong()));
    }

    XeMay readForm() {
        String ma = txtMaXe.getText().trim();
        String ten = txtTenXe.getText().trim();
        Boolean trangThai = Boolean.valueOf(cboTrangThai.getSelectedItem().toString());
        Double giaBan = Double.valueOf(txtGiaBan.getText().trim());
        Double giaNhap = Double.valueOf(txtGiaNhap.getText().trim());
        int soLuong = Integer.parseInt(cboSoLuong.getSelectedItem().toString());
        return new XeMay(ma, ten, trangThai, giaBan, giaNhap, soLuong);
    }

    boolean testData() {
        if (txtMaXe.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong bo trong ma xe !");
            return false;
        }
        if (txtTenXe.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong bo trong ten xe !");
            return false;
        } else {
            if (!txtTenXe.getText().matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Khong dung dinh dang ten");
                return false;
            }
        }
        if (txtGiaBan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong bo trong gia ban !");
            return false;
        } else {
            try {
                if (Double.parseDouble(txtGiaBan.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Gia ban phai lon hon 0 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gia ban phai la so !");
            }
        }
        if (txtGiaNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong bo trong gia nhap !");
            return false;
        } else {
            try {
                if (Double.parseDouble(txtGiaNhap.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Gia nhap phai lon hon 0 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gia nhap phai la so !");
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        txtTenXe = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        cboSoLuong = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbXeMay = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("SỬ DỤNG XE MÁY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mã xe");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tên xe");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Giá bán");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Trạng thái");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Giá nhập");

        txtMaXe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTenXe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cboSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tbXeMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã xe", "Tên xe", "Trạng thái", "Giá bán", "Giá nhập", "Số lượng"
            }
        ));
        tbXeMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXeMayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbXeMay);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtMaXe)
                            .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(cboSoLuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnAdd)
                .addGap(52, 52, 52)
                .addComponent(btnUpdate)
                .addGap(45, 45, 45)
                .addComponent(btnDelete)
                .addGap(51, 51, 51)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbXeMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXeMayMouseClicked
        index = tbXeMay.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbXeMayMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (testData()) {
            XeMay xm = this.readForm();
            if (service.getXM(xm.getMaXe()) != null) {
                JOptionPane.showMessageDialog(this, "Ma trung khong them duoc !");
            } else {
                if (service.insert_XM(xm) > 0) {
                    JOptionPane.showMessageDialog(this, "Add thanh cong !");
                    this.fillTable(service.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Add khong thanh cong !");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        index = tbXeMay.getSelectedRow();
        XeMay xm = this.readForm();
        String id = String.valueOf(tbXeMay.getValueAt(index, 0));
        if (service.update_XM(xm, id) > 0) {
            JOptionPane.showMessageDialog(this, "Update thanh cong !");
            this.fillTable(service.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Update khong thanh cong !");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        index = tbXeMay.getSelectedRow();
        String id = String.valueOf(tbXeMay.getValueAt(index, 0));
        if (service.delete_XM(id) > 0) {
            JOptionPane.showMessageDialog(this, "Delete thanh cong !");
            this.fillTable(service.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Delete khong thanh cong !");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_XeMay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboSoLuong;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbXeMay;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtTenXe;
    // End of variables declaration//GEN-END:variables
}
