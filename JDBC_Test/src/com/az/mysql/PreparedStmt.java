package com.az.mysql;
import java.sql.*;
public class PreparedStmt {

	public static void main(String[] args) {
		String name = null;
		
		if (1 != args.length) {
			System.out.println("Usage: \n java PreparedStmt userName \n System exit!");
			System.exit(-1);
		}
		
		name = args[0];
		
		Connection conn = null;
		PreparedStatement prstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(url, "root", "amigo");
			
			String sql = "insert into userlist values (null, ?);";
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1, name);//1 : 第一个问号的值。//貌似String也不需要''了。
			prstmt.executeUpdate();
System.out.println(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prstmt != null) {
					prstmt.close();
					prstmt = null;
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























