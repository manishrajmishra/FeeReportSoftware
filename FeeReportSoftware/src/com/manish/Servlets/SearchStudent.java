package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manish.DB.StudentDao;
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Student</title>");
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
	        out.println("<div class='container'>");
	        out.println("<div class='signup-content'>");
	        out.println("<div class='signup-form' style='width:1265px!important;'>");
	        out.println("<h2 class='form-title'>Search Student</h2>");
		
	        String searchString = request.getParameter("searchString");
			response.setContentType("text/html");
				String searchField=request.getParameter("searchField");
				ResultSet rst= StudentDao.getSearchResults(searchField, searchString);
				
				String responseBody="<table class='table table-bordered table-striped'>"
						+ "<tr><td>ID</td><td>Email</td><td>Name</td><td>Course</td><td>Date Of Joining</td><td>Address</td><td>Contact</td></tr>";
				try {
					while(rst.next()){
						System.out.println(rst.getString("rollno"));
						responseBody+="<tr><td>"+rst.getString("rollno")+"</td><td>"+rst.getString("email")+"</td><td>"+rst.getString("name")+"</td><td>"+rst.getString("course")+"</td><td>"+rst.getString("doj")+"</td><td>"+rst.getString("address")+"</td><td>"+rst.getString("contact")+"</td></tr>";
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				responseBody+="</table>";
				if(searchField.equals("doj")) {
					try {
						ResultSet rs=StudentDao.getTotalCollection(searchString);
						if(rs.next()) {
							System.out.println("total::"+rs.getInt("totalPaid"));
							responseBody+="<div>Total Sum = "+rs.getInt("totalPaid")+"</div>";
							responseBody+="<div>Total Registration = "+rs.getInt("totalregister")+"</div>";
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				out.print(responseBody);	
	}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
