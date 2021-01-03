package com.ikuta.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	// ����DB����
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ��ȡ���ݿ�����
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user = "root";
		String password = "admin";
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}

	// �ر���Դ
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
		if (stmt != null && !stmt.isClosed()) {
			stmt.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
