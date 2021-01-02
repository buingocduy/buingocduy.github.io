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

public class ct_hoadonServices {
    
     public ArrayList<CT_HoaDon> getAllRecords(){
        ArrayList<CT_HoaDon> list = new ArrayList<CT_HoaDon>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("select * from CTHoaDon");

            while(rs.next()){
                CT_HoaDon cthd = new CT_HoaDon(rs.getString("MaCTHoaDon"), rs.getString("MaHoaDon"), rs.getString("MaSach"), rs.getInt("SoLuong"), rs.getInt("DonGia"));
                list.add(cthd);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String MaHoaDon, String MaSach, int SoLuong, int DonGia){
        int rowCount = 0;
        try{
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO CTHoaDon (MaHoaDon, MaSach, SoLuong, DonGia) VALUES('"+ MaHoaDon + "'" +
                    ",'" + MaSach + "'" +
                    ",'" + SoLuong + "'" +
                    ",'" + DonGia +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(String MaCTHoaDon,String MaHoaDon, String MaSach, int SoLuong, int DonGia){
        int rowCount = 0;
        try{
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE CTHoaDon SET MaHoaDon='" + MaHoaDon + "'" +
                    ", MaSach ='" + MaSach +"'" +
                    ", SoLuong ='" + SoLuong +"'" +
                    ", DonGia = N'" + DonGia +"'" +
                    " WHERE MaCTHoaDon = '" + MaCTHoaDon +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(String MaCTHoaDon){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM CTHoaDon WHERE MaCTHoaDon = " + MaCTHoaDon;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

}
