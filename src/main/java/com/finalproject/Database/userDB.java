package com.finalproject.Database;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danhl
 */
import com.finalproject.business.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;




public class userDB {
   
    public static void insert(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans  = em.getTransaction();
        trans.begin();
        try{
            em.persist(user);
            trans.commit();
        } catch(Exception e){
            System.out.print(e);
        } finally{
            em.close();
        }
    }
    
    public static void update(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(user);
            trans.commit();
        } catch(Exception e){
            System.out.print(e);
        } finally{
            em.close();
        }
    }
   
    public static User selectUser(String email, String pass){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "select u from User u "
                          + "where u.email = :email and u.password = :password";
        TypedQuery<User> q = em.createQuery(queryString, User.class);
        q.setParameter("email", email);
        q.setParameter("password",pass);
        User result = null;
        try{
            result = q.getSingleResult();
        } catch(NoResultException ex){
            return null;
        } finally {
            em.close();
        }
        return result;
    }
    
    public static User selectUserFromId(int id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "select u from User u "
                          + "where u.idUser = :idUser";
        TypedQuery<User> q = em.createQuery(queryString, User.class);
        q.setParameter("idUser", id);
        User result = null;
        try{
            result = q.getSingleResult();
        } catch(NoResultException ex){
            return null;
        } finally {
            em.close();
        }
        return result;
    }
    
    public static boolean emailExits(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
         String queryString = "select u from User u "
                          + "where u.email = :email ";
        TypedQuery<User> q = em.createQuery(queryString, User.class);
        q.setParameter("email", email);
        User result = null;
        try{
            result = q.getSingleResult();
        } catch(NoResultException ex){
            return false;
        } finally {
            em.close();
        }
        return result != null;
    }
    
    public static boolean userExits(String email, String pass){
        User user = selectUser(email,pass);
        return user != null;
    }
    
    public static String getUserName(String email, String pass){
        User user = selectUser(email,pass);
        return user.getFirstname();
    }
    
    public static int getMaxID(){
 
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "select max(u.idUser) from User u";
        TypedQuery<Integer> q =  em.createQuery(queryString,Integer.class);    
        int id = 0;
        try{
            id =  q.getSingleResult();
        } catch(NoResultException ex){
            return  id;
        } finally {
            em.close();
        }
        return id;
    }
    
}
  

