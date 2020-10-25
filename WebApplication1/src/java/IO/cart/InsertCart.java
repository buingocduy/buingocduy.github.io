/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.cart;

import context.DBContext;
import entity.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author BND6699
 */
public class InsertCart {
    Connection conn = null; // kết nối với sql
    PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
    ResultSet rs = null; //nhận kết quả trả về
    
    public Item checkInsert(String id, String tensp, String gia, String hinhanh){
        try {
            String query = "insert into giohang values (?,?,?,?,1)";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            ps.setString(1, id); 
            ps.setString(2, tensp); 
            ps.setString(3, gia); 
            ps.setString(4, hinhanh);
         
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                Item i = new Item(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)); //xét giá trị a
                return i; //sai thì trả null
            }        
        } catch (Exception e) {
        }
        return null;
        
    }
}
