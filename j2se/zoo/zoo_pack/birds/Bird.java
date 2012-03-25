package zoo_pack.birds;

public class Bird extends zoo_pack.Animal //don't forget,extends
{
//attribute
	static private int count;

//constructor
	public Bird()
	{
		super(2);
		setKind("Bird");
		count++;
	}
	public Bird(int l) {
		super(l);
		setKind("Bird");
		count++;
	}

//method
	public void move()
	{
		System.out.println("Flying...");
	}

	static public int getCount()
	{
		return count;
	}
}
