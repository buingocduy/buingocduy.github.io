/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

/**
 *
 * @author BND6699
 */
import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ct_phieunhapXL {

    //Hien thi
    public ArrayList<ct_phieunhapTT> getRecords(String MaPN) {
        ArrayList<ct_phieunhapTT> list = new ArrayList<ct_phieunhapTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM ct_phieunhap WHERE MaPN = '" + MaPN + "'");
            while (rs.next()) {
                ct_phieunhapTT phieunhapCT = new ct_phieunhapTT(rs.getString("MaCTPN"), rs.getString("MaPN"), rs.getString("MaSP"), rs.getLong("SoLuong"), rs.getLong("DonGiaNhap"));
                list.add(phieunhapCT);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Them
    public int AddNewRecord(String MaPN, String MaSP, long SoLuong, long DonGia) {
        int rowCount = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "IF EXISTS (SELECT * FROM ct_phieunhap Where MaPN = '" + MaPN + "' and MaSP = '" + MaSP + "') "
                    + "BEGIN PRINT 'DA TON TAI' "
                    + "END "
                    + "ELSE "
                    + "INSERT INTO ct_phieunhap(MaPN,MaSP,Soluong,DonGiaNhap) VALUES ('" + MaPN
                    + "','" + MaSP
                    + "','" + SoLuong
                    + "','" + DonGia + "')";

            System.out.println(sql);

            rowCount = acc.Update(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Them
    public int AddNewRecord2(String MaPN, String MaSP, long SoLuong, long DonGia) {
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();

            String sql2 = "IF EXISTS (SELECT * FROM ct_phieunhap Where MaSP = '" + MaSP + "') "
                    + "BEGIN "
                    + "Update ct_kho SET Soluong = "
                    + "(select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "') "
                    + "WHERE MaSP = '" + MaSP + "' "
                    + "END "
                    + "ELSE  Update ct_kho SET Soluong = (select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') Where MaSP = '" + MaSP + "'";

            System.out.println(sql2);

            rowCount2 = acc.Update(sql2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount2;
    }

    //Sua
    public int UpdateRecord(String MaCTPN, String MaPN, String MaSP, long SoLuong, long DonGia) {
        int rowCount = 0;
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE ct_phieunhap SET MaPN = '" + MaPN
                    + "',MaSP ='" + MaSP
                    + "',SoLuong = '" + SoLuong
                    + "',DonGiaNhap = '" + DonGia
                    + "' WHERE MaCTPN = '" + MaCTPN + "'";

            String sql2 = "IF EXISTS (SELECT * FROM ct_phieunhap Where MaSP = '" + MaSP + "') "
                    + "BEGIN "
                    + "Update ct_kho SET Soluong = "
                    + "(select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "') "
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

    //Xoa
    public int DeleteRecord(String MaCTPN, String MaSP) {
        int rowCount = 0;
        int rowCount2 = 0;
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM ct_phieunhap WHERE MaCTPN = " + MaCTPN;

            String sql2 = "IF EXISTS (SELECT * FROM ct_phieunhap Where MaSP = '" + MaSP + "') "
                    + "BEGIN "
                    + "Update ct_kho SET Soluong = "
                    + "(select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = '" + MaSP + "') - "
                    + "(select 'Soluongxuat'=Sum(SoLuong) from ct_phieuxuat where MaSP = '" + MaSP + "') "
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
}
