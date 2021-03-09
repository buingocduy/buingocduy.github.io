/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

import java.util.Date;

/**
 *
 * @author vuhuynh
 */
public class phieuxuatTT {

    private String MaPX;
    private int MaKH, MaKho;
    private String Username;
    private Date NgayXuat;

    public phieuxuatTT(String MaPX, int MaKH, int MaKho, String Username, Date NgayXuat) {
        this.MaPX = MaPX;
        this.MaKH = MaKH;
        this.MaKho = MaKho;
        this.Username = Username;
        this.NgayXuat = NgayXuat;
    }

    public String getMaPX() {
        return MaPX;
    }

    public void setMaPX(String MaPX) {
        this.MaPX = MaPX;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaKho() {
        return MaKho;
    }

    public void setMaKho(int MaKho) {
        this.MaKho = MaKho;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Date getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(Date NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

}
