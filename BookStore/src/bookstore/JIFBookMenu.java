
package bookstore;


import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.sql.*;

/**
 *
 * @author 10520_000
 */
public class JIFBookMenu extends javax.swing.JInternalFrame {

    private JDesktopPane desktop;
    /**
     * Creates new form JIFTainguyen
     */
    public JIFBookMenu() throws PropertyVetoException {
        
        this.setFrameIcon(new ImageIcon("Image/login.png"));
       javax.swing.plaf.InternalFrameUI gui  = this.getUI();  
            ((javax.swing.plaf.basic.BasicInternalFrameUI)gui).setNorthPane(null);
        initComponents();
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanelDanhMuc = new javax.swing.JPanel();
        jLabelTieuDe = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jButtonNhapSach = new javax.swing.JButton();
        jButtonLoaiSach = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setMaximumSize(new java.awt.Dimension(80, 80));

        jPanelDanhMuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelDanhMuc.setPreferredSize(new java.awt.Dimension(238, 288));

        jLabelTieuDe.setBackground(new java.awt.Color(255, 153, 255));
        jLabelTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTieuDe.setForeground(java.awt.SystemColor.textHighlight);
        jLabelTieuDe.setText("Quản lý thông tin sách");

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close1.png"))); // NOI18N
        jButtonClose.setText("Đóng");
        jButtonClose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonNhapSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/book.png"))); // NOI18N
        jButtonNhapSach.setText("Thông tin sách");
        jButtonNhapSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonNhapSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhapSachActionPerformed(evt);
            }
        });

        jButtonLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/list.png"))); // NOI18N
        jButtonLoaiSach.setText("THông tin loại sách");
        jButtonLoaiSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoaiSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDanhMucLayout = new javax.swing.GroupLayout(jPanelDanhMuc);
        jPanelDanhMuc.setLayout(jPanelDanhMucLayout);
        jPanelDanhMucLayout.setHorizontalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhMucLayout.createSequentialGroup()
                        .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNhapSach, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(jButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanelDanhMucLayout.setVerticalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addComponent(jLabelTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLoaiSach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNhapSach)
                .addGap(45, 45, 45)
                .addComponent(jButtonClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNhapSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhapSachActionPerformed
        // TODO add your handling code here:
        //Quan ly Kho
        frmBook form = new frmBook();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);        
        form.setVisible(true);
        
    }//GEN-LAST:event_jButtonNhapSachActionPerformed

    private void jButtonLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoaiSachActionPerformed
        // Loai sach
        frmLoaiSach form = new frmLoaiSach();
        //vi tri giua man hinh
        form.pack();
        form.setLocationRelativeTo(null);        
        form.setVisible(true);
    }//GEN-LAST:event_jButtonLoaiSachActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLoaiSach;
    private javax.swing.JButton jButtonNhapSach;
    private javax.swing.JLabel jLabelTieuDe;
    private javax.swing.JPanel jPanelDanhMuc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the desktop
     * 
     */
    public JDesktopPane getDesktop() {
        return desktop;
    }

    
    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

  
}
