/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Date;

/**
 *
 * @author Nguyen Van Ky
 */
public class Warehouse {
    private String tenkho, address, phone;
    private Integer makho;
    
    public Warehouse(Integer makho, String tenkho, String address, String phone){
        this.makho = makho;
        this.tenkho = tenkho;
        this.address = address; 
        this.phone = phone;
    }
    

    public Integer getMakho() {
        return makho;
    }
   
    public String getTenkho() {
        return tenkho;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
