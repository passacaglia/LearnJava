public class MyProperties {
	public static void main(String args[]) {
		String property;
		
		property = System.getProperty("P1");
		System.out.println("Property 'P1' = '" + property + "'");
		
		property = System.getProperty("P2");
		System.out.println("Property 'P2' = '" + property + "'");
	}
}

/**
*To run this program,try 
*				"java -DP1=ABC -DP2=DEF MyProperties" 
*				"java -D<��������>=<value> -D<��������>=<value> MyProperties"
*in the command-line window.
*/