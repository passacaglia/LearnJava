package com.az.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DBAccess {

	private String drv = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost:3306/contacts";

	private String usr = "root";

	private String pwd = "amigo";

	private Connection conn = null;

	private Statement stmt = null;

	private ResultSet rs = null;
	

	public boolean createConn() {
		boolean b = false;
		try {
			Class.forName(drv).newInstance();
			conn = DriverManager.getConnection(url, usr, pwd);
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean update(String sql) {
		boolean b = false;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			b = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return b;
	}

	public void query(String sql) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean next() {
		boolean b = false;
		try {
			if(rs.next()) { 
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;		
	}

	public String getValue(String field) {
		String value = null;
		try {
			if(rs!=null)value = rs.getString(field);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void closeConn() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeStmt() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeRs() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDrv() {
		return drv;
	}

	public void setDrv(String drv) {
		this.drv = drv;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStm() {
		return stmt;
	}

	public void setStm(Statement stmt) {
		this.stmt = stmt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}
	
	public int getId() {
		int value = 0;
		try {
			if(null != rs) {
				value = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getName() {
		String value = null;
		try {
			if(null != rs) {
				value = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public String getEmail() {
		String value = null;
		try {
			if(null != rs) {
				value = rs.getString("email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}