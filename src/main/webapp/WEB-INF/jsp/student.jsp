<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<script type="text/javascript">
window.setTimeout(function() {
    $(".msgcss").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 5000);
</script>
<body>
<div class="container">
<div>
       <c:if test ="${not empty msg}"> 
				<div class="col-sm-12" style="margin-bottom: -1.3em;">
					<div class="form-group">
						<div class="msgcss fadeIn animated alert alert-danger" style="text-align: center;">${msg}</div>
					</div>
				</div>
			</c:if>
</div>
<form:form modelAttribute="testStudent" class = "form-horizontal" action="student" enctype="multipart/form-data" method="POST">
									<form:hidden path="id"/>
									<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">FirstName:</label>
										<form:input path="firstname" class="col-md-3"  placeholder="Enter firstname"/>
									</div>
									<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">LastName:</label>
										<form:input path="lastname" class="col-md-3"  placeholder="Enter lastname"/>
									</div>
									<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Branch:</label>
										<form:input path="branch" class="col-md-3"  placeholder="Enter quantity"/>
										</div>
										<div class="form-group">
										<label class="col-md-3 control-label no-padding-right">Address:</label>
										<form:input path="address" class="col-md-3"  placeholder="Enter address"/>
										</div>
										<div class="form-group">
										<label class="col-md-3 control-label no-padding-right">Joindate:</label>
										<form:input type="datetime-local" path="jdate" />
										</div>
										<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">mobileno:</label>
										<form:input path="mno" class="col-md-3"  placeholder="Enter mobileno"/>
									</div>
										<div class="form-group">
										<label class="col-md-3 control-label no-padding-right">Select file:</label>
										  <input type="file" name="file" id="file" multiple>
										 </div>
											<div class="form-group">
										<input type="submit"  id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
										</div>
									
</form:form>
<br>
<div class="table-responsive"> 
	<table class="table table-bordered table-hover">
		<tr class="warning">
			<th>id</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>branch</th>
			<th>address</th>
			<th>joindate</th>
			<th>mobileno</th>
			<th>fileupload</th>
			<th>filedownload</th>
			<th>options</th>
		</tr>	
<c:forEach var="list" items="${studentList}">
			 <tr class="active">
				<td>${list.id }</td>
				<td>${list.firstname }</td>
				<td>${list.lastname}</td>
				<td>${list.branch}</td>
				<td>${list.address}</td>
				<td>${list.jdate}</td>
				<td>${list.mno}</td>
				<td>${list.files}</td>
				<!--for download option  -->
				<td><c:if test="${not empty list.files}">
			    <c:forTokens items="${list.files}" delims="*" var="mySplit">
			<a class="attachments" target="_blank" href="reportDocuments/${mySplit}"><i class="fa fa-paperclip fa-lg grey" title="${mySplit}"></i></a>
		    </c:forTokens>
		   </c:if> </td>
				<td> <a href="studentdelete?id=${list.id}"> <i class="fa fa-trash"></i> </a>
				<a href="studentedit?id=${list.id}"> <i class="fa fa-edit"></i></a></td>
			</tr>
		</c:forEach>
		 </table>							
</div>
</div>


</body>
</html>