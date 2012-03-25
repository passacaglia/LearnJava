import java.util.*;

public class SystemProperties {
	public static void main(String args[]) {
		Properties p = System.getProperties();
		Enumeration enu = p.propertyNames();
		
		String propertyName = "";
		String property = "";
		
		while (enu.hasMoreElements()) {
			propertyName = (String) enu.nextElement();
			property = p.getProperty(propertyName);
			System.out.println("Property '" + propertyName + "' = '" + property + "'");
		}
	}
}