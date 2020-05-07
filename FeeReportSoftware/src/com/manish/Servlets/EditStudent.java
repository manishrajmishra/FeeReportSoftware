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
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int rollno=Integer.parseInt(request.getParameter("rollno"));
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
		
		
		StudentBean bean=new StudentBean(rollno,name, email, sex, course, fee, paid, due, address, contact, new java.sql.Date(cDate.getTime()));
		int status=StudentDao.update(bean);
		System.out.println(status);
		MailerStudent.send(email, "Your Updation is Successfully Done.", "Your Credinatials are: \n Email: "+email+" \n Gender: "+sex+" \n Course: "+course+" \n Total Fees of Course: "+fee+" \n Amount Paid: "+paid+" \n Amount Due: "+due+" \n Address: "+address+" \n Contact Number: "+contact);
		response.sendRedirect("ViewStudent");
		
		out.close();
	}

}
