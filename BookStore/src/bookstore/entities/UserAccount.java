/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Date;

/**
 *
 * @author Vinh
 */
public class UserAccount {
    private String username, password, hoten, email, phone;
    private Date ngaysinh, ngaybatdau;
    
    public UserAccount(String username, String password, String hoten, String email, String phone, Date ngaysinh, Date ngaybatdau){
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
    
    public String getPassword(){
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
