/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dal;

import bookstore.entities.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Xuan Vinh
 */
public class CategoryServices {
    //lay danh sach UserAccount
    public ArrayList<Category> getAllRecords(){
        ArrayList<Category> list = new ArrayList<Category>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [LoaiSach]");

            while(rs.next()){
                Category cat = new Category(rs.getInt("MaLoai"), rs.getString("TenLoai"));
                list.add(cat);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String categoryName){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO LoaiSach (TenLoai) VALUES(N'" + categoryName +"'"+                     
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
    public int UpdateRecord(int categoryID, String categoryName){
        int rowCount = 0;
        try{
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE LoaiSach SET TenLoai=N'" + categoryName + "'" +                    
                    " WHERE MaLoai = " + categoryID ;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(int categoryID){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM LoaiSach WHERE MaLoai = " + categoryID;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
