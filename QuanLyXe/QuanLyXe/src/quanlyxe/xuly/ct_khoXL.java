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

/**
 *
 * @author BND6699
 */
public class ct_khoXL {

    //lay danh sach CT_KHO
    public ArrayList<ct_khoTT> getAllRecords(String MaKho) {
        ArrayList<ct_khoTT> list = new ArrayList<ct_khoTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM ct_kho where MaKho = '" + MaKho + "'");

            while (rs.next()) {
                ct_khoTT ct_khoTT = new ct_khoTT(rs.getString("CTMaKho"), rs.getString("MaKho"), rs.getString("MaSP"), rs.getLong("Soluong"));
                list.add(ct_khoTT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String MaKho, String MaSP, long Soluong) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "IF EXISTS (SELECT * FROM ct_kho Where MaSP = '" + MaSP + "') "
                    + "BEGIN PRINT 'DA TON TAI' "
                    + "END "
                    + "ELSE "
                    + "INSERT INTO ct_kho (MaKho,MaSP,Soluong) VALUES('" + MaKho + "'"
                    + ",'" + MaSP + "'"
                    + ",'" + Soluong + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);
     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;       
    }

    //Cap nhat
    public int UpdateRecord(String CTMaKho, String MaKho, String MaSP, long Soluong) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE ct_kho SET MaKho ='" + MaKho + "'"
                    + ", MaSP   ='" + MaSP + "'"
                    + ", Soluong    ='" + Soluong + "'"
                    + " WHERE CTMaKho = " + CTMaKho + "";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int DeleteRecord(String CTMaKho) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM ct_kho WHERE CTMaKho = '" + CTMaKho + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
