/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.controller;

import com.finalproject.Database.userDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.finalproject.business.User;
/**
 *
 * @author danhl
 */
public class registerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String action = request.getParameter("action");
            String url = "/register.jsp";
            
            if(action.equals("registerUser")){
                String email = request.getParameter("email");
                String fName = request.getParameter("firstName");
                String lName = request.getParameter("lastName");
                String pass = request.getParameter("password");
                int idMax = userDB.getMaxID();
                // declare User 
                User user = new User();                
                
                // check email of User
                if(!userDB.emailExits(email)){
                    user.setEmail(email);
                    user.setPassword(pass);
                    user.setFirstname(fName);
                    user.setLastname(lName);
                    user.setId(idMax+1);
                    
                    // insert user database
                    userDB.insert(user);
                    // response page
                    url = "/login.jsp";
                }
                else{
                    request.setAttribute("noteRegister", true);
                }
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            
        
    }

}
