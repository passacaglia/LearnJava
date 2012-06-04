package com.az.sqlite.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteBean {
	
	private Connection connection = null;
	
	//strWho : dbName
	//in D:/Temp/strWho
	public Statement connect(String strWho) {
		Statement statement = null;
	    try {		    
			// load the sqlite-JDBC driver using the current class loader
		    Class.forName("org.sqlite.JDBC");
		    
	    	// create a database connection
		    connection = DriverManager.getConnection("jdbc:sqlite:D:/Temp/" + strWho + ".sqlite");
			statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
		
			
			
			System.out.println("connected!");
			
	    } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch(SQLException e) {
		      // if the error message is "out of memory", 
		      // it probably means no database file is found
		      System.err.println(e.getMessage());
		} finally {
			return statement;
		}
	}
	
	public void close() {
		try {
			if(connection != null) {
				connection.close();
			} 
		} catch(SQLException e) {
				// connection close failed.
				System.err.println(e);
		}
	}
	
	
}
