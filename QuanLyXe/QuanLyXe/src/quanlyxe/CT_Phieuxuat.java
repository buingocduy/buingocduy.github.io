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
    khoXL khoServices = new khoXL();
    
    ArrayList<khoTT> dsKho = new ArrayList<khoTT>();
    ArrayList<sanphamTT> dsSanpham = new ArrayList<sanphamTT>();
    ArrayList<ct_phieuxuatTT> dsPhieuXuatCT = new ArrayList<ct_phieuxuatTT>();
    ArrayList<phieuxuatTT> dsPX = new ArrayList<phieuxuatTT>();
    ArrayList<soluongTT> dsSoluong = new ArrayList<>();

    /**
     * Creates new form frmPhieuXuatCT
     */
    public CT_Phieuxuat() {
        initComponents();
        loadKho();
        txtSoLuong.setText("0");
    }

    public void setMPX(String MaPX) {
        this.txt_mapx.setText(MaPX);

    }

    public void showDataList(String MaPX) {
        DefaultTableModel model = (DefaultTableModel) this.tblPhieuXuatCT.getModel();
        model.setRowCount(0);

        ArrayList<ct_phieuxuatTT> list = phieuXuatCTServices.getRecords(MaPX);
        dsPhieuXuatCT = list;

        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaCTPX();
            row[1] = list.get(i).getMaPX();
            row[2] = list.get(i).getMaKho();
            row[3] = list.get(i).getMaSP();
            row[4] = list.get(i).getSoLuong();
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
                    (String) tblPhieuXuatCT.getValueAt(selectedRow, 3),
                    (long) tblPhieuXuatCT.getValueAt(selectedRow, 4));

        }
    }

    private void ShowDataDetail(String MaCTPX, String MaPX, String MaKho, String MaSP, long SoLuong) {
        txt_mactpx.setText(MaCTPX);
        txt_mapx.setText(MaPX);
        
        if (selectedPhieuXuatCT != null) {
            cbxKho.setSelectedItem(findKho(selectedPhieuXuatCT.getMaKho(), dsKho));
        }
        
        if (selectedPhieuXuatCT != null) {
            txt_masp.setSelectedItem(findSanpham(selectedPhieuXuatCT.getMaSP(), dsSanpham));
        }

        txtSoLuong.setText(String.valueOf(SoLuong));
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
    
    public void loadSanpham(String MaKho) {
        txt_masp.removeAllItems();
        dsSanpham = sanphamServices.getSP(MaKho);
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
    
    private khoTT findKho(String maKho, ArrayList<khoTT> warehouses) {
        for (khoTT item : warehouses) {
            if (item.getMaKho().equals(maKho)) {
                return item;
            }
        }
        return null;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_soluongcon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_mactpx = new javax.swing.JLabel();
        txt_mapx = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxKho = new javax.swing.JComboBox<>();
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

        txt_masp.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                txt_maspAncestorRemoved(evt);
            }
        });
        txt_masp.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txt_maspMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txt_maspMouseDragged(evt);
            }
        });
        txt_masp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_maspMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_maspMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_maspMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_maspMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_maspMouseExited(evt);
            }
        });
        txt_masp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maspActionPerformed(evt);
            }
        });

        jLabel4.setText("Số Lượng xuất");

        txtSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoLuongMouseClicked(evt);
            }
        });
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã chi tiết phiếu xuất:");

        jLabel2.setText("Mã phiêu xuất:");

        txt_soluongcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_soluongcon.setForeground(new java.awt.Color(255, 51, 0));
        txt_soluongcon.setText("000");

        jLabel6.setText("Số lượng còn:");

        txt_mactpx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mactpx.setForeground(new java.awt.Color(255, 51, 0));
        txt_mactpx.setText("000");

        txt_mapx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mapx.setText("000");

        jLabel7.setText("Kho");

        cbxKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_masp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxKho, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mapx)
                            .addComponent(txt_mactpx))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_soluongcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_mactpx))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_mapx))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_soluongcon)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(78, Short.MAX_VALUE))
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
                "Mã chi tiết phiêu xuất", "Mã phiếu xuất", "Mã kho", "Mã sản phẩm", "Số lượng xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        int SoLuongCon = Integer.valueOf(txt_soluongcon.getText().trim());
        int SoLuong = Integer.valueOf(txtSoLuong.getText().trim());
        khoTT kho = (khoTT) cbxKho.getSelectedItem();
        
        if (SoLuong >= SoLuongCon) {
            JOptionPane.showMessageDialog(null, "Số lượng không đủ!");
        } else {
            int rowEffected = phieuXuatCTServices.AddNewRecord(maPX, kho.getMaKho(), masp.getID(), SoLuong);
            if (rowEffected > 0) {
                int rowEffected2 = phieuXuatCTServices.AddNewRecord2(maPX, kho.getMaKho(), masp.getID(), SoLuong);
                if (rowEffected2 > 0) {
                    showDataList(maPX);
                    showSoluong(masp.getID());
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại (Do sai hoặc đã tồn tại)");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maCTPX = txt_mactpx.getText().trim();
        String maPX = txt_mapx.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa chi tiết phiếu xuất " + maCTPX + " ?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (input == 0) {

            int rowEffected = phieuXuatCTServices.DeleteRecord(maCTPX, masp.getID());
            if (rowEffected > 0) {
                showDataList(maPX);
                showSoluong(masp.getID());
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
        int SoLuongCon = Integer.valueOf(txt_soluongcon.getText().trim());
        int SoLuong = Integer.valueOf(txtSoLuong.getText().trim());
        khoTT kho = (khoTT) cbxKho.getSelectedItem();
        
        if (SoLuong > SoLuongCon) {
            JOptionPane.showMessageDialog(null, "Số lượng không đủ!");
        } else {
            int rowEffected = phieuXuatCTServices.UpdateRecord(maCTPX, kho.getMaKho(), maPX, masp.getID(), SoLuong);
            if (rowEffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                showDataList(maPX);
                showSoluong(masp.getID());
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txt_maspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maspActionPerformed

    }//GEN-LAST:event_txt_maspActionPerformed

    private void cbxKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKhoActionPerformed
        khoTT kho = (khoTT) cbxKho.getSelectedItem(); 
        loadSanpham(kho.getMaKho());
 
    }//GEN-LAST:event_cbxKhoActionPerformed

    private void txt_maspMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseEntered
   
    }//GEN-LAST:event_txt_maspMouseEntered

    private void txt_maspMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseMoved
        
    }//GEN-LAST:event_txt_maspMouseMoved

    private void txt_maspMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseExited
  
    }//GEN-LAST:event_txt_maspMouseExited

    private void txt_maspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseClicked
       sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
       showSoluong(masp.getID());
       System.out.println(masp.getName());
    }//GEN-LAST:event_txt_maspMouseClicked

    private void txt_maspMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseDragged
       
    }//GEN-LAST:event_txt_maspMouseDragged

    private void txt_maspMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMouseReleased
  
    }//GEN-LAST:event_txt_maspMouseReleased

    private void txt_maspAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_maspAncestorRemoved
         
    }//GEN-LAST:event_txt_maspAncestorRemoved

    private void txt_maspMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_maspMousePressed
     
    }//GEN-LAST:event_txt_maspMousePressed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed

    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoLuongMouseClicked
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        showSoluong(masp.getID());
        System.out.println(masp.getName());
    }//GEN-LAST:event_txtSoLuongMouseClicked

    public void showSoluong(String MaSP) {
        //load data
        ArrayList<soluongTT> list = phieuXuatCTServices.getSoluong(MaSP);
        dsSoluong = list;

        for (int i = 0; i < list.size(); i++) {
            txt_soluongcon.setText(String.valueOf((list.get(i).getSoLuong())));
            System.out.println(list.get(i).getSoLuong());
        }
    }

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
    private javax.swing.JComboBox<khoTT> cbxKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhieuXuatCT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JLabel txt_mactpx;
    private javax.swing.JLabel txt_mapx;
    private javax.swing.JComboBox<sanphamTT> txt_masp;
    private javax.swing.JLabel txt_soluongcon;
    // End of variables declaration//GEN-END:variables

}
