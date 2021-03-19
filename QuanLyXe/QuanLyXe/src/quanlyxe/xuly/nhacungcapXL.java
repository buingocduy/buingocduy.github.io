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
public class nhacungcapXL {

    //lay danh sach toàn bộ UserAccount
    public ArrayList<nhacungcapTT> getAllRecords() {
        ArrayList<nhacungcapTT> list = new ArrayList<nhacungcapTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM nhacungcap");

            while (rs.next()) {
                nhacungcapTT ncc = new nhacungcapTT(rs.getString("MaNCC"), rs.getString("TenNCC"),
                        rs.getString("DiaChi"), rs.getString("Email"), rs.getString("SDT"));
                list.add(ncc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    // lấy danh sách theo tìm kiếm
    public ArrayList<nhacungcapTT> getRecords(String MaNCC) {
        ArrayList<nhacungcapTT> list = new ArrayList<nhacungcapTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM nhacungcap WHERE MaNCC = '" + MaNCC + "'");

            while (rs.next()) {
                nhacungcapTT ncc = new nhacungcapTT(rs.getString("MaNCC"), rs.getString("TenNCC"),
                        rs.getString("DiaChi"), rs.getString("Email"), rs.getString("SDT"));
                list.add(ncc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Tao moi
    public int AddNewRecord(String MaNCC, String tenNCC, String diaChi, String email, String phone) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO nhacungcap (MaNCC,TenNCC, DiaChi, Email, SDT) VALUES(N'" + MaNCC + "'"
                    + ",N'" + tenNCC + "'"
                    + ",N'" + diaChi + "'"
                    + ", '" + email + "'"
                    + ", '" + phone + "'" + ")";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int UpdateRecord(String MaNCC, String tenNCC, String diaChi, String email, String phone) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE nhacungcap SET TenNCC=N'" + tenNCC + "'"
                    + ", DiaChi =N'" + diaChi + "'"
                    + ", Email = '" + email + "'"
                    + ", SDT = '" + phone + "'"
                    + " WHERE MaNCC = '" + MaNCC + "'";

            System.out.println(sql);
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Cap nhat
    public int DeleteRecord(String MaNCC) {
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM nhacungcap WHERE MaNCC = '" + MaNCC + "'";

            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
