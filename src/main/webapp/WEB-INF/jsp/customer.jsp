<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers Details</title>
</head>
<body>
<form:form modelAttribute="customertest" class = "form-horizontal" action="customertest"  method="POST">
<div class="form-group">
<label class="col-md-3 control-label no-padding-right">FirstName</label>
<div class="col-md-6">
<form:input path="firstname" class="form-control"  placeholder="Enter firstname"/>
</div>
</div>

<div class="form-group">
<label class="col-md-3 control-label no-padding-right">LastName</label>
<div class="col-md-6">
<form:input path="lastname" class="form-control"  placeholder="Enter lastname"/>
</div>
</div>

<div class="form-group">
<label class="col-md-3 control-label no-padding-right">Address</label>
<div class="col-md-6">
<form:textarea path="address" class="form-control"  placeholder="Enter address"/>
</div>
</div>

<div class="form-group">
<label class="col-md-3 control-label no-padding-right">Mobileno</label>
<div class="col-md-6">
<form:input path="mno" class="form-control"  placeholder="Enter mobileno"/>
</div>
</div>

<div class="form-group">
<div class="col-md-offset-3 col-md-6">
<input type="submit"  id="submit1"  class="btn btn-success" value="Create"/>
<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
</div>
</div>


</form:form>

</body>
</html>