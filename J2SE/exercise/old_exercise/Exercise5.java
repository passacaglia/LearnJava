public class Exercise5
{
	public static void main(String[] args) 
	{
		int a,b,sum=0;
		a=6;
		b=4;

		if (a<=b)
		{
			while (a<=b)
				sum+=a++;
		}
		else 
		{
			while (a>b)
			{
				sum+=b++;
			}
			sum+=a;
		}
		System.out.println(sum);
	}
}
