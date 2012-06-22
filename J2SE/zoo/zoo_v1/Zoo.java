public class Zoo
{
	public static void main(String[] args) 
	{
		Animal animal1 = new Animal();
		Animal animal2;
			animal2 = new Animal();
		
		animal1.legs=4;
		
		System.out.println("Animal1 has " +animal1.legs+ " legs");
		System.out.println("Animal1 has " +animal2.legs+ " legs");

		animal1.eat();
		animal2.move();
	}
}
