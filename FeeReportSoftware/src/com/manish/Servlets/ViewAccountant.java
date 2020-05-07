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

import com.manish.Beans.AccountantBean;
import com.manish.DB.AccountantDao;
@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
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
		
		if(session==null||session.getAttribute("admin")==null){
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container' >");
	        out.println("<h1>Login To Do So!</h1>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signup-form'>");
	        out.println("<h2 class='form-title'>Admin Login</h2>");
			request.getRequestDispatcher("AdminLoginForm.html").include(request, response);
			out.println("</div>");
			out.println("<div class='signup-image'>");
            out.println("<figure>");
            out.println("<img src='images/signup-image.jpg' alt='sing up image'>");
            out.println("</figure>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</section>");
            out.println("</div>");
		}else {
			request.getRequestDispatcher("navadmin.jsp").include(request, response);
		    out.println("<div class='main'>");
			out.println("<section class='signup'>");
	        out.println("<div class='container'>");
	        out.println("<h2 class='form-title'>View Accountant</h2>");
	
		List<AccountantBean> list=AccountantDao.getAllRecords();
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
		for(AccountantBean bean:list){
			out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditAccountantForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteAccountant?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
	}	
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
