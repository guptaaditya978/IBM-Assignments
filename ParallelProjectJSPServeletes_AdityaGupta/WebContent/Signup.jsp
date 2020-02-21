<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN UP</title>
</head>
<body>
	<form action ="SignupServelet" method="post">
		
		<input type="text" name="name" id="name" placeholder="Enter Your Name" required><br>
		<input type="text" name="emailId" id="emailId" placeholder="Enter Your Email-Id" required><br>
		<input type="number" name="phoneNumber" id="phoneNumber" placeholder="Enter Your Mobile Number" required><br>
		<input type="password" pattern="[0-9]*" name="pin" id="pin" placeholder="Enter Your Password" required><br>
		<input type="submit" value="Submit">
	</form>
	<p>${name}</p>
	<form action ="index.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>