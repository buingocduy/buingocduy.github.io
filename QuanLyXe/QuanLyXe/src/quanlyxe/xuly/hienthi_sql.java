/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BND6699
 */
public class hienthi_sql {

    private Connection conn;
    private Statement stmt;

    public hienthi_sql() {
        try {
            ketnoi_sql myCon = new ketnoi_sql();
            conn = myCon.getConnection();
            stmt = conn.createStatement();
        } catch (Exception ex) {

        }
    }

    //INSERT, UPDATE, DELETE    
    public int Update(String str) {
        try {
            int i = stmt.executeUpdate(str);
            return i;
        } catch (Exception ex) {
            return -1;
        }
    }

    //SELECT
    public ResultSet Query(String str) {
        try {
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        } catch (Exception ex) {
            return null;
        }

    }
}
