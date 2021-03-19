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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class phieunhapXL {

    public ArrayList<phieunhapTT> getAllRecords() {
        ArrayList<phieunhapTT> list = new ArrayList<phieunhapTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM phieunhap");
            while (rs.next()) {
                phieunhapTT phieunhap = new phieunhapTT(rs.getString("MaPN"), rs.getString("Username"), rs.getString("MaNCC"), rs.getDate("NgayNhap"), rs.getString("MaKho"));
                list.add(phieunhap);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Them
    public int AddNewRecord(String Username, String MaNCC, Date ngaynhap, String maKho) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strNgayNhap = formatter.format(ngaynhap);

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO phieunhap (Username, MaNCC, NgayNhap,MaKho) VALUES('" + Username
                    + "','" + MaNCC
                    + "','" + strNgayNhap + "'"
                    + ",'" + maKho
                    + "')";
            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Sua
    public int UpdateRecord(String MaPN, String Username, String MaNCC, Date ngaynhap, String maKho) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strNgayNhap = formatter.format(ngaynhap);

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE phieunhap SET Username ='" + Username
                    + "',MaNCC ='" + MaNCC
                    + "',NgayNhap ='" + strNgayNhap + "'"
                    + ",MaKho ='" + maKho
                    + "' WHERE MaPN = " + MaPN;
            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xoa
    public int DeleteRecord(String MaPN) {
        int rowCount = 0;
        try {
            hienthi_sql acc = new hienthi_sql();

            String sql = "DELETE FROM phieunhap WHERE MaPN = " + MaPN;
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
