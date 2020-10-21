/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.PD;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BND6699
 */
public class ProductIO {
        Connection conn = null; // kết nối với sql
        PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
        ResultSet rs = null; //nhận kết quả trả về
            
    public Product getProductbyID (String id){
        Product pd = null;
        try {
            String query = "select * from sanpham where id = ?";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
                ps.setString(1, id);
                rs = ps.executeQuery(); //nhận kết quả trả về
                if (rs.next())//check từng dòng trong sql
            {
                        pd = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                        rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));//xét giá trị a            
            }
            } catch (Exception ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            }    
            return pd;       
    }
}
