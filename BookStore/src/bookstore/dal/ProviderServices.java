/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dal;

import bookstore.entities.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinh
 */
public class ProviderServices {
    //lay danh sach UserAccount
    public ArrayList<Provider> getAllRecords(){
        ArrayList<Provider> list = new ArrayList<Provider>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM NhaCungCap");

            while(rs.next()){
                Provider ncc = new Provider(rs.getInt("MaNCC"), rs.getString("TenNCC"), 
                        rs.getString("DiaChi"), rs.getString("Email"), 
                        rs.getString("Phone"), rs.getString("NguoiLienHe"));
                list.add(ncc);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String tenNCC, String diaChi, String email, String phone, String nguoiLienHe){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO NhaCungCap (TenNCC, DiaChi, Email, Phone, NguoiLienHe) VALUES(N'" + tenNCC +"'"+ 
                    ",N'" + diaChi       +"'" +
                    ", '" + email        +"'" +                    
                    ", '" + phone        +"'" +
                    ",N'" + nguoiLienHe  +"'" +
                    ")";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(int maNCC, String tenNCC, String diaChi, String email, String phone, String nguoiLienHe){
        int rowCount = 0;
        try{
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE NhaCungCap SET TenNCC=N'" + tenNCC + "'" +
                    ", DiaChi =N'"      + diaChi +"'" +
                    ", Email = '"       + email +"'" +
                    ", Phone = '"       + phone +"'" +
                    ", nguoiLienHe =N'" + nguoiLienHe +"'" +
                    " WHERE MaNCC = "   + maNCC ;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(int maNCC){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM NhaCungCap WHERE MaNCC = " + maNCC;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
