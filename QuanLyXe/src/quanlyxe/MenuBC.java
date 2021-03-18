/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import quanlyxe.xuly.ketnoi_sql;

/**
 *
 * @author BND6699
 */
public class MenuBC extends javax.swing.JFrame {

    /**
     * Creates new form MenuBC
     */
    public MenuBC() {
        initComponents();     

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ngaybatdau = new com.toedter.calendar.JDateChooser();
        ngaykethuc = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_doanhso = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cb_DSB = new javax.swing.JRadioButton();
        cb_CTDSB = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btn_thongkesanpham = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setTitle("Báo cáo");
        setResizable(false);

        ngaybatdau.setDateFormatString("dd/MM/yyyy");

        ngaykethuc.setDateFormatString("dd/MM/yyyy");

        jLabel1.setText("Từ ngày");

        jLabel2.setText("Đến ngày");

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("XEM BÁO CÁO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(28, 28, 28))
        );

        btn_doanhso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report2.png"))); // NOI18N
        btn_doanhso.setText("Xem");
        btn_doanhso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doanhsoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn"));

        buttonGroup1.add(cb_DSB);
        cb_DSB.setText("Danh số bán");

        buttonGroup1.add(cb_CTDSB);
        cb_CTDSB.setText("Chi tiết doanh số bán");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cb_DSB)
            .addComponent(cb_CTDSB)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_DSB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_CTDSB)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/cp.png"))); // NOI18N

        btn_thongkesanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report1.png"))); // NOI18N
        btn_thongkesanpham.setText("Xuất thống kê sản phẩm");
        btn_thongkesanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thongkesanphamMouseClicked(evt);
            }
        });
        btn_thongkesanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkesanphamActionPerformed(evt);
            }
        });
        jMenu1.add(btn_thongkesanpham);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/people.png"))); // NOI18N

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report1.png"))); // NOI18N
        jMenu3.setText("Xuất thông tin khách hàng");
        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ngaykethuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_doanhso))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngaykethuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_doanhso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_doanhsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doanhsoActionPerformed
        
        Date startDate = ngaybatdau.getDate();
        Date endDate = ngaykethuc.getDate();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        
  
        if (startDate == null | endDate == null) 
        {
            JOptionPane.showMessageDialog(null, "Hãy chọn ngày bắt đầu và kết thúc");
        }
        
        else if(cb_DSB.isSelected() == true) //Xem doanh số
        {
            String strngaybd = formatter.format(startDate);
            String strngaytk = formatter.format(endDate);
            
            String tungay = formatter2.format(startDate);
            String denngay = formatter2.format(endDate);
            
            Baocao baocao = new Baocao();
            baocao.showDataList(strngaybd, strngaytk);
            baocao.showTong(strngaybd, strngaytk);
            baocao.setNgay(tungay, denngay);
            
            //vi tri giua man hinh va maximize
            baocao.pack();
            baocao.setLocationRelativeTo(null);
            baocao.setVisible(true);
        }   
        
        else if(cb_CTDSB.isSelected() == true)// Xem chi tiết doanh số
        {
            String strngaybd = formatter.format(startDate);
            String strngaytk = formatter.format(endDate);
            
            String tungay = formatter2.format(startDate);
            String denngay = formatter2.format(endDate);
            
            CT_Baocao ctbaocao = new CT_Baocao();
            ctbaocao.showDataList(strngaybd, strngaytk);
            ctbaocao.showTong(strngaybd, strngaytk);
            ctbaocao.setNgay(tungay, denngay);
            
            //vi tri giua man hinh va maximize
            ctbaocao.pack();
            ctbaocao.setLocationRelativeTo(null);
            ctbaocao.setVisible(true);
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Hãy chọn 1 trong 2 cái để xem");
        }     
    }//GEN-LAST:event_btn_doanhsoActionPerformed
    
    //Xuất thống kê sản phẩm
    private void btn_thongkesanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkesanphamActionPerformed

    }//GEN-LAST:event_btn_thongkesanphamActionPerformed

    private void btn_thongkesanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongkesanphamMouseClicked
         try {
            ketnoi_sql sql = new ketnoi_sql();
                   
            JasperDesign jd = JRXmlLoader.load("G:\\BuiNgocDuy\\QuanLyXe\\src\\quanlyxe\\baocao\\ThongKeSLSP.jrxml");       
            JasperReport jr = JasperCompileManager.compileReport("G:\\BuiNgocDuy\\QuanLyXe\\src\\quanlyxe\\baocao\\ThongKeSLSP.jrxml");  
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), sql.getConnection());
            JasperViewer.viewReport(jp);
            JasperExportManager.exportReportToPdfFile( jp,"G:\\BuiNgocDuy\\QuanLyXe\\src\\quanlyxe\\baocao\\ThongKeSLSP.pdf");
                    
        } catch (ClassNotFoundException | SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Cannot show report" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Sanpham.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_btn_thongkesanphamMouseClicked

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
            java.util.logging.Logger.getLogger(MenuBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_doanhso;
    private javax.swing.JMenu btn_thongkesanpham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cb_CTDSB;
    private javax.swing.JRadioButton cb_DSB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser ngaybatdau;
    private com.toedter.calendar.JDateChooser ngaykethuc;
    // End of variables declaration//GEN-END:variables
}
