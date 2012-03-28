
import java.sql.*;

public class Tracsaction_Test {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(url,"root", "amigo");
			
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			stmt.addBatch("insert into userlist values (null, 'Henry')");
			stmt.addBatch("insert into userlist values (null, 'Jane')");
			stmt.addBatch("insert into userlist values (null, 'Lily')");
			stmt.executeBatch();
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
