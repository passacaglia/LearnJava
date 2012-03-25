public class Test {
	public static void main(String argv[]) {
		Student s1 = new Student("A","S1");
		Student s2 = new Student("B","shanghai","S2");
		Teacher t1 = new Teacher("T1","Professor");
		Teacher t2 = new Teacher("T2","shanghai","Associate Professor");
		Person p1 = new Person("P1","shanghai");
		Person p2 = new Person("P2","shanghai");
		
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(t1.info());
		System.out.println(t2.info());
		System.out.println("\n" + p1.toString() + "\n");
		System.out.println("If p1 & p2 is the same one : " + p1.equals(p2));
		
		System.out.println("\n" + s1.toString() + "\n");
		System.out.println("If s1 & s2 is the same one : " + s1.equals(s2));
	}
}