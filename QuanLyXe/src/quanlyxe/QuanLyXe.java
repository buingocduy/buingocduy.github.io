/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe;

/**
 *
 * @author BND6699
 */
public class QuanLyXe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dangnhap dangnhap = new Dangnhap();
        //vi tri giua man hinh
        dangnhap.pack();
        dangnhap.setLocationRelativeTo(null);
        dangnhap.setVisible(true);
    }

}
