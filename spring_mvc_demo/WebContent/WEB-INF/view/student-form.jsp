<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Below directive is for adding form tags to use in jsp -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student" >
		
		First Name : <form:input path="firstName" />
		
		<br> <br>
		
		Last Name : First Name : <form:input path="lastName" />
		
		<br><br>
		
		Country :
		
			<form:select path="country">
				
				<form:options items="${student.countryOptions }" />
				
			</form:select>
		
		<br><br>
			
		Favourite programming Language :
		<br>
		
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		Perl <form:radiobutton path="favouriteLanguage" value="Perl"/>
		PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
		GoLang <form:radiobutton path="favouriteLanguage" value="GoLang"/>
		
		
		<br><br>
		
		Operating System Used :
		
		Linux <form:checkbox path="operatingSystems"  value="Linux" />
		Windows <form:checkbox path="operatingSystems"  value="Windows" />
		MacOs <form:checkbox path="operatingSystems"  value="MacOS" />			
		
		<br><br>
				
		<input type="submit"  value ="Submit" />
	
	</form:form>

</body>
</html>








