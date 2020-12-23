/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author BND6699
 */
public class Cart {
    private String username;
    private String tensp;
    private String soluongmua;
    private String tonggia;

    public Cart() {
    }

    public Cart(String username, String tensp, String soluongmua, String tonggia) {
        this.username = username;
        this.tensp = tensp;
        this.soluongmua = soluongmua;
        this.tonggia = tonggia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(String soluongmua) {
        this.soluongmua = soluongmua;
    }

    public String getTonggia() {
        return tonggia;
    }

    public void setTonggia(String tonggia) {
        this.tonggia = tonggia;
    }

    
}
