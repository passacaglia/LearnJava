class Exercise1
{
	public static void main(String[] args) 
	{
		int i=100;
		i=((i++ >> 35)>>32)%10;
		System.out.println(i);
	}
}
