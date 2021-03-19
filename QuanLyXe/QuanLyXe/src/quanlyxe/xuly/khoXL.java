/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.khoTT;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class khoXL {

    //lay danh sach KHO
    public ArrayList<khoTT> getAllRecords() {
        ArrayList<khoTT> list = new ArrayList<khoTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM Kho");

            while (rs.next()) {
                khoTT kho = new khoTT(rs.getString("MaKho"), rs.getString("TenKho"), rs.getString("DiaChi"), rs.getString("Phone"));
                list.add(kho);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //lay danh sach kho
    public ArrayList<khoTT> getRecords(String Makho) {
        ArrayList<khoTT> list = new ArrayList<khoTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM Kho WHERE Makho = N'" + Makho + "'");

            while (rs.next()) {
                khoTT kho = new khoTT(rs.getString("MaKho"), rs.getString("TenKho"), rs.getString("DiaChi"), rs.getString("Phone"));
                list.add(kho);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String makho, String ten, String address, String phone) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO Kho (MaKho,TenKho,DiaChi,Phone) VALUES('"+makho+"'"
                    + "N'" + ten + "'"
                    + ",N'" + address + "'"
                    + ", '" + phone + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int UpdateRecord(String makho, String ten, String address, String phone) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE Kho SET TenKho =N'" + ten + "'"
                    + ", DiaChi   =N'" + address + "'"
                    + ", Phone    ='" + phone + "'"
                    + " WHERE MaKho = '" + makho + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int DeleteRecord(String Makho) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM Kho WHERE MaKho = '" + Makho + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
