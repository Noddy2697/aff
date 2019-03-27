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
  width: 33.33%;
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
			response.sendRedirect("loginAgain.jsp");
		}
	%>
	<div align="center"><b><h3>Welcome Admin</h3></b></div>
	<div width:100%> 
		<form class = "r" action = "Logout">
			<input type = "submit" value = "logout">
		</form>
	</div>
	<div class = "row">
		<div class="column" align="center"><br><br>
			<B>Hospital</B><br><br><br><br>
			<form action = "Login1">
				name : <br><input type="text" name = "n"> <br><br>
				Username : <br><input type="text" name = "u"> <br><br>
				Password : <br><input type="text" name = "p"> <br><br>
				<input type = "submit" value = "addhospital">
			</form><br><br>
			<form action = "ShowH">
				<input type = "submit" value = "Show HospitalsS">
			</form><br><br>
		</div>
		<div class="column" align="center">
			<B>Docter</B><br><br><br><br>
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
		<div class="column" align="center">
			<B>Pat</B><br><br><br><br>
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
		
</body>
</html>