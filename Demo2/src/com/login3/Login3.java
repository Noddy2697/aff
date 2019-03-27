package com.login3;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.addD.AddD;
import com.addp.AddP;

/**
 * Servlet implementation class Login3
 */
@WebServlet("/Login3")
public class Login3 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
		String name = request.getParameter("n");
		
		AddP login1 = new AddP();
		
		try {
			if(login1.add2(name,uname, pass)) {
				/*HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("hos.jsp");*/
				JOptionPane.showMessageDialog(null, "patient added");
			}
			else {
				response.sendRedirect("admin.jsp");
			}
		} catch (HeadlessException | SQLException | NamingException e) {
			e.printStackTrace();
		}
	}

}
