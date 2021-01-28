
package quanlyxe;


import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author 10520_000
 */
public class MenuNX extends javax.swing.JInternalFrame {

    private JDesktopPane desktop;
    /**
     * Creates new form JIFTainguyen
     */
    public MenuNX() throws PropertyVetoException {
        
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
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanelDanhMuc = new javax.swing.JPanel();
        jLabelTieuDe = new javax.swing.JLabel();
        btn_thoat = new javax.swing.JButton();
        btn_sanpham = new javax.swing.JButton();
        btn_loaisp = new javax.swing.JButton();
        btn_sanpham1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

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

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Quản lý thông tin sản phẩm");
        setMaximumSize(new java.awt.Dimension(80, 80));

        jPanelDanhMuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelDanhMuc.setPreferredSize(new java.awt.Dimension(238, 288));

        jLabelTieuDe.setBackground(new java.awt.Color(255, 153, 255));
        jLabelTieuDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTieuDe.setForeground(new java.awt.Color(255, 51, 51));
        jLabelTieuDe.setText("Phiếu nhập, xuất, hóa đơn");

        btn_thoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/close1.png"))); // NOI18N
        btn_thoat.setText("Đóng");
        btn_thoat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        btn_sanpham.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report3.png"))); // NOI18N
        btn_sanpham.setText("Phiếu xuất");
        btn_sanpham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanphamActionPerformed(evt);
            }
        });

        btn_loaisp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_loaisp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/list.png"))); // NOI18N
        btn_loaisp.setText("Phiếu nhập");
        btn_loaisp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_loaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loaispActionPerformed(evt);
            }
        });

        btn_sanpham1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sanpham1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report.png"))); // NOI18N
        btn_sanpham1.setText("Hóa đơn");
        btn_sanpham1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sanpham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanpham1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDanhMucLayout = new javax.swing.GroupLayout(jPanelDanhMuc);
        jPanelDanhMuc.setLayout(jPanelDanhMucLayout);
        jPanelDanhMucLayout.setHorizontalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhMucLayout.createSequentialGroup()
                        .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_thoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_sanpham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(btn_loaisp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDanhMucLayout.createSequentialGroup()
                        .addComponent(btn_sanpham1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTieuDe)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDanhMucLayout.setVerticalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addComponent(jLabelTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sanpham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sanpham1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_thoat)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanphamActionPerformed
        //sản phẩm

        
    }//GEN-LAST:event_btn_sanphamActionPerformed

    private void btn_loaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loaispActionPerformed
  
 
    }//GEN-LAST:event_btn_loaispActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_sanpham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanpham1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sanpham1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loaisp;
    private javax.swing.JButton btn_sanpham;
    private javax.swing.JButton btn_sanpham1;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JInternalFrame jInternalFrame1;
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
