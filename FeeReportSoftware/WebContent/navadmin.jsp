<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.manish.Servlets.AdminLogin"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="bootstrap.min.css"/>
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
<title>Admin</title>
</head>
<body>
<%
if((Boolean)session.getAttribute("admin")==null){
	response.sendRedirect("admin.html");
}else{
	%>
	<!-- <nav class="navbar navbar-inverse"> -->
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="AdminLogin">FeeReport</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="AddAccountantForm">Add Accountant</a></li>
        <li><a href="ViewAccountant">View Accountant</a></li>
        <li><a href="SearchAccountantForm">Search Accountant</a></li>
        <li><a href="LogoutAdmin">Logout</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
<!-- </nav> -->
 <script src="vendor/jquery/jquery.min.js"></script>
  <script src="js/main.js"></script>
  <script src="jquery.min.js"></script>
  <script src="bootstrap.min.js"></script>
	<%
}
%>
</body>
</html>