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

public class hoadonXL {

 
    //lay danh sach UserAccount
    public ArrayList<hoadonTT> getAllRecords(){
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon");

            while(rs.next()){
                hoadonTT hd = new hoadonTT(rs.getString("MaHoaDon"), rs.getDate("Ngay"), rs.getInt("MaKH"), rs.getString("HinhThucTT"),rs.getLong("TongTien"),rs.getString("Username"));
                list.add(hd);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    //lay danh sach UserAccount
    public ArrayList<hoadonTT> getRecords(String tim, String lua){
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon WHERE "+lua+" = '"+tim+"'");

            while(rs.next()){
                hoadonTT hd = new hoadonTT(rs.getString("MaHoaDon"), rs.getDate("Ngay"), rs.getInt("MaKH"), rs.getString("HinhThucTT"),rs.getLong("TongTien"),rs.getString("Username"));
                list.add(hd);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    //Tao moi
    public int AddNewRecord(Date Ngay, int MaKH, String HinhThucTT, long TongTien, String Username){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strngay = formatter.format(Ngay); 
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "INSERT INTO hoadon (Ngay, MaKH, HinhThucTT, TongTien, Username) VALUES('"+ strngay + "'" +
                    "," + MaKH +
                    ",N'" + HinhThucTT + "'" +                   
                    "," + TongTien + "" +
                    ",'" + Username +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(String MaHoaDon, Date Ngay, int MaKH, String HinhThucTT, long TongTien, String Username){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strngay = formatter.format(Ngay); 
            
            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE hoadon SET Ngay ='" + strngay +"'" +
                    ", MaKH =" + MaKH +
                    ", HinhThucTT = N'" + HinhThucTT +"'" +
                    ", TongTien =" + TongTien +"" +
                    ", Username ='" + Username +"'" +
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
                
            hienthi_sql acc = new hienthi_sql();
            String sql = "DELETE FROM hoadon WHERE MaHoaDon = " + MaHoaDon;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }

}
