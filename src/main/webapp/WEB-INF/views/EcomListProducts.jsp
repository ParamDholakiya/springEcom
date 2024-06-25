<%@page import="com.bean.EProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>List Products</h2>

    <%
    List<EProductBean> products = (List<EProductBean>)request.getAttribute("products");
    %>
	
	<a href="/newproduct">New Product</a>
	<a href="deleteProductByName">Delete By name</a>
    <table border="1">
        <tr>
            <th>ProductId</th>
            <th>ProductName</th>
            <th>Actions</th>
        </tr>
        <%
        for (EProductBean p : products) {
            out.print("<tr>");
            out.print("<td>" + p.getProductId() + "</td><td>" + p.getProductName() + "</td>");
            out.print("<td><a href='deleteProduct?productId=" + p.getProductId() + "'>Delete</a></td>");
            out.print("</tr>");
        }
        %>
    </table>
</body>
</html>