public class TestAccess {
	
}

class T {
	private int i = 0;
					int j = 0;
	protected int k = 0;
	public int m = 0;
}

class TT {
	public void m() {
		T t = new T();
		System.out.println(t.i);//²»ÄÜ·ÃÎÊ
	}
}