<%-- 
    Document   : updateUser
    Created on : Nov 22, 2021, 8:26:22 PM
    Author     : danhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>      
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>    
<!--        <link rel="icon" href="images/icon.jpg" type="image/gif" />-->
        <link rel="stylesheet" href="css/update/update.css">
        <jsp:include page="/includes/header.jsp" /> 
    </head>
    <body class="update_body">
    <h10>Update user</h10><br><br>
     <form action="invoice" method="POST">            
         <div class="form">
         <input type="hidden" name="action" value="updateUser">
         <input type="hidden" name="idUser" value="${user.getId()}">
         <div class="form-change">
             <label class="label" for="fname">First Name :</label>
            <input type="text" name="firstName" id="fname" class="box" required=""  value="${user.getFirstname()}">
         </div><br><br>
         <div class="form-change">
            <label class="label" for="lname">Last Name :</label>
            <input type="text" name="lastName" id="lname" class="box" required=""  value="${user.getLastname()}">     
         </div><br><br>
         <div class="form-change">
            <label class="label" for="lname">Email :</label>
            <input type="email" name="email" id="email" class="box" required="" value="${user.getEmail()}">
         </div><br><br>
         <div class="form-change">
            <label class="label" for="phone">Number phone :</label>
            <input type="tel" name="numPhone" id="phone" class="box" required=""   value="${user.getPhonenumber()}">          
         </div><br><br>
         <div class="form-change">
            <label class="label" for="address">Address :</label>
            <input type="text" name="address" id="address" class="box" required="" value="${user.getAddress()}"> 
         </div><br><br>
         <div class="form-change">
            <label class="label" for="cretype">Creditcard Type :</label>
            <input type="text" name="creditcardType" id="cretype" class="box" value="${user.getCreditcardType()}" required="">
         </div><br><br>
         <div class="form-change">
            <label class="label" for="crenum">Creditcard Number :</label>
            <input type ="text" name="creditcardNumber" id="crenum" class="box" value="${user.getCreditcardNumber()}" required="">
         </div><br><br>
         <div class="form-change">
            <label class="label" for="credate">Creditcard Date :</label>
            <input type ="date" name="creditcardExpDate" id="credate" class="box" value="${user.getCreditcardexprationdate()}" required="">
         </div><br><br><br><br><br>
         <input type="submit" class="update_btn" value="Update user">
     </div>            
    </form>
    
    </body><br>
    <jsp:include page="/includes/footer.jsp" />
</html>
