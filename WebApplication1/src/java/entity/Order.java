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
public class Order {
    private String id;
    private String use;
    private String gia;
    private String soluongmua;

    public Order() {
    }

    public Order(String id, String use, String gia, String soluongmua) {
        super(); 
        this.id = id;
        this.use = use;
        this.gia = gia;
        this.soluongmua = soluongmua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(String soluongmua) {
        this.soluongmua = soluongmua;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", use=" + use + ", gia=" + gia + ", soluongmua=" + soluongmua + '}';
    }   
}
