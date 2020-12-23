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
public class Hang {
    private String tenhang;
    private String logo;

    public Hang() {
    }

    public Hang(String tenhang, String logo) {
        this.tenhang = tenhang;
        this.logo = logo;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    
}
