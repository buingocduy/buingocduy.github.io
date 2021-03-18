/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QLUser {

    public ArrayList<User> getQuyen(String Quyen) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM taikhoan WHERE Quyen = " + Quyen + "");

            while (rs.next()) {
                User user = new User(rs.getString("Tenuser"), rs.getString("Matkhau"), rs.getString("Duongdan"), rs.getInt("Quyen"));
                list.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
     public ArrayList<User> getTen(String Tenuser) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM taikhoan WHERE Tenuser = '" + Tenuser + "'");

            while (rs.next()) {
                User user = new User(rs.getString("Tenuser"), rs.getString("Matkhau"), rs.getString("Duongdan"), rs.getInt("Quyen"));
                list.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public int themUser(String Tenuser, String Matkhau, String Duongdan, int Quyen) {
        int rowCount = 0;
        System.out.println(Tenuser + Matkhau + Duongdan + Quyen);
        try {
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO taikhoan (Tenuser,Matkhau,Duongdan,Quyen) VALUES('" + Tenuser + "'"
                    + ", '" + Matkhau + "'"
                    + ", '" + Duongdan + "'"
                    + ", " + Quyen + ")";
            System.out.println(sql);        
            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
