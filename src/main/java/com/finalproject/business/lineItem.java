/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.business;


/**
 *
 * @author danhl
 */
public class lineItem {
    private Product product;
    private int quantity;
    private int total;
    
    public void setProduct(Product product){
        this.product = product;
    }
    
    public Product getProduct(){
        return this.product;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public int getTotal(){
        this.total = (this.product.getPrice())*(this.quantity);
        return this.total;
    }
}
