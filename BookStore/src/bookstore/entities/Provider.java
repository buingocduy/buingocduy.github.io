/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Date;

/**
 *
 * @author Nguyen Xuan Vinh
 */
public class Provider {
    int maNCC;
    private String tenNCC, diaChi, email, phone, nguoiLienHe;

    public Provider(int maNCC, String tenNCC, String diaChi, String email, String phone, String nguoiLienHe) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.phone = phone;
        this.nguoiLienHe = nguoiLienHe;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getNguoiLienHe() {
        return nguoiLienHe;
    }
        
    
}
