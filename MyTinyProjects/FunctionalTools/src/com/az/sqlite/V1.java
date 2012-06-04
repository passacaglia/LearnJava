/**
 * deprecated
 * try SepWordsThenWrite.
 */

package com.az.sqlite;

import java.sql.*;
import java.io.*;

public class V1 {
	
	static String strWho = "pinyin";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("D:/Temp/" + strWho + "_.txt"));
		
		// load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");

	    Connection connection = null;
		    
		try {		    
		    // create a database connection
		    connection = DriverManager.getConnection("jdbc:sqlite:D:/Temp/" + strWho + ".sqlite");
			  // connection = DriverManager.getConnection("jdbc:sqlite:C:/sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
			statement.executeUpdate("drop table if exists " + strWho);
			statement.executeUpdate(
					"create table " + strWho + " (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " 
					+ strWho + " varchar, cc string)"
					);
			
			String str = null;
			String s1 = null;
			String s2 = null;
			while((str=br.readLine()) != null) {
				s1 = str.substring(0, str.indexOf(" "));
				s2 = str.substring(str.indexOf(" "), str.length());
				s2 = s2.trim();
				statement.executeUpdate("insert into " + strWho + " values(null, '" + s1 + "', '" + s2+ "')");
			}
			
			/*ResultSet rs = statement.executeQuery("select * from " + strPU);
			while(rs.next()) {
			  // read the result set
				System.out.print("id : " + rs.getInt("id") + "  ");
				System.out.print("cc : " + rs.getString("cc") + "  ");
				System.out.println(strPU + " : " + rs.getString(strPU));
			}*/
		
		
			System.out.println("ok");
		
		
		} catch(SQLException e) {
		      // if the error message is "out of memory", 
		      // it probably means no database file is found
		      System.err.println(e.getMessage());
		    }
		    finally {
		      try {
		        if(connection != null)
		          connection.close();
		    } catch(SQLException e) {
		        // connection close failed.
		        System.err.println(e);
		      }
		    }
		
		
		
		
		
		
		
	}
	    
	    
}	    
	    
	    
	    
	    
