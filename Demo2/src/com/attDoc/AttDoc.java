package com.attDoc;

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
import com.login.logind.Logind;

@WebServlet("/AttDoc")
public class AttDoc extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
	    
		LoginDoc logind = new LoginDoc();
		
		try {
			if(logind.check(uname, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("attdoc.jsp");
			}
			else {
				response.sendRedirect("loginAgain2.jsp");
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

}
