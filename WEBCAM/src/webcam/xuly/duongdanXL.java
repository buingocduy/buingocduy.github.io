/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam.xuly;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import webcam.thuthe.duongdanTT;

/**
 *
 * @author Admin
 */
public class duongdanXL {
    
    public ArrayList<duongdanTT> getAllRecords(){
        ArrayList<duongdanTT> list = new ArrayList<duongdanTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT ID,LINK FROM duongdan");
            
            while(rs.next()){
                duongdanTT dd = new duongdanTT(rs.getString("id"),rs.getString("link"));
                list.add(dd);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public int UpdateRecord(String link){
        int rowCount = 0;
        try {

            hienthi_sql acc = new hienthi_sql();
            String sql = "UPDATE duongdan SET LINK = '"+link+"' WHERE ID = '1'";
            System.out.println(sql);

            rowCount = acc.Update(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
