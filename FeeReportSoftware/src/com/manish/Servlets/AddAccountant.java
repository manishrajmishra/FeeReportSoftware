package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manish.Beans.AccountantBean;
import com.manish.DB.AccountantDao;
import com.manish.mailapi.MailerAccountant;

@WebServlet("/AddAccountant")
public class AddAccountant extends HttpServlet {
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
		out.println("<title>Accountant Added</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='main'>");
		out.println("<section class='signup'>");
        out.println("<div class='container'>");
        out.println("<div class='signup-content'>");
        out.println("<div class='signup-form'>");
        out.println("<p>Accountant is added successfully!</p>");
        out.println("<h1 class='form-title'>Add Accountant Form</h1>");
        
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(name, email, password, address, contact);
		int status=AccountantDao.save(bean);
		System.out.println(status);
		MailerAccountant.send(email, "Successfull Registration " , "Your Registration credentials are: \n Email: "+email+" \n Password: "+password+" \n Address Registration: "+address+" \n Contact Number: "+contact);
		
		request.getRequestDispatcher("AddAccountantForm.jsp").include(request, response);
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
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
