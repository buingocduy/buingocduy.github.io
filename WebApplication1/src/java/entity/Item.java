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
    private String id;
    private String tensp;
    private int gia;
    private double soluongmua;

    public Item() {
    }

    public Item(String id, String tensp, int gia, double soluongmua) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.soluongmua = soluongmua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public double getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(double soluongmua) {
        this.soluongmua = soluongmua;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", tensp=" + tensp + ", gia=" + gia + ", soluongmua=" + soluongmua + '}';
    }

    
}

