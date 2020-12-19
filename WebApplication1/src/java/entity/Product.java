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
public class Product {
    private String tensp;
    private String gia;
    private String hinh;
    private String kichthuoc;
    private String chieucaoyen;
    private String sizebanh;
    private String engine;
    private String CC;
    private String congsuat;
    private String CCnhot;
    private String CCxang;
    private String phanh;
    private String gear;
    private String hang;

    public Product() {
    }

    public Product(String tensp, String gia, String hinh, String kichthuoc, String chieucaoyen, String sizebanh, String engine, String CC, String congsuat, String CCnhot, String CCxang, String phanh, String gear, String hang) {
        this.tensp = tensp;
        this.gia = gia;
        this.hinh = hinh;
        this.kichthuoc = kichthuoc;
        this.chieucaoyen = chieucaoyen;
        this.sizebanh = sizebanh;
        this.engine = engine;
        this.CC = CC;
        this.congsuat = congsuat;
        this.CCnhot = CCnhot;
        this.CCxang = CCxang;
        this.phanh = phanh;
        this.gear = gear;
        this.hang = hang;
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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }

    public String getChieucaoyen() {
        return chieucaoyen;
    }

    public void setChieucaoyen(String chieucaoyen) {
        this.chieucaoyen = chieucaoyen;
    }

    public String getSizebanh() {
        return sizebanh;
    }

    public void setSizebanh(String sizebanh) {
        this.sizebanh = sizebanh;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getCongsuat() {
        return congsuat;
    }

    public void setCongsuat(String congsuat) {
        this.congsuat = congsuat;
    }

    public String getCCnhot() {
        return CCnhot;
    }

    public void setCCnhot(String CCnhot) {
        this.CCnhot = CCnhot;
    }

    public String getCCxang() {
        return CCxang;
    }

    public void setCCxang(String CCxang) {
        this.CCxang = CCxang;
    }

    public String getPhanh() {
        return phanh;
    }

    public void setPhanh(String phanh) {
        this.phanh = phanh;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

}