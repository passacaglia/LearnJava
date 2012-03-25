package org.snowtown;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
	
	private static Properties prop = new Properties(); 
	
	static {
		try {
			prop.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/tank.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private PropertyMgr() {}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
