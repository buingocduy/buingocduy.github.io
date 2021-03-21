/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

import quanlyxe.thucthe.*;
import quanlyxe.xuly.*;
import java.awt.Component;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vuhuynh
 */
public class CT_Phieunhap extends javax.swing.JFrame {

    ct_phieunhapTT selectedPhieunhapCT = null;
    ct_phieunhapXL phieunhapCTServices = new ct_phieunhapXL();

    sanphamXL sanphamServices = new sanphamXL();
    phieunhapXL phieunhapServices = new phieunhapXL();

    ArrayList<sanphamTT> dsSanpham = new ArrayList<sanphamTT>();
    ArrayList<ct_phieunhapTT> dsPhieunhapCT = new ArrayList<ct_phieunhapTT>();
    ArrayList<phieunhapTT> dsPN = new ArrayList<phieunhapTT>();

    public CT_Phieunhap() {
        initComponents();
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
    
    public void setMPX(String MaPN) {
        this.txt_mapn.setText(MaPN);
    }   

    public void showDataList(String MaPN) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuNhapCT.getModel();
        model.setRowCount(0);

        ArrayList<ct_phieunhapTT> list = phieunhapCTServices.getRecords(MaPN);
        dsPhieunhapCT = list;

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaCTPN();
            row[1] = list.get(i).getMaPN();
            row[2] = list.get(i).getMaSP();
            row[3] = list.get(i).getSoLuong();
            row[4] = en.format(list.get(i).getDonGia());
            model.addRow(row);
        }
        ListSelectionModel cellSelectionModel = tblPhieuNhapCT.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                gridSelectedChanged(e);
            }
        });

    }

    public void gridSelectedChanged(ListSelectionEvent e) {
        String selectedData = null;
        String selectedID = "";

        int[] selectedRows = tblPhieuNhapCT.getSelectedRows();
        int[] selectedColumns = tblPhieuNhapCT.getSelectedColumns();

        int selectedRow = tblPhieuNhapCT.getSelectedRow();
        int selectedColumn = tblPhieuNhapCT.getSelectedColumn();

        if (selectedRow >= 0 && selectedColumn >= 0) {
            selectedData = String.valueOf(tblPhieuNhapCT.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) tblPhieuNhapCT.getValueAt(selectedRow, 0);
            selectedPhieunhapCT = findCTPhieunhap(selectedID, dsPhieunhapCT);

            ShowDataDetail(selectedID,
                    (String) tblPhieuNhapCT.getValueAt(selectedRow, 1),
                    (String) tblPhieuNhapCT.getValueAt(selectedRow, 2),
                    (long) tblPhieuNhapCT.getValueAt(selectedRow, 3),
                    (String) tblPhieuNhapCT.getValueAt(selectedRow, 4));
        }
    }

    private void ShowDataDetail(String MaCTPN, String MaPN, String MaSP, long SoLuong, String DonGia) {
        txt_mactpn.setText(MaCTPN);
        txt_mapn.setText(MaPN);

        if (selectedPhieunhapCT != null) {
            txt_masp.setSelectedItem(findSanpham(selectedPhieunhapCT.getMaSP(), dsSanpham));
        }

        txtSoLuong.setText(String.valueOf(SoLuong));
        txtDonGia.setText(DonGia);
    }

    public void loadSanpham(String MaNCC) {
        txt_masp.removeAllItems();
        dsSanpham = sanphamServices.getSP(MaNCC);
        for (sanphamTT item : dsSanpham) {
            txt_masp.addItem(item);
        }
        //jcbAuthor = new JComboBox(new DefaultComboBoxModel(authors));
        txt_masp.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof sanphamTT) {
                    sanphamTT sanpham = (sanphamTT) value;
                    setText(String.valueOf(sanpham.getName()));
                }
                return this;
            }
        });
    }

    public sanphamTT findSanpham(String ID, ArrayList<sanphamTT> sanpham) {
        for (sanphamTT item : sanpham) {
            if (item.getID().equals(ID)) {
                return item;
            }
        }
        return null;
    }

    public ct_phieunhapTT findCTPhieunhap(String MACTPN, ArrayList<ct_phieunhapTT> ct_phieunhap) {
        for (ct_phieunhapTT item : ct_phieunhap) {
            if (item.getMaCTPN().equals(MACTPN)) {
                return item;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_masp = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_mactpn = new javax.swing.JLabel();
        txt_mapn = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_nguoilap = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhapCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết phiếu nhập kho");
        setResizable(false);

        jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Mã sản phẩm");

        txt_masp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maspActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lượng nhập");

        jLabel5.setText("Đơn giá nhập");

        jLabel1.setText("Mã chi tiết phiếu nhập:");

        jLabel2.setText("Mã phiếu nhập:");

        txt_mactpn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mactpn.setForeground(new java.awt.Color(255, 51, 0));
        txt_mactpn.setText("000");

        txt_mapn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mapn.setText("000");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mactpn)
                            .addComponent(txt_mapn))))
                .addGap(134, 134, 134))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_mactpn))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_mapn))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelHeader.setBackground(java.awt.SystemColor.activeCaption);
        jPanelHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelHeader.setPreferredSize(new java.awt.Dimension(618, 74));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CHI TIẾT PHIẾU NHẬP KHO");
        jLabel9.setIconTextGap(10);

        txt_nguoilap.setText("Null");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_nguoilap)
                .addGap(223, 223, 223)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                        .addComponent(txt_nguoilap)
                        .addContainerGap())))
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

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/close2.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblPhieuNhapCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết phiếu nhập", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng nhập", "Đơn giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhapCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        Phieunhap phieunhap = new Phieunhap();
        phieunhap.setTenUser(txt_nguoilap.getText());
        this.dispose();

        //vi tri giua man hinh
        phieunhap.pack();
        phieunhap.setLocationRelativeTo(null);
        phieunhap.setVisible(true);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String MaPN = txt_mapn.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        long SoLuong = Long.valueOf(txtSoLuong.getText().trim());
        long DonGia = Long.valueOf(txtDonGia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));

        int rowEffected = phieunhapCTServices.AddNewRecord(MaPN, masp.getID(), SoLuong, DonGia);
        if (rowEffected > 0) {          
            int rowEffected2 = phieunhapCTServices.AddNewRecord2(MaPN, masp.getID(), SoLuong, DonGia);
            if(rowEffected2 > 0){
                JOptionPane.showMessageDialog(null, "Thêm thành công!");   
                showDataList(MaPN); 
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Tạo mới thất bại (Do sai hoặc đã tồn tại)");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String MaCTPN = txt_mactpn.getText().trim();
        String MaPN = txt_mapn.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        
        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa chi tiết phiếu xuất " + MaCTPN + " ?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (input == 0) {

            int rowEffected = phieunhapCTServices.DeleteRecord(MaCTPN, masp.getID());
            if (rowEffected > 0) {
                showDataList(MaPN);
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String MaCTPN = txt_mactpn.getText().trim();
        String MaPN = txt_mapn.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        int SoLuong = Integer.valueOf(txtSoLuong.getText().trim());
        long DonGia = Long.valueOf(txtDonGia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));

        int rowEffected = phieunhapCTServices.UpdateRecord(MaCTPN, MaPN, masp.getID(), SoLuong, DonGia);
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            showDataList(MaPN);
        } else
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txt_maspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maspActionPerformed

    }//GEN-LAST:event_txt_maspActionPerformed

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
            java.util.logging.Logger.getLogger(CT_Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CT_Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CT_Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CT_Phieunhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CT_Phieunhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuNhapCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JLabel txt_mactpn;
    private javax.swing.JLabel txt_mapn;
    private javax.swing.JComboBox<sanphamTT> txt_masp;
    private javax.swing.JLabel txt_nguoilap;
    // End of variables declaration//GEN-END:variables

}
