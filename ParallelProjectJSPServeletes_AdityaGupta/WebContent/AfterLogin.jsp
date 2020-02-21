<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DASHBOARD</title>
</head>
<body>
	<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<marquee> <h1>Welcome to your dashboard</h1></marquee>
	<form action="Payment.jsp" method="post">
	<input type="submit" value="Payment">
	</form><br>
	<form action="FundTransfer.jsp" method="post">
	<input type="submit" value="Fund Transfer">
	</form><br>
	<form action="Deposit.jsp" method="post">
	<input type="submit" value="Recharge My Wallet">
	</form><br>
	<form action="ViewTransactionsServelet" method="post">
	<input type="submit" value="View All My Transactions">
	</form><br>
	<form action="FetchServelet" method="post">
	<input type="submit" value="My Profile">
	</form><br>
	<form action="CheckBalanceServelet" method="post">
	<input type="submit" value="Check My Balance">
	</form><br>
	<form action="LogoutServelet" method="post">
	<input type="submit" value="Log Out">
	</form><br>
	<p> ${name}</p>
</body>
</html>