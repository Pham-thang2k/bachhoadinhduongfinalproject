/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.util;

import javax.servlet.http.Cookie;

/**
 *
 * @author danhl
 */
public class cookieUtil {
    public static String getCookieValue(Cookie[] cookies, String cookieName){
      
        String cookieValue = "";
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookieName.equals(cookie.getName())){
                    cookieValue = cookie.getValue();
                }
            }
        }        
        return cookieValue;
    };
}
