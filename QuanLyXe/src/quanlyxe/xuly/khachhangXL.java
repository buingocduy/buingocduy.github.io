/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class khachhangXL {
    //lay danh sach UserAccount
    public ArrayList<khachhangTT> getAllRecords(){
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM khachhang");

            while(rs.next()){
                khachhangTT cust = new khachhangTT(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("Email"), rs.getString("Phone"));
                list.add(cust);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
        return list;
    }
    
    //lay danh sach UserAccount
    public ArrayList<khachhangTT> getRecords(String Phone){
        ArrayList<khachhangTT> list = new ArrayList<khachhangTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM khachhang where Phone = "+Phone+"");

            while(rs.next()){
                khachhangTT cust = new khachhangTT(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"), rs.getString("Email"), rs.getString("Phone"));
                list.add(cust);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
        return list;
    }
    
    //Thêm
    public int AddNewRecord(String tenKH, String diaChi, String email, String phone){
        int rowCount = 0;
        try{
                
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO khachhang (TenKH, DiaChi, Email, Phone) VALUES(N'" + tenKH +"'"+ 
                    ",N'" + diaChi       +"'" +
                    ", '" + email        +"'" +                    
                    ", '" + phone        +"'" +")";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Sửa
    public int UpdateRecord(int maKH, String tenKH, String diaChi, String email, String phone){
        int rowCount = 0;
        try{
    
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE khachhang SET TenKH=N'" + tenKH + "'" +
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
    
    //Xóa
    public int DeleteRecord(int maKH){
        int rowCount = 0;
        try{
                
            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM khachhang WHERE MaKH = " + maKH;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
