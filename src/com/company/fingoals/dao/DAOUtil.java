package com.company.fingoals.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOUtil {

	public static Connection openConnection() throws Exception {

		Connection conn = null;

		String driverClassName = "oracle.jdbc.driver.OracleDriver";

		String connectionUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "fingoals";
		String dbPwd = "finpassword";

		Class.forName(driverClassName);

		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);

		return conn;
	}

	public static void closeConnection(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

}
