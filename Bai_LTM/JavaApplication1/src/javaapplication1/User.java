/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author FLASH
 */
public class User {

    public String Tenuser, Matkhau, Duongdan;
    public int Quyen;

    public User(String Tenuser, String Matkhau, String Duongdan, int Quyen) {
        this.Tenuser = Tenuser;
        this.Matkhau = Matkhau;
        this.Duongdan = Duongdan;
        this.Quyen = Quyen;
    }

    public String getTenuser() {
        return Tenuser;
    }

    public void setTenuser(String Tenuser) {
        this.Tenuser = Tenuser;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getDuongdan() {
        return Duongdan;
    }

    public void setDuongdan(String Duongdan) {
        this.Duongdan = Duongdan;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

}
