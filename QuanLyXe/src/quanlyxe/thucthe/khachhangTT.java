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
    int maKH;
    String tenKH, diaChi, email, phone;

    public khachhangTT(int maKH, String tenKH, String diaChi, String email, String phone) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.email = email;
        this.phone = phone;
    }

    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}