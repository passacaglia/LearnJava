public class TestArray {
	
	public static void main(String args[]) {
		int a [] = new int[5];
		int [] b = new int[5];
		int c[] = new int[5];

		System.out.print("\n\na[]:\n");		
		for (int i=0;i<a.length;i++) {//ע��i����ʼֵ
			a[i] = i+1;
			System.out.print(a[i] + "\t");
		}
		
//ѭ������
		System.out.print("\n\nb[]:\n");
		for (int i=0;i<a.length;i++) {
			b[i] = a[i];
			System.out.print(b[i] + "\t");
		}

//System.arraycopy
		System.arraycopy(a,0,c,1,a.length-1);//c�Ǵӵڶ�������ʼ���Ƶģ���c[0]=0;

		System.out.print("\n\nc[]: \n");		
		for (int i=0;i<c.length;i++) {
			System.out.print(c[i] + "\t");
		}
		
//��������
		TestArrayObj obj[] = new TestArrayObj[7];//���ɶ�������
		obj[0] = new TestArrayObj();//���ɶ���ʵ��
		/*for (int i=0;i<7;i++) {
			System.out.println(obj[i]);
		}*/
		System.out.println("\n\nobj[0].q = " + obj[0].q);//���������obj[5].q���ͻ����NullPointerException�Ĵ�����Ϊobj[5]��û����������ʵ��������ֻ�Ǹ���������ã�����������ֻ�������˶���ʵ��������������ʵ�� ����������������ʹ�á�
	
//��ά����
		int d[][] = new int[3][2];//����Ķ�ά����
		
		int e[][] = new int[3][];///�����������
		e[0] = new int[1];//e[0]������1��
		e[1] = new int[2];//e[1]������2��
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