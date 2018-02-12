<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details here</title>
</head>
<body>
<%-- <table style="width: 100%">
		<caption>Books Details</caption> --%>
		
		<div class="container field">
		
  <h2>Customer Details</h2>
<table class="table table-bordered table-hover">
 
		<tr class="active">
			<th>id</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>address</th>
			<th>number</th>
		</tr>
		<c:forEach var="list" items="${List}">
			 <tr >
				<td>${list.id }</td>
				<td>${list.firstname }</td>
				<td>${list.lastname}</td>
				<td>${list.address}</td>
				<td>${list.mno}</td>
			</tr>
		</c:forEach>
		 </table>
</div>
	



</body>
</html>