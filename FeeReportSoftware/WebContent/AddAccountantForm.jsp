<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if((Boolean)session.getAttribute("admin")==null){
	response.sendRedirect("accountant.html");
}else{
%>
<form action="AddAccountant" method="post" class="register-form" id="register-form">
                       <div class="form-group">
                          <label for="name"><i class="zmdi zmdi-account"></i></label>
                          <input type="text" name="name" id="name" placeholder="Accountant Name" pattern="(?=.*[a-z])(?=.*[A-Z]).{1,}" title="Must contain only uppercase and lowercase letter" required />
                       </div>
                       <div class="form-group">
                          <label for="email"><i class="zmdi zmdi-email"></i></label>
                          <input type="email" name="email" id="email" placeholder="Accountant Email" required />
                       </div>
                       <div class="form-group">
                           <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                           <input type="password" name="password" id="pass" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-]).{8,}" title="Must contain at least one number , one special character and one uppercase and lowercase letter, and at least 8 or more characters" required />
                        </div>
                        <div class="form-group">
                           <label for="address"><i class="zmdi zmdi-home"></i></label>
                           <input type="text" name="address" id="pass" placeholder="Address" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[:.-=,]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required />
                        </div>
                        <div class="form-group">
                           <label for="mobile"><i class="zmdi zmdi-smartphone-android"></i></label>
                           <input type="text" name="contact" id="pass" placeholder="Mobile" pattern="(?=.*\d).{10,10}" title="Must contain only number and length should be 10" required />
                        </div>
                        <div class="form-group form-button">
                           <input type="submit" name="signup" id="signup" class="form-submit" value="Submit"/>
                        </div>
         </form>
<%
}%>
</body>
</html>