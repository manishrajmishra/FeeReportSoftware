<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student Form</title>
</head>
<body>
<%
if((Boolean)session.getAttribute("accountant")==null){
	response.sendRedirect("accountant.html");
}else{%>
<form action="AddStudent" method="post" class="register-form" id="register-form">
  <div class="form-group">
      <label for="name"><i class="zmdi zmdi-account"></i></label>
      <input type="text" name="name" id="name" placeholder="Student Name" pattern="(?=.*[a-z])(?=.*[A-Z]).{1,}" title="Must contain only uppercase and lowercase letter" required />
  </div>
  <div class="form-group">
      <label for="email"><i class="zmdi zmdi-email"></i></label>
      <input type="email" name="email" id="email" placeholder="Student Email" required />
   </div>
  <div class="form-group"></br>
       <label for="sex"></label>
       Male&nbsp&nbsp&nbsp&nbsp<i class="zmdi zmdi-male">&nbsp&nbsp&nbsp
       <input type="radio" name="sex" id="sex" value="male" required/></i>
       Female&nbsp&nbsp&nbsp&nbsp<i class="zmdi zmdi-female">&nbsp&nbsp&nbsp
       <input type="radio" name="sex" id="sex" value="female" required/></i>
  </div>
  <div class="form-group"></br></br>
     <label for="course">Course:</label>
     <select name="course" id="course" onchange="GetSelectedValue()" required></br></br><br>
     </br>
     <option value="0">Select Course</option>
		<option value="Java">Java</option>
		<option value=".Net">.Net</option>
		<option value="PHP">PHP</option>
		<option value="Android">Android</option>
		<option value="Hadoop">Hadoop</option>
		<option value="Selenium">Selenium</option>
		<option value="Micro Controller System">Micro Controller System</option>
		<option value="Full Stack Development">Full Stack Development</option>
		<option value="C,C++">C,C++</option>
		<option value="Ionic Development">Ionic Development</option>
		<option value="C#">C#</option>
	  </select>
	  
	  <script type="text/javascript">
	  function GetSelectedValue(){
		  var selectedValue = document.getElementById("course").value;
		  var fees=0;
		  if(selectedValue=="Java"){
			  fees=7500;
		  }else if(selectedValue==".Net"){
			  fees=18500;
		  }else if(selectedValue=="PHP"){
			  fees=10500;
		  }else if(selectedValue=="Android"){
			  fees=10500;
		  }
		  else if(selectedValue=="Hadoop"){
			  fees=9500;
		  }
		  else if(selectedValue=="Selenium"){
			  fees=10500;
		  }
		  else if(selectedValue=="Micro Controller System"){
			  fees = 9500;
		  }
		  else if(selectedValue=="Full Stack Development"){
			  fees=6500;
		  }
		  else if(selectedValue=="C,C++"){
			  fees=10500;
		  }
		  else if(selectedValue=="Ionic Development"){
			  fees=11500;
		  }
		  else if(selectedValue=="C#"){
			  fees=9500;
		  }
		  document.getElementById("fee").value=fees;
	  }
	  function GetPaidValue(){
		  var fees1 = document.getElementById("fee").value;
		  var paidValue = document.getElementById("paid").value;
		  if(parseInt(paidValue)<parseInt(fees1) && parseInt(paidValue)>=0){
			  var dues = parseInt(fees1)-parseInt(paidValue);
			  document.getElementById("due").value=dues;  
		  }else if(parseInt(paidValue)==parseInt(fees1)){
			  document.getElementById("due").value=0;
		  }
		  else if(parseInt(paidValue)<0 || parseInt(paidValue)>parseInt(fees1)){
				/* document.getElementById("paid").value=0;
				document.getElementById("due").value=0; */
				alert("Check the paid field properly");
		  } 
	  }
	  </script>
  </div>
  <div class="form-group">
      <label for="date"><i class="zmdi zmdi-calendar"></i></label>
      <input type="date" name="date" id="date" required />
   </div>
   
  <div class="form-group">
    <label for="fee"><i class="zmdi zmdi-balance-wallet"></i></label>
    <input type="number" name="fee" id="fee" placeholder="Fee" pattern="(?=.*\d).{1,}" title="Must contain number and length can be anything but not blank"  readonly required/>
  </div>
  
  <div class="form-group">
    <label for="paid"><i class="zmdi zmdi-balance"></i></label>
    <input type="number" name="paid" id="paid" onchange="GetPaidValue()" placeholder="Paid" pattern="(?=.*\d).{1,}" title="Must contain number and length can be anything but not blank" required/>
  </div>
  
  <div class="form-group">
    <label for="due"><i class="zmdi zmdi-alert-triangle"></i></label>
    <input type="number" name="due" id="due" placeholder="Due" pattern="(?=.*\d).{1,}" title="Must contain number and length can be anything but not blank" readonly required/>
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