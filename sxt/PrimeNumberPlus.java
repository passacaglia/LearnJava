public class PrimeNumberPlus
{
	public static void main(String[] args) 
	{
		int count = 0;//beautiful on screen.And it should be put outside of the next for circle
		for (int i=2; i<100 ; i++)
		{
			boolean f = true;
			for (int j=2; j<i ; j++)//start from 2.if 1,you are terminated!
			{
				
				if (i % j == 0)
				{
					f = false;
					break;
				}
			}

			if (!f)
			{
				continue;
			}
			
			System.out.print(i + "\t");
			
			count++;
			if (count%5 == 0)
			{
				System.out.print("\n");
			}
		}

		System.out.println("\n");

		
//1 to 100,can be / by 3
		int n=1,mp=1;
		do 
		{
			mp=3*n;
			System.out.print(mp + "\t");
			n++;
			count++;
			if (count%5 == 0)
			{
				System.out.print("\n");
			}
		} while ( mp < 99 );//think from the opposite side.if mp<100,it will do another mp=3*n.now 102.//97,98,99,ok.

//another method.the first five numbers
		System.out.println("\n");
		count = 0;
		for (int i=1; i<100 ; i++)
		{
			if (i % 3 == 0)
			{
				System.out.print(i + "\t");
				count++;
			}
			if (count == 5)
			{
				break;
			}
		}
	}
}
