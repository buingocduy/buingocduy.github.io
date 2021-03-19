/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

/**
 *
 * @author Bùi Ngọc Duy
 */
public class khachhangTT {

    String phone, tenKH, diaChi, email;
    long TongTienDaMua;

    public khachhangTT(String phone, String tenKH, String diaChi, String email, long TongTienDaMua) {
        this.phone = phone;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.email = email;
        this.TongTienDaMua = TongTienDaMua;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTongTienDaMua() {
        return TongTienDaMua;
    }

    public void setTongTienDaMua(long TongTienDaMua) {
        this.TongTienDaMua = TongTienDaMua;
    }

    
}
