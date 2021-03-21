/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class ct_phieuxuatXL {

    //Hien thi
    public ArrayList<ct_phieuxuatTT> getRecords(String MaPX) {
        ArrayList<ct_phieuxuatTT> list = new ArrayList<ct_phieuxuatTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM ct_phieuxuat WHERE MaPX = '" + MaPX + "'");
            while (rs.next()) {
                ct_phieuxuatTT phieuXuatCT = new ct_phieuxuatTT(rs.getString("MaCTPX"), rs.getString("MaPX"), rs.getString("MaKho"), rs.getString("MaSP"), rs.getLong("SoLuong"));
                list.add(phieuXuatCT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Hien thi
    public ArrayList<soluongTT> getSoluong(String MaSP) {
        ArrayList<soluongTT> list = new ArrayList<soluongTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("Select MaSP, Soluong From ct_kho Where MaSP = '" + MaSP + "'");
            while (rs.next()) {
                soluongTT soluongTT = new soluongTT(rs.getString("MaSP"), rs.getLong("SoLuong"));
                list.add(soluongTT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Them
    public int AddNewRecord(String MaPX, String MaKho, String MaSP, long SoLuong) {
        int rowCount = 0;
        try {
            hienthi_sql acc = new hienthi_sql();

            String sql = "IF EXISTS (SELECT * FROM ct_phieuxuat Where MaPX = '" + MaPX + "' and  MaSP = '" + MaSP + "') "
                    + "BEGIN PRINT 'DA TON TAI' "
                    + "END "
                    + "ELSE "
                    + "INSERT INTO ct_phieuxuat (MaPX, MaKho, MaSP, SoLuong) VALUES(" + MaPX
                    + ",'" + MaKho
                    + "','" + MaSP
                    + "'," + SoLuong
                    + ")";

            System.out.println(sql);

            rowCount = acc.Update(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rowCount;
    }

    //Them
    public int AddNewRecord2(String MaPX, String MaKho, String MaSP, long SoLuong) {
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();

            String sql2 = "Update ct_kho SET Soluong = "
                    + "((select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "'))"
                    + "WHERE MaSP = '" + MaSP + "'";

            System.out.println(sql2);

            rowCount2 = acc.Update(sql2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rowCount2;
    }

    //Sua
    public int UpdateRecord(String MaCTPX, String MaKho, String MaPX, String MaSP, long SoLuong) {
        int rowCount = 0;
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE ct_phieuxuat SET MaPX = '" + MaPX
                    + "',MaKho ='" + MaKho
                    + "',MaSP ='" + MaSP
                    + "',SoLuong = '" + SoLuong
                    + "' WHERE MaCTPX = '" + MaCTPX + "'";

            String sql2 = "Update ct_kho SET Soluong = "
                    + "((select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "'))"
                    + "WHERE MaSP = '" + MaSP + "'";

            System.out.println(sql);
            System.out.println(sql2);

            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }

    //Xóa từng chi tiết phiếu xuất
    public int DeleteRecord(String MaCTPX, String MaSP) {
        int rowCount = 0;
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM ct_phieuxuat WHERE MaCTPX = " + MaCTPX;

            String sql2 = "IF EXISTS (SELECT * FROM ct_phieuxuat Where MaSP = '" + MaSP + "') "
                    + "BEGIN "
                    + "Update ct_kho SET Soluong = "
                    + "((select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "')) "
                    + "WHERE MaSP = '" + MaSP + "' "
                    + "END "
                    + "ELSE  Update ct_kho SET Soluong = (select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') Where MaSP = '" + MaSP + "'";

            System.out.println(sql);
            System.out.println(sql2);

            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }

    //Xóa toàn bộ
    public int DeleteAll(String MaPX, String MaSP) {
        int rowCount = 0;
        int rowCount2 = 0;
        int rowCount3 = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM ct_phieuxuat WHERE MaPX = " + MaPX;
            String sql2 = "DELETE FROM phieuxuat WHERE MaPX = " + MaPX;

            String sql3 = "IF EXISTS (SELECT * FROM ct_phieuxuat Where MaSP = '" + MaSP + "') "
                    + "BEGIN "
                    + "Update ct_kho SET Soluong = "
                    + "((select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "')) "
                    + "WHERE MaSP = '" + MaSP + "' "
                    + "END "
                    + "ELSE  Update ct_kho SET Soluong = (select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') Where MaSP = '" + MaSP + "'";

            System.out.println(sql);
            System.out.println(sql2);
            System.out.println(sql3);

            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);
            rowCount3 = acc.Update(sql3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2 & rowCount3;
    }
}
