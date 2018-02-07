<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>



<form:form modelAttribute="userForm" action="emp" class="form-horizontal" method="POST" >
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Username</label>
									<div class="col-md-6">
										<form:input path="name" class="form-control"  placeholder="Enter Username"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label no-padding-right">Father name</label>
									<div class="col-md-6">
										<form:input path="fname" class="form-control"  placeholder="Enter Username"/>
									</div>
								</div>
									
                    		<div class="col-md-offset-3 col-md-6">
										<input type="submit"  id="submit1"  class="btn btn-success" value="Create"/>
										<input class="btn-danger btn cancel"  type="reset"  value="Reset" />
									</div>
                    		
								</form:form>
</body>

<script type="text/javascript">

/* function leela()
{

	alert("hi");
var fd = new FormData();

fd.append("fileToUpload[]", document.getElementById('file').files[0]);

$.ajax({
    type: 'POST',
    url: 'atest',
    cache: false,
    contentType: false,
    processData: false,
    data : fd,
    success: function(result){
        console.log(result);
    },
    error: function(err){
        console.log(err);
    }
});

} */



/* ar data = new FormData();
jQuery.each(jQuery('#file')[0].files, function(i, file) {
    data.append('file-'+i, file);
});

//Full Ajax request
jQuery.ajax({
    url: 'atest',
    data: data,
    cache: false,
    contentType: false,
    processData: false,
    type: 'POST',
    success: function(data){
        alert(data);
    }
});




 */


</script>
</html>