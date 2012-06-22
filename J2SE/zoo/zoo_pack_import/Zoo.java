/**
*Animal a1 = new Animal(3);
*(3) is wrong.
**/

package zoo_pack_import;//add package settings to every file is much better.including this one.

import zoo_pack_import.birds.*;
import zoo_pack_import.carnivorous.Lion;
import zoo_pack_import.aquatic.Fish;
import zoo_pack_import.Animal;

public class Zoo
{
	public static void main(String[] args) 
	{
		Animal a1=new Animal(3);
		Animal a2=new Bird();
		Animal a3=new Ostrich();
		Animal a4=new Fish();
		Animal a5=new Lion();

		Bird bird1=new Bird();
		Bird bird2=new Bird();
		Ostrich ostrich1=new Ostrich();
		Animal ostrich2=new Ostrich();//call it Animal,so you can only use method & attribute in Animal;new attribute | method in Ostrich can not be used

		Fish fish1=new Fish();
		Fish fish2=new Fish();
		Fish fish3=new Fish();
		Fish fish4=new Fish();

		Lion lion1=new Lion();
		Lion lion2=new Lion();
		
		System.out.println("\nHi:");
		System.out.println("There are "+Animal.getCount()+" animals in total.");//remember "()",when you are calling a method
		System.out.println(bird1.getKind() + " has" + bird1.getLegs() + " legs.");
		System.out.println(ostrich1.getKind() + " has " + ostrich1.getLegs() + " legs.");
		System.out.println(fish1.getKind() + " has " + fish1.getLegs() + " legs.");
		System.out.println(lion1.getKind() + " has " + lion1.getLegs() + " legs.");
		((Ostrich)ostrich2).hideHead();//force;convert;

	}
}
