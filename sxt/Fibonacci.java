public class Fibonacci
{
	public static void main(String[] args) 
	{
		System.out.println(fib(-999));
		System.out.println(fibonacci(89));
		System.out.println(printfib(5));
	}

	public static long fib(int n)
	{
		if (n<1)
		{
			System.out.println("\nHey,that is a bad parameter!");
			return 0;
		}
		if (n == 1 | n == 2)
		{
			return 1;
		}
		else 
		{
			return fib(n-1) + fib(n-2);
		}
	}

	public static long fibonacci(int index)
	{
		if (index == 1 | index == 2)
		{
			return 1;
		}
		long f1 = 1l;
		long f2 = 1l;
		long f = 0l;
		for (int i=0; i<index-2; i++)
		{
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
	}

	static public int printfib(int index)
	{
		long f1 = 1l;
		long f2 = 1l;
		long f = 0l;
		int count = 2;
		if (index == 1)
		{
			System.out.print(f1);
		}
		else //It is not 'else if' here.
		{
			System.out.print(f1 + "\t" + f2 + "\t");
		
			for (int i=3; i<=index; i++)
			{
				f = f1 + f2;
				System.out.print(f + "\t");
				f1 = f2;
				f2 = f;
				count++;
				if (count == 5)
				{
					System.out.println("\n");
				}
			}
		}
		System.out.println("Total:");
		return index;
	}
}
