<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mới</title>
</head>
<body>
	<center>
		<h1>Products Management</h1>
        <h2>
        	<a href="list">List Products</a>  	
        </h2>
	</center>
	<div align="center">
		<c:if test="${product != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${product == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${product != null}">
            			Edit Product
            		</c:if>
            		<c:if test="${product == null}">
            			New Product
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${product != null}">
        			<input type="hidden" name="id" value="<c:out value='${product.ID}' />" />
        		</c:if>            
            <tr>
                <th>Code: </th>
                <td>
                	<input type="text" name="code" size="45"
                			value="<c:out value='${product.code}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Code_product: </th>
                <td>
                	<input type="text" name="code_sp" size="45"
                			value="<c:out value='${product.code_sp}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                	<input type="text" name="price_in" size="5"
                			value="<c:out value='${product.price_in}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Date: </th>
                <td>
                	<input type="date" name="date_in" size="5"
                			value="<c:out value='${product.date_in}' />"
                	/>
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