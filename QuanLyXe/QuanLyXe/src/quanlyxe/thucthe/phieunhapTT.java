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
public class phieunhapTT {

    private String MaPN, Username, MaNCC;
    private Date NgayNhap;
    private String MaKho;

    public phieunhapTT(String MaPN, String Username, String MaNCC, Date NgayNhap, String MaKho) {
        this.MaPN = MaPN;
        this.Username = Username;
        this.MaNCC = MaNCC;
        this.NgayNhap = NgayNhap;
        this.MaKho = MaKho;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

}
