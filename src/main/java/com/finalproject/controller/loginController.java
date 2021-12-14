package com.finalproject.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.finalproject.Database.userDB;
import com.finalproject.business.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danhl
 */
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             String action = request.getParameter("action");
        String url = "/login.jsp";
        HttpSession session = request.getSession();
        
        if(action.equals("loginUser")){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(userDB.userExits(email, password)){
                User user = userDB.selectUser(email, password);
                session.setAttribute("user", user);
                url = "/index.jsp";
            }
            getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    }
}
