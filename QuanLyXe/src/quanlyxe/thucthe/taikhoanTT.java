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
public class taikhoanTT {

    private String username, password, hoten, email, phone;
    private Date ngaysinh, ngaybatdau;

    public taikhoanTT(String username, String password, String hoten, String email, String phone, Date ngaysinh, Date ngaybatdau) {
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.email = email;
        this.phone = phone;
        this.ngaysinh = ngaysinh;
        this.ngaybatdau = ngaybatdau;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHoten() {
        return hoten;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

}
