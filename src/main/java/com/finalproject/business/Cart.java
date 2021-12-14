/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.business;


import java.util.ArrayList;

/**
 *
 * @author danhl
 */
public class Cart {
    private ArrayList<lineItem> items;
    
    public Cart(){
        items = new ArrayList<lineItem>();
    }
    
    public void setItems(ArrayList<lineItem> listItem){
        this.items = (ArrayList<lineItem>) listItem;
    }
    
    public ArrayList<lineItem> getItems(){
        return (ArrayList<lineItem>) this.items;
    }
    
    public void addItem(lineItem item){
        int id = item.getProduct().getId();
        int quantity = item.getQuantity();
        for(lineItem i : this.items){
            if(i.getProduct().getId() == id){
                i.setQuantity(quantity);
                return;
            }
        }
        this.items.add(item);
    }
    
    public void removeItem(lineItem item){
        int id =item.getProduct().getId();
        for(int i = 0; i < this.items.size();i++){
            lineItem it = this.items.get(i);
            if(it.getProduct().getId() == id){
                this.items.remove(i);
                return;
            }
        }
    }
    
}
