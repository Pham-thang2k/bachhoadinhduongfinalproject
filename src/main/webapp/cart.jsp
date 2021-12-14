<%-- 
    Document   : Cart.jsp
    Created on : Nov 19, 2021, 8:26:12 AM
    Author     : danhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <title>Cart</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/cart/cart.css" type="text/css"/>    
<head>   
    <jsp:include page="/includes/header.jsp" />
</head>
<body>

<!--<h1>Your cart</h1>-->
<h10>Your Cart</h10>
<table>
  <tr>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
  </tr>


<c:forEach var="item" items="${cart.getItems()}">
  <tr>
      <td><b>${item.getProduct().getName()}</b></td>
    <td><img src="images/${item.getProduct().getIdtype()}/${item.getProduct().getId()}/1.jpg" class="img" alt=""width="50" height="50"></td>
    <td>
        <div class="buttons_added">
            <form action="" method = "POST">
                <input type="hidden" name="action" value="changeNum">
                <input type="hidden" name="idProduct" value="${item.getProduct().getId()}">
                <input type="submit" name="sign" value="+" class="quan">
                <input name="numProduct" type="text" value="${item.getQuantity()}" class="quantity">
                <input type="submit" name="sign" value="-" class="quan">
            </form>
        </div>
    </td>
    <td>${item.getProduct().getPrice()} VND</td>   
    <td>${item.getTotal()} VND </td>   
    <td>
      <form action="" method="POST">
        <input type="hidden" name="action" value="remove">
        <input type="hidden" name="idProduct" value="${item.getProduct().getId()}">
        <input type="submit" value="remove" class="button">
      </form>
    </td>
  </tr>
</c:forEach>
</table>

<form action="" method="POST">
  <input type="hidden" name="action" value="invoice">
  <input type="submit" class="invoice_btn" value="Invoice">
</form>

<form action="" method="POST" class="foot">
  <input type="hidden" name="action" value="contineShopping">
  <input type="submit" class="con_btn" value="contine shopping">
</form>
</body>
<footer>
    <jsp:include page="/includes/footer.jsp" />
</footer>
</html>
