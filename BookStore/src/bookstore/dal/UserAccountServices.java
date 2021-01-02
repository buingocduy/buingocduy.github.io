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
public class UserAccountServices {
    
    //lay danh sach UserAccount
    public ArrayList<UserAccount> getAllRecords(){
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM UserAccount");

            while(rs.next()){
                UserAccount user = new UserAccount(rs.getString("Username"), rs.getString("Password"), rs.getString("HoTen"), rs.getString("Email"), rs.getString("Phone"), rs.getDate("NgaySinh"), rs.getDate("NgayBatDau"));
                list.add(user);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String username, String pass, String hoten, String email, String phone, Date birthDay, Date startDate){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strBirthDay = formatter.format(birthDay); 
            String strStartDate = formatter.format(startDate); 
            System.out.println("Date Format with yyyy-MM-dd : "+ strBirthDay + "," + strStartDate);  
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO UserAccount ([Username],[Password], HoTen,Email,Phone,NgaySinh,NgayBatDau) VALUES('" + username +"'"+ 
                    ", '" + pass         +"'" +
                    ",N'" + hoten        +"'" +                    
                    ", '" + email        +"'" +
                    ", '" + phone        +"'" +
                    ", '" + strBirthDay  +"'" +
                    ", '" + strStartDate +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat
    public int UpdateRecord(String username, String pass, String hoten, String email, String phone, Date birthDay, Date startDate){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strBirthDay = formatter.format(birthDay); 
            String strStartDate = formatter.format(startDate); 
            System.out.println("Date Format with yyyy-MM-dd : "+ strBirthDay + "," + strStartDate);  
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE UserAccount SET HoTen=N'" + hoten + "'" +
                    ", [Password] ='" + pass +"'" +
                    ", Email ='" + email +"'" +
                    ", Phone ='" + phone +"'" +
                    ", NgaySinh ='" + strBirthDay +"'" +
                    ", NgayBatDau ='" + strStartDate +"'" +
                    " WHERE Username = '" + username +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(String username){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM UserAccount WHERE Username = '" + username +"'";
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
