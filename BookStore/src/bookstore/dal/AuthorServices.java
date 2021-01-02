package bookstore.dal;

import bookstore.entities.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class AuthorServices {
	
    //lay danh sach 
    public ArrayList<Author> getAllRecords(){
        ArrayList<Author> list = new ArrayList<Author>();
        try{        
            SqlDataAccess dbAccess = new SqlDataAccess();
            ResultSet rs = dbAccess.Query("SELECT * FROM TacGia");

            while(rs.next()){
            	Author tacgia = new Author(rs.getInt("MaTacGia"), rs.getString("TenTacGia"), rs.getString("GhiChu"));
                list.add(tacgia);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //Tao moi
    public int AddNewRecord(String authorName, String note){
        int rowCount = 0;
        try{

            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "INSERT INTO TacGia ([TenTacGia], GhiChu) VALUES(N'" + authorName +"'"+
                    ",N'" + note   +"')";                    
            
            System.out.println(sql);
            
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Cap nhat  
    public int UpdateRecord(int authorID, String authorName, String note){
        int rowCount = 0;
        try{
    
            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "UPDATE TacGia SET TenTacGia=N'" + authorName + "'" +
                    ", GhiChu   =N'" + note +"'" +                    
                    " WHERE MaTacGia = " + authorID ;
            
            System.out.println(sql);
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Xoa
    public int DeleteRecord(int authorID){
        int rowCount = 0;
        try{
                
            SqlDataAccess dbAccess = new SqlDataAccess();
            String sql = "DELETE FROM TacGia WHERE TenTacGia = " + authorID;
            
            System.out.println(sql);
            
            rowCount = dbAccess.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
	
}
