package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manish.Beans.StudentBean;
import com.manish.DB.StudentDao;
@WebServlet("/EditStudentForm")
public class EditStudentForm extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentBean bean=StudentDao.getRecordByRollno(rollno);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
        HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("accountant")==null){
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container'>");
	        out.println("<h1>Sorry, Login To Do So!</h1>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signin-image'>");
	        out.println("<figure>");
	        out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
	        out.println("</figure>");
	        out.println("</div>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Accountant Login</h2>");
			request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
			out.println("</div>");
		}else {
			request.getRequestDispatcher("navaccountant.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container'>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signin-image'>");
	        out.println("<figure>");
	        out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
	        out.println("</figure>");
	        out.println("</div>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Edit Student Form</h2>");
	        out.print("<form action='EditStudent' method='post' class='register-form' id='register-form'>");
	        out.print("<div class='form-group'>");
	        out.print("<input type='hidden' name='rollno' value='"+bean.getRollno()+"'/>");
	        out.print("<label for='name'><i class='zmdi zmdi-account'></i></label>");
	        out.print("<input type='text' value='"+bean.getName()+"' name='name' id='name' placeholder='Accountant Name' pattern='(?=.*[a-z])(?=.*[A-Z]).{1,}' title='Must contain only uppercase and lowercase letter' required />");
	        out.print("</div>");
	        out.print("<div class='form-group'>");
	        out.print("<label for='email'><i class='zmdi zmdi-email'></i></label>");
	        out.print("<input type='email' value='"+bean.getEmail()+"' name='email' id='email' placeholder='Accountant Email' readonly required />");
	        out.print("</div>");
			out.print("<div class='form-group'>");
			out.print("<label for='sex'><i class='zmdi zmdi-male-female'></i></label>");
			out.print("<input type='text'  value='"+bean.getSex()+"' name='sex' id='sex' placeholder='Sex'/>");
			out.print("</div>");
			out.print("<div class='form-group'>");
			out.print("<label for='course'><i class='zmdi zmdi-receipt'></i></label>");
			out.print("<input type='text' value='"+bean.getCourse()+"' name='course' id='course' placeholder='Course' pattern='(?=.*[a-z])(?=.*[A-Z]).{1,}' title='Must contain only uppercase and lowercase letter' required/>");
			out.print("</div>");
			out.print("<div class='form-group'>");
			out.print("<label for='date'><i class='zmdi zmdi-calendar'></i></label>");
			out.print("<input type='date'value='"+bean.getDoj()+"' name='date' id='date' required />");
			out.print("</div>");
			out.print("<div class='form-group'>");
			out.print("<label for='fee'><i class='zmdi zmdi-balance-wallet'></i></label>");
			out.print("<input type='number' value='"+bean.getFee()+"' name='fee' id='fee' placeholder='Fee' pattern='(?=.*\\d).{1,}' title='Must contain number and length can be anything but not blank' required/>");
			out.print("</div>");
			out.print("<div class='form-group'>");
			out.print(" <label for='paid'><i class='zmdi zmdi-balance'></i></label>");
			out.print("<input type='number'  value='"+bean.getPaid()+"' name='paid' id='paid' placeholder='Paid' pattern='(?=.*\\d).{1,}' title='Must contain number and length can be anything but not blank' required/>");
			out.print("</div>");
			out.print("<div class='form-group'>");
			out.print("<label for='due'><i class='zmdi zmdi-alert-triangle'></i></label>");
			out.print("<input type='number' value='"+bean.getDue()+"' name='due' id='due' placeholder='Due' pattern='(?=.*\\d).{1,}' title='Must contain number and length can be anything but not blank' required/>");
			out.print("</div>");
			out.print("<div class='form-group'>");
	        out.print("<label for='address'><i class='zmdi zmdi-home'></i></label>");
	        out.print("<input type='text' value='"+bean.getAddress()+"' name='address' id='pass' placeholder='Address' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[:.-=,]).{8,}' title='Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters' required />");
	        out.print("</div>");
	        out.print("<div class='form-group'>");
	        out.print("<label for='mobile'><i class='zmdi zmdi-smartphone-android'></i></label>");
	        out.print("<input type='text' value='"+bean.getContact()+"' name='contact' id='pass' placeholder='Mobile' pattern='(?=.*\\d).{10,10}' title='Must contain only number and lenght shoul be 10' required />");
	        out.print("</div>");
	        out.print("<div class='form-group form-button'>");
	        out.print("<input type='submit' name='signup' id='signup' class='form-submit' value='Submit'/>");
	        out.println("</div>");
			out.print("</form>");
		
		}
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
				
		out.close();
	}

}
