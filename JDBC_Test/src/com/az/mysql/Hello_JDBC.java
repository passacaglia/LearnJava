package com.az.mysql;

import java.sql.*;

public class Hello_JDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. Load the Driver. newʵ����ʱ��Driver�Զ���DriverManagerע�ᡣ
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=amigo";
			//2. ע��֮�󣬿���ͨ��DriverManager�õ����ݿ��һ�����ӡ�
			conn = DriverManager.getConnection(url);
			
			//3. ����һ��������
			stmt = conn.createStatement();
			String sql = "select * from userlist";
			//4. ���������������ִ��Query(select)/Update(insert, update, delete).
			//   ���ң��õ��������
			rs = stmt.executeQuery(sql);
			
			//rs.next()���ƶ��α꣨�Ƿ�����һ���������ʼ��ָ�ڵ�һ����ǰ�棩
			while (rs.next()) {
				//5. ��ResultSet�ĸ���get������ȡ����Ҫ��ֵ��
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//Exception ��¼��log�ļ�� (log4j)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  //6. �� finally����رո������ӡ�
			try {
				//���жϰ�����û�С�
				if (rs != null) {
					rs.close();
					rs = null;//��Ϊ�ա�GC's working time��
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



















