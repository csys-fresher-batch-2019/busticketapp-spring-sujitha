package com.chainsys.busticketapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DbConnection {
	public static Connection getConnection() throws Exception{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String server = "localhost";
				//TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
					//TimeZone.setDefault(timeZone);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@" + server + ":1521:XE", "system",
						"oracle");
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "sujitha","sujitha");
								
				return connection;
			}
}