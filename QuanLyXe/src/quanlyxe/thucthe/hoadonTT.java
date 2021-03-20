/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

import java.util.Date;

/**
 *
 * @author BND6699
 */
public class hoadonTT {

    String MaHoaDon;
    Date Ngay;
    String SDT;
    long TongTien;
    String UserID;
    String GhiChu;

    public hoadonTT(String MaHoaDon, Date Ngay, String SDT, long TongTien, String UserID, String GhiChu) {
        this.MaHoaDon = MaHoaDon;
        this.Ngay = Ngay;
        this.SDT = SDT;
        this.TongTien = TongTien;
        this.UserID = UserID;
        this.GhiChu = GhiChu;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

}
