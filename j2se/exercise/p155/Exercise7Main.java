public class Exercise7Main extends Exercise7 {

//��ΪExercise7û���޲�����constructor��Ϊ����Java�Զ������޲�����constructor������������Ҫ�ֶ���������һ����
	public Exercise7Main(int i) {
		super(i);
	}
	
	public static void main(String args[]) {
		Exercise7 q1;
		q1 = new Exercise7(10);
		System.out.println(q1.i);
	}
}