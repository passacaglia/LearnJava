public class TestConvert
{
	public static void main(String[] args) 
	{
		int i=1;
		int j=1;

		float f1=0.1f;//it is a float in the computer;
		float f11 = (float)0.1;//still a double
		float f2=123;
		
		long l1=12345678;
		long l2=88888888;
		double d1=2e20,d2=124;
		
		byte b1=1,b2=2,b3=127;
		j=j+10;
		i=i/10;
		i=(int)(i*0.1);
		char c1='a',c2=123;
		byte b= (byte)(b1-b2);//might be a mistake:byte--int
		int bbb=b1-b2;
		char c= (char)(c1+c2-1);//another mistake:char-->>int
		int cc= c1+c2-1;
		
		float f3=f1+f2;//f1 is float type;f2 is int type defaultly,will convert to float,that is ok;
		float f4=(float)(f1+f2*0.1);//0.1-->>double
		double d=d1*i+j;
		float f=(float)(d1*5+d2);
		System.out.println("Fine.");
	}
}
