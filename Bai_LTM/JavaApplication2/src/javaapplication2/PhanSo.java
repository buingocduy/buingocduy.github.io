/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author BND6699
 */
public class PhanSo {
    private int tuso;
    private int mauso;
    
    public PhanSo(boolean a){
        tuso=(int) (Math.random()*100);
        do{
            mauso=(int) (Math.random()*90+1);
        }while(mauso == 0);
    }
    
    public PhanSo(){
        tuso=(int) Math.random()*100;
        do{
            mauso=(int) Math.random()*90+1;
        }while(mauso == 0);
    }
    
    public PhanSo(int tuso, int mauso){
        this.tuso = tuso;
        if(mauso == 0){
            mauso = 1;
        } else{
            this.mauso = mauso;
        }
        
        
    }

    public int getMauso() {
        return mauso;
    }

    @Override
    public String toString() {
        return "PhanSo{" + "tuso=" + tuso + ", mauso=" + mauso + '}';
    }

}
