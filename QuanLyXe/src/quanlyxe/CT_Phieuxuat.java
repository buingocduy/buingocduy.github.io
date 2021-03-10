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
public class CT_Phieuxuat extends javax.swing.JFrame {

    ct_phieuxuatTT selectedPhieuXuatCT = null;
    ct_phieuxuatXL phieuXuatCTServices = new ct_phieuxuatXL();

    sanphamXL sanphamServices = new sanphamXL();
    phieuxuatXL phieuxuatServices = new phieuxuatXL();

    ArrayList<sanphamTT> dsSanpham = new ArrayList<sanphamTT>();
    ArrayList<ct_phieuxuatTT> dsPhieuXuatCT = new ArrayList<ct_phieuxuatTT>();
    ArrayList<phieuxuatTT> dsPX = new ArrayList<phieuxuatTT>();

    /**
     * Creates new form frmPhieuXuatCT
     */
    public CT_Phieuxuat() {
        initComponents();
        loadSanpham();

    }

    public void setMPX(String MaPX) {
        this.txt_mapx.setText(MaPX);

    }

    public void showDataList(String MaPX) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuXuatCT.getModel();
        model.setRowCount(0);

        ArrayList<ct_phieuxuatTT> list = phieuXuatCTServices.getRecords(MaPX);
        dsPhieuXuatCT = list;

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaCTPX();
            row[1] = list.get(i).getMaPX();
            row[2] = list.get(i).getMaSP();
            row[3] = list.get(i).getSoLuong();
            row[4] = en.format(list.get(i).getDonGia());
            model.addRow(row);
        }
        ListSelectionModel cellSelectionModel = tblPhieuXuatCT.getSelectionModel();
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

        int[] selectedRows = tblPhieuXuatCT.getSelectedRows();
        int[] selectedColumns = tblPhieuXuatCT.getSelectedColumns();

        int selectedRow = tblPhieuXuatCT.getSelectedRow();
        int selectedColumn = tblPhieuXuatCT.getSelectedColumn();

        if (selectedRow >= 0 && selectedColumn >= 0) {
            selectedData = String.valueOf(tblPhieuXuatCT.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) tblPhieuXuatCT.getValueAt(selectedRow, 0);
            selectedPhieuXuatCT = findCTPhieuxuat(selectedID, dsPhieuXuatCT);

            ShowDataDetail(selectedID,
                    (String) tblPhieuXuatCT.getValueAt(selectedRow, 1),
                    (String) tblPhieuXuatCT.getValueAt(selectedRow, 2),
                    (long) tblPhieuXuatCT.getValueAt(selectedRow, 3),
                    (String) tblPhieuXuatCT.getValueAt(selectedRow, 4));

        }
    }

    private void ShowDataDetail(String MaCTPX, String MaPX, String MaSP, long SoLuong, String DonGia) {
        txt_mactpx.setText(MaCTPX);
        txt_mapx.setText(MaPX);

        if (selectedPhieuXuatCT != null) {
            txt_masp.setSelectedItem(findSanpham(selectedPhieuXuatCT.getMaSP(), dsSanpham));
        }

        txtSoLuong.setText(String.valueOf(SoLuong));
        txtDonGia.setText(DonGia);
    }

    private void loadSanpham() {
        txt_masp.removeAllItems();
        dsSanpham = sanphamServices.getAllRecords();
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

    public ct_phieuxuatTT findCTPhieuxuat(String MACTPX, ArrayList<ct_phieuxuatTT> ct_phieuxuat) {
        for (ct_phieuxuatTT item : ct_phieuxuat) {
            if (item.getMaCTPX().equals(MACTPX)) {
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
        txt_mapx = new javax.swing.JTextField();
        txt_mactpx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuXuatCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết phiêu xuất kho");
        setResizable(false);

        jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Mã sản phẩm");

        txt_masp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maspActionPerformed(evt);
            }
        });

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Đơn Giá");

        txt_mapx.setEnabled(false);

        txt_mactpx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mactpx.setForeground(new java.awt.Color(255, 51, 0));
        txt_mactpx.setEnabled(false);

        jLabel1.setText("Mã chi tiết phiếu xuất");

        jLabel2.setText("Mã phiêu xuất");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
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
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_mapx)
                            .addComponent(txt_masp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mactpx, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(144, 144, 144))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mactpx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mapx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CHI TIẾT PHIẾU XUẤT KHO");
        jLabel9.setIconTextGap(10);

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addContainerGap(28, Short.MAX_VALUE))
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

        tblPhieuXuatCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết phiêu xuất", "Mã phiếu xuất", "Mã sản phẩm", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPhieuXuatCT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        Phieuxuat phieuxuat = new Phieuxuat();
        this.dispose();

        //vi tri giua man hinh
        phieuxuat.pack();
        phieuxuat.setLocationRelativeTo(null);
        phieuxuat.setVisible(true);
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maPX = txt_mapx.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        int SoLuong = Integer.valueOf(txtSoLuong.getText().trim());
        long DonGia = Long.valueOf(txtDonGia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));

        int rowEffected = phieuXuatCTServices.AddNewRecord(maPX, masp.getID(), SoLuong, DonGia);
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            showDataList(maPX);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maCTPX = txt_mactpx.getText().trim();
        String maPX = txt_mapx.getText().trim();
        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa chi tiết phiếu xuất " + maCTPX + " ?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (input == 0) {

            int rowEffected = phieuXuatCTServices.DeleteRecord(maCTPX);
            if (rowEffected > 0) {
                showDataList(maPX);
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String maCTPX = txt_mactpx.getText().trim();
        String maPX = txt_mapx.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        int SoLuong = Integer.valueOf(txtSoLuong.getText().trim());
        long DonGia = Long.valueOf(txtDonGia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));

        int rowEffected = phieuXuatCTServices.UpdateRecord(maCTPX, maPX, masp.getID(), SoLuong, DonGia);
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            showDataList(maPX);
        } else
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txt_maspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maspActionPerformed
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        System.out.println(masp.getName() + "-" + masp.getPrice());
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        long giaban = masp.getPrice();
        String str1 = en.format(giaban);
        txtDonGia.setText(str1);
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
            java.util.logging.Logger.getLogger(CT_Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CT_Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CT_Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CT_Phieuxuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CT_Phieuxuat().setVisible(true);
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
    private javax.swing.JTable tblPhieuXuatCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txt_mactpx;
    private javax.swing.JTextField txt_mapx;
    private javax.swing.JComboBox<sanphamTT> txt_masp;
    // End of variables declaration//GEN-END:variables

}
