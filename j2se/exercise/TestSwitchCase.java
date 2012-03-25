public class TestSwitchCase 
{
	public static void main(String[] args) 
	{
		char yesNo=' ';

		for (int i=1;i<4 ;i++)
		{
			switch (i)
			{
			case 1:
				yesNo='a';
				System.out.println("\n1.");
				break;
			case 2:
				yesNo='x';
				System.out.println("\n2.");
				break;
			case 3:
				yesNo='y';
				System.out.println("\n3.");
				break;
			}

			switch (yesNo)
			{
			case 'y':
			case 'Y':
				System.out.println("\nYour answer is YES!");
				break;
		
			case 'x':
			case 'X':
				System.out.println("\nYour answer is NO!");
				break;
		
			default://给其他情况准备的
				System.out.println("\n Wrong input!");
			}

		}


	}
}
