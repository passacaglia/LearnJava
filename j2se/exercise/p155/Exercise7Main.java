public class Exercise7Main extends Exercise7 {

//因为Exercise7没有无参数的constructor，为避免Java自动调用无参数的constructor而出错。我们需要手动调用另外一个。
	public Exercise7Main(int i) {
		super(i);
	}
	
	public static void main(String args[]) {
		Exercise7 q1;
		q1 = new Exercise7(10);
		System.out.println(q1.i);
	}
}