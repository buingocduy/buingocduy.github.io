/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import webcam.xuly.khachhang;
import webcam.thuthe.khachhangTT;
import webcam.xuly.ketnoi_sql;

/**
 *
 * @author Bùi Ngọc Duy 06/06/1999
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

        Object[] row = new Object[10];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getSTT();
            row[1] = list.get(i).getHOTEN();
            row[2] = list.get(i).getSDT();
            row[3] = list.get(i).getCMND();
            row[4] = list.get(i).getNGAYVAO();
            row[5] = list.get(i).getGIOVAO();
            row[6] = list.get(i).getTENCONGTY();
            row[7] = list.get(i).getLYDOVAO();
            row[8] = list.get(i).getHINHANH();

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

        if (selectedRow >= 0 && selectedColumn >= 0) {
            //selectedData = String.valueOf(jTableKho.getValueAt(selectedRow, selectedColumn));
            selectedID = (String) jTable1.getValueAt(selectedRow, 0);

            System.out.println("Selected: " + selectedID);

            showDataDetail(
                    (String) jTable1.getValueAt(selectedRow, 0),
                    (String) jTable1.getValueAt(selectedRow, 1),
                    (String) jTable1.getValueAt(selectedRow, 2),
                    (String) jTable1.getValueAt(selectedRow, 3),
                    (String) jTable1.getValueAt(selectedRow, 4),
                    (String) jTable1.getValueAt(selectedRow, 5),
                    (String) jTable1.getValueAt(selectedRow, 6),
                    (String) jTable1.getValueAt(selectedRow, 7),
                    (String) jTable1.getValueAt(selectedRow, 8));

        }
    }

    private void showDataDetail(String STT, String HOTEN, String SDT, String CMND, String NGAYVAO, String GIOVAO, String TENCONGTY, String LYDOVAO, String HINHANH) {

        txt_stt.setText(String.valueOf(STT));
        txt_hoten.setText(HOTEN);
        txt_sdt.setText(SDT);
        txt_cmnd.setText(CMND);
        txt_ngayvao.setText(NGAYVAO);
        txt_giovao.setText(GIOVAO);
        txt_tencongty.setText(TENCONGTY);
        txt_lydovao.setText(LYDOVAO);

        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(HINHANH));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(305, 309, image.SCALE_SMOOTH));
            txt_hinhanh.setIcon(icon);
            System.out.println("lấy hình " + icon);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showData(String TU, String DEN) {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        model.setRowCount(0);

        //load data
        ArrayList<khachhangTT> list = KHservices.getRecords(TU,DEN);
        dsKH = list;

        Object[] row = new Object[10];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getSTT();
            row[1] = list.get(i).getHOTEN();
            row[2] = list.get(i).getSDT();
            row[3] = list.get(i).getCMND();
            row[4] = list.get(i).getNGAYVAO();
            row[5] = list.get(i).getGIOVAO();
            row[6] = list.get(i).getTENCONGTY();
            row[7] = list.get(i).getLYDOVAO();
            row[8] = list.get(i).getHINHANH();

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txt_stt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_cmnd = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ngayvao = new javax.swing.JLabel();
        txt_giovao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tencongty = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_lydovao = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_in = new javax.swing.JButton();
        txt_tu = new javax.swing.JTextField();
        btn_xem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_den = new javax.swing.JTextField();

        setTitle("Quản lý xem dữ liệu");
        setBackground(new java.awt.Color(153, 255, 0));
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ tên", "Số điện thoại", "CMND", "Ngày vào", "Giờ vào", "Tên công ty", "Lý do vào", "Hình ảnh"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(153, 255, 0));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_stt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_stt.setForeground(new java.awt.Color(255, 51, 0));
        txt_stt.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("STT:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Họ tên:");

        txt_hoten.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_hoten.setForeground(new java.awt.Color(255, 51, 0));
        txt_hoten.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Số điện thoại:");

        txt_sdt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_sdt.setForeground(new java.awt.Color(255, 0, 0));
        txt_sdt.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("CMND:");

        txt_cmnd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_cmnd.setForeground(new java.awt.Color(255, 0, 0));
        txt_cmnd.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Ngày giờ vào:");

        txt_ngayvao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_ngayvao.setForeground(new java.awt.Color(255, 51, 0));
        txt_ngayvao.setText("0");

        txt_giovao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_giovao.setForeground(new java.awt.Color(255, 51, 0));
        txt_giovao.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tên công ty:");

        txt_tencongty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_tencongty.setForeground(new java.awt.Color(255, 0, 0));
        txt_tencongty.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Lý do vào:");

        txt_lydovao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_lydovao.setForeground(new java.awt.Color(255, 0, 0));
        txt_lydovao.setText("0");

        btn_xoa.setBackground(new java.awt.Color(204, 255, 0));
        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 0, 0));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_cmnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_ngayvao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_giovao))
                    .addComponent(txt_lydovao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tencongty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_stt, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_stt)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hoten)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_sdt))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cmnd))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngayvao)
                    .addComponent(jLabel4)
                    .addComponent(txt_giovao))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tencongty))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_lydovao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_in.setBackground(new java.awt.Color(204, 255, 0));
        btn_in.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_in.setForeground(new java.awt.Color(255, 51, 0));
        btn_in.setText("In");
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });

        btn_xem.setBackground(new java.awt.Color(204, 255, 0));
        btn_xem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_xem.setForeground(new java.awt.Color(255, 51, 0));
        btn_xem.setText("Xem");
        btn_xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 0));
        jButton1.setText("Tải lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Chọn ngày xem");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Từ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Đến");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_in, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_xem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_tu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_den, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_den, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btn_xem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_in, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lọc và in", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemActionPerformed
        String TU = txt_tu.getText().trim();
        String DEN = txt_den.getText().trim();
        showData(TU,DEN);
    }//GEN-LAST:event_btn_xemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showDataList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        //Xoa Record
        String STT = txt_stt.getText().trim();

        int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa STT " + STT + " không?", "Confirmation...",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        System.out.println("Xoa? =" + input);

        if (input == 0) {
            //Xoa
            int rowEffected = KHservices.DeleteRecord(STT);
            if (rowEffected > 0) {
                showDataList();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        String TU = txt_tu.getText().trim();
        String DEN = txt_den.getText().trim();
        XuatDS(TU,DEN);
        System.out.println(TU +" - "+ DEN);
    }//GEN-LAST:event_btn_inActionPerformed

    public void XuatDS(String TU, String DEN) {
        try {
            ketnoi_sql sql = new ketnoi_sql();
            Hashtable map = new Hashtable();
            JasperDesign jd = JRXmlLoader.load("D:\\BuiNgocDuy\\WEBCAM\\src\\PDF\\report1.jrxml");
            JasperReport jr = JasperCompileManager.compileReport("D:\\BuiNgocDuy\\WEBCAM\\src\\PDF\\report1.jrxml");

            map.put("TU",TU);
            map.put("DEN",DEN);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, map, sql.getConnection());
            JasperViewer.viewReport(jp, false);
            JasperExportManager.exportReportToPdfFile(jp, "D:\\BuiNgocDuy\\WEBCAM\\src\\PDF\\report1.pdf");

        } catch (ClassNotFoundException | SQLException | JRException e) {
            JOptionPane.showMessageDialog(null, "Cannot show report" + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

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
    private javax.swing.JButton btn_in;
    private javax.swing.JButton btn_xem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txt_cmnd;
    private javax.swing.JTextField txt_den;
    private javax.swing.JLabel txt_giovao;
    private javax.swing.JLabel txt_hinhanh;
    private javax.swing.JLabel txt_hoten;
    private javax.swing.JLabel txt_lydovao;
    private javax.swing.JLabel txt_ngayvao;
    private javax.swing.JLabel txt_sdt;
    private javax.swing.JLabel txt_stt;
    private javax.swing.JLabel txt_tencongty;
    private javax.swing.JTextField txt_tu;
    // End of variables declaration//GEN-END:variables
}
