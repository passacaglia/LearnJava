public class Exercise2 {
		public void method(int i) {}
}

class Exercise2_ extends Exercise2 {
	public void method (int i) {}//A
	private void method (int j) {}//B
	public int method (int i) {}//C
	public float method (float f) {}//D
	private String method (String s) {}//E
}

/*
*The wrong override will display on the screen.
*And,for D & E.They are completely new method(不同的返回值类型),so they were wrong too.
*合法的覆盖需要：相同的，返回值类型、方法名、参数类型、相同或者更加开放的限定词。
*
*合法的重载需要：相同的方法名，并且传递的参数类型一定要不同，个数不同时也算重载。限定词、返回值不作要求。
*/

