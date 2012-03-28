import java.sql.*;
public class JDBC_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(url, "root", "amigo");
			
			stmt = conn.createStatement();
			String sql = "insert into userlist values (null, 'Alex');";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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























