/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.videoio.*;

/**
 *
 * @author Bùi Ngọc Duy 06/06/1999
 */
public class WEBCAM extends javax.swing.JFrame {

    private JLabel cameraSrceen;
    private JLabel linkhinh;
    private JButton btnCapture;
    private JButton btnxem;
    private JButton btn_back;
    private VideoCapture capture;
    private Mat image;
    private boolean clicked = false;
    OPEN open = new OPEN();

    public WEBCAM() {
        setLayout(null);
        cameraSrceen = new JLabel();
        cameraSrceen.setBounds(15, 10, 500, 400);
        add(cameraSrceen);

        btnCapture = new JButton("Chụp");
        btnCapture.setBounds(170, 430, 200, 50);
        btnCapture.setForeground(Color.RED);
        btnCapture.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnCapture.setBackground(new java.awt.Color(204, 255, 0));
        add(btnCapture);
        
        btnxem = new JButton("Xem dữ liệu chụp");
        btnxem.setBounds(10, 520, 160, 30);
        btnxem.setForeground(Color.RED);
        btnxem.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnxem.setBackground(new java.awt.Color(204, 255, 0));
        add(btnxem);
        
        btn_back = new JButton("Chỉnh đường dẫn");
        btn_back.setBounds(360, 520, 160, 30);
        btn_back.setForeground(Color.RED);
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 14));
        btn_back.setBackground(new java.awt.Color(204, 255, 0));
        add(btn_back);
        
        btnxem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemActionPerformed(evt);
            }
        });
        
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btnCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = true;
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                capture.release();
                image.release();
                System.exit(0);
            }

        });

        setSize(new Dimension(550, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Phần mềm quản lý ra vào");
        setResizable(false);
        setVisible(true);
    }
      
    private void btn_xemActionPerformed(java.awt.event.ActionEvent evt) {                                        
        XEM xem = new XEM();
        xem.pack();
        xem.setLocationRelativeTo(null);
        xem.setVisible(true);
        this.dispose();
    }        
    
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {                                        
        open.pack();
        open.setLocationRelativeTo(null);
        open.setVisible(true); 
        this.dispose();
    }  
    
    //Tạo camera
    public void startcamera(String url) throws IOException {
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] imageData;

        ImageIcon icon;
        try {
            
        while (true) {
            //đọc hình vào ma trận
            capture.read(image);

            //chuyển hình ảnh sang byte
            final MatOfByte buf = new MatOfByte();
            Imgcodecs.imencode(".jpg", image, buf);

            imageData = buf.toArray();

            //thêm tên 
            icon = new ImageIcon(imageData);
            cameraSrceen.setIcon(icon);

            //lưu file
            if (clicked) {
                String name = "";
                if (name.equals("")) {
                    name = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss").format(new Date());
                }
                JOptionPane.showMessageDialog(this, "Chụp hình thành công");        
                
                //Gán địa chỉ lưu ảnh
                Imgcodecs.imwrite(url + "src\\images\\" + name + ".jpg", image);
                System.out.println(name+".jpg");
                
                //Gán tên cho hình ảnh
                MENU menu = new MENU();
                menu.setHinh(url + "src\\images\\"+name+".jpg","images\\"+name+".jpg");
                menu.pack();
      
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
                this.dispose();
                clicked = false;
            }
        }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Đường dẫn mở file opencv.dll sai hoặc không kết nối được với thiết bị");   
        }
    }
    
    public void RUN (String url){
        //Gọi opencv ra trên file
        String opencvpath = url;
        //String opencvpath = "T:\\BuiNgocDuy\\WEBCAM\\";
        String libPath = System.getProperty("java.library.path");
        System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
        System.out.println("load thành công");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WEBCAM webcam = new WEBCAM();
   
                //chạy camera 
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            webcam.startcamera(url);                         
                        } catch (IOException ex) {
                            Logger.getLogger(WEBCAM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }).start();
            }
        });
    }  
}
