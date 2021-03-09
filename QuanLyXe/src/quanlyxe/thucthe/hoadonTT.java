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
    int MaKH;
    String HinhThucTT;
    long TongTien;
    String UserID;

    public hoadonTT(String MaHoaDon, Date Ngay, int MaKH, String HinhThucTT, long TongTien, String UserID) {
        this.MaHoaDon = MaHoaDon;
        this.Ngay = Ngay;
        this.MaKH = MaKH;
        this.HinhThucTT = HinhThucTT;
        this.TongTien = TongTien;
        this.UserID = UserID;
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

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getHinhThucTT() {
        return HinhThucTT;
    }

    public void setHinhThucTT(String HinhThucTT) {
        this.HinhThucTT = HinhThucTT;
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

}
