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
@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		
		AccountantBean bean=new AccountantBean(id,name, email, password, address, contact);
		AccountantDao.update(bean);
		MailerAccountant.send(email, "Successfull Updated Your Profile " , "Your Updated credentials are: \n Email: "+email+" \n Password: "+password+" \n Address: "+address+" \n Contact Number: "+contact);
		response.sendRedirect("ViewAccountant");
		
		out.close();
	}

}
