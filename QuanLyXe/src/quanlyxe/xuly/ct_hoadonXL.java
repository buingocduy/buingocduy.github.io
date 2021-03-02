/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import quanlyxe.thucthe.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ct_hoadonXL {
    
     public ArrayList<ct_hoadonTT> getAllRecords(String MaHD){
        ArrayList<ct_hoadonTT> list = new ArrayList<ct_hoadonTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("select * from ct_hoadon where MaHoaDon = '"+MaHD+"'");

            while(rs.next()){
                ct_hoadonTT cthd = new ct_hoadonTT(rs.getString("MaCTHoaDon"), rs.getString("MaHoaDon"), rs.getString("MaSP"), rs.getInt("SoLuong"), rs.getLong("DonGia"));
                list.add(cthd);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
     
     
    //Tao moi
    public int AddNewRecord(String MaHoaDon, String MaSP, int SoLuong, long DonGia){
        int rowCount = 0;
        int rowCount2 = 0;
        try{
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO ct_hoadon (MaHoaDon, MaSP, SoLuong, DonGia) VALUES('"+ MaHoaDon + "'" +
                    ",'" + MaSP + "'" +
                    ",'" + SoLuong + "'" +
                    ",'" + DonGia +"')"; 
            
            String sql2 = "UPDATE hoadon SET TongTien = (Select 'TongTien'=sum(DonGia) From ct_hoadon Where MaHoaDon = '"+ MaHoaDon + "') WHERE MaHoaDon = '"+ MaHoaDon + "'";
            
            System.out.println(sql);
            System.out.println(sql2);
          
            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }
    
    //Cap nhat
    public int UpdateRecord(String MaCTHoaDon,String MaHoaDon, String MaSP, int SoLuong, long DonGia){
        int rowCount = 0;
        int rowCount2 = 0;
        try{
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE ct_hoadon SET MaHoaDon='" + MaHoaDon + "'" +
                    ", MaSP ='" + MaSP +"'" +
                    ", SoLuong ='" + SoLuong +"'" +
                    ", DonGia = '" + DonGia +"'" +
                    " WHERE MaCTHoaDon = '" + MaCTHoaDon +"'";
            
            
            String sql2 = "UPDATE hoadon SET TongTien = (Select 'TongTien'=sum(DonGia) From ct_hoadon Where MaHoaDon = '"+ MaHoaDon + "') WHERE MaHoaDon = '"+ MaHoaDon + "'";
            
            System.out.println(sql);
            System.out.println(sql2);
          
            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }
    
    //Xóa
    public int DeleteRecord(String MaCTHoaDon, String MaHoaDon){
        int rowCount = 0;
        int rowCount2 = 0;
        try{
                
            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM ct_hoadon WHERE MaCTHoaDon = " + MaCTHoaDon;
            
            String sql2 = "UPDATE hoadon SET TongTien = (Select 'TongTien'=sum(DonGia) From ct_hoadon Where MaHoaDon = '"+ MaHoaDon + "') WHERE MaHoaDon = '"+ MaHoaDon + "'";
            
            System.out.println(sql);
            System.out.println(sql2);
          
            rowCount = acc.Update(sql);
            rowCount2 = acc.Update(sql2);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount & rowCount2;
    }

}
