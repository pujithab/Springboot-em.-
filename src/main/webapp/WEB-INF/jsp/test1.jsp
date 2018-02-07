<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <title>Try v1.2 Bootstrap Online</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/scripts/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<label for = "name">Example of Default Checkbox and radio button </label>

<div class = "checkbox">
   <label>
      <input type = "checkbox" value = "">Option 1
   </label>
</div>

<div class = "checkbox">
   <label>
      <input type = "checkbox" value = "">Option 2
   </label>
</div>

<div class = "radio">
   <label>
      <input type = "radio" name = "optionsRadios" id = "optionsRadios1" value = "option1" checked> Option 1
   </label>
</div>



<label for = "name">Example of Inline Checkbox and radio button </label>

<div>
   <label class = "checkbox-inline">
      <input type = "checkbox" id = "inlineCheckbox1" value = "option1"> Option 1
   </label>
   
   <label class = "checkbox-inline">
      <input type = "checkbox" id = "inlineCheckbox2" value = "option2"> Option 2
   </label>
   
   <label class = "checkbox-inline">
      <input type = "checkbox" id = "inlineCheckbox3" value = "option3"> Option 3
   </label>
   
   <label class = "checkbox-inline">
      <input type = "radio" name = "optionsRadiosinline" id = "optionsRadios3" value = "option1" checked> Option 1
   </label>
   
   <label class = "checkbox-inline">
      <input type = "radio" name = "optionsRadiosinline" id = "optionsRadios4" value = "option2"> Option 2
   </label>
</div>
<form action="/action_page.php">
  <select name="cars">
    <option value="volvo">Volvo</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
  </select>
  <br><br>
  <input type="submit">
</form>

</body>
</html>