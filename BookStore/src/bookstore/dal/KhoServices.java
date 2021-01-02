/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dal;

import bookstore.entities.UserAccount;
import bookstore.entities.Warehouse;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class KhoServices {
    
    //lay danh sach UserAccount
    public ArrayList<Warehouse> getAllRecords(){
        ArrayList<Warehouse> list = new ArrayList<Warehouse>();
        try{        
            SqlDataAccess kho = new SqlDataAccess();
            ResultSet rs = kho.Query("SELECT * FROM Kho");

            while(rs.next()){
                Warehouse khosach = new Warehouse(rs.getInt("MaKho"), rs.getString("TenKho"), rs.getString("DiaChi"), rs.getString("Phone"));
                list.add(khosach);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(Integer makho, String ten, String address, String phone){
        int rowCount = 0;
        try{

            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO Kho ([MaKho],[TenKho], DiaChi,Phone) VALUES('" + makho +"'"+ 
                    ",N'" + ten         +"'" +
                    ",N'" + address        +"'" +                    
                    ", '" + phone +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(Integer makho, String ten, String address, String phone){
        int rowCount = 0;
        try{
          
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE Kho SET TenKho =N'" + ten +"'" +
                    ", DiaChi   =N'"    + address   +"'" +
                    ", Phone    ='"     + phone     +"'" +
                    " WHERE MaKho = '" + makho +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(int Makho){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM Kho WHERE MaKho = '" + Makho +"'";
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
