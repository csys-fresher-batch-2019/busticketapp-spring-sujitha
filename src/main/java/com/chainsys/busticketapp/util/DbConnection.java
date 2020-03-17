package com.chainsys.busticketapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import com.chainsys.busticketapp.exception.DbException;

public class DbConnection {
	public static Connection getConnection() throws DbException{
		Connection connection=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		//String url="jdbc:oracle:thin:@13.235.147.120:1521:XE";
		connection=DriverManager.getConnection(url,"system","oracle");
		//connection=DriverManager.getConnection(url,"sujitha","sujitha");
		}
		catch(ClassNotFoundException e) {
		throw new DbException("Driver class not found");
		}catch(SQLException e)
		{
		throw new DbException("invalid DB credentials"+e.getMessage());
		}
		return connection;
		}

}
//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "sujitha","sujitha");
