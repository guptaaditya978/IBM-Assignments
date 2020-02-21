<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge Your Wallet</title>
</head>
<body>

<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<form action ="DepositServelet" method="post">
		
		<input type="number" name="amount" id="amount" placeholder="Enter The Amount you want to add to your wallet"><br>
		<input type="submit" value="ADD">
	</form>
	<form action="AfterLogin.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>