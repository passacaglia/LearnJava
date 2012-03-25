/**
*Ŀ¼��
*�ݹ�ķ���
*˼������δ�ӡ�����ߣ���ΰ�Ŀ¼�����������в������룿
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