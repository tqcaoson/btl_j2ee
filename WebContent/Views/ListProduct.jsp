<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Products Management</h1>
        <h3>
        	<a href="new-product">Add New Product</a>   	
        
        </h3>
</center>
<center>
<form action="find-product" method="post" >
	<label >Enter the name to search </label><input type="text" name="nameproduct" />
	<input type="submit" value="Find" />
</form>
</center>
<table border="1" cellpadding="10" align="center">
	<caption style="size = 40" > <h3>List Of Products</h3></caption>
	<tr> 
		<th> ID</th>
		<th> Product Name</th>
		<th> Code</th>
		<th> Number </th>
		<th> Price In </th>
		<th> Price Out </th>
		<th> Them, Xoa</th>
	</tr>
	<c:forEach var="product" items="${listProduct}" >
		<tr>
			<td>${product.id }" </td>
			<td><c:out value="${product.productName}"></c:out> </td>
			<td><c:out value="${product.code}"></c:out> </td>
			<td><c:out value="${product.number}"></c:out> </td>
			<td><c:out value="${product.priceInt}"></c:out> </td>
			<td><c:out value="${product.priceOut}"></c:out> </td>
			
			<td>
				<a href="edit-product?id=<c:out value="${product.id}"/>">Edit</a>
				<a href="delete-product?id=<c:out value="${product.id}"/>">Delete</a>
			</td>
			
		</tr>
	 </c:forEach>
</table>
</body>
</html>
