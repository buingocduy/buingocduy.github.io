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
 * @author DELL
 */
public class CustomerServices {
    //lay danh sach UserAccount
    public ArrayList<Customer> getAllRecords(){
        ArrayList<Customer> list = new ArrayList<Customer>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM KhachHang");

            while(rs.next()){
                Customer cust = new Customer(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("Email"), rs.getString("Phone"));
                list.add(cust);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
        return list;
    }
    //Tao moi
    public int AddNewRecord(String tenKH, String diaChi, String email, String phone){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO KhachHang (TenKH, DiaChi, Email, Phone) VALUES(N'" + tenKH +"'"+ 
                    ",N'" + diaChi       +"'" +
                    ", '" + email        +"'" +                    
                    ", '" + phone        +"'" +
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
    public int UpdateRecord(int maKH, String tenKH, String diaChi, String email, String phone){
        int rowCount = 0;
        try{
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE KhachHang SET TenKH=N'" + tenKH + "'" +
                    ", DiaChi =N'" + diaChi +"'" +
                    ", Email  = '" + email +"'" +
                    ", Phone  = '" + phone +"'" +
                    " WHERE MaKH = " + maKH ;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(int maKH){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM KhachHang WHERE MaKH = " + maKH;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
