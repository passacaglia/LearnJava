/**
*1.不可抛出  原有方法抛出异常类  的父类或上层类。
*2.抛出的异常类数目  不可比原有的方法 抛出的还多。
*
*只要重写的方法抛出的异常类  可以自动将类型转换成  父类中所声明的异常类，那就OK。
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

//抛出了IOException的父类，故出错
class A2 extends TestExceptionAndMethodOverride {
	public void method() throws Exception {
	}
}