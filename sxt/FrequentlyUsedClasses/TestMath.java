public class TestMath {
	public static void main(String[] args) {
		double a = Math.random();
		double b = Math.random();
		System.out.println(a);
		System.out.println(Math.sqrt(a * a + b *b));//平方根
		System.out.println(Math.pow(a,8));//指数
		System.out.println(Math.round(b));
		System.out.println(Math.log(Math.pow(Math.E, 15)));
		double d = 60.0, r = Math.PI/4;
		System.out.println(Math.toRadians(d));
		System.out.println(Math.toDegrees(r));
	}
}