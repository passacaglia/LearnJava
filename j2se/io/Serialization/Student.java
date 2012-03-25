import java.io.*;

public class Student implements Serializable {
	private String name;
	private int chScore, engScore, mathScore;
	public Student(String n, int c, int e, int m) {
		name = n;
		chScore = c;
		engScore = e;
		mathScore = m;
	}
	
	public double avgScore() {
		return (chScore + engScore + mathScore) / 3.0;
	}
	
	public void printData() {
		System.out.println("name: " + name);
		System.out.println("Chinese Score: " + chScore);
		System.out.println("English Score: " + engScore);
		System.out.println("Math Score: " + mathScore);
		System.out.println("Average Score: " + avgScore());
	}
}