package com.finalproject.Database;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.finalproject.business.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
/**
 *
 * @author danhl
 */
public class productDB {
      
    public static  void update(Product product){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(product);
            trans.commit();
        }catch (Exception e){
            System.out.print(e);
        }finally{
            em.close();
        }
    }
    
    public static List<Product> selectProduct(int idType){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select p from Product p " + 
                         "where p.idType = :idType ";
        TypedQuery<Product> q = em.createQuery(qString,Product.class);
        q.setParameter("idType",idType);
        List<Product> result = null;
        try{
            result = q.getResultList();
        } catch(NoResultException ex){
            return null;
        }finally{
            em.close();
        }
        return result;
    }
    
    public static Product selectProductFromId(int idProduct){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select p from Product p " +
                         "where p.idProduct = :idProduct ";
        TypedQuery<Product> q = em.createQuery(qString,Product.class);
        q.setParameter("idProduct",idProduct);
        Product result = null;
        try{
            result = q.getSingleResult();
        } catch(NoResultException ex){
            return null;
        }finally{
            em.close();
        }
        return result;
    }
    
    
}
