<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- adding jstl tags to use iteration for getting operating systems whicha are in array -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Spring Form tags and Data Binding</h2>
<hr>

The Student is confirmed : ${student.firstName} ${student.lastName}

<br><br>

Country : ${student.country}

<br><br>

Favourite Programming Language : ${student.favouriteLanguage }

<br><br>

Operating System User : 

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li> ${temp } </li>
	</c:forEach>
	
</ul>

</body>
</html>