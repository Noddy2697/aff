<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("username") == null)  {
			response.sendRedirect("login.jsp");
		}
	%>
	
	<form action = "Addhos">
		Hospital name : <input type="text" name = "u"> <br>
		Location : <input type="password" name = "p"> <br>
		<input type = "submit" value = "Add">
	</form>
	<br><br><br>
	<form action = "Adddoc">
		Docter's name : <input type="text" name = "u"> <br>
		Address : <input type="password" name = "p"> <br>
		<input type = "submit" value = "Add">
	</form>
	<br><br><br>
	<form action = "Addpat">
		Patient's name : <input type="text" name = "u"> <br>
		Address : <input type="password" name = "p"> <br>
		<input type = "submit" value = "Add">
	</form>
	
</body>
</html>