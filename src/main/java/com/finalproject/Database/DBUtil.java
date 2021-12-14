/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.Database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danhl
 */
class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bachhoadinhduongwebPU");
    
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
}
