/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import quanlyxe.xuly.ketnoi_sql;
/**
 *
 * @author BND6699
 */
public class Menu extends javax.swing.JFrame {
    
    public void setTenUser(String username){        
        this.txt_username.setText(username);
        
        String b = "admin";
        
        boolean c = b.equals(username);
        
        System.out.println(c);
        if(c == true)
        {
            btn_taikhoan.setEnabled(true);
        } 
        
        if(c == false)
        {
            btn_taikhoan.setEnabled(false); 
        }
        System.out.println(username);
    }
    
    public Menu() {
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

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        btn_sanpham = new javax.swing.JButton();
        btn_nhacungcap = new javax.swing.JButton();
        btn_khachhang = new javax.swing.JButton();
        btn_phieu = new javax.swing.JButton();
        btn_baocao = new javax.swing.JButton();
        btn_taikhoan = new javax.swing.JButton();
        btn_kho = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_dangnhaplai = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý xe máy");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 180, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_sanpham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/cp.png"))); // NOI18N
        btn_sanpham.setText("Thông tin sản phẩm");
        btn_sanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanphamActionPerformed(evt);
            }
        });

        btn_nhacungcap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_nhacungcap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/groupbook.png"))); // NOI18N
        btn_nhacungcap.setText("Thông tin nhà cung cấp");
        btn_nhacungcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhacungcapActionPerformed(evt);
            }
        });

        btn_khachhang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/people.png"))); // NOI18N
        btn_khachhang.setText("Thông tin khách hàng");
        btn_khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khachhangActionPerformed(evt);
            }
        });

        btn_phieu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_phieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/ban.png"))); // NOI18N
        btn_phieu.setText("Phiếu nhập, xuất, hóa đơn");
        btn_phieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_phieuActionPerformed(evt);
            }
        });

        btn_baocao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_baocao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report4.png"))); // NOI18N
        btn_baocao.setText("Báo cáo");
        btn_baocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_baocaoActionPerformed(evt);
            }
        });

        btn_taikhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_taikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/people2.png"))); // NOI18N
        btn_taikhoan.setText("Quản lý tài khoản");
        btn_taikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taikhoanActionPerformed(evt);
            }
        });

        btn_kho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_kho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/home1.png"))); // NOI18N
        btn_kho.setText("Kho sản phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_sanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(btn_khachhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(btn_phieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(btn_baocao, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(btn_taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(btn_kho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btn_kho, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_phieu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_baocao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(new java.awt.Color(153, 180, 209));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("MOWO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_dangnhaplai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/logout.png"))); // NOI18N
        btn_dangnhaplai.setText("Đăng xuất");
        btn_dangnhaplai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangnhaplaiActionPerformed(evt);
            }
        });

        desktop.setBackground(new java.awt.Color(255, 153, 102));
        desktop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/Capture.PNG"))); // NOI18N
        desktop.add(jLabel1);
        jLabel1.setBounds(-70, -70, 390, 450);

        txt_username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 51, 51));
        txt_username.setText("username");

        jLabel3.setText("Người dùng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_username)
                        .addGap(39, 39, 39)
                        .addComponent(btn_dangnhaplai))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktop))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(desktop)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_dangnhaplai)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_username)
                                .addComponent(jLabel3))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_taikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taikhoanActionPerformed
        //tài khoản
        Taikhoan taikhoan = new Taikhoan();
        //vi tri giua man hinh
        taikhoan.pack();
        taikhoan.setLocationRelativeTo(null);        
        taikhoan.setVisible(true);
    }//GEN-LAST:event_btn_taikhoanActionPerformed
    
    // Đăng xuất
    private void btn_dangnhaplaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangnhaplaiActionPerformed
        Dangnhap dangnhap = new Dangnhap();
        dangnhap.pack();
        dangnhap.setLocationRelativeTo(null);
        dangnhap.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_btn_dangnhaplaiActionPerformed

    private void btn_sanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanphamActionPerformed
        MenuSP menusp;

        try {
            menusp = new MenuSP();
            // new loginJFrame().show();
            // dispose();
            //setSize(frame);
            menusp.setVisible(true);
  
            desktop.add(menusp);
            menusp.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sanphamActionPerformed

    private void btn_baocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_baocaoActionPerformed
        
    }//GEN-LAST:event_btn_baocaoActionPerformed

    private void btn_phieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_phieuActionPerformed
        MenuNX menunx;

        try {
            menunx = new MenuNX();
            // new loginJFrame().show();
            // dispose();
            //setSize(frame);
            menunx.setVisible(true);
  
            desktop.add(menunx);
            menunx.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(MenuSP.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_btn_phieuActionPerformed

    private void btn_nhacungcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhacungcapActionPerformed
        //Nhà cung cấp
        Nhacungcap nhacungcap = new Nhacungcap();
        //vi tri giua man hinh
        nhacungcap.pack();
        nhacungcap.setLocationRelativeTo(null);        
        nhacungcap.setVisible(true);
    }//GEN-LAST:event_btn_nhacungcapActionPerformed

    private void btn_khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khachhangActionPerformed
         //Nhà khách hàng
        Khachhang khachhang = new Khachhang();
        //vi tri giua man hinh
        khachhang.pack();
        khachhang.setLocationRelativeTo(null);        
        khachhang.setVisible(true);
    }//GEN-LAST:event_btn_khachhangActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_baocao;
    private javax.swing.JButton btn_dangnhaplai;
    private javax.swing.JButton btn_khachhang;
    private javax.swing.JButton btn_kho;
    private javax.swing.JButton btn_nhacungcap;
    private javax.swing.JButton btn_phieu;
    private javax.swing.JButton btn_sanpham;
    private javax.swing.JButton btn_taikhoan;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txt_username;
    // End of variables declaration//GEN-END:variables
   



}