/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcam.thuthe;

/**
 *
 * @author BND6699
 */
public class khachhangTT {
    String STT,HOTEN,NGAYGIOVAO,HINHANH;

    public khachhangTT(String STT, String HOTEN, String NGAYGIOVAO, String HINHANH) {
        this.STT = STT;
        this.HOTEN = HOTEN;
        this.NGAYGIOVAO = NGAYGIOVAO;
        this.HINHANH = HINHANH;
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getNGAYGIOVAO() {
        return NGAYGIOVAO;
    }

    public void setNGAYGIOVAO(String NGAYGIOVAO) {
        this.NGAYGIOVAO = NGAYGIOVAO;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }
    
    
}
