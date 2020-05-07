package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AddAccountantForm")
public class AddAccountantForm extends HttpServlet {
	
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
		out.println("<title>Add Accountant</title>");
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
	        out.println("<h1>Sorry, login to Do So!</h1>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Admin Login</h2>");
			request.getRequestDispatcher("AdminLoginForm.html").include(request, response);
			out.println("</div>");
		}else{
			request.getRequestDispatcher("navadmin.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container'>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Add Accountant Form</h2>");
			request.getRequestDispatcher("AddAccountantForm.jsp").include(request, response);
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
