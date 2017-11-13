<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" type = "text/css" href = "css/style.css">
<title>User info</title>
</head>
<body>
	<p> <a href = "/"> Dashboard</a></p>
	<div>
		<p> <c:out value = "${ language.name }" /> </p>
		<p> <c:out value = "${ language.creator }" /> </p>
		<p> <c:out value = "${ language.version }" /> </p>
		<p> <a href = "/language/delete/${id}"> delete </a> </p>
		<p> <a href = "/language/edit/${id}" > edit </a> </p>
		
	</div>
</body>
</html>