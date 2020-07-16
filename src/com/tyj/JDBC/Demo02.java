package com.tyj.JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 利用Druid数据库连接池 获取连接 访问数据库
 */
public class Demo02 {
	public static void main(String[] args) throws Exception {
		/*Properties properties=new Properties();
		InputStream asStream = Demo02.class.getClassLoader().getResourceAsStream("druidJDBC80.properties");
		properties.load(asStream);
		javax.sql.DataSource pool = DruidDataSourceFactory.createDataSource(properties);*/
		DataSource pool = DruidJDBCutils.getDataSource();
		Connection connection = pool.getConnection();
		String sql="select * from student";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		while(rs.next()) {
			String sno = rs.getString("sno");
			String sname = rs.getString("sname");
			System.out.println(sno+"=="+sname);
		}
		prepareStatement.close();
		connection.close();
	}
}
