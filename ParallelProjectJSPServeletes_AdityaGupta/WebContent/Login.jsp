<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id!=null){
			response.sendRedirect("AfterLogin.jsp");
		}
	%>
	<form action ="LoginServelet" method="post">
		
		<input type="number" name="phoneNumber" id="phoneNumber" placeholder="Enter Your Mobile Number"><br>
		<input type="password" pattern="[0-9]*" name="pin" id="pin" placeholder="Enter Your Password"><br>
		<input type="submit" value="Login">
	</form>
	
	<form action ="index.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>