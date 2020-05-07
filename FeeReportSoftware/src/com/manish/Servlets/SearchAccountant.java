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

import com.manish.DB.AccountantDao;

/**
 * Servlet implementation class SearchAccountant
 */
@WebServlet("/SearchAccountant")
public class SearchAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
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
        out.println("<div class='signup-content'>");
        out.println("<div class='signup-form' style='width:1250px!important;'>");
        out.println("<h2 class='form-title'>Search Accountant</h2>");
        
        String searchString = request.getParameter("searchString");
		response.setContentType("text/html");
			String searchField=request.getParameter("searchField");
			ResultSet rst= AccountantDao.getSearchResults(searchField, searchString);
			
			String responseBody="<table class='table table-bordered table-striped'>"
					+ "<tr><td>ID</td><td>Email</td><td>Name</td><td>Address</td><td>Contact</td></tr>";
			
			try {
				while(rst.next()){
					System.out.println(rst.getString("id"));
					responseBody+="<tr><td>"+rst.getString("id")+"</td><td>"+rst.getString("email")+"</td><td>"+rst.getString("name")+"</td><td>"+rst.getString("address")+"</td><td>"+rst.getString("contact")+"</td></tr>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			responseBody+="</table>";
			out.print(responseBody);
	}
	}

}
