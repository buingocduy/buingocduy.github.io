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
public class tongtienTT {

    long SoLuong,TongTien;

    public tongtienTT(long SoLuong, long TongTien) {
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public long getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(long SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }
    
    
    
}
