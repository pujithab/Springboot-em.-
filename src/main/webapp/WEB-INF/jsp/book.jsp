<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book jsp</title>
</head>
<script type="text/javascript">
window.setTimeout(function() {
    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 5000);
</script>
<body>
<div>


       <c:if test ="${not empty msg}"> 
				<div class="col-sm-12" style="margin-bottom: -1.3em;">
					<div class="form-group">
						<div class="msgcss fadeIn animated alert alert-danger" style="text-align: center;">${msg}</div>
					</div>
				</div>
			</c:if>
<h3>insert Details</h3>
</div>
<form:form modelAttribute="testBook" class = "form-horizontal" action="booktest"  method="POST">
<div class="form-group">
                                  <form:hidden path="id"/>
									<label class="col-md-3 control-label no-padding-right">BookName</label>
									<div class="col-md-6">
										<form:input path="name" class="form-control"  placeholder="Enter Bookname"/>
									</div>
									</div>
									<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Author</label>
									<div class="col-md-6">
										<form:input path="author" class="form-control"  placeholder="Enter author"/>
									</div>
									</div>
									<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Quantity</label>
									<div class="col-md-6">
										<form:input path="quantity" class="form-control"  placeholder="Enter quantity"/>
										</div>
										</div>
											<div class="col-md-offset-3 col-md-6">
										<input type="submit"  id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
									</div>
									
									
									
									
</form:form>

 <h3>Books Details</h3>
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
				<td><a href="delete?id=${list.id}"> Delete</a>
				<a href="edit?id=${list.id}"> Edit</a></td>
			</tr>
		</c:forEach>
		 </table>
</body>
</html>