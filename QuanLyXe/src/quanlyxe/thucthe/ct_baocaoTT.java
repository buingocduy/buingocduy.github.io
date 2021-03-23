/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

/**
 *
 * @author BND6699
 */
public class ct_baocaoTT {
    String TenSP;
    long GiaBan,SoLuong,TongTien;

    public ct_baocaoTT(String TenSP, long GiaBan, long SoLuong, long TongTien) {
        this.TenSP = TenSP;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public long getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(long GiaBan) {
        this.GiaBan = GiaBan;
    }

    public long getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(long SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    
}
