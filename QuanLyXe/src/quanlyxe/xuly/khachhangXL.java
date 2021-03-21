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
public class khachhangXL {

    //lay danh sach UserAccount
    public ArrayList<khachhangTT> getAllRecords() {
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM khachhang");

            while (rs.next()) {
                khachhangTT cust = new khachhangTT(rs.getString("SDT"),rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("Email"), rs.getLong("TongTienDaMua"));
                list.add(cust);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //lay danh sach UserAccount
    public ArrayList<khachhangTT> getRecords(String Phone) {
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM khachhang where SDT = " + Phone + "");

            while (rs.next()) {
                khachhangTT cust = new khachhangTT(rs.getString("SDT"),rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("Email"), rs.getLong("TongTienDaMua"));
                list.add(cust);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Thêm
    public int AddNewRecord(String phone, String tenKH, String diaChi, String email, long TongTienDaMua) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO khachhang (SDT, TenKH, DiaChi, Email, TongTienDaMua) VALUES('" + phone + "'"
                    + ",N'" + tenKH + "'"
                    + ",N'" + diaChi + "'"
                    + ", '" + email + "'"
                    + ", " +TongTienDaMua + " )";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Sửa
    public int UpdateRecord(String phone, String tenKH, String diaChi, String email, long TongTienDaMua) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE khachhang SET TenKH=N'" + tenKH + "'"
                    + ", DiaChi =N'" + diaChi + "'"
                    + ", Email  = '" + email + "'"   
                    + ", TongTienDaMua  = " + TongTienDaMua + ""   
                    + " WHERE SDT = '" + phone +"'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xóa
    public int DeleteRecord(String phone) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM khachhang WHERE SDT = '" + phone +"'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
