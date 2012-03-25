public class TestWrapClasses {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Double d = new Double("123.956");
		int j = i.intValue() + d.intValue();
		float f = i.floatValue() + d.floatValue();
		System.out.println(j);
		System.out.println(f);
		
		double pi = Double.parseDouble("3.1415926");
		double r = Double.valueOf("2.0").doubleValue();
		double s = pi*r*r;
		System.out.println(s);
		
		try {
			int k = Integer.parseInt("1.25");
			//思考如何让他不出错。直接把小数点后面的去掉？
			//2011.11.05 update：做不到。下面的方法也会出错。NumberFormatException。
			//做不到就做不到，别钻牛角尖。
			/*
			Integer l = new Integer("1.25");
			int k = l.intValue();
			System.out.println(k);
			*/
		} catch (NumberFormatException e) {
			System.out.println("Number Format Error !");
		}
		
		System.out.println(Integer.toBinaryString(123) + "B");
		System.out.println(Integer.toHexString(123) + "H");
		System.out.println(Integer.toOctalString(123) + "O");
		
	}
}