public class Exercise2 {
		public void method(int i) {}
}

class Exercise2_ extends Exercise2 {
	public void method (int i) {}//A
	private void method (int j) {}//B
	public int method (int i) {}//C
	public float method (float f) {}//D
	private String method (String s) {}//E
}

/*
*The wrong override will display on the screen.
*And,for D & E.They are completely new method(��ͬ�ķ���ֵ����),so they were wrong too.
*�Ϸ��ĸ�����Ҫ����ͬ�ģ�����ֵ���͡����������������͡���ͬ���߸��ӿ��ŵ��޶��ʡ�
*
*�Ϸ���������Ҫ����ͬ�ķ����������Ҵ��ݵĲ�������һ��Ҫ��ͬ��������ͬʱҲ�����ء��޶��ʡ�����ֵ����Ҫ��
*/

