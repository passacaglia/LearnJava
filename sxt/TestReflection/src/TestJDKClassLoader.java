
public class TestJDKClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(String.class.getClassLoader());//bootstrap class。最核心的.无名。
//		//though error, just go on.
//		System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getName());
//		System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
		
		ClassLoader c = TestJDKClassLoader.class.getClassLoader();
		while(null != c) {
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
