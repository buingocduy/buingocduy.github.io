package bookstore.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDataAccess {
	private Connection conn;
    private Statement stmt;
    
    public SqlDataAccess(){
        try{
            SqlConnection myCon = new SqlConnection();
            conn = myCon.getConnection();
            stmt = conn.createStatement();
        }
        catch(Exception ex){
        	
        }        
    }
    //INSERT, UPDATE, DELETE    
    public int Update(String str){
        try{
            int i = stmt.executeUpdate(str);
            return i;
        }
        catch(Exception ex){
            return -1;
        }
    }
    //SELECT
    public ResultSet Query(String str){
        try{
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        }
        catch(Exception ex){
            return null;
        }
        
    }
}
