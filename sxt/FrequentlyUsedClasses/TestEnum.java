public class TestEnum {
	public enum MyColor { red, green, blue};
	
	public static void main(String[] args) {
		MyColor m = MyColor.red;
		switch(m) {
			case red:
				System.out.println("red");
				break;
			case green:
				System.out.println("green");
				break;
			case blue:
				System.out.println("blue");
				break;
			default:
				System.out.println("default");
		}
		
		System.out.println(m);
		System.out.println(m.ordinal());
	}
}