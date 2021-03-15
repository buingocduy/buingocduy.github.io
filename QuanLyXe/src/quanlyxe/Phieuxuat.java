/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

import quanlyxe.thucthe.*;
import quanlyxe.xuly.*;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.awt.Component;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bui Ngoc Duy
 */
public class Phieuxuat extends javax.swing.JFrame {

    phieuxuatXL phieuXuatServices = new phieuxuatXL();
    khachhangXL customerServices = new khachhangXL();
    khoXL khoServices = new khoXL();

    ArrayList<khachhangTT> dsKhachHang = new ArrayList<khachhangTT>();
    ArrayList<khoTT> dsKho = new ArrayList<khoTT>();
    ArrayList<phieuxuatTT> dsPhieuXuat = new ArrayList<phieuxuatTT>();

    phieuxuatTT selectedPhieuXuat = null;

    public Phieuxuat() {
        initComponents();

        loadKhachHang();
        loadKho();

        showDataList();
    }

    public void setTenUser(String username) {
        this.txt_nguoilap.setText(username);

        String b = "admin";

        boolean c = b.equals(username);

        System.out.println(c);
        if (c == true) {
            btnXoa.setEnabled(true);
        }

        if (c == false) {
            btnXoa.setEnabled(false);
        }
        System.out.println(username);
    }

