public class Ostrich extends Bird
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
