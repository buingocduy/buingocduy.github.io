/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

/**
 *
 * @author Bui Ngoc Duy
 */
public class ct_phieuxuatTT {

    private String MaCTPX, MaPX;
    private String MaSP;
    private long SoLuong, DonGia;

    public ct_phieuxuatTT(String MaCTPX, String MaPX, String MaSP, long SoLuong, long DonGia) {
        this.MaCTPX = MaCTPX;
        this.MaPX = MaPX;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaCTPX() {
        return MaCTPX;
    }

    public void setMaCTPX(String MaCTPX) {
        this.MaCTPX = MaCTPX;
    }

    public String getMaPX() {
        return MaPX;
    }

    public void setMaPX(String MaPX) {
        this.MaPX = MaPX;
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

    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

}
