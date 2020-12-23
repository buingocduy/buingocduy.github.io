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
public class Item {
    private int id;
    private String tensp;
    private String hinhanh;
    private int gia;
    private int soluongmua;
    private int tonggia;

    public Item() {
    }

    public Item(int id, String tensp, String hinhanh, int gia, int soluongmua, int tonggia) {
        this.id = id;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.soluongmua = soluongmua;
        this.tonggia = tonggia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public int getTonggia() {
        return tonggia;
    }

    public void setTonggia(int tonggia) {
        this.tonggia = tonggia;
    }


   

    
    
    
}
