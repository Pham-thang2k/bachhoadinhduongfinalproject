package com.finalproject.controller;

import com.finalproject.business.User;
import com.finalproject.util.cookieUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danhl
 */
public class userController extends HttpServlet {


     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String  action = request.getParameter("action");
        String url = "/index.jsp";
        
        switch(action){
            case "checkUser":
              url =  checkUser(request,response);
        }
        
    
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    private String checkUser(HttpServletRequest request, HttpServletResponse response){
        String url;
        HttpSession session = request.getSession();
        
        // get the User Object 
        User user = (User) session.getAttribute("user");
        
        // if User object doesnt exist, check email cookie
            Cookie[] cookies = request.getCookies();
            String emailAddress = cookieUtil.getCookieValue(cookies, "emailCookie");
        
            // if cookie doesn't exist, go to Resgistration page
            if(emailAddress == null || emailAddress.equals("")){
                url = "/login.jsp";
            }
            else{
                if(user == null){
                    session.setAttribute("userName", "Đăng Nhập");
                }
                else{
                    session.setAttribute("userName", user.getFirstname());
                }
                url = "/index.jsp";
            }
            
            return url;
    }
   
}
