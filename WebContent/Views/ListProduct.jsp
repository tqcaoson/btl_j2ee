<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách</title>
</head>
<body>
	<center>
		<h1>Products Management</h1>
		<h2><a href="new">New Product</a></h2>
	<table border="1" cellpadding="6">
		<tr> 
			<th> ID</th>
			<th> Code</th>
			<th> Code_product</th>
			<th> Price</th>
			<th> Date</th>
			<th> Update</th>
		</tr>
		<c:forEach var="product" items="${listProduct}" >
			<tr>
			<th><c:out value="${product.ID}"></c:out> </th>
			<th><c:out value="${product.code}"></c:out> </th>
			<th><c:out value="${product.code_sp}"></c:out> </th>
			<th><c:out value="${product.price_in}"></c:out> </th>
			<th><c:out value="${product.date_in}"></c:out> </th>
			<th>
				<a href="edit?ID=<c:out value="${product.ID}"/>">Edit</a>
				<a href="delete?ID=<c:out value="${product.ID}"/>">Delete</a>
			</th>
			</tr>
	 	</c:forEach>
	</table>
</center>
</body>
</html>