package com.addp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AddP {

	
	public boolean add2(String name, String uname, String pass) throws SQLException, NamingException {
		String sql  = "insert into pat values(?,?,?)";
		InitialContext initialContext = new InitialContext();
	    Context context = (Context) initialContext.lookup("java:comp/env");
	    DataSource ds = (DataSource) context.lookup("mydb");
	    Connection conn = ds.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, uname);
			st.setString(3,pass);
			int i = st.executeUpdate();

			if(i!=0) {
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
