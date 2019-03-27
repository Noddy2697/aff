package com.login2;

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
import com.addh.Addh;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/Login2")
public class Login2 extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uname = request.getParameter("u");
		String pass = request.getParameter("p");
		String name = request.getParameter("n");
		
		AddD login1 = new AddD();
		
		try {
			if(login1.add1(name,uname, pass)) {
				/*HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("hos.jsp");*/
				JOptionPane.showMessageDialog(null, "docter added");
			}
			else {
				response.sendRedirect("admin.jsp");
			}
		} catch (HeadlessException | NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

}
