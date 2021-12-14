<%-- 
    Document   : register
    Created on : Nov 9, 2021, 9:43:59 PM
    Author     : vumin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BachHoaDinhDuong</title>
    <link rel="stylesheet" href="css/register/register.css" type="text/css"/>
</head>
<body>
    <div class="content">            
        <h1>Sign Up</h1>
        <p id="p_size">Please fill out all the text boxes</p>
        <div id="input-form">
            <form action="register" method="POST" >
                <input type="hidden" name="action" value="registerUser" >                                
                <input type="email" name="email"  class="f_input" placeholder="Email"  required><br>
                <input type="text" name="firstName" class="f_input"  placeholder="FirstName"  required><br>
                <input type="text" name="lastName"  class="f_input" placeholder="LastName"  required><br>                
                <input type="password" name="password"  class="f_input1" placeholder="Password"  required><br>
                <input type="password" name="confirmpassword"  class="f_input2" placeholder="Confirm Password"  required oniput="check(this)">
                <br>                  
                <p>${noteRegister == null ? " ": "Email đã tồn tại" }</p>
                <label>&nbsp;</label>
                <input type="submit" class="button" value="Sign up" id="submit">
            </form>
        </div>            
    </div> 
</body>
</html>