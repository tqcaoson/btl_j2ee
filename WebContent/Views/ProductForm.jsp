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
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-product">List All Products</a>
        	
        </h3>
	</center>
	<div align="center">
		<c:if test="${product != null}">
			<form action="update-product" method="post">
        </c:if>
        <c:if test="${product == null}">
			<form action="insert-product" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${product != null}">
            			Edit Product
            		</c:if>
            		<c:if test="${product == null}">
            			Add New Product
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${product != null}">
        			<input type="hidden" name="id" value="<c:out value='${product.id}' />" />
        		</c:if>            
            <tr>
                <th>Product Name: </th>
                <td>
                	<input type="text" name="product_name" size="45"
                			value="<c:out value='${product.productName}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Code Product: </th>
                <td>
                	<input type="text" name="code" size="45"
                			value="<c:out value='${product.code}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Number: </th>
                <td>
                	<input type="text" name="number" size="5"
                			value="<c:out value='${product.number}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price In: </th>
                <td>
                	<input type="text" name="price_int" size="5"
                			value="<c:out value='${product.priceInt}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price Out: </th>
                <td>
                	<input type="text" name="price_out" size="5"
                			value="<c:out value='${product.priceOut}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>

        </form>
    </div>
</body>
</html>
