/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.business;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author danhl
 */
@Entity
@Table(name="invoicedb")
public class Invoice implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idinvoice")
    private int idInvoice;
    
    @Basic(optional = false)
    @Column (name = "iduser")
    private int idUser;
    
    @Basic(optional = false)
    @Column(name = "idproduct")
    private int idProduct;
    
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    
    @Basic(optional = false)
    @Column(name = "dateinvoice")
    private Date dateInvoice;
    
    public int getId(){
        return this.idInvoice;
    }
    
    public void setId(int id){
        this.idInvoice = id;
    }
    
    public int getIdUser(){
        return this.idUser;
    }
    
    public void setIdUser(int id){
        this.idUser = id;
    }
    
    public int getIdProduct(){
        return this.idProduct;
    }
    
    public void setIdProduct(int id){
        this.idProduct = id;
    }
    
    public int getQuantiy(){
        return this.quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public String getDateInvoice(){
        return String.valueOf(this.dateInvoice);
    }
    
    public void setDateInvoice(String date){
        this.dateInvoice = java.sql.Date.valueOf(date);
    }


}
