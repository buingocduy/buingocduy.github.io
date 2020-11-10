/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.ACC;

import context.DBContext;
import entity.checkrDK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Check {
    Connection conn = null; // kết nối với sql
    PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
    ResultSet rs = null; //nhận kết quả trả về
    
    public checkrDK checkRegistercheck(String user){   
        try {
            String query = "select username from taikhoan where username = ?";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            ps.setString(1, user); //truyền vào dấu ? taikhoan
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                checkrDK b = new checkrDK(rs.getString(1)); //xét giá trị a
                return b;
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
