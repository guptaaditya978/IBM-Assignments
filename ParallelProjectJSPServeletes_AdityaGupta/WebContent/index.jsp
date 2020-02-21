<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id!=null){
			response.sendRedirect("AfterLogin.jsp");
		}
	%>
	<marquee><h1>WELCOME TO BATWA PAYMENT PORTAL</h1></marquee>
	<form action ="Signup.jsp">
		<input type="submit" value="Create My Account">
	</form> &nbsp;
	<form action ="Login.jsp">
		<input type="submit" value="Log In">
	</form>
</body>
</html>