/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam.xuly;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import webcam.thuthe.*;
import webcam.xuly.hienthi_sql;

public class khachhang {

    public ArrayList<khachhangTT> getAllRecords() {
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM khachhang");

            while (rs.next()) {
                khachhangTT hd = new khachhangTT(rs.getString("STT"), rs.getString("HOTEN"), rs.getString("SDT"), rs.getString("CMND"), rs.getString("NGAYVAO"), rs.getString("GIOVAO"), rs.getString("TENCONGTY"), rs.getString("LYDOVAO"), rs.getString("HINHANH"));
                list.add(hd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public ArrayList<khachhangTT> getRecords(String TU, String DEN) {
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("select * from khachhang where NGAYVAO between '"+TU+"' and '"+DEN+"'");

            while (rs.next()) {
                khachhangTT hd = new khachhangTT(rs.getString("STT"), rs.getString("HOTEN"), rs.getString("SDT"), rs.getString("CMND"), rs.getString("NGAYVAO"), rs.getString("GIOVAO"), rs.getString("TENCONGTY"), rs.getString("LYDOVAO"), rs.getString("HINHANH"));
                list.add(hd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String HOTEN, String SDT, String CMND, String NGAYVAO, String GIOVAO, String TENCONGTY, String LYDOVAO, String HINHANH) {
        int rowCount = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO khachhang (HOTEN, SDT, CMND, NGAYVAO, GIOVAO, TENCONGTY, LYDOVAO, HINHANH) VALUES(N'" + HOTEN + "'"
                    + ",'" + SDT + "'"
                    + ",'" + CMND + "'"
                    + ",'" + NGAYVAO + "'"
                    + ",'" + GIOVAO + "'"
                    + ",N'" + TENCONGTY + "'"
                    + ",N'" + LYDOVAO + "'"
                    + ",'" + HINHANH + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xóa
    public int DeleteRecord(String STT) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();

            String sql = "DELETE FROM khachhang WHERE STT = '" + STT + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

}
