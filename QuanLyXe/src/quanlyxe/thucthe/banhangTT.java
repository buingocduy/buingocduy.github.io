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
public class banhangTT {

    String MaCTHoaDon, MaSP, TenSP;
    long SoLuong;
    long Dongia;

    public banhangTT(String MaCTHoaDon, String MaSP, String TenSP, long SoLuong, long Dongia) {
        this.MaCTHoaDon = MaCTHoaDon;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.Dongia = Dongia;
    }

    public String getMaCTHoaDon() {
        return MaCTHoaDon;
    }

    public void setMaCTHoaDon(String MaCTHoaDon) {
        this.MaCTHoaDon = MaCTHoaDon;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
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
