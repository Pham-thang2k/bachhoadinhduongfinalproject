<%-- 
    Document   : login
    Created on : Nov 10, 2021, 10:01:28 AM
    Author     : vumin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/login/login.css" type="text/css">
</head>
<body>
    <div class="content">            
        <h1>Sign Up</h1>
        <p id="p_size">Please fill out all the text boxes</p>
        <div id="input-form">
            <form action="login" method="POST" >
                <input type="hidden" name="action" value="loginUser" >                                
                <input type="email" name="email"  class="f_input" placeholder="Email"  required><br>                
                <input type="password" name="password"  class="f_input" placeholder="Password"  required><br>                  
                <label>&nbsp;</label>
                <input type="submit" class="button" value="Login" id="submit">
                <a type="submit" href="register.jsp" class="button1" id="submit1">Sign Up</a>
            </form>
        </div>            
    </div> 
</body>
</html>
