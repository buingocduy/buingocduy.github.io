/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bui Ngoc DUy
 */
public class phieuxuatXL {

    public ArrayList<phieuxuatTT> getAllRecords() {
        ArrayList<phieuxuatTT> list = new ArrayList<phieuxuatTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM phieuxuat");
            while (rs.next()) {
                phieuxuatTT phieuXuat = new phieuxuatTT(rs.getString("MaPX"), rs.getString("Username"), rs.getDate("NgayXuat"));
                list.add(phieuXuat);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //Them
    public int AddNewRecord(String userID, Date ngayXuat) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strNgayXuat = formatter.format(ngayXuat);
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO phieuxuat (Username, NgayXuat) VALUES('" + userID
                    + "','" + strNgayXuat + "')";
            
            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Sua
    public int UpdateRecord(int maPX, String userID, Date ngayXuat) {
        int rowCount = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strNgayXuat = formatter.format(ngayXuat);
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE phieuxuat SET Username ='" + userID            
                    + "',NgayXuat ='" + strNgayXuat + "'"   
                    + " WHERE MaPX = " + maPX;
            
            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

    //Xoa
    public int DeleteRecord(String maPX) {
        int rowCount = 0;
        try {
            hienthi_sql acc = new hienthi_sql();

            String sql = "DELETE FROM phieuxuat WHERE MaPX = " + maPX;
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
