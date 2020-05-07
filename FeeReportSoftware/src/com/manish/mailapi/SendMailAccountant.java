package com.manish.mailapi;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@WebServlet("/SendMailAccountant")  
public class SendMailAccountant extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,  
 HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    String to=request.getParameter("to");  
    String subject=request.getParameter("subject");  
    String msg=request.getParameter("msg");  
          
    MailerAccountant.send(to, subject, msg);  
    out.close();  
    }  
  
}  