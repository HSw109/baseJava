package com.hsw.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class OracleConn {
	public Connection makeConnect()throws Exception{
		// Load the JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Initial connectivity object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db:1521:xe","system","trgg1234");
		return con;
		
	}
	public String getData(Connection con, String query)throws Exception{
		
		String result = "";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			result += "ID: " + rs.getInt(1) + " Name: " + rs.getString(2)+rs.getString(3) + " Job: " + rs.getString(4) + " Salary: " + rs.getString(5) + " .\n";
		}
		rs.close();
		st.close();
		con.close();
		return result;		
	}
}
