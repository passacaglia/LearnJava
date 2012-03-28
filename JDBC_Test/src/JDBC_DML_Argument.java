import java.sql.*;
public class JDBC_DML_Argument {

	public static void main(String[] args) {
		String name = null;
		
		if (1 != args.length) {
			System.out.println("Usage: \n java JDBC_DML_Argument userName \n System exit!");
			System.exit(-1);
		}
		
		name = args[0];
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(url, "root", "amigo");
			
			stmt = conn.createStatement();
			String sql = "insert into userlist values (null, '" + name + "');";
			stmt.executeUpdate(sql);
System.out.println(sql);
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























