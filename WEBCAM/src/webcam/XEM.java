/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import webcam.xuly.khachhang;
import webcam.thuthe.khachhangTT;
/**
 *
 * @author BND6699
 */
public class XEM extends javax.swing.JFrame {

    khachhangTT selectedKH = null;
    khachhang KHservices = new khachhang();

    ArrayList<khachhangTT> dsKH = new ArrayList<>();

    public XEM() {
        initComponents();
        showDataList();
    }
    
    public void showDataList() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<khachhangTT> list = KHservices.getAllRecords();
        dsKH = list;

        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getSTT();
            row[1] = list.get(i).getHOTEN();
            row[2] = list.get(i).getNGAYGIOVAO();
            row[3] = list.get(i).getHINHANH();
            
            model.addRow(row);
        }
        
        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //goi ham show data chi tiet
                gridSelectedChanged(e);
            }
          });
    }
    
     public void gridSelectedChanged(ListSelectionEvent e) {
        String selectedData = null;
        String selectedID = ""; 

        int[] selectedRows = jTable1.getSelectedRows();
        int[] selectedColumns = jTable1.getSelectedColumns();

        int selectedRow = jTable1.getSelectedRow();
        int selectedColumn = jTable1.getSelectedColumn();

        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);
        
        if(selectedRow >=0 && selectedColumn >=0){
            //selectedData = String.valueOf(jTableKho.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) jTable1.getValueAt(selectedRow, 0);

            System.out.println("Selected: "  + selectedID);

            showDataDetail( 
                (String) jTable1.getValueAt(selectedRow, 0),
                (String) jTable1.getValueAt(selectedRow, 1),
                (String) jTable1.getValueAt(selectedRow, 2), 
                (String) jTable1.getValueAt(selectedRow, 3)); 
                
        }
    }
    
    private void showDataDetail(String STT, String HOTEN, String NGAYGIOVAO, String HINHANH){
        
        txt_stt.setText(String.valueOf(STT));
        txt_hoten.setText(HOTEN);
        txt_ngaygiovao.setText(NGAYGIOVAO);
        
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(HINHANH));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(305, 256, image.SCALE_SMOOTH));
            txt_hinhanh.setIcon(icon);
            System.out.println("lấy hình " + icon);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showData(String Ngay) {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<khachhangTT> list = KHservices.getRecords(Ngay);
        dsKH = list;

        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getSTT();
            row[1] = list.get(i).getHOTEN();
            row[2] = list.get(i).getNGAYGIOVAO();
            row[3] = list.get(i).getHINHANH();
            
            model.addRow(row);
        }
        
        ListSelectionModel cellSelectionModel = jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //goi ham show data chi tiet
                gridSelectedChanged(e);
            }
          });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txt_hinhanh = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JLabel();
        txt_stt = new javax.swing.JLabel();
        txt_ngaygiovao = new javax.swing.JLabel();
        txt_ngayxem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_xem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("XEM");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ tên", "Ngày giờ vào", "Hình ảnh"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_hinhanh.setPreferredSize(new java.awt.Dimension(256, 246));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        txt_hoten.setText("jLabel1");

        txt_stt.setText("jLabel2");

        txt_ngaygiovao.setText("jLabel3");

        jLabel1.setText("Chọn ngày xem");

        btn_xem.setText("xem");
        btn_xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemActionPerformed(evt);
            }
        });

        jButton1.setText("tải lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_hoten)
                            .addComponent(txt_stt)
                            .addComponent(txt_ngaygiovao)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ngayxem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_xem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngayxem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_stt)
                        .addGap(18, 18, 18)
                        .addComponent(txt_hoten)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ngaygiovao)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemActionPerformed
        String NGAY = txt_ngayxem.getText().trim();    
        showData(NGAY);
    }//GEN-LAST:event_btn_xemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showDataList();
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
            java.util.logging.Logger.getLogger(XEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XEM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txt_hinhanh;
    private javax.swing.JLabel txt_hoten;
    private javax.swing.JLabel txt_ngaygiovao;
    private javax.swing.JTextField txt_ngayxem;
    private javax.swing.JLabel txt_stt;
    // End of variables declaration//GEN-END:variables
}
