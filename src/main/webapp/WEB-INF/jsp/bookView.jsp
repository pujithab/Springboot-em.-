<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Books</title>

<!-- <style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style> -->
</head>
<body>

	<%-- <table style="width: 100%">
		<caption>Books Details</caption> --%>
		
		<div class="container field">
		
  <h2>Books Details</h2>
<table class="table table-bordered table-hover">
 
		<tr class="warning">
			<th>id</th>
			<th>name</th>
			<th>author</th>
			<th>quantity</th>
			<th>options</th>
		</tr>
		<c:forEach var="list" items="${booksList}">
			 <tr class="active">
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>${list.author}</td>
				<td>${list.quantity}</td>
				<td><a href="<c:url value='/Delete/${list.id}' />" >Delete</a></td>
				
			</tr>
		</c:forEach>
		 </table>
</div>
	





</body>
</html>