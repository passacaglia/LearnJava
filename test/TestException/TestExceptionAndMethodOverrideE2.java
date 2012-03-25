/**
*1.不可抛出  原有方法抛出异常类  的父类或上层类。
*2.抛出的异常类数目  不可比原有的方法 抛出的还多。
*
*只要重写的方法抛出的异常类  可以自动将类型转换成  父类中所声明的异常类，那就OK。
*This program test rule2.
**/
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TestExceptionAndMethodOverrideE2 {
	public void method() throws IOException, RuntimeException {
	}
}

//这里多抛出了java.sql.SQLException，不行。
class B1 extends TestExceptionAndMethodOverrideE2 {
	public void method() throws FileNotFoundException, ArithmeticException, java.sql.SQLException {
	}
}

//NullPointerException可以转换成RuntimeException，故可以正常编译。
class B2 extends TestExceptionAndMethodOverrideE2 {
	public void method() throws FileNotFoundException, ArithmeticException, NullPointerException {
	}
}