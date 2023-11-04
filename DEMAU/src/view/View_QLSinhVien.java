package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import service.SinhVienService;

public class View_QLSinhVien extends javax.swing.JFrame {

    private SinhVienService service = new SinhVienService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int index = -1;

    public View_QLSinhVien() {
        initComponents();
        cboNganhHoc.removeAllItems(); //Xoá hết các item cũ
        String[] menus = {
            "Phát triển phần mềm",
            "Ứng dụng phần mềm",
            "Xử lí dữ liệu",
            "Lập trình Web",
            "Lập trình Mobile"};
        for (String item : menus) {
            cboNganhHoc.addItem(item);
        }
        this.setLocationRelativeTo(null);
        this.fillTable(service.getAll());
    }

    void fillTable(List<SinhVien> list) {
        dtm = (DefaultTableModel) tbSinhVien.getModel();
        dtm.setRowCount(0);
        for (SinhVien x : list) {
            dtm.addRow(x.toDataRow());
        }
    }

    void showData(int index) {
        SinhVien sv = service.getAll().get(index);
        txtMaSV.setText(sv.getMaSV());
        txtTenSV.setText(sv.getTenSV());
        txtTuoi.setText(String.valueOf(sv.getTuoi()));
        txtKiHoc.setText(String.valueOf(sv.getKiHoc()));
        cboNganhHoc.setSelectedItem(sv.getNganhHoc());
        txtDiemTB.setText(String.valueOf(sv.getDiemTB()));
        rdoNam.setSelected(!sv.getGioiTinh());
        rdoNu.setSelected(sv.getGioiTinh());
    }

    SinhVien readForm() {
        String ma = txtMaSV.getText().trim();
        String ten = txtTenSV.getText().trim();
        int tuoi = Integer.parseInt(txtTuoi.getText().trim());
        int ki = Integer.parseInt(txtKiHoc.getText().trim());
        String nganh = cboNganhHoc.getSelectedItem().toString();
        float diem = Float.parseFloat(txtDiemTB.getText().trim());
        boolean gt = rdoNu.isSelected();
        return new SinhVien(ki, ma, ten, tuoi, ki, nganh, diem, gt);
    }

    boolean testData() {
        if (txtMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã sinh viên !");
            return false;
        }
        if (txtTenSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tên !");
            return false;
        } else { // Check tên là chữ cái, không có số, không có kí tự đặc biệt, ÁP DỤNG VỚI KHÔNG CÓ TIẾNG VIỆT
            if (!txtTenSV.getText().matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "Tên sai định dạng !");
                return false;
            }
        }
        if (txtTuoi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tuổi !");
            return false;
        } else {
            try {
                if (Integer.parseInt(txtTuoi.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn 0 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tuổi phải là số !");
                return false;
            }
        }
        if (txtKiHoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống kì học !");
            return false;
        } else {
            try {
                if (Integer.parseInt(txtKiHoc.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Kì học phải lớn hơn 0 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Kì học phải là số !");
                return false;
            }
        }
        if (txtDiemTB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống điểm trung bình !");
            return false;
        } else {
            try {
                if (Float.parseFloat(txtDiemTB.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Điểm trung bình phải lớn hơn 0 !");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Điểm trung bình phải là số !");
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenderGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKiHoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboNganhHoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtDiemTB = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mã ");

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tên");

        txtTenSV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tuổi");

        txtTuoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Kì học");

        txtKiHoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Ngành học");

        cboNganhHoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Giới tính");

        GenderGroup.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNam.setText("Nam");

        GenderGroup.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoNu.setText("Nữ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Điểm trung bình");

        txtDiemTB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        btnRemove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên", "Tuổi", "Học kì", "Ngành học", "Điểm TB", "Giới tính"
            }
        ));
        tbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSinhVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(495, 495, 495)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(87, 87, 87)
                                        .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(92, 92, 92)
                                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdoNam)
                                            .addComponent(cboNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdoNu))))
                                .addGap(155, 155, 155)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnAdd)
                        .addGap(117, 117, 117)
                        .addComponent(btnUpdate)
                        .addGap(101, 101, 101)
                        .addComponent(btnRemove)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtKiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboNganhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(rdoNam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoNu)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        index = tbSinhVien.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (this.testData()) {
            SinhVien sv = this.readForm();
            if (service.getSV(sv.getMaSV()) != null) {
                JOptionPane.showMessageDialog(this, "Trùng mã sinh viên, mời nhập lại !");
            } else {
                if (service.addSinhVien(sv) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công !");
                    this.fillTable(service.getAll());
                } else { // Không add được
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        index = tbSinhVien.getSelectedRow();
        int id = Integer.parseInt(tbSinhVien.getValueAt(index, 0).toString());
        SinhVien sv = this.readForm();
        if (service.updateSV(sv, id) > 0) {
            JOptionPane.showMessageDialog(this, "Update thành công !");
            this.fillTable(service.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Update không thành công !");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        index = tbSinhVien.getSelectedRow();
        int id = Integer.parseInt(tbSinhVien.getValueAt(index, 0).toString());
        if (service.removeSV(id) > 0) {
            JOptionPane.showMessageDialog(this, "Xoá thành công !");
            this.fillTable(service.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xoá thất bại !");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_QLSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GenderGroup;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboNganhHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtKiHoc;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
