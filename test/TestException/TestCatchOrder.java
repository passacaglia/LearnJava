/**
*From top to bottom:
*Sub exception ---> Father exception
**/


public class TestCatchOrder {
	public static void main(String args[]) {
		try {
			int i = Integer.parseInt(args[0]);
			int ans = 10 / i;
		}
		catch (RuntimeException re) {
			System.err.println("RuntimeException: " + re);
		}
		catch (ArithmeticException ae) {
			System.err.println("You must input a nonzero number!");
		}
		catch (NumberFormatException ne) {
			System.err.println("You must input an integer number!!");
		}

		catch (Exception e) {
			System.err.println("Exception: " + e);
		}
	}
}