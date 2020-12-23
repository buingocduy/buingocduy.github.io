/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.CART;

import context.DBContext;
import entity.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author BND6699
 */
public class InserCartIO {
    Connection conn = null; // kết nối với sql
    PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
    ResultSet rs = null; //nhận kết quả trả về
    
    public Cart checkCart(String username, String tensp ,String soluongmua, String tonggia){     
    try {
            String query = "insert into hoadon values (?,?,?,?)";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            ps.setString(1, username); //truyền vào dấu ? taikhoan
            ps.setString(2, tensp); 
            ps.setString(3, soluongmua); 
            ps.setString(4, tonggia); 
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                Cart c = new Cart(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)); //xét giá trị a
                return c;
            }
            
        } catch (Exception e) {
        }
        return null;       
    }
  
}
