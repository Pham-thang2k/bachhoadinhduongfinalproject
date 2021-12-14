package com.finalproject.controller;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.finalproject.Database.invoiceDB;
import com.finalproject.Database.productDB;
import com.finalproject.business.Cart;
import com.finalproject.business.Product;
import com.finalproject.business.User;
import com.finalproject.business.lineItem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danhl
 */

public class cartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "/cart.jsp";
        
        // return cart
        if(null == action){
            url = "/cart.jsp";
        }
        else switch (action) {
            // remove product into cart
            case "remove":
                // get id product 
                String sIdProduct = request.getParameter("idProduct");
                int id = Integer.valueOf(sIdProduct);
                
                // remove product 
                removeProduct(request,response,id);
                break;
            // return home to contine shopping
            case "contineShopping":
                url = "/index.jsp";
                break;
            case "changeNum":
                // get id product 
                sIdProduct = request.getParameter("idProduct");
                id = Integer.valueOf(sIdProduct);
                
                url = updateNum(request,response,id);
                break;
            case "invoice":
                url = returnInvoice(request,response);
                break;
            default:
                break;
        }


        getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request,response);
    }

    private String removeProduct(HttpServletRequest request,HttpServletResponse response, int idProduct){
        Product p = new Product();
        p = productDB.selectProductFromId(idProduct);
        
        // add lineItem
        lineItem item = new lineItem();
        item.setProduct(p);
        
        // get session and remove Item into cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeItem(item);
        
        // set cart into session
        session.setAttribute("cart", cart);
        return "/cart.jsp";
    }
    
    private String updateNum(HttpServletRequest request,HttpServletResponse response,int idProduct){
        Product p = new Product();
        p = productDB.selectProductFromId(idProduct);
        
        // get sign
        String sign = request.getParameter("sign");
        String snumProduct = request.getParameter("numProduct");
        int numProduct = Integer.valueOf(snumProduct);
        
        // get Session 
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        
        // update number of product
        if(numProduct > 0){
            if(sign.equals("+")){
                for(lineItem i : cart.getItems()){
                    int id = i.getProduct().getId();
                    if(idProduct == id){
                        i.setQuantity(numProduct+1);
                    }
                }
            }else if(sign.equals("-")){
                for(lineItem i : cart.getItems()){
                    int id = i.getProduct().getId();
                    if(idProduct == id){
                        i.setQuantity(numProduct-1);
                    }
                }
            }
        }
        
        // set session
        session.setAttribute("cart", cart);
        return "/cart.jsp";
    }

    private String returnInvoice(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        //check user is not null
        if((user.getFirstname() != null) && (user.getLastname() != null) && (user.getEmail() != null ) && (user.getPhonenumber() != null) && (user.getAddress() != null)){
           int id =  invoiceDB.getMaxID();
           request.setAttribute("idInvoice", id);
            return "/invoice.jsp";
        }else{
            return "/updateUser.jsp";
        }
    }
    
}
