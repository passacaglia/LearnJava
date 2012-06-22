public class EveryOtherFive
{
	public static void main(String[] args) 
	{
		for (int i=5;i<=100;i+=5)//when i<=15,ererything looks beautiful,however,when i>=25,seems not good!
		{
			if (i%10==5)
			{
				for (int j=5;j<=100;j+=5)
				{
					if (j%10==5)
					System.out.print(i + "*" + j + "=" +i*j +"\t");// print & println (difference)
				}
				System.out.print("\n");
			}	
		}
	}
}
