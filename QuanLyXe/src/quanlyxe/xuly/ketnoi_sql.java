/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BND6699
 */
public class ketnoi_sql {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";sslProtocol=TLSv1.2;";
        }
        System.out.println("ket noi thanh cong");
        System.out.println(url);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    //private final String serverName = "DESKTOP-46VDUF3\\SQLEXPRESS"; //cho laptop
    private final String serverName = "DESKTOP-ACKLLQG\\SQLEXPRESS";
    private final String dbName = "QLXE";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "sa";

}
