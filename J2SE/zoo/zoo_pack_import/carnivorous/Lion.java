package zoo_pack_import.carnivorous;

public class Lion extends zoo_pack_import.Animal
{
//attribute
	static private int count;

//constructor
	public Lion()
	{
		super(4);
		setKind("Lion");
		count++;
	}

//method
	static public int getCount()
	{
		return count;
	}
}
