
public class TestBirthDate {
	
	public static void main(String args[]) {
		int date = 9;
		TestBirthDate t = new TestBirthDate();
		BirthDate bd1 = new BirthDate(1,1,1997);
		BirthDate bd2 = new BirthDate(2,10,2000);
		t.change1(date);
		t.change2(bd1);
		t.change3(bd2);
		
		System.out.println("\ndate=" + date);
		bd1.display();
		bd2.display();
	}
	
	public void change1(int i) {
		i = 1235;//sorry.
	}
	
	public void change2(BirthDate b) {
		b = new BirthDate(2,2,1998);//sorry.
	}
	
	public void change3(BirthDate b) {
		//b = new BirthDate();
		b.setDay(3);//that's fine.
	}
}