/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

import java.util.Date;

/**
 *
 * @author Bui Ngoc Duy
 */
public class khoTT {

    private String MaKho, TenKho, DiaChi, Phone;

    public khoTT(String MaKho, String TenKho, String DiaChi, String Phone) {
        this.MaKho = MaKho;
        this.TenKho = TenKho;
        this.DiaChi = DiaChi;
        this.Phone = Phone;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getTenKho() {
        return TenKho;
    }

    public void setTenKho(String TenKho) {
        this.TenKho = TenKho;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    
}
