<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quantity too large</title>
</head>
<body>
<table>
	<tr>
		<c:forEach items="${products}" 
		                 var="product">
			<h1>Error Creating the Following Order</h1>
			<h2>Quantity too large: Product stock = ${product.qtyInStock }</h2>
			
		</c:forEach>
	</tr>
</table>
<a href="index.html" >Home</a>
<a href="newOrder.html" >Add Order</a>
<a href="showOrders.html" >List Orders</a>
</body>
</html>