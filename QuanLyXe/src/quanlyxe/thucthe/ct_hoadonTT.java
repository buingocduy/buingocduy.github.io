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
public class ct_hoadonTT {

    String MaCTHoaDon, MaHoaDon, MaSP;
    long SoLuong;
    long Dongia;

    public ct_hoadonTT(String MaCTHoaDon, String MaHoaDon, String MaSP, long SoLuong, long Dongia) {
        this.MaCTHoaDon = MaCTHoaDon;
        this.MaHoaDon = MaHoaDon;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.Dongia = Dongia;
    }

    public String getMaCTHoaDon() {
        return MaCTHoaDon;
    }

    public void setMaCTHoaDon(String MaCTHoaDon) {
        this.MaCTHoaDon = MaCTHoaDon;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public long getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(long SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getDongia() {
        return Dongia;
    }

    public void setDongia(long Dongia) {
        this.Dongia = Dongia;
    }

}
