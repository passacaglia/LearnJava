public class Exercise8 {
	public Exercise8 (int i) {}
	public Exercise8 (int i, float f) {}
	
	Exercise8 q1 = new Exercise8();//A ������У�û����Ӧ�Ĺ��캯��
	Exercise8 q2 = new Exercise8(10);//B
	Exercise8 q3 = new Exercise8(10,10);//C
	//Exercise8 q4 = new Exercise8(10,10.0);//D ������У�����ʱ�ͳ����ˡ�10.0Ĭ����double�͡�
	Exercise8 q5 = new Exercise8(10,10.0f);//E
}

//���Բ���Exercise8����ģ�B C E