package com.az.javabean;

import java.util.HashMap;

public class Contacts {
	private DBAccess dba = new DBAccess();
	private HashMap<String, String> contacts = new HashMap<String, String>();
	
	public HashMap getContacts() {
		dba.createConn();
		dba.query("select * from contacts order by id");
		while (dba.next()) {
			contacts.put(dba.getName(), dba.getEmail());
		}
		return contacts;
	}
	
}
