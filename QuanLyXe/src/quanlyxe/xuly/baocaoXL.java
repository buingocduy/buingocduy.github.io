/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

/**
 *
 * @author BND6699
 */

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import quanlyxe.thucthe.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class baocaoXL {
    
    //lay danh sach HOA DON
    public ArrayList<hoadonTT> getRecords(String startDate, String endDate){
        ArrayList<hoadonTT> list = new ArrayList<hoadonTT>();
        try{        
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT * FROM hoadon WHERE Ngay between '"+startDate+"' and '"+endDate+"' ");

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
    
}
