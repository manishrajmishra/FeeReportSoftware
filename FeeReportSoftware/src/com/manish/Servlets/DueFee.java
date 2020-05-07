package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manish.Beans.StudentBean;
import com.manish.DB.StudentDao;
@WebServlet("/DueFee")
public class DueFee extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Accountant</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		
			HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("accountant")==null){
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='sign-in'>");
	        out.println("<div class='container'>");
	        out.println("<h1>Login To Do So!</h1>");
	        out.println("<div class='signin-content'>");
	        out.println("<div class='signin-image'>");
	        out.println("<figure>");
	        out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
	        out.println("</figure>");
	        out.println("</div>");
	        out.println("<div class='signin-form'>");
	        out.println("<h2 class='form-title'>Accountant Login</h2>");
			request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
			out.println("</div>");
		}else {
			request.getRequestDispatcher("navaccountant.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container' style='width:1250px!important;'>");
	        out.println("<h2 class='form-title'>Due Fee</h2>");
	
			List<StudentBean> list=StudentDao.getDues();
			out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><th>ID</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>Paid</th><th>Due</th><th>Address</th><th>Mobile</th><th>Edit</th><th>Delete</th>");
			for(StudentBean bean:list){
				out.print("<tr><td>"+bean.getRollno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSex()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getFee()+"</td><td>"+bean.getPaid()+"</td><td>"+bean.getDue()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditStudentForm?rollno="+bean.getRollno()+"'>Edit</a></td><td><a href='DeleteStudent?rollno="+bean.getRollno()+"'>Delete</a></td></tr>");
			    
			}
			out.println("</table>");
			
			out.println("</div>");
			
	}
		
			request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
	
	}

}
