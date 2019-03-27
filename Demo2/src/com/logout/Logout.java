package com.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.logind.Logind;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	 	HttpSession session = request.getSession( false );

	    if( session != null ) {
	    	session.removeAttribute("username");
	    	session.invalidate();
	    }
		response.sendRedirect("loginexit.jsp");
	}
}
