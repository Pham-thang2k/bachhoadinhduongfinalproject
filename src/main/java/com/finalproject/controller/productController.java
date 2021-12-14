/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.controller;

import com.finalproject.Database.productDB;
import com.finalproject.business.Product;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.finalproject.business.lineItem;
import com.finalproject.business.Cart;


/**
 *
 * @author danhl
 */
public class productController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set up and get Parameter i
        String action = request.getParameter("idProduct");
        ServletContext sc = getServletContext();
        String url = "/index.jsp";
        int id = Integer.parseInt(action);
        int saleOff = 20;

        if(id > 0){
            // get parameter numstar and numreview
            String snumStar = request.getParameter("numStar");
            String snumProduct = request.getParameter("numProduct");
            // convert int
            int numStar = (int)((snumStar == null)? 0 : Integer.valueOf(snumStar));
            int numProduct = (int) ((snumProduct == null)? 0:Integer.valueOf(snumProduct) );
            
            if(numStar > 0){
                String snumReview = request.getParameter("numReview");
                int numReview = Integer.valueOf(snumReview);
                
                // update data
                updateStar(id,numStar,numReview);
            } if(numProduct > 0){
                HttpSession session = request.getSession();
                
                // add into lineItem
                lineItem item = new lineItem();
                Product p = new Product();
                p = productDB.selectProductFromId(id);
                if(p != null){
                    item.setProduct(p);
                    item.setQuantity(numProduct);
                
                // add Cart into session 
                Cart cart = null;
                Object c = session.getAttribute("cart");
                if(c == null){
                    cart = new Cart();
                }else{
                    cart = (Cart) c;
                }               
                    cart.addItem(item);
                    session.setAttribute("cart", cart);
                }
                
            }
            // return product page
            url = returnProduct(request,response,id,saleOff);        
            
        }
        
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    
    private String returnProduct(HttpServletRequest request, HttpServletResponse response,int id,int saleOff){
            Product p = new Product();
            p = productDB.selectProductFromId(id);
            int numStar;
            if(p.getNumreview()== 0){
                numStar = 0;
            }else{
                numStar = (int)((p.getNumstar())/(p.getNumreview()));
            }
                String[] star = {"","","","",""};
            
            // set start 
            for(int i = 1; i <= 5; i++){
                if(i <= numStar){
                    star[i-1] = "checked";
                    request.setAttribute("star" + String.valueOf(i), star[i-1]);
                }
            }
            // set Atritube product
            request.setAttribute("product", p);
            // set saleoff
            request.setAttribute("salePrice",(p.getPrice()*(100-saleOff)/100));
            return "/product.jsp";
    }

    private void updateStar(int id, int numStar, int numReview) {
        Product p = new Product();
        p = productDB.selectProductFromId(id);
        p.setNumstar(numStar);
        p.setNumreview(numReview);
        productDB.update(p);
    }
    

}


