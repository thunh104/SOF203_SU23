package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XeMay;
import service.XeMayService;

public class FormXeMay extends javax.swing.JFrame {

    private int index = -1;
    private List<XeMay> list = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private XeMayService service = new XeMayService();

    public FormXeMay() {
        initComponents();
        cboSoLuong.removeAllItems();
        for (int i = 0; i <= 2000; i++) {
            cboSoLuong.addItem(String.valueOf(i));
        }
        cboTrangThai.removeAllItems();
        String[] tt = {
            "0 - Het hang",
            "1- Con hang"
        };
        for (String t : tt) {
            cboTrangThai.addItem(t);
        }
        this.setLocationRelativeTo(null);
        this.fillTable(service.getAll());
    }

    void fillTable(List<XeMay> listxm) {
        dtm = (DefaultTableModel) tbXeMay.getModel();
        dtm.setRowCount(0);
        for (XeMay xm : listxm) {
            dtm.addRow(xm.toDataRow());
        }
    }

    void showData(int index) {
        XeMay xm = service.getAll().get(index);
        txtMaXe.setText(xm.getMa());
        txtTenXe.setText(xm.getTen());
        cboTrangThai.setSelectedItem(xm.isTrangThai() ? "0 - Het hang" : "1- Con hang");
        txtGiaBan.setText(String.valueOf(xm.getGiaBan()));
        txtGiaNhap.setText(String.valueOf(xm.getGiaNhap()));
        cboSoLuong.setSelectedItem(String.valueOf(xm.getSoLuong()));
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
                JOptionPane.showMessageDialog(this, "Ten xe khong dung dinh dang !");
                return false;
            }
        }
        if (txtGiaBan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong bo trong gia ban !");
            return false;
        } else {
            try {
                if (Double.parseDouble(txtGiaBan.getText()) < 50) {
                    JOptionPane.showMessageDialog(this, "Gia ban phai lon hon 50 !");
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
                if (Double.parseDouble(txtGiaNhap.getText()) < 50) {
                    JOptionPane.showMessageDialog(this, "Gia nhap phai lon hon 50 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gia nhap phai la so !");
            }
        }
        return true;
    }

    XeMay readForm(){
        String ma = txtMaXe.getText().trim();
        String ten = txtTenXe.getText().trim();
        Boolean tt = Boolean.valueOf(cboTrangThai.getSelectedItem().toString());
        Double gb = Double.valueOf(txtGiaBan.getText().trim());
        Double gn = Double.valueOf(txtGiaNhap.getText().trim());
        int sl = Integer.parseInt(cboSoLuong.getSelectedItem().toString());
        return new XeMay(ma, ten, tt, gb, gn, sl);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        txtTenXe = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboSoLuong = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbXeMay = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("SU DUNG XE MAY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Ma xe");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ten xe");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Trang thai");

        txtMaXe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTenXe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Gia ban");

        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Gia nhap");

        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("So luong");

        cboSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        tbXeMay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ma xe", "Ten xe", "Trang thai", "Gia ban", "Gia nhap", "So luong"
            }
        ));
        tbXeMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXeMayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbXeMay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txtMaXe)
                    .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboSoLuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnAdd)
                .addGap(50, 50, 50)
                .addComponent(btnUpdate)
                .addGap(46, 46, 46)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbXeMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXeMayMouseClicked
        index = tbXeMay.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbXeMayMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(testData()){
            XeMay xm = this.readForm();
            if(service.getXM(xm.getMa()) != null){
                JOptionPane.showMessageDialog(this, "Ma trung !");
            }
            else {
                if(service.insert_XM(xm) > 0){
                    JOptionPane.showMessageDialog(this, "Add thanh cong !");
                    this.fillTable(service.getAll());
                }
                else {
                    JOptionPane.showMessageDialog(this, "Add khong thanh cong !");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        index = tbXeMay.getSelectedRow();
        String id = String.valueOf(tbXeMay.getValueAt(index, 0));
        XeMay xm = this.readForm();
        if(service.update_XM(xm, id) > 0){
            JOptionPane.showMessageDialog(this, "Update thanh cong !");
            this.fillTable(service.getAll());
        }
        else {
            JOptionPane.showMessageDialog(this, "Update khong thanh cong !");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        index = tbXeMay.getSelectedRow();
        String id = String.valueOf(tbXeMay.getValueAt(index, 0));
        if(service.delete_Xm(id) > 0){
            JOptionPane.showMessageDialog(this, "Delete thanh cong !");
            this.fillTable(service.getAll());
        }
        else {
            JOptionPane.showMessageDialog(this, "Delete khong thanh cong !");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormXeMay().setVisible(true);
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
