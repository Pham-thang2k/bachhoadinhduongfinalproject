package com.finalproject.Database;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bhddweb.Database;

import com.finalproject.business.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author danhl
 */
public class typeDB {
	
    public static List<Type> selectType() {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            String qString = "select t from Type t";
            TypedQuery<Type> q = em.createQuery(qString,Type.class);
            List<Type> result = null;
            try{
                    result = q.getResultList();
                }catch(NoResultException ex){
                    return null;
                }finally{
                    em.close();
                }
           
        return result;
    }
    
    
}
