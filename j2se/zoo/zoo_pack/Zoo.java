package zoo_pack;

public class Zoo
{
	public static void main(String[] args) 
	{
		Animal a1=new zoo_pack.Animal();
		zoo_pack.Animal a2=new zoo_pack.birds.Bird();
		zoo_pack.Animal a3=new zoo_pack.birds.Ostrich();
		zoo_pack.Animal a4=new zoo_pack.aquatic.Fish();
		zoo_pack.Animal a5=new zoo_pack.carnivorous.Lion();

		zoo_pack.birds.Bird bird1=new zoo_pack.birds.Bird();
		zoo_pack.birds.Bird bird2=new zoo_pack.birds.Bird();
		zoo_pack.birds.Ostrich ostrich1=new zoo_pack.birds.Ostrich();
		zoo_pack.Animal ostrich2=new zoo_pack.birds.Ostrich();//call it Animal,so you can only use method & attribute in Animal;new attribute | method in Ostrich can not be used

		zoo_pack.aquatic.Fish fish1=new zoo_pack.aquatic.Fish();
		zoo_pack.aquatic.Fish fish2=new zoo_pack.aquatic.Fish();
		zoo_pack.aquatic.Fish fish3=new zoo_pack.aquatic.Fish();
		zoo_pack.aquatic.Fish fish4=new zoo_pack.aquatic.Fish();

		zoo_pack.carnivorous.Lion lion1=new zoo_pack.carnivorous.Lion();
		zoo_pack.carnivorous.Lion lion2=new zoo_pack.carnivorous.Lion();
		
		System.out.println("\nHi:");
		System.out.println("There are "+Animal.getCount()+" animals in total.");//remember "()",when you are calling a method
		System.out.println(bird1.getKind() + " has" + bird1.getLegs() + " legs.");
		System.out.println(ostrich1.getKind() + " has " + ostrich1.getLegs() + " legs.");
		System.out.println(fish1.getKind() + " has " + fish1.getLegs() + " legs.");
		System.out.println(lion1.getKind() + " has " + lion1.getLegs() + " legs.");
		((zoo_pack.birds.Ostrich)ostrich2).hideHead();//force;convert;

	}
}
