<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product By Name</title>
</head>
<body>

	<h2>Delete Product By Name</h2>
	<a href="/products">List Products</a>
	<form action="deleteProductByNameController" method="post">
		ProductName: <input type="text" name="productName" /><br> <br>
		<input type="submit" value="Submit" />
	</form>
	
	
</body>
</html>