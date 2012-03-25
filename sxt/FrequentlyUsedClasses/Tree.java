/**
*目录树
*递归的方法
*思考：如何打印出虚线？如何把目录名当作命令行参数传入？
**/
import java.io.File;

public class Tree {
	public static void main(String[] args) {
		File f = new File("A");
		//File f = new File("D:/A");
		System.out.println(f.getName());
		tree(f, 1);
	}
	
	static void tree(File f, int level) {
		String space = "";
		for (int i=0; i<level; i++) {
			space += "	";
		}
		
		
		File[] childs = f.listFiles();
		for (int i=0; i<childs.length; i++) {
			System.out.println(space + childs[i].getName());
			if (childs[i].isDirectory()) {
				tree(childs[i], level + 1);
			}
		}
	}
}