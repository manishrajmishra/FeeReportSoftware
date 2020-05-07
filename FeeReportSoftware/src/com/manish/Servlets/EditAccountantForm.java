package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manish.Beans.AccountantBean;
import com.manish.DB.AccountantDao;

@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		AccountantBean bean=AccountantDao.getRecordById(id);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Accountant</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
        HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("admin")==null){
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container'>");
	        out.println("<h1>Sorry, Login To Do So!</h1>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Admin Login</h2>");
			request.getRequestDispatcher("AdminLoginForm.html").include(request, response);
			out.println("</div>");
		}else {
			
			    request.getRequestDispatcher("navadmin.jsp").include(request, response);
			    out.println("<div class='main'>");
				out.println("<section class='signup'>");
		        out.println("<div class='container'>");
		        out.println("<div class='signup-content'>");
		        out.println("<div class='signup-form'>");
		        out.println("<h2 class='form-title'>Edit Accountant Form</h2>");
		        out.print("<form action='EditAccountant' method='post' class='register-form' id='register-form'>");
		        out.print("<div class='form-group'>");
		        out.print("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		        out.print("<label for='name'><i class='zmdi zmdi-account'></i></label>");
		        out.print("<input type='text' value='"+bean.getName()+"' name='name' id='name' placeholder='Accountant Name' pattern='(?=.*[a-z])(?=.*[A-Z]).{1,}' title='Must contain only uppercase and lowercase letter' required />");
		        out.print("</div>");
		        out.print("<div class='form-group'>");
		        out.print("<label for='email'><i class='zmdi zmdi-email'></i></label>");
		        out.print("<input type='email' value='"+bean.getEmail()+"' name='email' id='email' placeholder='Accountant Email' readonly required />");
		        out.print("</div>");
		        out.print("<div class='form-group'>");
		        out.print("<label for='pass'><i class='zmdi zmdi-lock'></i></label>");
		        out.print("<input type='password' value='"+bean.getPassword()+"' name='password' id='pass' placeholder='Password' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-]).{8,}' title='Must contain at least one number, one special character and one uppercase and lowercase letter, and at least 8 or more characters' required />");
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
		        out.println("</form>");
				out.println("</div>");
		}       
				out.println("<div class='signup-image'>");
		        out.println("<figure>");
		        out.println("<img src='images/signup-image.jpg' alt='sing up image'>");
		        out.println("</figure>");
		        out.println("</div>");
		        out.println("</div>");
		        out.println("</div>");
		        out.println("</section>");
		        out.println("</div>");
				request.getRequestDispatcher("footer.html").include(request, response);
				out.println("</body>");
				out.println("</html>");
				
				
				out.close();
	}

}
