/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyxe.thucthe;

/**
 * Xem / Xoa / Sua 
 *
 * @author Bùi Ngọc Duy
 */
public class sanphamTT {

    String ID, Name, categoryID;
    long Price;
    String supplierID, publishingYear;

    public sanphamTT(String ID, String Name, String categoryID, long Price, String supplierID, String publishingYear) {
        this.ID = ID;
        this.Name = Name;
        this.categoryID = categoryID;
        this.Price = Price;
        this.supplierID = supplierID;
        this.publishingYear = publishingYear;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long Price) {
        this.Price = Price;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

}
