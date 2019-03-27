package com.login1;

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

import com.addh.Addh;
import com.login.logind.Logind;

/**
 * Servlet implementation class Login1
 */
@WebServlet("/Login1")
public class Login1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
		String name = request.getParameter("n");
		
		Addh login1 = new Addh();
		
		try {
			if(login1.add(name,uname, pass)) {
				/*HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("hos.jsp");*/
				JOptionPane.showMessageDialog(null, "hospital added");
			}
			else {
				response.sendRedirect("admin.jsp");
			}
		} catch (HeadlessException | NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
}
