<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="testForm" class = "form-horizontal" action="test"  method="POST">
   
   <div class = "form-group">
      <label for = "firstname" class = "col-sm-2 control-label">First Name :</label>
		
      
         <form:input path="ftname" type = "text" class = "form-control" id = "firstname" placeholder = "Enter First Name"/>
      </div>
  
   
   <div class = "form-group">
      <label for = "lastname" class = "col-sm-2 control-label">Last Name :</label>
		
      
         <form:input path="lname" type = "text" class = "form-control" id = "lastname" placeholder = "Enter Last Name"/>
      </div>
   
   <div class = "form-group">
      <label for = "Address" class = "col-sm-2 control-label">Address :</label>
		
 
         <form:input path="address" type = "text" class = "form-control" id = "lastname" placeholder = "Enter Address"/>
      </div>
   
   <div class = "form-group">
      <label for = "radioButton" class = "radiobutton">gender :</label>
 
        <form:radiobutton path="sex" value="M" checked="checked"/> M
		<form:radiobutton path="sex" value="F" /> F
      </div>
      
   
   
   <div class = "form-group">
      <div class = "col-sm-offset-2 col-sm-10">
         <div class = "checkbox">
            <label><input type = "checkbox"> Remember me</label>
         </div>
      </div>
   </div>
   <div class="col-md-offset-3 col-md-6">
										<input type="submit"  id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
   
   
	
</form:form>




</body>
</html>