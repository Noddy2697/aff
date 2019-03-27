package com.attHos;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.attDoc.loginDoc.LoginDoc;
import com.attHos.loginHos.LoginHos;

/**
 * Servlet implementation class AttHos
 */
@WebServlet("/AttHos")
public class AttHos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
	    
		LoginHos logind = new LoginHos();
		
		try {
			if(logind.check(uname, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("atthosp.jsp");
			}
			else {
				response.sendRedirect("loginAgain1.jsp");
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}


}
