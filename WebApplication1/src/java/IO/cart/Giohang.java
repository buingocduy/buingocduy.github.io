/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO.cart;

import entity.Item;
import java.util.ArrayList;

/**
 *
 * @author BND6699
 */
public class Giohang 
{
   private ArrayList<Item>cart;
   
   public Giohang(){
        cart=new ArrayList<Item>();
   }
   
    public void ThemHang(Item mh){
        //Nếu món hàng đã có trong giỏ
        //thì cập nhập lại số lượng
        if(cart.contains(mh)){
            Item hang=cart.get(cart.indexOf(mh));
            hang.setSoluongmua(hang.getSoluongmua()+mh.getSoluongmua());
        }
        else{//còn không thì thêm mới
            cart.add(mh);
        }
    }
     
    public double Tongtien(){
        double tien=0;
        for(Item mh:cart){
            tien+=mh.getGia()*mh.getSoluongmua();
        }
        return tien;
    }
     
    public ArrayList<Item> getGH(){
        return cart;
    }
    
}
    

