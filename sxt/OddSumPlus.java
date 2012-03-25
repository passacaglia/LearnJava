public class OddSumPlus
{
	public static void main(String[] args) 
	{
		int i,sum;
		for (i=1,sum=0;i<=100;i+=2)//1+3+5+...+99 
		{
			sum+=i;
		}
		System.out.println(sum);
		System.out.println(JieCheng());
	}

	static public int JieCheng() 
	{
		int i,j,sum=0;
		for (i=1,j=1;i<=10;i++) 
		{
			j*=i;
			sum+=j;
		}

		return sum;
	}

}
