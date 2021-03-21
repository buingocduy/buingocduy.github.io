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
 * @author BND6699
 */
public class CT_Hoadon extends javax.swing.JFrame {

    ct_hoadonTT selectedCTHoaDon = null;
    ct_hoadonXL ct_hoadonservices = new ct_hoadonXL();

    sanphamXL sanphamService = new sanphamXL();
    hoadonXL hoadonService = new hoadonXL();

    ArrayList<sanphamTT> dsSanpham = new ArrayList<>();
    ArrayList<ct_hoadonTT> dsCTHoaDon = new ArrayList<>();
    ArrayList<hoadonTT> dsHoaDon = new ArrayList<>();
    ArrayList<soluongTT> dsSoluong = new ArrayList<>();

    public void setMHD(String MaHD) {
        this.txt_mahoadon.setText(MaHD);
    }

    public CT_Hoadon() {

        initComponents();
        txt_soluong.setText("1");
        //load danh san pham     
        loadSanpham();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jPanelDetail = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_masp = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_xoahet = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_soluongcon = new javax.swing.JLabel();
        txt_macthoadon = new javax.swing.JLabel();
        txt_mahoadon = new javax.swing.JLabel();
        txt_tonggia = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setTitle("Quản lý chi tiết hóa đơn");
        setResizable(false);

        jPanelHeader1.setBackground(java.awt.SystemColor.activeCaption);
        jPanelHeader1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ CHI TIẾT HÓA ĐƠN");
        jLabel2.setIconTextGap(10);

        javax.swing.GroupLayout jPanelHeader1Layout = new javax.swing.GroupLayout(jPanelHeader1);
        jPanelHeader1.setLayout(jPanelHeader1Layout);
        jPanelHeader1Layout.setHorizontalGroup(
            jPanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeader1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeader1Layout.setVerticalGroup(
            jPanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 180, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add1.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setIconTextGap(10);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/sua2.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setIconTextGap(10);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/del.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setIconTextGap(10);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/close2.png"))); // NOI18N
        btnClose.setText("Thoát");
        btnClose.setIconTextGap(10);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết hóa đơn", "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        jTableData.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableData);
        jTableData.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanelDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Số lượng");

        jLabel3.setText("Mã hóa đơn:");

        jLabel6.setText("Mã sản phẩm");

        jLabel7.setText("Đơn giá:");

        txt_masp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maspActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã chi tiết hóa đơn:");

        txt_soluong.setAutoscrolls(false);
        txt_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soluongActionPerformed(evt);
            }
        });

        jLabel1.setText("Tổng tiền:");

        btn_xoahet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/deldata.png"))); // NOI18N
        btn_xoahet.setText("Xóa hóa đơn");
        btn_xoahet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahetActionPerformed(evt);
            }
        });

        jLabel8.setText("Số lượng còn:");

        txt_soluongcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_soluongcon.setForeground(new java.awt.Color(255, 51, 0));
        txt_soluongcon.setText("000");

        txt_macthoadon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_macthoadon.setForeground(new java.awt.Color(255, 51, 0));
        txt_macthoadon.setText("000");

        txt_mahoadon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mahoadon.setText("000");

        txt_tonggia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tonggia.setText("000");

        txt_dongia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_dongia.setText("000");

        javax.swing.GroupLayout jPanelDetailLayout = new javax.swing.GroupLayout(jPanelDetail);
        jPanelDetail.setLayout(jPanelDetailLayout);
        jPanelDetailLayout.setHorizontalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_xoahet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_macthoadon)
                    .addComponent(txt_mahoadon)
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_masp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soluongcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_tonggia)
                    .addComponent(txt_dongia))
                .addGap(56, 56, 56))
        );
        jPanelDetailLayout.setVerticalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                        .addComponent(txt_macthoadon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_mahoadon))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDetailLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_soluongcon)
                        .addComponent(jLabel8))
                    .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_dongia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tonggia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_xoahet)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadSanpham() {
        txt_masp.removeAllItems();
        dsSanpham = sanphamService.getAllRecords();
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

    public ct_hoadonTT findCTHoaDon(String MaCTHoaDon, ArrayList<ct_hoadonTT> cT_HoaDons) {
        for (ct_hoadonTT item : cT_HoaDons) {
            if (item.getMaCTHoaDon().equals(MaCTHoaDon)) {
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

    private void showDataDetail(String MaCTHoaDon, String MaHoaDon, String MaSP, long SoLuong, String Dongia) {

        txt_macthoadon.setText(MaCTHoaDon);
        txt_mahoadon.setText(MaHoaDon);

        if (selectedCTHoaDon != null) {
            txt_masp.setSelectedItem(findSanpham(selectedCTHoaDon.getMaSP(), dsSanpham));
        }

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        txt_soluong.setText(String.valueOf(SoLuong));
        txt_dongia.setText(Dongia);

        long dg = Long.valueOf(txt_dongia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));
        long sl = Long.valueOf(txt_soluong.getText().trim());
        long tg = dg * sl;
        String str2 = en.format(tg);

        txt_tonggia.setText(str2);
    }

    public void gridSelectedChanged(ListSelectionEvent e) {
        String selectedData = null;
        String selectedID = "";  //Mã chi tiết hóa đơn

        int[] selectedRows = jTableData.getSelectedRows();
        int[] selectedColumns = jTableData.getSelectedColumns();

        int selectedRow = jTableData.getSelectedRow();
        int selectedColumn = jTableData.getSelectedColumn();

        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);

        if (selectedRow >= 0 && selectedColumn >= 0) {
            selectedData = String.valueOf(jTableData.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) jTableData.getValueAt(selectedRow, 0);
            //Find chi tiết hóa đơn
            selectedCTHoaDon = findCTHoaDon(selectedID, dsCTHoaDon);

            System.out.println("Selected: " + selectedData + " , MaHoaDon: " + selectedID);

            showDataDetail(selectedID,
                    (String) jTableData.getValueAt(selectedRow, 1),
                    (String) jTableData.getValueAt(selectedRow, 2),
                    (long) jTableData.getValueAt(selectedRow, 3),
                    (String) jTableData.getValueAt(selectedRow, 4));
        }
    }

    public void showDataList(String MaHD) {

        DefaultTableModel model = (DefaultTableModel) this.jTableData.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<ct_hoadonTT> list = ct_hoadonservices.getAllRecords(MaHD);
        dsCTHoaDon = list;

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getMaCTHoaDon();
            row[1] = list.get(i).getMaHoaDon();
            row[2] = list.get(i).getMaSP();
            row[3] = list.get(i).getSoLuong();
            row[4] = en.format(list.get(i).getDongia());

            model.addRow(row);
        }

        ListSelectionModel cellSelectionModel = jTableData.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Dang ky event click tren danh sach        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //goi ham show data chi tiet
                gridSelectedChanged(e);
            }
        });
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Tao Moi     
        String MaCTHoaDon = txt_macthoadon.getText().trim();
        String MaHD = txt_mahoadon.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        int SoLuongCon = Integer.valueOf(txt_soluongcon.getText().trim());
        long DonGia = Long.valueOf(txt_dongia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));
        int SoLuong = Integer.valueOf(txt_soluong.getText().trim());

        if (SoLuong > SoLuongCon) {
            JOptionPane.showMessageDialog(null, "Số lượng không đủ!");
        } else {
            int rowEffected = ct_hoadonservices.AddNewRecord(MaHD, masp.getID(), SoLuong, DonGia);
            if (rowEffected > 0) {
                JOptionPane.showMessageDialog(null, "Tạo mới thành công!");
                showDataList(MaHD);
                Hoadon hoadon = new Hoadon();
                hoadon.showDataList();
                showSoluong(masp.getID());
            } else {
                JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Cap Nhat record
        String MaCTHoaDon = txt_macthoadon.getText().trim();
        String MaHD = txt_mahoadon.getText().trim();
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        int SoLuongCon = Integer.valueOf(txt_soluongcon.getText().trim());
        long DonGia = Long.valueOf(txt_dongia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));
        int SoLuong = Integer.valueOf(txt_soluong.getText().trim());

        if (SoLuong > SoLuongCon) {
            JOptionPane.showMessageDialog(null, "Số lượng không đủ!");
        } else {
            int rowEffected = ct_hoadonservices.UpdateRecord(MaCTHoaDon, MaHD, masp.getID(), SoLuong, DonGia);
            if (rowEffected > 0) {
                showDataList(MaHD);
                showSoluong(masp.getID());
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Xoa Record
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        String MaCTHoaDon = txt_macthoadon.getText().trim();
        String MaHD = txt_mahoadon.getText().trim();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa chi tiết hóa đơn " + MaCTHoaDon + " không?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Delete data? =" + input);

        if (input == 0) {
            //Xoa
            //goi ham trong package "bookstore.dal"
            int rowEffected = ct_hoadonservices.DeleteRecord(MaCTHoaDon, MaHD);
            if (rowEffected > 0) {
                showDataList(MaHD);
                showSoluong(masp.getID());
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // Hóa đơn
        Hoadon hoadon = new Hoadon();
        this.dispose();

        //vi tri giua man hinh
        hoadon.pack();
        hoadon.setLocationRelativeTo(null);
        hoadon.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txt_maspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maspActionPerformed
        sanphamTT masp = (sanphamTT) txt_masp.getSelectedItem();
        showSoluong(masp.getID());

        System.out.println(masp.getName() + "-" + masp.getPrice());
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);

        long giaban = masp.getPrice();
        String str1 = en.format(giaban);
        txt_dongia.setText(str1);

        long dg = Long.valueOf(txt_dongia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));
        long sl = Long.valueOf(txt_soluong.getText().trim());
        long tg = sl * dg;

        if (tg > 1000000000) {
            JOptionPane.showMessageDialog(null, "Tổng tiền tối đa 1 tỷ!");
        } else {
            long tien = tg;
            String str2 = en.format(tien);
            txt_tonggia.setText(str2);
        }
    }//GEN-LAST:event_txt_maspActionPerformed

    private void txt_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluongActionPerformed
        long dg = Long.valueOf(txt_dongia.getText().trim().replaceAll("\\.", "").replaceAll(",", ""));
        long sl = Long.valueOf(txt_soluong.getText().trim());
        long tg = sl * dg;

        if (tg > 1000000000) {
            JOptionPane.showMessageDialog(null, "Tổng tiền tối đa 1 tỷ!");
        } else {
            long tien = tg;
            Locale localeEN = new Locale("en", "EN");
            NumberFormat en = NumberFormat.getInstance(localeEN);
            String str1 = en.format(tien);

            txt_tonggia.setText(str1);
        }
    }//GEN-LAST:event_txt_soluongActionPerformed

    // Xóa toàn bộ dữ liệu của 1 hóa đơn
    private void btn_xoahetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahetActionPerformed

        String MaCTHoaDon = txt_macthoadon.getText().trim();
        String MaHD = txt_mahoadon.getText().trim();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa toàn bộ hóa đơn " + MaHD + " không?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Delete data? =" + input);

        if (input == 0) {
            //Xoa
            //goi ham trong package "bookstore.dal"
            int rowEffected = ct_hoadonservices.DeleteAll(MaHD);
            if (rowEffected > 0) {
                showDataList(MaHD);
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                Hoadon hoadon = new Hoadon();
                this.dispose();

                //vi tri giua man hinh
                hoadon.pack();
                hoadon.setLocationRelativeTo(null);
                hoadon.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoahetActionPerformed

    public void showSoluong(String MaSP) {
        //load data
        ArrayList<soluongTT> list = ct_hoadonservices.getSoluong(MaSP);
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
            java.util.logging.Logger.getLogger(CT_Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CT_Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CT_Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CT_Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CT_Hoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_xoahet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelHeader1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableData;
    private javax.swing.JLabel txt_dongia;
    private javax.swing.JLabel txt_macthoadon;
    private javax.swing.JLabel txt_mahoadon;
    private javax.swing.JComboBox<sanphamTT> txt_masp;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JLabel txt_soluongcon;
    private javax.swing.JLabel txt_tonggia;
    // End of variables declaration//GEN-END:variables
}