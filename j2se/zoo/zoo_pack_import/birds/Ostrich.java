package zoo_pack_import.birds;

public class Ostrich extends zoo_pack_import.birds.Bird
{
//attribute
	static private int count;

//constructor
	public Ostrich()
	{
		super(2);
		setKind("Ostrich");
		count++;
	}

//method
	public void move()
	{
		System.out.println("Running...");
	}
	public void hideHead()
	{
		System.out.println("Look,ostrich is hidding the head...");
	}

	static public int getCount()
	{
		return count;
	}
}
