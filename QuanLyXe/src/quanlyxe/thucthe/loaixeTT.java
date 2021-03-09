/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

/**
 * Loại sản phẩm
 *
 * @author Bùi Ngọc Duy
 */
public class loaixeTT {

    String Maloai;
    String Tenloai;

    public loaixeTT(String Maloai, String Tenloai) {
        this.Maloai = Maloai;
        this.Tenloai = Tenloai;
    }

    public String getMaloai() {
        return Maloai;
    }

    public void setMaloai(String Maloai) {
        this.Maloai = Maloai;
    }

    public String getTenloai() {
        return Tenloai;
    }

    public void setTenloai(String Tenloai) {
        this.Tenloai = Tenloai;
    }

}
