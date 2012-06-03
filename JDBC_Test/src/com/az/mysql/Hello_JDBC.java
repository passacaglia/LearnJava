package com.az.mysql;

import java.sql.*;

public class Hello_JDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. Load the Driver. new实例的时候，Driver自动向DriverManager注册。
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=amigo";
			//2. 注册之后，可以通过DriverManager拿到数据库的一个连接。
			conn = DriverManager.getConnection(url);
			
			//3. 创建一个语句对象。
			stmt = conn.createStatement();
			String sql = "select * from userlist";
			//4. 用上面的语句对象来执行Query(select)/Update(insert, update, delete).
			//   并且，拿到结果集。
			rs = stmt.executeQuery(sql);
			
			//rs.next()。移动游标（是否有下一个）。（最开始，指在第一个的前面）
			while (rs.next()) {
				//5. 用ResultSet的各种get方法，取得想要的值。
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//Exception 记录到log文件里。 (log4j)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  //6. 在 finally里面关闭各种连接。
			try {
				//先判断爱下有没有。
				if (rs != null) {
					rs.close();
					rs = null;//设为空。GC's working time。
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



















