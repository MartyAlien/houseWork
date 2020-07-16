package com.tyj.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo01 {
	/*
	 * mysql8.0驱动包
	 */
	public static void main(String[] args) throws Exception {
		/*Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tyj_sm_new3?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
		Connection connection = DriverManager.getConnection(url, "root", "root");*/
		Connection connection = JDBCutills.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from student order by sno");
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			String snoString=rs.getString("sno");
			String snameString=rs.getString("sname");
			System.out.println(snoString+"=="+snameString);
		}
		prepareStatement.close();
		connection.close();
	}
}
