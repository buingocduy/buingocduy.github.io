package bookstore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.DesktopPaneUI;


/**
 *
 * @author 10520_000
 */
public class jframeMain extends javax.swing.JFrame implements ActionListener{
    JLabel lbUser, lbquyen ;
    //AutoSuggest _tenKhach = null;
    public jframeMain() {
       lbUser = new JLabel("");
		lbUser.setForeground(Color.WHITE);
		lbUser.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lbUser.setBackground(Color.WHITE);
		lbUser.setBounds(1180,665, 170, 26);
		getContentPane().add(lbUser);

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Image/login.png"));
        
        
        initComponents();
              
        
        //Make dragging a little faster but perhaps uglier.        
        //setExtendedState(MAXIMIZED_BOTH);
         
        
    }

//    // Set kich thuoc cac tab menu
//    private void setSize(JInternalFrame frm){
//        frm.setSize(283, 270);
//    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        desktopCN = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelTab = new javax.swing.JPanel();
        jBtnPublisher = new javax.swing.JButton();
        jBtnBook = new javax.swing.JButton();
        jButtonUserAccount = new javax.swing.JButton();
        jBtnWarehouse = new javax.swing.JButton();
        jBtnGiaoDich = new javax.swing.JButton();
        jButtonBaoCao = new javax.swing.JButton();
        jBtnCustomer = new javax.swing.JButton();
        jBtnAuthor = new javax.swing.JButton();
        jBtnProvider = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        lbUsername = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ NHÀ SÁCH");
        setLocationByPlatform(true);

