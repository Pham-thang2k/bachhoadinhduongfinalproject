<%-- 
    Document   : invoice
    Created on : Nov 22, 2021, 5:07:30 PM
    Author     : danhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <title>invoice</title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/invoice/invoice.css" type="text/css"/>    
        <jsp:include page="/includes/header.jsp" />     
    </head>
    <body>     
    <h10>YOUR INVOICE</h10><br> 
<table>
  <tr>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
  </tr>


<c:forEach var="item" items="${cart.getItems()}">
  <tr>
      <td>
          <b>${item.getProduct().getName()}</b>
      </td>
    <td><img src="images/${item.getProduct().getIdtype()}/${item.getProduct().getId()}/1.jpg" class="img" alt=""width="50" height="50"></td>
    <td>
        <b>${item.getQuantity()}</b>
    </td>
    <td>${item.getProduct().getPrice()} VND</td>   
    <td>${item.getTotal()} VND </td>   
    <td>
     
    </td>
  </tr>
</c:forEach>
</table><br>

<div class="in4">
    <div class="form-change name">
        <label for="fname" class="label">First Name: </label> 
        <input type="text" id="fname"  value="${user.getFirstname()}" class="form-control info" readonly/>
    </div>
    <div class="form-change name lname">
        <label for="lname" class="label">Last name: </label>
        <input type="text" id="lname"  value="${user.getLastname()}" class="form-control info" readonly/>
    </div><br><br><br><br>
    <div class="form-change email_phone">
        <label for="email" class="label" >Email: </label>
        <input type="text" id="email"  value="${user.getEmail()}" class="form-control info" readonly/>
    </div>
    <div class="form-change email_phone phone">
        <label for="phone" class="label"> Number phone :</label>
        <input type="text" id="phone"  value="${user.getPhonenumber()}" class="form-control info" readonly/>
    </div><br><br><br><br>
    <div class="form-change address_cre">
        <label for="address" class="label">Address: </label>
        <input type="text" id="address"  value="${user.getAddress()}" class="form-control info" readonly/>
    </div>
    <div class="form-change address_cre cretype">
        <label for="cretype" class="label">Credit Card Type :</label>
        <input type="text" id="cretype"  value="${user.getCreditcardType()}" class="form-control info" readonly/>
    </div><br><br><br><br>
    <div class="form- cre">
        <label for="crenum"  class="label">Credit Card Number: </label>
        <input type="text" id="crenum"  value="${user.getCreditcardNumber()}" class="form-control info" readonly/>
    </div>
    <div class="form-change cre date">
        <label for="credate" class="label">Credit Card Exp Date: </label>
        <input type="text" id="credate"  value="${user.getCreditcardexprationdate()}" class="form-control info" readonly/>
    </div><br><br><br>
    
</div>
    <form action="invoice" method = "POST">
        <input type="hidden" name="idInvoice" value="${idInvoice+1}">
        <input type="hidden" name="action" value="bought">
        <input type="submit" value="Completed" class="com_btn">
    </form>      
    </body><br>
    <jsp:include page="/includes/footer.jsp" />
</html>
