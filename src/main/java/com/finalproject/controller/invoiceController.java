/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.controller;


import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.finalproject.Database.invoiceDB;
import com.finalproject.Database.userDB;
import com.finalproject.business.Cart;
import com.finalproject.business.User;

/**
 *
 * @author danhl
 */
public class invoiceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = null;
        HttpSession session = request.getSession();
        
        if(action == null){
            url = "/cart.jsp";
        }else switch(action){
            case "updateUser":
                String idUser = request.getParameter("idUser");
                int id = Integer.valueOf(idUser);
                User user =  userDB.selectUserFromId(id);

                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String numPhone = request.getParameter("numPhone");
                String Address = request.getParameter("address");
                String creditcardType = request.getParameter("creditcardType");
                String creditcardNumber = request.getParameter("creditcardNumber");
                String creditcardExpDate = request.getParameter("creditcardExpDate");

                
                // set user 
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmail(email);
                user.setAddress(Address);
                user.setPhonenumber(numPhone);
                user.setCreditcardType(creditcardType);
                user.setCreditcardNumber(creditcardNumber);
                user.setCreditcardexprationdate(Date.valueOf(creditcardExpDate));
                userDB.update(user);
                session.setAttribute("user", user); 
                request.setAttribute("idInvoice", invoiceDB.getMaxID());
                url = "/invoice.jsp";
            break;
            case "bought":
                User u = (User) session.getAttribute("user");
                Cart c = (Cart) session.getAttribute("cart");
                int idInvoice;
                idInvoice = Integer.valueOf(request.getParameter("idInvoice"));
                invoiceDB.insertFull(c,u.getId(),idInvoice);
                url = "/index.jsp";
            break;
            default:
            break;
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = null;
        HttpSession session = request.getSession();
        
        if(action == null){
            url = "/cart.jsp";
        }else switch(action){
            case "updateUser":
                String idUser = request.getParameter("idUser");
                int id = Integer.valueOf(idUser);
                User user =  userDB.selectUserFromId(id);

                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String numPhone = request.getParameter("numPhone");
                String Address = request.getParameter("address");
                String creditcardType = request.getParameter("creditcardType");
                String creditcardNumber = request.getParameter("creditcardNumber");
                String creditcardExpDate = request.getParameter("creditcardExpDate");

                
                // set user 
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmail(email);
                user.setAddress(Address);
                user.setPhonenumber(numPhone);
                user.setCreditcardType(creditcardType);
                user.setCreditcardNumber(creditcardNumber);
                user.setCreditcardexprationdate(Date.valueOf(creditcardExpDate));
                userDB.update(user);
                session.setAttribute("user", user); 
                request.setAttribute("idInvoice", invoiceDB.getMaxID());
                url = "/invoice.jsp";
            break;
            case "bought":
                User u = (User) session.getAttribute("user");
                Cart c = (Cart) session.getAttribute("cart");
                int idInvoice;
                idInvoice = Integer.valueOf(request.getParameter("idInvoice"));
                invoiceDB.insertFull(c,u.getId(),idInvoice);
                url = "/index.jsp";
            break;
            default:
            break;
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
