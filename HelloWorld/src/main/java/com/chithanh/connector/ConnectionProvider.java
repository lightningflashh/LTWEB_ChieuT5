package com.chithanh.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		try {
			Class.forName("com.sql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ltweb01?useSSL=false&useUnicode=true&characterEncoding=UTF-8", 
					"root",
					"123456");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
