/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.ACC;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author BND6699
 */
public class LoginIO {
    Connection conn = null; // kết nối với sql
    PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
    ResultSet rs = null; //nhận kết quả trả về
    
    public Account checkLogin(String user, String pass){
        try {
            String query = "select * from taikhoan where username = ? and password = ?";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            ps.setString(1, user); //truyền vào dấu ? taikhoan
            ps.setString(2, pass); //truyền vào dấu ? matkhau
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                Account a = new Account(rs.getString(1),rs.getString(2)); //xét giá trị a
                return a; //sai thì trả null
            }
        
        } catch (Exception e) {
        }
        return null;
        
    }
}
