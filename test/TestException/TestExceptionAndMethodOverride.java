/**
*1.�����׳�  ԭ�з����׳��쳣��  �ĸ�����ϲ��ࡣ
*2.�׳����쳣����Ŀ  ���ɱ�ԭ�еķ��� �׳��Ļ��ࡣ
*
*ֻҪ��д�ķ����׳����쳣��  �����Զ�������ת����  ���������������쳣�࣬�Ǿ�OK��
*This program test rule1.
**/
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TestExceptionAndMethodOverride {
	public void method() throws IOException {
	}
}

class A1 extends TestExceptionAndMethodOverride {
	public void method() throws FileNotFoundException {
	} 
}

//�׳���IOException�ĸ��࣬�ʳ���
class A2 extends TestExceptionAndMethodOverride {
	public void method() throws Exception {
	}
}