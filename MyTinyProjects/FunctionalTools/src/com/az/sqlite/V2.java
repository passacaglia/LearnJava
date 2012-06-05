/**
 * 分开重码，写入数据库。
 */

package com.az.sqlite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Statement;

import com.az.sqlite.beans.SqliteBean;

public class V2 {

	//strWho + ".txt"
	String strWho = "uggx";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new V2().doIt();
	}
	
	private void doIt() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D:/Temp/" + strWho + "_pretest.txt"));
		//BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Temp/" + strWho + "_HelloThereI'mNew.txt"));
		SqliteBean sb = new SqliteBean();
		Statement statement = sb.connect(strWho);
		statement.executeUpdate("drop table if exists " + strWho);
		statement.executeUpdate(
				"create table " + strWho + " (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, " 
				+ strWho + " varchar, cc varchar)"
				);
		
		String str = null;
		String[] sep = null;
		String sql = "insert into " + strWho + " values ";
		while((str=br.readLine()) != null) {
			sep = str.split(" ");
			for (int i=1; i<sep.length; i++) {
				System.out.println(sep[i]);
				//bw.write(sep[0] + " " + sep[i] + "\n");
				System.out.println(sql + "(" + sep[0] + ", " + sep[i] + ")");
				statement.executeUpdate(sql + "(null, '" + sep[0] + "', '" + sep[i] + "')");
			}
			
		}
		
		br.close();
		//bw.close();
		sb.close();
	}

}














