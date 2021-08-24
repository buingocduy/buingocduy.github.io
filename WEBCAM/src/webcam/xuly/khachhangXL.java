/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam.xuly;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import webcam.thuthe.*;
import webcam.xuly.hienthi_sql;

public class khachhangXL {

    public ArrayList<khachhangTT> getAllRecords() {
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT STT,HOTEN,SDT,CMND,NGAYVAO,GIOVAO,TENCONGTY,LYDOVAO,HINHANH FROM khachhang");

            while (rs.next()) {
                khachhangTT kh = new khachhangTT(rs.getString("STT"), rs.getString("HOTEN"), rs.getString("SDT"), rs.getString("CMND"), rs.getDate("NGAYVAO"), rs.getString("GIOVAO"), rs.getString("TENCONGTY"), rs.getString("LYDOVAO"), rs.getString("HINHANH"));
                list.add(kh);
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
            ResultSet rs = acc.Query("select STT,HOTEN,SDT,CMND,NGAYVAO,GIOVAO,TENCONGTY,LYDOVAO,HINHANH from khachhang where NGAYVAO between '" + TU + "' and '" + DEN + "'");

            while (rs.next()) {
                khachhangTT hd = new khachhangTT(rs.getString("STT"), rs.getString("HOTEN"), rs.getString("SDT"), rs.getString("CMND"), rs.getDate("NGAYVAO"), rs.getString("GIOVAO"), rs.getString("TENCONGTY"), rs.getString("LYDOVAO"), rs.getString("HINHANH"));
                list.add(hd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String HOTEN, String SDT, String CMND, Date NGAYVAO, String GIOVAO, String TENCONGTY, String LYDOVAO, String HINHANH,String HINHANHWEB) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strngay = formatter.format(NGAYVAO);
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO khachhang (HOTEN, SDT, CMND, NGAYVAO, GIOVAO, TENCONGTY, LYDOVAO, HINHANH,HINHANHWEB) VALUES(N'" + HOTEN + "'"
                    + ",'" + SDT + "'"
                    + ",'" + CMND + "'"
                    + ",'" + strngay + "'"
                    + ",'" + GIOVAO + "'"
                    + ",N'" + TENCONGTY + "'"
                    + ",N'" + LYDOVAO + "'"
                    + ",'" + HINHANH + "'"
                    + ",'" + HINHANHWEB + "')";

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
