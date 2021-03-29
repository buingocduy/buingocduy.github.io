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
    private VideoCapture capture;
    private Mat image;
    private boolean clicked = false;

    public WEBCAM() {
        setLayout(null);

        cameraSrceen = new JLabel();
        cameraSrceen.setBounds(15, 10, 500, 400);
        add(cameraSrceen);

        btnCapture = new JButton("Chụp");
        btnCapture.setBounds(170, 450, 200, 40);
        btnCapture.setForeground(Color.RED);
        btnCapture.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnCapture.setBackground(new java.awt.Color(204, 255, 0));
        add(btnCapture);

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

        setSize(new Dimension(550, 550));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Phần mềm quản lý ra vào Công Ty Nhựa Rạng Đông");
        setResizable(false);
        setVisible(true);

    }

    //Tạo camera
    public void startcamera() throws IOException {
        capture = new VideoCapture(0);
        image = new Mat();
        byte[] imageData;

        ImageIcon icon;
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
                    name = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
                }
                JOptionPane.showMessageDialog(this, "Chụp hình thành công");
                        
                Imgcodecs.imwrite("D:\\WEBCAM\\src\\images\\" + name + ".jpg", image);
                System.out.println(name+".jpg");
           
                MENU menu = new MENU();
                menu.setHinh("D:\\WEBCAM\\src\\images\\"+name+".jpg");
                menu.pack();
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
                clicked = false;
            }

        }
    }
    

    public static void main(String[] args) {
        String opencvpath = "D:\\WEBCAM\\";
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
                            webcam.startcamera();
                        } catch (IOException ex) {
                            Logger.getLogger(WEBCAM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }).start();
            }
        });
    }
}
