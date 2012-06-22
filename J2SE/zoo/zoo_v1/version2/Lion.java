public class Lion extends Animal
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
