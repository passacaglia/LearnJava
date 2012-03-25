public class TestArray {
	
	public static void main(String args[]) {
		int a [] = new int[5];
		int [] b = new int[5];
		int c[] = new int[5];

		System.out.print("\n\na[]:\n");		
		for (int i=0;i<a.length;i++) {//注意i的起始值
			a[i] = i+1;
			System.out.print(a[i] + "\t");
		}
		
//循环复制
		System.out.print("\n\nb[]:\n");
		for (int i=0;i<a.length;i++) {
			b[i] = a[i];
			System.out.print(b[i] + "\t");
		}

//System.arraycopy
		System.arraycopy(a,0,c,1,a.length-1);//c是从第二个数开始复制的，故c[0]=0;

		System.out.print("\n\nc[]: \n");		
		for (int i=0;i<c.length;i++) {
			System.out.print(c[i] + "\t");
		}
		
//对象数组
		TestArrayObj obj[] = new TestArrayObj[7];//生成对象数组
		obj[0] = new TestArrayObj();//生成对象实例
		/*for (int i=0;i<7;i++) {
			System.out.println(obj[i]);
		}*/
		System.out.println("\n\nobj[0].q = " + obj[0].q);//如果这里是obj[5].q，就会出现NullPointerException的错误。因为obj[5]还没有生产对象实例，现在只是个对象的引用（即声明）。只有生成了对象实例，即把声明和实例 关联起来才能正常使用。
	
//多维数组
		int d[][] = new int[3][2];//规则的多维数组
		
		int e[][] = new int[3][];///不规则的数组
		e[0] = new int[1];//e[0]里面有1个
		e[1] = new int[2];//e[1]里面有2个
		e[2] = new int[3];
		
		//print d[][]
		System.out.print("\nd[][]:\n\n");		
		for (int i=0;i<d.length;i++) {
			for (int j=0;j<d[i].length;j++) {
				d[i][j] = j;
				System.out.print("d[" + i + "][" + j + "]:" + "\t");//d[i][j]
				System.out.print(d[i][j] + "\n");//value
			}
			System.out.println("d.length = " + d.length + ".\nd[" + i + "].length = " + d[i].length + ".\n");
		}

		//print e[][]
		System.out.print("\ne[][]:\n\n");
		for (int i=0;i<e.length;i++) {
			for (int j=0;j<e[i].length;j++) {
				e[i][j] = j;
			System.out.print("e[" + i + "][" + j + "]:" + "\t");//e[i][j]
			System.out.print(e[i][j] + "\n");//value
			}
			System.out.println("e.length = " + e.length + ".\ne[" + i + "].length = " + e[i].length + ".\n");
		}
	}
}