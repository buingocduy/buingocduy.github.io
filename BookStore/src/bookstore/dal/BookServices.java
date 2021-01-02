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
 * @author Vinh
 */
public class BookServices {
    //lay danh sach UserAccount
    public ArrayList<Book> getAllRecords(){
        ArrayList<Book> list = new ArrayList<Book>();
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [Sach]");

            while(rs.next()){
                Book book = new Book(rs.getString("MaSach"), rs.getString("TenSach"), rs.getInt("MaTacGia"), rs.getInt("MaLoaiSach"), rs.getInt("MaNXB"), rs.getInt("NamXuatBan"));
                list.add(book);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String bookID, String bookName, int authorID, int categoryID, int publisherID, int publishingYear){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO Sach (MaSach, TenSach, MaTacGia, MaLoaiSach, MaNXB, NamXuatBan) VALUES('" + bookID + "'" +
                    ",N'" + bookName +"'"+ 
                    ", " + authorID         +
                    ", " + categoryID       +                    
                    ", " + publisherID      +
                    ", " + publishingYear   +
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
    public int UpdateRecord(String bookID, String bookName, int authorID, int categoryID, int publisherID, int publishingYear){
        int rowCount = 0;
        try{
    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE Sach SET TenSach=N'" + bookName + "'" +
                    ", MaTacGia     =" + authorID       +
                    ", MaLoaiSach   =" + categoryID     +
                    ", MaNXB        =" + publisherID    +
                    ", NamXuatBan   =" + publishingYear +
                    " WHERE MaSach = '" + bookID +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Cap nhat
    public int DeleteRecord(String bookID){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM Sach WHERE MaSach = " + bookID;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
