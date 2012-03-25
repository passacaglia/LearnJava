package bean;

public class Bean_Counter {
	
	public Bean_Counter() {}
	private int count;
	
	public int getCount() {
		this.count++;
		return this.count;
	}
	
	public void setCount(int c) {
		this.count = c;
	}
}
