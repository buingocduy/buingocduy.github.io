/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBContext 
{
    public Connection getConnection() throws Exception{
        String url = "jdbc:sqlserver://"+serverName+":"+ portNumber+"\\"+instance+";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
        url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName=" +dbName;
        System.out.println("ket noi thanh cong");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    public ResultSet chondulieu(String getConnection) throws Exception{
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(getConnection);
        return rs;  
    }
    
    public static void main(String[] args) throws Exception{
        DBContext connet = new DBContext();
        System.out.println(connet.getConnection());
    }
    
    private final String serverName = "DESKTOP-ACKLLQG\\SQLEXPRESS";
    private final String dbName = "nguoidung";
    private final String portNumber = "1433";
    private final String instance = ""; 
    private final String userID = "sa";
    private final String password = "sa";          
    }
    

