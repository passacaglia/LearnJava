package com.az.oracle;

import java.sql.*;

public class HelloOracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:@127.0.0.1:1521";
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	}

}
