<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1>List of Products</h1>
<table border="1" cellpadding="5">
  <tr>
   <th>Product ID</th>
   <th>Description</th>
   <th>Quantity in Stock</th>
  </tr>
  <tr>
    <c:forEach items="${products}" 
                 var="product">
      <tr> 
        <td>${product.pId}</td>
        <td>${product.pDesc}</td>
        <td>${product.qtyInStock}</td>
      </tr>
    </c:forEach>
  </tr>
</table>
<a href="index.html" >Home</a>
<a href="addProduct.html" >Add Product</a>
<a href="showCustomers.html" >List Customers</a>
<a href="showOrders.html" >List Orders</a>
</body>
</html>