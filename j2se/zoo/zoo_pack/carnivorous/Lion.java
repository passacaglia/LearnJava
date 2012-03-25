package zoo_pack.carnivorous;

public class Lion extends zoo_pack.Animal
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
