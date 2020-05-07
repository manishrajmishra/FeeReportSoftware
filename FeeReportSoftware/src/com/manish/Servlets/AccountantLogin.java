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

@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Panel</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		ResultSet rs = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = null;
		if (email != null && password != null) {
			rs = AccountantDao.validate(email, password);
			try {
				if (rs.next()) {
					session = request.getSession();
					session.setAttribute("accountant", true);
					session.setAttribute("usermail", rs.getString("email"));
					request.getRequestDispatcher("navaccountant.jsp").include(request, response);
					out.println("<div class='main'>");
					out.println("<section class='signup'>");
					out.println("<div class='container'>");
					out.println("<h1>Welcomes To Accountant Pannel</h1>");
					out.println("<div class='signup-content'>");
					out.println("<div class='signup-form'>");

					
					try {
						out.println("<table class='table table-bordered table-striped'>");
						out.print("<tr><td>ID:</td><td>" + rs.getInt("id") + "</td></tr>");
						out.print("<tr><td>Name:</td><td>" + rs.getString("name") + "</td></tr>");
						out.print("<tr><td>Email:</td><td>" + rs.getString("email") + "</td></tr>");
						out.print("<tr><td>Contact:</td><td>" + rs.getString("contact") + "</td></tr>");
						out.print("<tr><td>Address:</td><td>" + rs.getString("address") + "</td></tr>");
						out.print("</table>");
						out.println("</div>");
						out.println("<div class='signin-image'>");
						out.println("<figure>");
						out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
						out.println("</figure>");
						out.println("</div>");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*
					 * request.getRequestDispatcher("accountanthome.html").include(request,
					 * response);
					 */
				} else {
					request.getRequestDispatcher("navhome.jsp").include(request, response);
					out.println("<div class='main'>");
					out.println("<section class='sign-in'>");
					out.println("<div class='container'>");
					out.println("<h1>Sorry, username or password error!</h1>");
					out.println("<div class='signin-content'>");
					out.println("<div class='signin-form'>");
					out.println("<h2 class='form-title'>Accountant Login</h2>");
					request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
					out.print("</div>");
					out.println("<div class='signin-image'>");
					out.println("<figure>");
					out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
					out.println("</figure>");
					out.println("</div>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</section>");
			out.println("</div>");
			request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
		} else if(request.getSession().getAttribute("usermail")!=null){
			String emailOld = (String) request.getSession().getAttribute("usermail");
			System.out.println(emailOld);
			rs = AccountantDao.validate(emailOld);
			try {
				System.out.println(rs.getFetchSize());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (rs.next()) {
					request.getRequestDispatcher("navaccountant.jsp").include(request, response);
					out.println("<div class='main'>");
					out.println("<section class='signup'>");
					out.println("<div class='container'>");
					out.println("<h1>Welcomes To Accountant Pannel</h1>");
					out.println("<div class='signup-content'>");
					out.println("<div class='signup-form'>");

					
					System.out.println(rs.getString("name")+":"+rs.getString("email"));
					try {
						out.println("<table class='table table-bordered table-striped'>");
						out.print("<tr><td>ID:</td><td>" + rs.getInt("id") + "</td></tr>");
						out.print("<tr><td>Name:</td><td>" + rs.getString("name") + "</td></tr>");
						out.print("<tr><td>Email:</td><td>" + rs.getString("email") + "</td></tr>");
						out.print("<tr><td>Contact:</td><td>" + rs.getString("contact") + "</td></tr>");
						out.print("<tr><td>Address:</td><td>" + rs.getString("address") + "</td></tr>");
						out.print("</table>");
						out.println("</div>");
						out.println("<div class='signin-image'>");
						out.println("<figure>");
						out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
						out.println("</figure>");
						out.println("</div>");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("</section>");
					out.println("</div>");
					request.getRequestDispatcher("footer.html").include(request, response);
					out.println("</body>");
					out.println("</html>");
					
				}
				
				out.close();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='main'>");
			out.println("<section class='sign-in'>");
			out.println("<div class='container'>");
			out.println("<h1>Sorry, Login To Do So!</h1>");
			out.println("<div class='signin-content'>");
			out.println("<div class='signin-form'>");
			out.println("<h2 class='form-title'>Accountant Login</h2>");
			request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
			out.println("</div>");
			out.println("<div class='signin-image'>");
			out.println("<figure>");
			out.println("<img src='images/signin-image.jpg' alt='sing up image'>");
			out.println("</figure>");
			out.println("</div>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}