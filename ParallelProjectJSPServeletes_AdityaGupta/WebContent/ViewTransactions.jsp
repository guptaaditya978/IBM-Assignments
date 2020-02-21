<%@ page import="java.util.ArrayList" %>
<%@ page import="com.parallel.test.bean.Transactions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<body>
<%Integer id = (Integer)session.getAttribute("id");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	<table>
		<tr>
			<th>Transaction Id</th>
			<th>Date</th>
			<th>Type</th>
			<th>Amount</th>
			<th>Balance</th>
		</tr>
		<% ArrayList<Transactions> a = (ArrayList)request.getAttribute("lists") ; 
			if(a==null || a.size()==0){
				request.setAttribute("name", "No Transactions Yet");
				request.getRequestDispatcher("AfterLogin.jsp").include(request, response);
			}
		for(int i = 0; i < a.size(); i++) { %>
            <tr>      
                <td><%= a.get(i).getTno()%></td>
                <td><%= a.get(i).getDot()%></td>
                <td><%= a.get(i).getType()%></td>
                <td><%= a.get(i).getAmount()%></td>
                <td><%= a.get(i).getBalance()%></td>  
            </tr>
        <% } %>
	</table>
	<form action="AfterLogin.jsp">
	<% request.setAttribute("name","name") ; %>
		<input type="submit" value="Go Back">
	</form>
</body>
</html>