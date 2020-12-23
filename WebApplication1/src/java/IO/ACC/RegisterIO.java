/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.ACC;

import context.DBContext;
import entity.Create;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author BND6699
 */
public class RegisterIO {
    Connection conn = null; // kết nối với sql
    PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
    ResultSet rs = null; //nhận kết quả trả về
    
    public Create checkRegister(String user, String pass ,String email, String phonenumber){     
        try {
            String query = "insert into taikhoan values (?,?,?,?)";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            ps.setString(1, user); //truyền vào dấu ? taikhoan
            ps.setString(2, pass); 
            ps.setString(3, email); 
            ps.setString(4, phonenumber); 
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                Create a = new Create(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)); //xét giá trị a
                return a;
            }
            
        } catch (Exception e) {
        }
        return null;       
    }
  
}