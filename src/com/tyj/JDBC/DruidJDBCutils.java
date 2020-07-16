package com.tyj.JDBC;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidJDBCutils {
	private static DataSource dataSource;
	static {
		Properties properties=new Properties();
		try {
			properties.load(DruidJDBCutils.class.getClassLoader().getSystemResourceAsStream("druidJDBC80.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return dataSource;
		
	}
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
