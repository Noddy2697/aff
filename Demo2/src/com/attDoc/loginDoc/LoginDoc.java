package com.attDoc.loginDoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDoc {

	public boolean check(String uname, String pass) throws NamingException, SQLException {
		String sql  = "select uname,pass from doc where uname=? and pass=?";
		InitialContext initialContext = new InitialContext();
	    Context context = (Context) initialContext.lookup("java:comp/env");
	    DataSource ds = (DataSource) context.lookup("mydb");
	    Connection conn = ds.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
            if (conn != null) {
                conn.close();
            }
            conn = null;
		}    
		return false;
	}

}
