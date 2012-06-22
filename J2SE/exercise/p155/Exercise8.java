public class Exercise8 {
	public Exercise8 (int i) {}
	public Exercise8 (int i, float f) {}
	
	Exercise8 q1 = new Exercise8();//A 这个不行，没有相应的构造函数
	Exercise8 q2 = new Exercise8(10);//B
	Exercise8 q3 = new Exercise8(10,10);//C
	//Exercise8 q4 = new Exercise8(10,10.0);//D 这个不行，编译时就出错了。10.0默认是double型。
	Exercise8 q5 = new Exercise8(10,10.0f);//E
}

//可以产生Exercise8对象的：B C E