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

public class taikhoanXL {

    //Lấy danh sách trong tài khoản
    public ArrayList<taikhoanTT> getAllRecords() {
        ArrayList<taikhoanTT> list = new ArrayList<taikhoanTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM taikhoan");

            while (rs.next()) {
                taikhoanTT taikhoan = new taikhoanTT(rs.getString("Username"), rs.getString("Password"), rs.getString("HoTen"), rs.getString("Email"), rs.getString("Phone"), rs.getDate("NgaySinh"), rs.getDate("NgayBatDau"));
                list.add(taikhoan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Lấy danh sách tìm kiếm trong tài khoản
    public ArrayList<taikhoanTT> getRecords(String HoTen) {
        ArrayList<taikhoanTT> list = new ArrayList<taikhoanTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM taikhoan WHERE HoTen = N'" + HoTen + "'");

            while (rs.next()) {
                taikhoanTT taikhoan = new taikhoanTT(rs.getString("Username"), rs.getString("Password"), rs.getString("HoTen"), rs.getString("Email"), rs.getString("Phone"), rs.getDate("NgaySinh"), rs.getDate("NgayBatDau"));
                list.add(taikhoan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Thêm
    public int AddNewRecord(String username, String pass, String hoten, String email, String phone, Date birthDay, Date startDate) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strBirthDay = formatter.format(birthDay);
            String strStartDate = formatter.format(startDate);
            System.out.println("Date Format with yyyy-MM-dd : " + strBirthDay + "," + strStartDate);

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO taikhoan ([Username],[Password], HoTen,Email,Phone,NgaySinh,NgayBatDau) VALUES('" + username + "'"
                    + ", '" + pass + "'"
                    + ",N'" + hoten + "'"
                    + ", '" + email + "'"
                    + ", '" + phone + "'"
                    + ", '" + strBirthDay + "'"
                    + ", '" + strStartDate + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Sửa
    public int UpdateRecord(String username, String pass, String hoten, String email, String phone, Date birthDay, Date startDate) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strBirthDay = formatter.format(birthDay);
            String strStartDate = formatter.format(startDate);
            System.out.println("Date Format with yyyy-MM-dd : " + strBirthDay + "," + strStartDate);

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE taikhoan SET HoTen=N'" + hoten + "'"
                    + ", [Password] ='" + pass + "'"
                    + ", Email ='" + email + "'"
                    + ", Phone ='" + phone + "'"
                    + ", NgaySinh ='" + strBirthDay + "'"
                    + ", NgayBatDau ='" + strStartDate + "'"
                    + " WHERE Username = '" + username + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xóa
    public int DeleteRecord(String username) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM taikhoan WHERE Username = '" + username + "'";
            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
