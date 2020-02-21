<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<form action="UpdateServelet" method="post">
		<input type="text" name="name" id="name" value='<%=request.getAttribute("name")%>' required><br>
		<input type="text" name="emailId" id="emailId" value='<%=request.getAttribute("emailId")%>' required><br>
		<input type="number" name="phoneNumber" id="phoneNumber" value='<%=request.getAttribute("phoneNumber")%>' required><br>
		<input type="password" pattern="[0-9]*" name="pin" id="pin" value='<%=request.getAttribute("pin")%>' required><br>
		<input type="submit" value="Update">
	</form>	
	<form action="AfterLogin.jsp">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>