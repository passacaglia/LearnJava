/**
 * 分开重码，写入数据库。
 */

package com.az.sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;

import com.az.sqlite.beans.SqliteBean;

public class Alter {

	//strWho + ".txt"
	String strWho = "pinyin";
	String strWhoOpp = "uggx";
	String strFinal = "pinyinuggx";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Alter().doIt();
	}
	
	private void doIt() throws Exception {
		//connect db1
		SqliteBean sb = new SqliteBean();
		Statement statement_pinyin = sb.connect(strWho);
		
		//connect the finall db
		SqliteBean sbFinal = new SqliteBean();
		Statement statement_final = sb.connect(strFinal);
		
		//connect db2
		SqliteBean sb_uggx = new SqliteBean();
		Statement statement_uggx = sb_uggx.connect(strWhoOpp);

		//query db1
		ResultSet rs_pinyin = statement_pinyin.executeQuery("select * from " + strWho);
		ResultSet rs_uggx = null;
		
		int id_pinyin = -1;
		String pinyin = null;
		String cc_pinyin = null;
		int id_uggx = -1;
		String uggx = null;
		String cc_uggx = null;
		
		String sql_query = null;
		String sql_update = null;
		String sql_del = null;
		
		while (rs_pinyin.next()) {
			//shows the result .
			id_pinyin = rs_pinyin.getInt("id");
			pinyin = rs_pinyin.getString(strWho);
			cc_pinyin = rs_pinyin.getString("cc");
			System.out.println("py---- : " + id_pinyin + ", " + pinyin + ", " + cc_pinyin);
			
			//query
			sql_query = "select * from " + strWhoOpp + " where cc like '" + cc_pinyin + "'";
			rs_uggx = statement_uggx.executeQuery(sql_query);
			
			if (rs_uggx.next()) {
				//show the result if exists in the second db.//final db.
				id_uggx = rs_uggx.getInt("id");
				uggx = rs_uggx.getString(strWhoOpp);
				cc_uggx = rs_uggx.getString("cc");
				System.out.println("uggx** : " + id_uggx + ", " + uggx + ", " + cc_uggx);
				
				//update uggx with "汉字"
				sql_update = "update " + strFinal + " set uggx = '" + uggx + "' where id = " + id_pinyin;
				System.out.println(sql_update);
				statement_final.executeUpdate(sql_update);
			} else {
				sql_del = "delete from " + strFinal + " where id = " + id_pinyin;
				System.out.println(sql_del + " , " + pinyin +  " , "+ cc_pinyin);
				statement_final.executeUpdate(sql_del);
			}

		}
		
		sb.close();
		sbFinal.close();
		sb_uggx.close();
	}

}














