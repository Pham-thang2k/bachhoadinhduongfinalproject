/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.Database;

import com.finalproject.business.Cart;
import com.finalproject.business.Invoice;
import com.finalproject.business.lineItem;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author danhl
 */
public class invoiceDB {
    public static void insert(Invoice invoice){
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans  = em.getTransaction();
        trans.begin();
        try{
            em.persist(invoice);
            trans.commit();
        } catch(Exception e){
            System.out.print(e);
        } finally{
            em.close();
        }
    }
    
     public static int getMaxID(){
 
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "select max(i.idInvoice) from Invoice i";
        TypedQuery<Integer> q =  em.createQuery(queryString,Integer.class);    
        int id = 0;
        try{
            id =  (q.getSingleResult() == null)? 0 : (q.getSingleResult());
        } catch(NoResultException ex){
            return  id;
        } finally {
            em.close();
        }
        return id;
    }
    
    public static void insertFull(Cart cart, int idUser, int idInvoice){
        int id = getMaxID();
        if(idInvoice > id){
            id = idInvoice;
            Invoice invoice = new Invoice();
            for(lineItem i : cart.getItems()){
                invoice.setId(id);
                invoice.setIdProduct(i.getProduct().getId());
                invoice.setQuantity(i.getQuantity());
                invoice.setIdUser(idUser);
                String sdate = String.valueOf(Date.valueOf(LocalDate.now()));
                invoice.setDateInvoice(sdate);
                insert(invoice);
        }
        }
    }

   
}
