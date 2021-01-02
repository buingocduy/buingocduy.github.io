package bookstore.dal;

import bookstore.entities.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PublisherServices {
	//lay danh sach 
    public ArrayList<Publisher> getAllRecords(){
        ArrayList<Publisher> list = new ArrayList<Publisher>();
        try{        
            SqlDataAccess dbAccess = new SqlDataAccess();
            ResultSet rs = dbAccess.Query("SELECT * FROM NhaXuatBan");

            while(rs.next()){
            	Publisher nxb = new Publisher(rs.getInt("MaNXB"), rs.getString("TenNXB"), rs.getString("DiaChi"), rs.getString("Email"), rs.getString("NguoiLienHe"));
                list.add(nxb);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String tenNXB, String diaChi, String email, String nguoiLienHe){
        int rowCount = 0;
        try{

            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "INSERT INTO NhaXuatBan (TenNXB, DiaChi, Email, NguoiLienHe) VALUES('N" + tenNXB +"'"+
            		",N'"+ diaChi   	+"'"+
            		",N'"+ email  		+"'"+
                    ",'" + nguoiLienHe  +"')";                    
            
            System.out.println(sql);
            
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat  
    public int UpdateRecord(Integer publisherID, String name, String diaChi, String email, String nguoiLienHe){
        int rowCount = 0;
        try{
    
            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "UPDATE NhaXuatBan SET TenNXB=N'" + name + "'" +
            		", diaChi 		=N'"+ diaChi 	+"'" +
                    ", Email 		='" + email 	+"'" +
                    ", NguoiLienHe	=N'"+ nguoiLienHe 	+"'" +
                    " WHERE MaNXB 	= " + publisherID ;
            
            System.out.println(sql);
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Xoa
    public int DeleteRecord(int publisherID){
        int rowCount = 0;
        try{
                
            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "DELETE FROM NhaXuatBan WHERE MaNXB = " + publisherID;
            
            System.out.println(sql);
            
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
