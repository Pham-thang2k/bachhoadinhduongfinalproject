/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.business;

import java.io.Serializable;
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
@Table(name = "productdb")
public class Product implements Serializable{

    @Column(name = "numstar")
    private Integer numstar;
    @Column(name = "numreview")
    private Integer numreview;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "idproduct")
    @Basic(optional = false)
    private int idProduct;
    
    @Column(name = "nameproduct")
    @Basic(optional = false)
    private String nameProduct;
    
    
    @Column(name = "notenum")
    private String noteNum;
    
    @Column(name = "price")
    private int price;
    
    @Column(name = "description")
    private String description;
    
    @Column (name = "idtype")
    @Basic(optional = false)
    private int idType;
    
    public void setId(int id){
        this.idProduct = id;
    }
    
    public int getId(){
        return this.idProduct;
    }
    
    public void setName(String name){
        this.nameProduct = name;
    }
    
    public String getName(){
        return this.nameProduct;
    }
    
    
    public void setNotenum(String note){
        this.noteNum = note;
    }
    
    public String getNotenum(){
        return this.noteNum;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public void setDescription(String Desp){
        this.description = Desp;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setIdtype(int id){
        this.idType = id;
    }
    
    public int getIdtype(){
        return this.idType;
    }

    public Product() {
    }

    public Integer getNumstar() {
        return numstar;
    }

    public void setNumstar(Integer numstar) {
        this.numstar = numstar;
    }

    public Integer getNumreview() {
        return numreview;
    }

    public void setNumreview(Integer numreview) {
        this.numreview = numreview;
    }
}
