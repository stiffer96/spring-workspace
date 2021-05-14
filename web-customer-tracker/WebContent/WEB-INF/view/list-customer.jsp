 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Adding jstl core tags  -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
		
		<div id="container">
			
			<div id="content">
				
				<!--  adding html table here -->
				<table>
					<tr>
						<th> First Name </th>
						<th> Last Name </th>
						<th> Email </th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers }">
						<tr>
							<td> ${tempCustomer.firstName } </td>
							<td> ${tempCustomer.lastName } </td>
							<td> ${tempCustomer.email } </td>
						</tr>
					</c:forEach>
					
					
				</table>
			
			</div>
		
		
		</div>

	</div>
</body>
</html>