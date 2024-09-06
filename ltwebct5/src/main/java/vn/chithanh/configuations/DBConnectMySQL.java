package vn.chithanh.configuations;

import java.sql.*;

public class DBConnectMySQL {
	private static String USERNAME = "root";
	private static String PASSWORD = "123456";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/ltweb01";

	public static Connection getDatabaseConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to the database successfully.");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Database connection failed.");
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		try (Connection conn = getDatabaseConnection()) {
			if (conn != null) {
				System.out.println("Successfully connected to the database.");
			} else {
				System.out.println("Connection failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
