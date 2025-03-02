<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<h1>Add a product</h1>
<form:form modelAttribute="product">
<table>
  <tr>
    <td>Product Description:</td>
    <td><form:input path="pDesc" ></form:input></td>
    <td><form:errors path="pDesc" ></form:errors></td>
  </tr>
  <tr>
    <td>Quantity in Stock:</td>
    <td><form:input path="qtyInStock" ></form:input></td>
    <td><form:errors path="qtyInStock" ></form:errors></td>
  <tr>
  	<td colspan="2">
  		<input type="submit" value="Add" />
  	</td>
  </tr>
</table>
</form:form>
<a href="index.html" >Home</a>
<a href="showOrders.html" >List Orders</a>
<a href="showCustomers.html" >List Customers</a>
</body>
</html>