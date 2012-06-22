public class Animal
{
//attribute
	private int legs;
	private String kind;
	static private int count;
//constructor
	public Animal()
	{
		setLegs(4);
		count++;
	}
	public Animal(int l)
	{
		setLegs(l);
		count++;
	}
//method
	public void eat()
	{
		System.out.println("Eating...");
	}
	public void move()
	{
		System.out.println("Moving...");
	}

	public void setLegs(int l)
	{
		if (l!=0 && l!=2 && l!=4)
		{
			System.out.println("Are you kidding me?" + l +"legs??");
			return;//don't forget this.Take you back to where you find this.
		}
		legs=l;
	}
	public int getLegs()
	{
		return legs;//return, give the value to the object who is calling it.
	}

	public void setKind(String str)
	{
		kind=str;
	}
	public String getKind()
	{
		return kind;
	}

	static public int getCount()
	{
		return count;
	}
}
