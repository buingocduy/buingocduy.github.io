/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

/**
 *
 * @author BND6699
 */
public class CT_HoaDon {
    String MaCTHoaDon,MaHoaDon,bookID;
    int SoLuong,Dongia;

    public CT_HoaDon(String MaCTHoaDon, String MaHoaDon, String bookID, int SoLuong, int Dongia) {
        this.MaCTHoaDon = MaCTHoaDon;
        this.MaHoaDon = MaHoaDon;
        this.bookID = bookID;
        this.SoLuong = SoLuong;
        this.Dongia = Dongia;
    }

    public String getMaCTHoaDon() {
        return MaCTHoaDon;
    }

    public void setMaCTHoaDon(String MaCTHoaDon) {
        this.MaCTHoaDon = MaCTHoaDon;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int Dongia) {
        this.Dongia = Dongia;
    }
    
    
}
