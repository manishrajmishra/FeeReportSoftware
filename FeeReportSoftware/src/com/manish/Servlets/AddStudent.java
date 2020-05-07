
package com.manish.Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manish.Beans.StudentBean;
import com.manish.DB.StudentDao;
import com.manish.mailapi.MailerStudent;
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String course=request.getParameter("course");
		int fee=Integer.parseInt(request.getParameter("fee"));
		int paid=Integer.parseInt(request.getParameter("paid"));
		int due=Integer.parseInt(request.getParameter("due"));
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String doj= request.getParameter("date");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date cDate = null;
		try {
			cDate = (Date) df.parse(doj);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		StudentBean bean=new StudentBean(name, email, sex, course, fee, paid, due, address, contact, new java.sql.Date(cDate.getTime()));
		int status=StudentDao.save(bean);
		System.out.println(status);
		MailerStudent.send(email, "Your Registration is Successfully Done.", "Your Credinatials are: \n Email: "+email+" \n Gender: "+sex+" \n Course: "+course+" \n Total Fees of Course: "+fee+" \n Amount Paid: "+paid+" \n Amount Due: "+due+" \n Address: "+address+" \n Contact Number: "+contact);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Student Added</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='fonts/material-icon/css/material-design-iconic-font.min.css'/>");
		out.println("<link rel='stylesheet' href='css/style.css'/>");
		out.println("</head>");
		out.println("<body>");
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
        out.println("<p>Student is added successfully!</p>");
        out.println("<h1 class='form-title'>Add Student Form</h1>");
		
		request.getRequestDispatcher("AddStudentForm.jsp").include(request, response);
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
