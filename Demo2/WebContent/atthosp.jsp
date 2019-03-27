<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
  box-sizing: border-box;
}
.r {
  float: right;
}

.l {
  float: left;
}

.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 300px; 
}

.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
</head>
<body>
	<%
		if(session.getAttribute("username") == null)  {
			response.sendRedirect("loginAgain1.jsp");
		}
	%>
	<div align="center">
	<B>Welcome hospital</B>
	<div width:100%> 
		<form class = "r" action = "Logout">
			<input type = "submit" value = "logout">
		</form>
	</div>
	<div class = "row">
		<div class="column">
			<B>Docter</B>
			<form action = "Login2"><br><br>
				name : <br><input type="text" name = "n"> <br><br>
				Username : <br><input type="text" name = "u"> <br><br>
				Password : <br><input type="text" name = "p"> <br><br>
				<input type = "submit" value = "adddoc">
			</form><br><br>
			<form action = "ShowD">
				<input type = "submit" value = "Show Docters">
			</form><br><br>
		</div>
		<div class="column">
			<B>Pat</B>
			<form action = "Login3">
				name : <br><input type="text" name = "n"> <br><br>
				Username : <br><input type="text" name = "u"> <br><br>
				Password : <br><input type="text" name = "p"> <br><br>
				<input type = "submit" value = "addpat">
			</form><br><br>
			<form action = "ShowP">
				<input type = "submit" value = "Show Pat">
			</form><br><br>
		</div class="column">
			
	</div>
	</div>