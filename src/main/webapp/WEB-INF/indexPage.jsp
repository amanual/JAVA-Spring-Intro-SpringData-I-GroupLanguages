<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "css/style.css">
<title>Main page</title>
</head>
<body>
	<div>
		<table class = "table">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<c:forEach items = "${ langDisplay }" var = "langs" varStatus = "loop">
				<tr>
					<td><a href = "/language/${ langs.id }"><c:out value="${ langs.name }" /></a> </td>
					<td><c:out value="${ langs.creator }" /> </td>
					<td><c:out value="${ langs.version }" /> </td>
					<td><a href = "/language/delete/${ langs.id}">delete</a> &nbsp; <a href = "/language/edit/${ langs.id }">edit</a></td>
				</tr>
				
			</c:forEach>
		</table>
	</div>
	<div>
		<form:form method = "POST" action = "/language" modelAttribute = "languages">
				<form:hidden path="id"/>
			<p><form:label path = "name"> Name: <form:input path= "name" /> &nbsp; <form:errors path = "name" /> &nbsp; <label class = "errors"><c:out value="${ nameError }" /></label></form:label></p>
			<p><form:label path = "creator"> Creator: <form:input path = "creator" /> &nbsp; <form:errors path = "creator" /> &nbsp; <label class = "errors"><c:out value="${ creatorError }" /></label></form:label></p>
			<p><form:label path = "version"> Version: <form:input type = "number" path= "version" /> &nbsp; <form:errors path = "version" /> &nbsp; <label class = "errors"><c:out value="${ versionError }" /></label></form:label></p>
			<input type = "submit" value = "Submit">
		
		</form:form>
	</div>
</body>
</html>