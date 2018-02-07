<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<form action="test" autocomplete="on">
  First name:<input type="text" name="fname" id="fname" placeholder=" Enter First name"><br>
  Last name: <input type="text" name="lname" id="lname" placeholder=" Enter Last name"><br>
  Gender:<input type="radio" name="gender" value="male" checked> Male<td></td>
  <input type="radio" name="gender" value="female"> Female<br>
  <label for="mydropdown" datalabel="mydropdown">Dropdown:</label>  
  <select name="name" value="name" >
    <option value="s1">s1</option>
    <option value="s2">S2</option>
    <option value="s3">s3</option>
    <option value="s4">s4</option>
  </select><br>
  Address:<br>
  <textarea name="message" rows="10" cols="30">
  Enter Address:
</textarea><br>
 FileUpload:<input type="file" id="myFile"><br>
<input type="checkbox" name="checkbox" id="checkbox"> I am student<br>
  <input type="submit" name="submit" id="submit" value="submit"><td>  </td><input type="reset" name="reset" id="reset" value="reset"><br>
 
</form>
</body>
</html>