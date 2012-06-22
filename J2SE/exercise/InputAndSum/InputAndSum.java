/**
*The purpose of this program is to let you input two numbers,then the program will add them and give the sum to you.
*You can run the program in the command line window,and you can run it in the internet browser too.
*
*When you run the program in the command line window,remember to add two cmd-line arguments.
*Here we have two ways to solve to input problem.
*cmd-line arguments & system arguments (They shouldn't exist together)
**/

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class InputAndSum extends java.applet.Applet{
		
	InputAndSum ias = new InputAndSum();
	
	public static void main(String args[]) {
		System.out.println("Remeber that you have input two numbers, less or more numbers won't work!!");
		
		int s1 = 0;
		int s2 = 0;
		
		//command line arguments
		//use it like: "java InputAndSum 472 99"
		//Firstly,check the numbers if it is two.
		if (args.length != 2) {
			System.out.println("Sorry, you should input two numbers.\n Sample : 'java InputAndSum 472 99' \nAnd now, the program will exit!");
			System.exit(250);
		}
		
		try {
			s1 = Integer.parseInt(args[0]);
			s2 = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e) {
			System.out.println("\nHey , are you sure that what you have input is numbers?");
			System.exit(250);
		}
		
		//system arguments
		//use it like: "java -DP1=223 -DP2=87 InputAndSum"
		//暂时没有能够检验多余两个参数的方法！！！
		/*if (System.getProperty("P1") != null & System.getProperty("P2") != null) {
			try {
				s1 = Integer.parseInt(System.getProperty("P1"));
				s2 = Integer.parseInt(System.getProperty("P2"));
			}
			catch (NumberFormatException e) {
				System.out.println("\nHey, are you sure that what you have input is numbers?");
				System.exit(250);
			}
		}
		else {
			System.out.println("\nMake sure that you have input the right numbers. \n Sample : 'java -DP1=223 -DP2=87 InputAndSum'");
			System.exit(250);
		}*/
		
		System.out.println("Sum = " + (s1+s2));
	}
	
	public void init() {
		int s1 = 0;
		int s2 = 0;
		int sum = 0;
		
		try {
			s1 = Integer.parseInt(getParameter("par1"));
			s2 = Integer.parseInt(getParameter("par2"));
	  }
	  catch (NumberFormatException e) {
	  	System.out.println("What we need is numbers!!");
	  	System.exit(250);
	  }
		
		sum = s1 + s2;
	}

//这里有一个遗留问题，就是还没找到在applet中显示sum的方法//参考j2/ch3/MyFirst.java
//P237 
	public void paint(java.awt.Graphics g) {
		//InputAndSum ias = new InputAndSum();
		g.drawString("" , 30, 30);
	}
	
}

