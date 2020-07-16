package com.tyj.JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCutills {
	private static  String DIR;
	private static  String URL;
	private static  String USER;
	private static  String PWD;
	private static Connection connection=null;
	static {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream("./src/jdbc80.properties"));
			DIR=properties.getProperty("dir");
			URL=properties.getProperty("url");
			USER=properties.getProperty("user");
			PWD=properties.getProperty("pwd");
			Class.forName(DIR);
			connection = DriverManager.getConnection(URL,USER,PWD);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
}