        desktopCN.setBackground(java.awt.SystemColor.activeCaption);
        desktopCN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        desktopCN.add(jLabel5);
        jLabel5.setBounds(20, 100, 0, 0);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUẢN LÝ CỬA HÀNG SÁCH");
        desktopCN.add(jLabel3);
        jLabel3.setBounds(180, 60, 760, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/books2.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopCN.add(jLabel1);
        jLabel1.setBounds(370, 200, 240, 240);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/books.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        desktopCN.add(jLabel4);
        jLabel4.setBounds(340, 490, 480, 210);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        desktopCN.add(jLabel6);
        jLabel6.setBounds(10, 360, 310, 150);

        jPanelTab.setBackground(new java.awt.Color(51, 51, 51));
        jPanelTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTab.setForeground(new java.awt.Color(255, 255, 255));

        jBtnPublisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/groupbook.png"))); // NOI18N
        jBtnPublisher.setText("Thông tin Nhà xuất bản");
        jBtnPublisher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPublisherActionPerformed(evt);
            }
        });

        jBtnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book.png"))); // NOI18N
        jBtnBook.setText("Thông tin sách");
        jBtnBook.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBookActionPerformed(evt);
            }
        });

        jButtonUserAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/people3.png"))); // NOI18N
        jButtonUserAccount.setText("Quản Lý User Account");
        jButtonUserAccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUserAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserAccountActionPerformed(evt);
            }
        });

        jBtnWarehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home1.png"))); // NOI18N
        jBtnWarehouse.setText("Thông tin kho");
        jBtnWarehouse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnWarehouseActionPerformed(evt);
            }
        });

        jBtnGiaoDich.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ban.png"))); // NOI18N
        jBtnGiaoDich.setText("Phiếu Nhập, Xuất, Hóa Đơn");
        jBtnGiaoDich.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGiaoDichActionPerformed(evt);
            }
        });

        jButtonBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report4.png"))); // NOI18N
        jButtonBaoCao.setText("Báo cáo");
        jButtonBaoCao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaoCaoActionPerformed(evt);
            }
        });

        jBtnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/people.png"))); // NOI18N
        jBtnCustomer.setText("Thông tin Khách hàng");
        jBtnCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerActionPerformed(evt);
            }
        });

        jBtnAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/author.png"))); // NOI18N
        jBtnAuthor.setText("Thông tin Tác giả");
        jBtnAuthor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAuthorActionPerformed(evt);
            }
        });

        jBtnProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/data.png"))); // NOI18N
        jBtnProvider.setText("Thông tin Nhà cung cấp");
        jBtnProvider.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProviderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTabLayout = new javax.swing.GroupLayout(jPanelTab);
        jPanelTab.setLayout(jPanelTabLayout);
        jPanelTabLayout.setHorizontalGroup(
            jPanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUserAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTabLayout.setVerticalGroup(
            jPanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabLayout.createSequentialGroup()
                .addComponent(jBtnWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButtonBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        jButtonLogout.setText("Đăng xuất");
        jButtonLogout.setToolTipText("");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close1.png"))); // NOI18N
        jButtonExit.setText("Thoát");
        jButtonExit.setToolTipText("");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        desktop.setBackground(java.awt.SystemColor.activeCaption);
        desktop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbUsername.setForeground(java.awt.SystemColor.textHighlight);
        lbUsername.setText("username");
        desktop.add(lbUsername);
        lbUsername.setBounds(40, 90, 110, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.textHighlight);
        jLabel2.setText("Welcome");
        desktop.add(jLabel2);
        jLabel2.setBounds(40, 30, 140, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopCN, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(desktopCN, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(desktop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExit)
                            .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        frmDangNhap frmDN = new frmDangNhap();
        //vi tri giua man hinh
        frmDN.pack();
        frmDN.setLocationRelativeTo(null);
        frmDN.setVisible(true);
        dispose();        
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonThongtin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThongTinActionPerformed
        // TODO add your handling code here:
                   
    }//GEN-LAST:event_jButtonThongTinActionPerformed

    private void jButtonBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaoCaoActionPerformed
        // TODO add your handling code here:
        /*
        JIFBaoCao frame;
        try {
            frame = new JIFBaoCao();
            setSize(frame);
            frame.setVisible(true);
            frame.setDesktop(desktopCN);
            desktop.add(frame);
            frame.setSelected(true);
            
        } catch (PropertyVetoException ex) {
            Logger.getLogger(JIFTainguyen.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_jButtonBaoCaoActionPerformed

    private void jBtnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnWarehouseActionPerformed
        //Quan ly Kho
        frmWarehouse form = new frmWarehouse();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnWarehouseActionPerformed

    private void jBtnPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPublisherActionPerformed
        //Nha XB
        frmNhaXuatBan form = new frmNhaXuatBan();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnPublisherActionPerformed

    private void jBtnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAuthorActionPerformed
        // Quản lý tác giả
        frmAuthor form = new frmAuthor();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnAuthorActionPerformed

    private void jBtnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerActionPerformed
        // Quan ly khach hang
        frmKhachHang form = new frmKhachHang();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnCustomerActionPerformed

    private void jBtnProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProviderActionPerformed
        // Form Quan ly thông tin Nhà Cung cấp
        frmProvider form = new frmProvider();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnProviderActionPerformed

    private void jButtonUserAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserAccountActionPerformed
        frmUserAccount form = new frmUserAccount();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.setVisible(true);
    }//GEN-LAST:event_jButtonUserAccountActionPerformed

    private void jBtnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBookActionPerformed
        // TODO add your handling code here:
        
        JIFBookMenu frame;
        
        try {
            frame = new JIFBookMenu();
           // new loginJFrame().show();
           // dispose();
            //setSize(frame);
            frame.setVisible(true);
            frame.setDesktop(desktopCN);
            desktop.add(frame);
            frame.setSelected(true);
                       
        } catch (PropertyVetoException ex) {
            Logger.getLogger(JIFBookMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnBookActionPerformed

    private void jBtnGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGiaoDichActionPerformed
        hoadon form = new hoadon();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.setVisible(true);
    }//GEN-LAST:event_jBtnGiaoDichActionPerformed

    
    
    public void setTenUser(String username){ 
        this.lbUser.setText(username);
        this.lbUsername.setText(username);
    }
    public static void main(String args[]) 
    {
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new jframeMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JDesktopPane desktopCN;
    private javax.swing.JButton jBtnAuthor;
    private javax.swing.JButton jBtnBook;
    private javax.swing.JButton jBtnCustomer;
    private javax.swing.JButton jBtnGiaoDich;
    private javax.swing.JButton jBtnProvider;
    private javax.swing.JButton jBtnPublisher;
    private javax.swing.JButton jBtnWarehouse;
    private javax.swing.JButton jButtonBaoCao;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonUserAccount;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelTab;
    private javax.swing.JLabel lbUsername;
    // End of variables declaration//GEN-END:variables
    
     

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object getDesktop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
