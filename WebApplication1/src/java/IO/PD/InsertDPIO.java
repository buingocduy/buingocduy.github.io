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

public class InsertDPIO {
        Connection conn = null; // kết nối với sql
        PreparedStatement ps = null; // lấy lệnh từ netbeans qua sql
        ResultSet rs = null; //nhận kết quả trả về
        
    public Product checkInsert(String id, String tensp, String gia, String hinhanh, String kichthuoc, String chieucaoyen,
            String sizebanh, String engine, String CC, String congsuat, String CCnhot, String CCxang, String phanh, String gear){     
        try {
            String query = "insert into sanpham values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();//mở kết nối sql
            ps = conn.prepareStatement(query);//truyền lệnh cho sql
            
            ps.setString(1, id); //truyền vào dấu ? id
            ps.setString(2, tensp); //truyền vào dấu ? tensp
            ps.setString(3, gia); //truyền vào dấu ? gia
            ps.setString(4, hinhanh); //truyền vào dấu ? hinhanh
            ps.setString(5, kichthuoc); //truyền vào dấu ? kichthuoc
            ps.setString(6, chieucaoyen); //truyền vào dấu ? chieucaoyen
            
            ps.setString(7, sizebanh); //truyền vào dấu ? sizebanh
            ps.setString(8, engine); //truyền vào dấu ? engine
            ps.setString(9, CC); //truyền vào dấu ? CC
            ps.setString(10, congsuat); //truyền vào dấu ? congsuat
            ps.setString(11, CCnhot); //truyền vào dấu ? CCnhot
            
            ps.setString(12, CCxang); //truyền vào dấu ? CCxang
            ps.setString(13, phanh); //truyền vào dấu ? phanh
            ps.setString(14, gear); //truyền vào dấu ? gear
            rs = ps.executeQuery(); //nhận kết quả trả về
            while (rs.next())//check từng dòng trong sql
            {
                Product a = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
                        rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14));//xét giá trị a
                              
                return a; //sai thì trả null
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
