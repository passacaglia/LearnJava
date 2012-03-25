public class Fish extends Animal
{
//attribute
	static private int count;//"static",remember this word when you state a class member.

//constructor
	public Fish()
	{
		super(0);//calling method from father class
		setKind("Fish");
		count++;
	}

//method
	static public int getCount()//static,members of class;more effective under the master of class
	{
		return count;
	}
}
