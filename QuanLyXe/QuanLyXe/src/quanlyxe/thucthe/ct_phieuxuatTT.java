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
    private String MaKho, MaSP;
    private long SoLuong;

    public ct_phieuxuatTT(String MaCTPX, String MaPX, String MaKho, String MaSP, long SoLuong) {
        this.MaCTPX = MaCTPX;
        this.MaPX = MaPX;
        this.MaKho = MaKho;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
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

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
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

    
}
