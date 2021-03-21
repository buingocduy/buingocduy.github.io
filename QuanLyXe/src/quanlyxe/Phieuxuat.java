/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

import quanlyxe.thucthe.*;
import quanlyxe.xuly.*;
import com.microsoft.sqlserver.jdbc.*;
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
  
    ArrayList<phieuxuatTT> dsPhieuXuat = new ArrayList<phieuxuatTT>();
    phieuxuatTT selectedPhieuXuat = null;

    public Phieuxuat() {
        initComponents();
        showDataList();
    }

    public void setTenUser(String username) {
        this.txt_nguoilap.setText(username);      
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
            row[2] = formatter2.format(list.get(i).getNgayXuat());
       
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
                    (String) tblPhieuXuat.getValueAt(selectedRow, 2));
        }
    }

    private void ShowDataDetail(String maPX, String userID, String ngayXuat){      
        txtMaPX.setText(maPX);
        txt_nguoilap.setText(userID);
        dtmNgayXuat.setText(ngayXuat);
    }

    private phieuxuatTT findPhieuXuat(String maPX, ArrayList<phieuxuatTT> phieuXuats) {
        for (phieuxuatTT item : phieuXuats) {
            if (item.getMaPX() == maPX) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnChiTiet = new javax.swing.JButton();
        txt_nguoilap = new javax.swing.JLabel();
        txtMaPX = new javax.swing.JLabel();
        dtmNgayXuat = new javax.swing.JLabel();
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(62, 62, 62))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanelDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã phiếu xuất:");

        jLabel2.setText("Người xuất:");

        jLabel6.setText("Ngày xuất kho:");

        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report.png"))); // NOI18N
        btnChiTiet.setText("Xem chi tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        txt_nguoilap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nguoilap.setText("null");

        txtMaPX.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaPX.setForeground(new java.awt.Color(255, 51, 0));
        txtMaPX.setText("000");

        dtmNgayXuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dtmNgayXuat.setText("00/00/0000");

        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/close2.png"))); // NOI18N
        btnClose1.setText("Thoát");
        btnClose1.setIconTextGap(10);
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDetailLayout = new javax.swing.GroupLayout(jPanelDetail);
        jPanelDetail.setLayout(jPanelDetailLayout);
        jPanelDetailLayout.setHorizontalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nguoilap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtmNgayXuat))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDetailLayout.setVerticalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaPX))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nguoilap))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dtmNgayXuat))
                .addGap(51, 51, 51)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu xuất", "Người xuất", "Ngày xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
   
    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed

        CT_Phieuxuat ct_phieuxuat = new CT_Phieuxuat();
        ct_phieuxuat.setMPX(txtMaPX.getText());
        ct_phieuxuat.showDataList(txtMaPX.getText());
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
    private javax.swing.JLabel dtmNgayXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JLabel txtMaPX;
    private javax.swing.JLabel txt_nguoilap;
    // End of variables declaration//GEN-END:variables

}
