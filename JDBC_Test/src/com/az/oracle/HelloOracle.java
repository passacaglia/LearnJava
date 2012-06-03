package com.az.oracle;

import java.sql.*;

public class HelloOracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	}

}
