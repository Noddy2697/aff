package com.showD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ShowD
 */
@WebServlet("/ShowD")
public class ShowD extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				String sql  = "SELECT * FROM doc";
				InitialContext initialContext = new InitialContext();
			    Context context = (Context) initialContext.lookup("java:comp/env");
			    DataSource ds = (DataSource) context.lookup("mydb");
			    Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				PrintWriter out = response.getWriter();
				while(rs.next()){

					String docname = rs.getString("docname");
		            String uname = rs.getString("uname");
		            String pass = rs.getString("pass");
		            
		            out.print(", Docter: " + docname);
		            out.print(" ->  uname: " + uname );
		            out.print(" ->  pass: " + pass );
		            out.println();
		            out.println();
		         }
		         rs.close();
		         stmt.close();
		         conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} 
	}

}
