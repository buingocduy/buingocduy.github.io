/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import bookstore.entities.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadonServices {

 
    //lay danh sach UserAccount
    public ArrayList<HoaDon> getAllRecords(){
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM HOADON");

            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("MaHoaDon"), rs.getString("SoHoaDon"), rs.getDate("Ngay"), rs.getInt("MaKH"), rs.getString("HinhThucTT"),rs.getInt("TongTien"),rs.getString("UserID"));
                list.add(hd);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String SoHoaDon, Date Ngay, int MaKH, String HinhThucTT, int TongTien, String UserID){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strngay = formatter.format(Ngay); 
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO HoaDon (SoHoaDon, Ngay, MaKH, HinhThucTT, TongTien, UserID) VALUES('"+ SoHoaDon + "'" +
                    ",'" + strngay + "'" +
                    ",'" + MaKH + "'" +
                    ",N'" + HinhThucTT + "'" +                   
                    ",'" + TongTien + "'" +
                    ",'" + UserID +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(String MaHoaDon,String SoHoaDon, Date Ngay, int MaKH, String HinhThucTT, int TongTien, String UserID){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strngay = formatter.format(Ngay); 
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE HoaDon SET SoHoaDon='" + SoHoaDon + "'" +
                    ", Ngay ='" + strngay +"'" +
                    ", MaKH ='" + MaKH +"'" +
                    ", HinhThucTT = N'" + HinhThucTT +"'" +
                    ", TongTien ='" + TongTien +"'" +
                    ", UserID ='" + UserID +"'" +
                    " WHERE MaHoaDon = '" + MaHoaDon +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(String MaHoaDon){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM HoaDon WHERE MaHoaDon = " + MaHoaDon;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

}
