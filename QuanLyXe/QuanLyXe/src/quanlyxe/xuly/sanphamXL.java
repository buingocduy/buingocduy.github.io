/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class sanphamXL {

    //lay danh sach UserAccount
    public ArrayList<sanphamTT> getAllRecords() {
        ArrayList<sanphamTT> list = new ArrayList<sanphamTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM sanpham");

            while (rs.next()) {
                sanphamTT sp = new sanphamTT(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("Maloai"), rs.getLong("GiaBan"), rs.getString("MaNCC"), rs.getString("Namsanxuat"));
                list.add(sp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public ArrayList<sanphamTT> getRecords(String tim, String lua) {
        ArrayList<sanphamTT> list = new ArrayList<sanphamTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM sanpham WHERE " + lua + " = '" + tim + "'");

            while (rs.next()) {
                sanphamTT sp = new sanphamTT(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("Maloai"), rs.getLong("GiaBan"), rs.getString("MaNCC"), rs.getString("Namsanxuat"));
                list.add(sp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public ArrayList<sanphamTT> getSP(String MaNCC) {
        ArrayList<sanphamTT> list = new ArrayList<sanphamTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM sanpham WHERE MaNCC = '" + MaNCC + "'");

            while (rs.next()) {
                sanphamTT sp = new sanphamTT(rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("Maloai"), rs.getLong("GiaBan"), rs.getString("MaNCC"), rs.getString("Namsanxuat"));
                list.add(sp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String ID, String Name, String categoryID, long Price, String supplierID, String publishingYear) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO sanpham (MaSP, TenSP, Maloai, GiaBan, MaNCC, Namsanxuat) VALUES('" + ID + "'"
                    + ",N'" + Name + "'"
                    + ", '" + categoryID + "'"
                    + ", '" + Price + "'"
                    + ", '" + supplierID + "'"
                    + ", '" + publishingYear + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int UpdateRecord(String ID, String Name, String categoryID, long Price, String supplierID, String publishingYear) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE sanpham SET TenSP=N'" + Name + "'"
                    + ", Maloai  = '" + categoryID + "'"
                    + ", GiaBan   = '" + Price + "'"
                    + ", MaNCC   = '" + supplierID + "'"
                    + ", Namsanxuat = '" + publishingYear + "'"
                    + " WHERE MaSP = '" + ID + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int DeleteRecord(String ID) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM sanpham WHERE MaSP = '" + ID + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
