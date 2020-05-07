<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="bootstrap.min.css"/>
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
<title>Search Accountant</title>
</head>
<body>
<%
if((Boolean)session.getAttribute("admin")==null){
	response.sendRedirect("admin.html");
}else{%>
<form action="SearchAccountant" method="post" class="register-form" id="register-form">
<div class="container">
<select name="searchField" id="searchField">
	<option value="id">Id</option>
	<option value="email">Email</option>
		<option value="name">Name</option>
		<option value="address">Address</option>
		<option value="contact">Mobile</option>
	</select>
</div>
  <div class="form-group">
    <label for="name"><i class="zmdi zmdi-search"></i></label>
    <input type="text" name="searchString" placeholder="Search" required/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<%	
}%>
</body>
</html>