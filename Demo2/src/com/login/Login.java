package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.logind.Logind;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
	    
		Logind logind = new Logind();
		
		try {
			if(logind.check(uname, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("admin.jsp");
			}
			else {
				response.sendRedirect("loginAgain.jsp");
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
}