    private void showDataList() {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuXuat.getModel();
        model.setRowCount(0);

        ArrayList<phieuxuatTT> list = phieuXuatServices.getAllRecords();
        dsPhieuXuat = list;

        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");

        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaPX();
            row[1] = list.get(i).getUsername();
            row[2] = list.get(i).getMaKH();
            row[3] = formatter2.format(list.get(i).getNgayXuat());
            row[4] = list.get(i).getMaKho();
            model.addRow(row);

        }
        ListSelectionModel cellSelectionModel = tblPhieuXuat.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    gridSelectedChanged(e);
                } catch (ParseException ex) {
                    Logger.getLogger(Phieuxuat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void gridSelectedChanged(ListSelectionEvent e) throws ParseException {
        String selectedData = null;
        String selectedID = "";

        int[] selectedRows = tblPhieuXuat.getSelectedRows();
        int[] selectedColumns = tblPhieuXuat.getSelectedColumns();

        int selectedRow = tblPhieuXuat.getSelectedRow();
        int selectedColumn = tblPhieuXuat.getSelectedColumn();

        if (selectedRow >= 0 && selectedColumn >= 0) {
            selectedData = String.valueOf(tblPhieuXuat.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) tblPhieuXuat.getValueAt(selectedRow, 0);

            selectedPhieuXuat = findPhieuXuat(selectedID, dsPhieuXuat);

            System.out.println("Selected: " + selectedData + " , value: " + selectedID);

            ShowDataDetail(selectedID,
                    (String) tblPhieuXuat.getValueAt(selectedRow, 1),
                    (int) tblPhieuXuat.getValueAt(selectedRow, 2),
                    (String) tblPhieuXuat.getValueAt(selectedRow, 3),
                    (String) tblPhieuXuat.getValueAt(selectedRow, 4));
        }
    }

    private void ShowDataDetail(String maPX, String userID, int maKH, String ngayXuat, String maKho) throws ParseException {
        String stringDate1 = ngayXuat;
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter1.parse(stringDate1);

        txtMaPX.setText(maPX);
        txt_nguoilap.setText(userID);

        if (selectedPhieuXuat != null) {
            cbxKhachHang.setSelectedItem(findKhachHang(selectedPhieuXuat.getMaKH(), dsKhachHang));
        }

        dtmNgayXuat.setDate(date1);

        if (selectedPhieuXuat != null) {
            cbxKho.setSelectedItem(findKho(selectedPhieuXuat.getMaKho(), dsKho));
        }
    }

    private void loadKho() {
        cbxKho.removeAllItems();
        dsKho = khoServices.getAllRecords();
        for (khoTT kho : dsKho) {
            cbxKho.addItem(kho);
        }
        cbxKho.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof khoTT) {
                    khoTT warehouse = (khoTT) value;
                    setText(warehouse.getTenKho());
                }
                return this;
            }

        });
    }

    private void loadKhachHang() {
        cbxKhachHang.removeAllItems();
        dsKhachHang = customerServices.getAllRecords();
        for (khachhangTT khachHang : dsKhachHang) {
            cbxKhachHang.addItem(khachHang);
        }
        cbxKhachHang.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof khachhangTT) {
                    khachhangTT item = (khachhangTT) value;
                    setText(item.getTenKH());
                }
                return this;
            }

        });
    }

    private phieuxuatTT findPhieuXuat(String maPX, ArrayList<phieuxuatTT> phieuXuats) {
        for (phieuxuatTT item : phieuXuats) {
            if (item.getMaPX() == maPX) {
                return item;
            }
        }
        return null;
    }

    private khachhangTT findKhachHang(int maKH, ArrayList<khachhangTT> customers) {
        for (khachhangTT item : customers) {
            if (item.getMaKH() == maKH) {
                return item;
            }
        }
        return null;
    }

    private khoTT findKho(String maKho, ArrayList<khoTT> warehouses) {
        for (khoTT item : warehouses) {
            if (item.getMaKho().equals(maKho)) {
                return item;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelDetail = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaPX = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dtmNgayXuat = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbxKhachHang = new javax.swing.JComboBox<>();
        cbxKho = new javax.swing.JComboBox<>();
        txt_nguoilap = new javax.swing.JTextField();
        btnChiTiet = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý phiếu xuất kho");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanelHeader.setBackground(java.awt.SystemColor.activeCaption);
        jPanelHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setLabelFor(jPanelHeader);
        jLabel9.setText("PHIẾU XUẤT KHO");
        jLabel9.setIconTextGap(10);

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(25, 25, 25))
        );

        jPanelDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã phiếu xuất");

        txtMaPX.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaPX.setForeground(new java.awt.Color(255, 51, 0));
        txtMaPX.setEnabled(false);

        jLabel2.setText("Người Xuất");

        jLabel3.setText("Khách Hàng");

        jLabel6.setText("Ngày Xuất Kho");

        dtmNgayXuat.setDateFormatString("dd/MM/yyyy");

        jLabel4.setText("Kho");

        txt_nguoilap.setEnabled(false);

        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report.png"))); // NOI18N
        btnChiTiet.setText("Xem chi tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDetailLayout = new javax.swing.GroupLayout(jPanelDetail);
        jPanelDetail.setLayout(jPanelDetailLayout);
        jPanelDetailLayout.setHorizontalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                        .addComponent(btnChiTiet)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nguoilap)
                            .addComponent(cbxKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtmNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(cbxKho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaPX))
                        .addGap(157, 157, 157))))
        );
        jPanelDetailLayout.setVerticalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nguoilap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtmNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/sua2.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/del.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/close2.png"))); // NOI18N
        btnClose1.setText("Thoat");
        btnClose1.setIconTextGap(10);
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Xuất", "Người Xuất", "Khách Hàng", "Ngày Xuất", "Kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieuXuat.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblPhieuXuat);
        tblPhieuXuat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblPhieuXuat.getColumnModel().getColumnCount() > 0) {
            tblPhieuXuat.getColumnModel().getColumn(0).setResizable(false);
            tblPhieuXuat.getColumnModel().getColumn(1).setResizable(false);
            tblPhieuXuat.getColumnModel().getColumn(2).setResizable(false);
            tblPhieuXuat.getColumnModel().getColumn(3).setResizable(false);
            tblPhieuXuat.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maPX = txtMaPX.getText().trim();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (input == 0) {

            int rowEffected = phieuXuatServices.DeleteRecord(maPX);
            if (rowEffected > 0) {
                showDataList();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int maPX = Integer.parseInt(txtMaPX.getText().trim());
        String User = txt_nguoilap.getText().trim();
        khachhangTT khachHang = (khachhangTT) cbxKhachHang.getSelectedItem();
        Date ngayXuat = dtmNgayXuat.getDate();
        khoTT kho = (khoTT) cbxKho.getSelectedItem();

        int rowEffected = phieuXuatServices.UpdateRecord(maPX, User, khachHang.getMaKH(), ngayXuat, kho.getMaKho());
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Sửa thành công!");
            showDataList();
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String soPX = txtMaPX.getText().trim();
        String User = txt_nguoilap.getText().trim();
        khachhangTT khachHang = (khachhangTT) cbxKhachHang.getSelectedItem();
        Date ngayXuat = dtmNgayXuat.getDate();
        khoTT kho = (khoTT) cbxKho.getSelectedItem();

        int rowEffected = phieuXuatServices.AddNewRecord(User, khachHang.getMaKH(), ngayXuat, kho.getMaKho());
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            showDataList();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        khoTT kho = (khoTT) cbxKho.getSelectedItem();
        CT_Phieuxuat ct_phieuxuat = new CT_Phieuxuat();
        ct_phieuxuat.setMPX(txtMaPX.getText());
        ct_phieuxuat.showDataList(txtMaPX.getText());
        ct_phieuxuat.loadSanpham(kho.getMaKho());
        this.dispose();

        //vi tri giua man hinh va maximize
        ct_phieuxuat.pack();
        ct_phieuxuat.setLocationRelativeTo(null);
        ct_phieuxuat.setVisible(true);
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        // Thoat form
        this.dispose();
        //System.exit(0);
    }//GEN-LAST:event_btnClose1ActionPerformed

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
            java.util.logging.Logger.getLogger(Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Phieuxuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnClose1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<khachhangTT> cbxKhachHang;
    private javax.swing.JComboBox<khoTT> cbxKho;
    private com.toedter.calendar.JDateChooser dtmNgayXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTextField txtMaPX;
    private javax.swing.JTextField txt_nguoilap;
    // End of variables declaration//GEN-END:variables

}
