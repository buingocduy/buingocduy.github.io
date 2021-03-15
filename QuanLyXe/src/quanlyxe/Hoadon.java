/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

import quanlyxe.thucthe.*;
import quanlyxe.xuly.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hoadon extends javax.swing.JFrame {

    hoadonTT selectedHoaDon = null;
    hoadonXL hoadonservices = new hoadonXL();

    taikhoanXL userService = new taikhoanXL();
    khachhangXL CusService = new khachhangXL();

    ArrayList<khachhangTT> dskh = new ArrayList<>();
    ArrayList<taikhoanTT> dsuser = new ArrayList<>();
    ArrayList<hoadonTT> dsHoaDon = new ArrayList<>();

    public Hoadon() {
        initComponents();

        //load danh sach 
        showDataList();

        loadCustomer();
        txt_tongtien.setText("0");
    }

    public void setTenUser(String username) {
        this.txt_nguoilap.setText(username);

        String b = "admin";

        boolean c = b.equals(username);

        System.out.println(c);
        if (c == true) {
            btnDelete.setEnabled(true);
        }

        if (c == false) {
            btnDelete.setEnabled(false);
        }
        System.out.println(username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelDetail = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_makh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_ngaylap = new com.toedter.calendar.JDateChooser();
        txt_thanhtoan = new javax.swing.JComboBox<>();
        btn_cthd = new javax.swing.JButton();
        txt_mahoadon = new javax.swing.JLabel();
        txt_tongtien = new javax.swing.JLabel();
        txt_nguoilap = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_timkiem = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_tailai = new javax.swing.JButton();
        cb_chon = new javax.swing.JComboBox<>();

        setTitle("Quản lý hóa đơn");
        setResizable(false);

        jPanelHeader1.setBackground(java.awt.SystemColor.activeCaption);
        jPanelHeader1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ HÓA ĐƠN");
        jLabel2.setIconTextGap(10);

        javax.swing.GroupLayout jPanelHeader1Layout = new javax.swing.GroupLayout(jPanelHeader1);
        jPanelHeader1.setLayout(jPanelHeader1Layout);
        jPanelHeader1Layout.setHorizontalGroup(
            jPanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeader1Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeader1Layout.setVerticalGroup(
            jPanelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Mã khách hàng");

        jLabel5.setText("Tổng tiền:");

        jLabel6.setText("Ngày lập");

        jLabel7.setText("Hình thức thanh toán");

        jLabel8.setText("Người lập:");

        txt_makh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_makhActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã hóa đơn:");

        txt_ngaylap.setDateFormatString("dd/MM/yyyy");

        txt_thanhtoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIỀN MẶT", "QUẸT THẺ" }));

        btn_cthd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/report.png"))); // NOI18N
        btn_cthd.setText("Xem chi tiết");
        btn_cthd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cthdActionPerformed(evt);
            }
        });

        txt_mahoadon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_mahoadon.setForeground(new java.awt.Color(255, 51, 0));
        txt_mahoadon.setText("000");

        txt_tongtien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tongtien.setText("000");

        txt_nguoilap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nguoilap.setText("null");

        javax.swing.GroupLayout jPanelDetailLayout = new javax.swing.GroupLayout(jPanelDetail);
        jPanelDetail.setLayout(jPanelDetailLayout);
        jPanelDetailLayout.setHorizontalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addGap(0, 299, Short.MAX_VALUE)
                        .addComponent(btn_cthd))
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mahoadon)
                            .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_thanhtoan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_makh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ngaylap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                            .addComponent(txt_tongtien)
                            .addComponent(txt_nguoilap))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDetailLayout.setVerticalGroup(
            jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetailLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_mahoadon))
                .addGap(18, 18, 18)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanelDetailLayout.createSequentialGroup()
                        .addComponent(txt_tongtien)
                        .addGap(17, 17, 17)
                        .addComponent(txt_nguoilap)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btn_cthd)
                .addContainerGap())
        );

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Mã khách hàng", "Hình thức thanh toán", "Tổng tiền", "Người lập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableData.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableData);
        jTableData.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
        btnClose.setText("Thoat");
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
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Chức năng", jPanel2);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/tim.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tìm theo");

        btn_tailai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/refresh.png"))); // NOI18N
        btn_tailai.setText("Tải lại");
        btn_tailai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tailaiActionPerformed(evt);
            }
        });

        cb_chon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Ngày lập", " " }));
        cb_chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_chonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timkiem)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_chon, 0, 103, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tailai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_chon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_timkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btn_tailai)
                .addGap(19, 19, 19))
        );

        jTabbedPane5.addTab("Tìm kiếm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_makhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_makhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_makhActionPerformed

    private void showDataDetail(String MaHoaDon, String Ngay, int MaKH, String HinhThucTT, String TongTien, String UserID) throws ParseException {
        String stringDate1 = Ngay;
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter1.parse(stringDate1);
        
        txt_mahoadon.setText(MaHoaDon);
        txt_ngaylap.setDate(date1);
        
        if (selectedHoaDon != null) {
            txt_makh.setSelectedItem(findCustomer(Integer.valueOf(selectedHoaDon.getMaKH()), dskh));
        }
        txt_thanhtoan.setSelectedItem(HinhThucTT);

        txt_nguoilap.setText(UserID);
        txt_tongtien.setText(TongTien);
    }

    public void gridSelectedChanged(ListSelectionEvent e) throws ParseException {
        String selectedData = null;
        String selectedID = "";  //Mã hóa đơn

        int[] selectedRows = jTableData.getSelectedRows();
        int[] selectedColumns = jTableData.getSelectedColumns();

        int selectedRow = jTableData.getSelectedRow();
        int selectedColumn = jTableData.getSelectedColumn();

        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);

        if (selectedRow >= 0 && selectedColumn >= 0) {
            selectedData = String.valueOf(jTableData.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) jTableData.getValueAt(selectedRow, 0);

            selectedHoaDon = findHoaDon(selectedID, dsHoaDon);

            System.out.println("Selected: " + selectedData + " , MaHoaDon: " + selectedID);

            showDataDetail(selectedID,
                    (String) jTableData.getValueAt(selectedRow,1),
                    (int) jTableData.getValueAt(selectedRow, 2),
                    (String) jTableData.getValueAt(selectedRow, 3),
                    (String) jTableData.getValueAt(selectedRow, 4),
                    (String) jTableData.getValueAt(selectedRow, 5));

        }
    }

    private void showSearchDataList() {
        String lua = "";
        String tim = txt_timkiem.getText().trim();
        String chon = String.valueOf(cb_chon.getSelectedItem());

        if (chon.equals("Mã hóa đơn")) {
            lua = "MaHoaDon";
        }
        if (chon.equals("Ngày lập")) {
            lua = "Ngay";
        }

        System.out.println(tim + lua);
        DefaultTableModel model = (DefaultTableModel) this.jTableData.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<hoadonTT> list = hoadonservices.getRecords(tim, lua);
        dsHoaDon = list;

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        
        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getMaHoaDon();
            row[1] = list.get(i).getNgay();
            row[2] = list.get(i).getMaKH();
            row[3] = list.get(i).getHinhThucTT();
            row[4] = en.format(list.get(i).getTongTien());
            row[5] = list.get(i).getUserID();

            model.addRow(row);
        }

        ListSelectionModel cellSelectionModel = jTableData.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Dang ky event click tren danh sach        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try {
                    //goi ham show data chi tiet
                    gridSelectedChanged(e);
                } catch (ParseException ex) {
                    Logger.getLogger(Hoadon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void showDataList() {

        DefaultTableModel model = (DefaultTableModel) this.jTableData.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<hoadonTT> list = hoadonservices.getAllRecords();
        dsHoaDon = list;

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        
        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getMaHoaDon();
            row[1] = formatter2.format(list.get(i).getNgay());
            row[2] = list.get(i).getMaKH();
            row[3] = list.get(i).getHinhThucTT();
            row[4] = en.format(list.get(i).getTongTien());
            row[5] = list.get(i).getUserID();

            model.addRow(row);
        }

        ListSelectionModel cellSelectionModel = jTableData.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Dang ky event click tren danh sach        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try {
                    //goi ham show data chi tiet
                    gridSelectedChanged(e);
                } catch (ParseException ex) {
                    Logger.getLogger(Hoadon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Tao Moi
        String TT = txt_tongtien.getText().trim().replaceAll("\\.", "").replaceAll(",", "");
        String MaHoaDon = txt_mahoadon.getText().trim();
        Date Ngay = txt_ngaylap.getDate();
        khachhangTT MaKH = (khachhangTT) txt_makh.getSelectedItem();

        String HinhThucTT = String.valueOf(txt_thanhtoan.getSelectedItem());

        long TongTien = Integer.valueOf(TT);
        String UserID = txt_nguoilap.getText().trim();

        //goi ham trong package "bookstore.dal"
        int rowEffected = hoadonservices.AddNewRecord(Ngay, MaKH.getMaKH(), HinhThucTT, TongTien, UserID);
        if (rowEffected > 0) {
            JOptionPane.showMessageDialog(null, "Tạo mới thành công!");
            showDataList();
        } else {
            JOptionPane.showMessageDialog(null, "Tạo mới thất bại");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Cap Nhat record
        String TT = txt_tongtien.getText().trim().replaceAll("\\.", "").replaceAll(",", "");
        String MaHoaDon = txt_mahoadon.getText().trim();
        Date Ngay = txt_ngaylap.getDate();
        khachhangTT MaKH = (khachhangTT) txt_makh.getSelectedItem();
        String HinhThucTT = String.valueOf(txt_thanhtoan.getSelectedItem());
        long TongTien = Integer.valueOf(TT);
        String UserID = txt_nguoilap.getText().trim();

        //goi ham trong package "bookstore.dal"
        int rowEffected = hoadonservices.UpdateRecord(MaHoaDon, Ngay, MaKH.getMaKH(), HinhThucTT, TongTien, UserID);
        if (rowEffected > 0) {
            showDataList();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Xoa Record

        String MaHoaDon = txt_mahoadon.getText().trim();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hóa đơn " + MaHoaDon + " không?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Delete data? =" + input);

        if (input == 0) {
            //Xoa
            //goi ham trong package "bookstore.dal"
            int rowEffected = hoadonservices.DeleteRecord(MaHoaDon);
            if (rowEffected > 0) {
                showDataList();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Phải xóa hết chi tiết hóa đơn mới xóa được");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // Thoat form
        this.dispose();
        //System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btn_cthdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cthdActionPerformed
        CT_Hoadon ct_hoadon = new CT_Hoadon();
        ct_hoadon.setMHD(txt_mahoadon.getText());
        ct_hoadon.showDataList(txt_mahoadon.getText());
        this.dispose();

        //vi tri giua man hinh va maximize
        ct_hoadon.pack();
        ct_hoadon.setLocationRelativeTo(null);
        ct_hoadon.setVisible(true);

    }//GEN-LAST:event_btn_cthdActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        //Load bộ dữ liệu tìm kiếm
        showSearchDataList();
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_tailaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tailaiActionPerformed
        //Load lại toàn bộ dữ liệu
        showDataList();
    }//GEN-LAST:event_btn_tailaiActionPerformed

    private void cb_chonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_chonActionPerformed

    }//GEN-LAST:event_cb_chonActionPerformed

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
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoadon().setVisible(true);
            }
        });
    }

    //Load khách
    private void loadCustomer() {
        txt_makh.removeAllItems();
        dskh = CusService.getAllRecords();
        for (khachhangTT item : dskh) {
            txt_makh.addItem(item);
        }

        //jcbAuthor = new JComboBox(new DefaultComboBoxModel(authors));
        txt_makh.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof khachhangTT) {
                    khachhangTT customer = (khachhangTT) value;
                    setText(String.valueOf(customer.getTenKH()));
                }
                return this;
            }
        });
    }

    public khachhangTT findCustomer(int MaKH, ArrayList<khachhangTT> customers) {
        for (khachhangTT item : customers) {
            if (item.getMaKH() == MaKH) {
                return item;
            }
        }
        return null;
    }

    public hoadonTT findHoaDon(String MaHoaDon, ArrayList<hoadonTT> hoaDons) {
        for (hoadonTT item : hoaDons) {
            if (item.getMaHoaDon().equals(MaHoaDon)) {
                return item;
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_cthd;
    private javax.swing.JButton btn_tailai;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JComboBox<String> cb_chon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDetail;
    private javax.swing.JPanel jPanelHeader1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTableData;
    private javax.swing.JLabel txt_mahoadon;
    private javax.swing.JComboBox<khachhangTT> txt_makh;
    private com.toedter.calendar.JDateChooser txt_ngaylap;
    private javax.swing.JLabel txt_nguoilap;
    private javax.swing.JComboBox<String> txt_thanhtoan;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JLabel txt_tongtien;
    // End of variables declaration//GEN-END:variables

}
