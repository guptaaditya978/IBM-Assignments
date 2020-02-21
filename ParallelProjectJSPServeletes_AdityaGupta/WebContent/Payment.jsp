<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payments</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<form action ="Payment" method="post">
		
		<input type="number" name="amount" id="amount" placeholder="Enter The Amount you want to pay"><br>
		<input type="submit" value="PAY">
	</form>
	<form action="AfterLogin.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>