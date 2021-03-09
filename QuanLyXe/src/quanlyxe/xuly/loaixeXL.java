/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class loaixeXL {

    //Lấy danh sách loại xe
    public ArrayList<loaixeTT> getAllRecords() {
        ArrayList<loaixeTT> list = new ArrayList<loaixeTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM loaixe");

            while (rs.next()) {
                loaixeTT loaixe = new loaixeTT(rs.getString("Maloai"), rs.getString("Tenloai"));
                list.add(loaixe);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Lấy danh sách theo tìm kiếm
    public ArrayList<loaixeTT> getRecords(String Tenloai) {
        ArrayList<loaixeTT> list = new ArrayList<loaixeTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM loaixe WHERE Tenloai = N'" + Tenloai + "'");

            while (rs.next()) {
                loaixeTT loaixe = new loaixeTT(rs.getString("Maloai"), rs.getString("Tenloai"));
                list.add(loaixe);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Thêm
    public int AddNewRecord(String Maloai, String Tenloai) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO loaixe (Maloai,Tenloai) VALUES('" + Maloai + "',N'" + Tenloai + "'" + ")";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Sửa
    public int UpdateRecord(String Maloai, String Tenloai) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE loaixe SET Tenloai=N'" + Tenloai + "'"
                    + " WHERE Maloai = '" + Maloai + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xóa
    public int DeleteRecord(String Maloai) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM loaixe WHERE Maloai = '" + Maloai + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
