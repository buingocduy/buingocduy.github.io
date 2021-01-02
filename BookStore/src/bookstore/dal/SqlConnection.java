package bookstore.dal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class SqlConnection {
	public Connection getConnection() throws Exception{
	String url = "jdbc:sqlserver://"+serverName+":"+ portNumber+"\\"+instance+";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
        url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName=" +dbName+";sslProtocol=TLSv1.2;";
        System.out.println("ket noi thanh cong");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password); 
    }
	
	public void testConnection() throws ClassNotFoundException, Exception{
		Connection conn = null;
		try {       
	        // Test connection			
			conn = new SqlConnection().getConnection();

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Test SQL Server connection: ");
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {				
				if (conn != null && !conn.isClosed())
					try {conn.close();} catch (Exception ex) {ex.printStackTrace();}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
        
    //private final String serverName = "DESKTOP-46VDUF3\\SQLEXPRESS"; //cho laptop
    private final String serverName = "DESKTOP-ACKLLQG\\SQLEXPRESS";
    private final String dbName = "BookStoreDB";
    private final String portNumber = "1433";
    private final String instance = ""; 
    private final String userID = "sa";
    private final String password = "sa";      
		
}
