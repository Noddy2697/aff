package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
	    
		
		if(uname.equals("admin") && pass.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("admin.jsp");
		}
		else if(uname.equals("") && pass.equals("")) {
			/*PrintWriter out = response.getWriter();
			response.setContentType("text/html"); 
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('try again');");  
			out.println("</script>");
			//response.sendRedirect("login.jsp");
			flag = 1;*/
			response.sendRedirect("login.jsp");
		}
		else if(uname.equals("hos") && pass.equals("hos")){
			response.sendRedirect("hos.jsp");
		}
		
		else if(uname.equals("doc") && pass.equals("doc")){
			response.sendRedirect("doc.jsp");
		}
	}
}
