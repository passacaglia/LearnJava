/**
*1.�����׳�  ԭ�з����׳��쳣��  �ĸ�����ϲ��ࡣ
*2.�׳����쳣����Ŀ  ���ɱ�ԭ�еķ��� �׳��Ļ��ࡣ
*
*ֻҪ��д�ķ����׳����쳣��  �����Զ�������ת����  ���������������쳣�࣬�Ǿ�OK��
*This program test rule2.
**/
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TestExceptionAndMethodOverrideE2 {
	public void method() throws IOException, RuntimeException {
	}
}

//������׳���java.sql.SQLException�����С�
class B1 extends TestExceptionAndMethodOverrideE2 {
	public void method() throws FileNotFoundException, ArithmeticException, java.sql.SQLException {
	}
}

//NullPointerException����ת����RuntimeException���ʿ����������롣
class B2 extends TestExceptionAndMethodOverrideE2 {
	public void method() throws FileNotFoundException, ArithmeticException, NullPointerException {
	}
}