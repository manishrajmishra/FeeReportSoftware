package com.manish.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manish.DB.StudentDao;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
        HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("accountant")==null){
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='container'>");
			out.println("<h1>Not Accountant!</h1>");
			out.print("<h2>Accountant Login Form</h2>");
			request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
		}else {
		
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentDao.delete(rollno);
		response.sendRedirect("ViewStudent");
	 }
   }
}