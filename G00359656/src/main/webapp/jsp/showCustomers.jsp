<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<h1>List of Customers</h1>
<table>
  <tr>
    <c:forEach items="${customers}" 
                 var="customer">
                 
      <h3>${customer.cId} ${customer.cName}</h3>
      <h3>${customer.cName}'s Orders</h3>

      <table border="1" cellpadding="5">
        <tr>
          <th>Order ID</th>
   		  <th>Quantity</th>
   		  <th>Product ID</th>
   		  <th>Description</th> 
   	    </tr>
   	    <tr>
        	
       	  <c:forEach items="${customer.orders}" var="o">
       		  <tr>
       			  <td>${o.oId}</td>
       			  <td>${o.qty}</td>
       			  <td>${o.prod.pId}</td>
       			  <td>${o.prod.pDesc}</td>
       		  </tr>
       	  </c:forEach>
        </tr>
      </table>
    </c:forEach>
  </tr>
</table>
<a href="index.html" >Home</a>
<a href="addCustomer.html" >Add Customer</a>
<a href="showProducts.html" >List Products</a>
<a href="showOrders.html" >List Orders</a>
<form action="/logout" method=post>
 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout" />
</form>

</body>
</html>