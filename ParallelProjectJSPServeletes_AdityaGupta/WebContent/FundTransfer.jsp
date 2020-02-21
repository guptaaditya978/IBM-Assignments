<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<form action ="FundTransferServelet" method="post">
		
		<input type="number" name="phoneNumber2" id="phoneNumber2" placeholder="Enter The Mobile Number you want to send money"><br>
		<input type="number" name="amount" id="amount" placeholder="Enter The Amount you want to send"><br>
		<input type="submit" value="Send">
	</form>
	<form action="AfterLogin.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>