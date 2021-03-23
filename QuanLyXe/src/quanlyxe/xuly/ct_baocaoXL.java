/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.xuly;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import quanlyxe.thucthe.*;

/**
 *
 * @author BND6699
 */
public class ct_baocaoXL {

    //lay danh sach Baocao
    public ArrayList<ct_baocaoTT> getRecords(String strngaybd, String strngaytk) {
        ArrayList<ct_baocaoTT> list = new ArrayList<ct_baocaoTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("select TenSP, GiaBan, 'SoLuong'=SUM(SoLuong), 'TongTien'=(SUM(SoLuong) * GiaBan) from ct_hoadon,hoadon,sanpham  where ct_hoadon.MaHoaDon = hoadon.MaHoaDon and sanpham.MaSP = ct_hoadon.MaSP and Ngay between '" + strngaybd + "' and '" + strngaytk + "' Group by TenSP,GiaBan");

            while (rs.next()) {
                ct_baocaoTT ctbc = new ct_baocaoTT(rs.getString("TenSP"), rs.getLong("GiaBan"), rs.getLong("SoLuong"),rs.getLong("TongTien"));
                list.add(ctbc);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public ArrayList<tongtienTT> getTong(String strngaybd, String strngaytk) {
        ArrayList<tongtienTT> list = new ArrayList<tongtienTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("SELECT 'SoLuong'=SUM(ct_hoadon.SoLuong),'TongTien'=SUM(hoadon.TongTien) "
                                + "FROM ct_hoadon,hoadon  "
                                + "WHERE ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '" + strngaybd + "' and '" + strngaytk + "'");

            while (rs.next()) {
                tongtienTT hd = new tongtienTT(rs.getLong("SoLuong"),rs.getLong("TongTien"));
                list.add(hd);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    public ArrayList<tongtienTT> getGiamgia(String strngaybd, String strngaytk) {
        ArrayList<tongtienTT> list = new ArrayList<tongtienTT>();
        try {
            hienthi_sql acc = new hienthi_sql();
            ResultSet rs = acc.Query("select 'SoLuong'=sum(ThanhTien),'TongTien'=sum(ct_hoadon.ThanhTien - hoadon.TongTien)"
                                + "FROM ct_hoadon,hoadon  "
                                + "WHERE ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '" + strngaybd + "' and '" + strngaytk + "'");

            while (rs.next()) {
                tongtienTT hd = new tongtienTT(rs.getLong("SoLuong"),rs.getLong("TongTien"));
                list.add(hd);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
}
