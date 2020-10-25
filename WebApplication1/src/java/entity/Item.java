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
    private String gia;
    private String image;
    private String soluongmua;

    public Item() {
    }

    public Item(String id, String tensp, String gia, String image, String soluongmua) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.image = image;
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

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(String soluongmua) {
        this.soluongmua = soluongmua;
    } 
}

