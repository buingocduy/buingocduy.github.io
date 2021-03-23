/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import quanlyxe.thucthe.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadonXL {

    //lay danh sach HOA DON
    public ArrayList<hoadonTT> getAllRecords() {
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon");

            while (rs.next()) {
                hoadonTT hd = new hoadonTT(rs.getString("MaHoaDon"), rs.getDate("Ngay"), rs.getString("SDT"), rs.getLong("TongTien"), rs.getString("Username"), rs.getString("GhiChu"));
                list.add(hd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //lay danh sach HOA DON
    public ArrayList<hoadonTT> getRecords(String tim, String lua) {
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon WHERE " + lua + " = '" + tim + "' or GhiChu like N'%"+tim+"%'");

            while (rs.next()) {
                hoadonTT hd = new hoadonTT(rs.getString("MaHoaDon"), rs.getDate("Ngay"), rs.getString("SDT"), rs.getLong("TongTien"), rs.getString("Username"), rs.getString("GhiChu"));
                list.add(hd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tổng
    public ArrayList<hoadonTT> getTong(String MaHoaDon) {
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon Where MaHoaDon = '" + MaHoaDon + "'");

            while (rs.next()) {
                hoadonTT hd = new hoadonTT(rs.getString("MaHoaDon"), rs.getDate("Ngay"), rs.getString("SDT"), rs.getLong("TongTien"), rs.getString("Username"), rs.getString("GhiChu"));
                list.add(hd);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(Date Ngay, String SDT, long TongTien, String Username, String GhiChu) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strngay = formatter.format(Ngay);

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO hoadon (Ngay, SDT, TongTien, Username, GhiChu) VALUES('" + strngay + "'"
                    + ",'" + SDT + "'"
                    + "," + TongTien + ""
                    + ",'" + Username + "'"
                    + ",N'" + GhiChu + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int UpdateRecord(String MaHoaDon, Date Ngay, String SDT, long TongTien, String Username, String GhiChu) {
        int rowCount = 0;
        int rowCount2 = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strngay = formatter.format(Ngay);

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE hoadon SET Ngay ='" + strngay + "'"
                    + ", SDT = '" + SDT + "'"
                    + ", TongTien =" + TongTien + ""
                    + ", Username ='" + Username + "'"
                    + ", GhiChu = N'" + GhiChu + "'"
                    + " WHERE MaHoaDon = '" + MaHoaDon + "'";

            String sql2 = "UPDATE khachhang SET TongTienDaMua = "
                    + " (select sum(TongTien) from hoadon where SDT = '" + SDT + "' ) "
                    + "  WHERE SDT = '" + SDT + "' ";

            System.out.println(sql);
            System.out.println(sql2);

            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }

    //Xóa
    public int DeleteRecord(String MaHoaDon, String SDT) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();

            String sql = "DELETE FROM hoadon WHERE MaHoaDon = " + MaHoaDon;

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Xóa
    public int DeleteRecord2(String MaHoaDon, String SDT) {
        int rowCount2 = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
    
            String sql2 = "UPDATE khachhang SET TongTienDaMua = "
                    + " (select sum(TongTien) from hoadon where SDT = '" + SDT + "' ) "
                    + "  WHERE SDT = '" + SDT + "' ";

            System.out.println(sql2);

            rowCount2 = acc.Update(sql2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount2;
    }

    //Cap nhat
    public int Update(String MaHoaDon, String SDT, String GhiChu) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE hoadon SET SDT = '" + SDT + "'"
                    + ", GhiChu = N'" + GhiChu + "'"
                    + " WHERE MaHoaDon = '" + MaHoaDon + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
