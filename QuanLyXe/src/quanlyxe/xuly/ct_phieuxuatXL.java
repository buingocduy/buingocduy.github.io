/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import quanlyxe.thucthe.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author vuhuynh
 */
public class ct_phieuxuatXL {
    
    //Hien thi
    public ArrayList<ct_phieuxuatTT> getRecords(String MaPX) {
        ArrayList<ct_phieuxuatTT> list = new ArrayList<ct_phieuxuatTT>();
        try{
        hienthi_sql acc = new hienthi_sql();
        ResultSet rs = acc.Query("SELECT * FROM ct_phieuxuat WHERE MaPX = '"+ MaPX+"'");
        while(rs.next()){
           ct_phieuxuatTT phieuXuatCT = new ct_phieuxuatTT(rs.getString("MaCTPX"),rs.getString("MaPX"),rs.getString("MaSP"),rs.getLong("SoLuong"),rs.getLong("DonGia"));
           list.add(phieuXuatCT);
        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    } 
    
    //Them
    public int AddNewRecord(String MaPX, String MaSP, long SoLuong, long DonGia){
        int rowCount = 0;
        try {
        hienthi_sql acc = new hienthi_sql();
        String sql = "INSERT INTO ct_phieuxuat (MaPX, MaSP, SoLuong, DonGia) VALUES("+ MaPX
                +",'"+ MaSP
                +"',"+ SoLuong
                +","+ DonGia
                +")";
        System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return rowCount;
    }
    
    //Sua
    public int UpdateRecord(String MaCTPX, String MaPX, String MaSP, long SoLuong, long DonGia){
        int rowCount = 0;
        try{
        hienthi_sql acc = new hienthi_sql();
        String sql = "UPDATE ct_phieuxuat SET MaPX = '"+MaPX
                +"',MaSP ='"+ MaSP 
                +"',SoLuong = '"+ SoLuong 
                +"',DonGia = '"+ DonGia
                +"' WHERE MaCTPX = '"+ MaCTPX +"'" ;
        
        System.out.println(sql);
        rowCount = acc.Update(sql);
        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Xoa
    public int DeleteRecord(String MaCTPX){
        int rowCount = 0;
        try{
        hienthi_sql acc = new hienthi_sql();
        String sql = "DELETE FROM ct_phieuxuat WHERE MaCTPX = " + MaCTPX;
        rowCount=acc.Update(sql);}
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
