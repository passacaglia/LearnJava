//面向对象的写法

public class Count3Quit2 {
	public static void main(String args[]) {
		CircleKid ck = new CircleKid(500);
		int countNum = 0;//数1， 2， 3。
		Kid k = ck.first;//第一个小孩
		
		while (ck.index > 1) {
			countNum ++;
			if (countNum == 3) {
				countNum = 0;
				ck.delKid(k);
			}
			//无论如何，数完一个数，跳到下一个小孩。【这种，相当于k不动，圈子动】
			k = k.right;
		}
		
		System.out.println("The " + (ck.first.id + 1) + "th kid.");
	}
	
}

class Kid {
	int id;//小孩的号
	Kid left, right;//小孩的左边、右边
}

class CircleKid {
	int index = 0;//用来表示小孩的个数
	Kid first, last;//第一个，最后一个
	
	CircleKid(int n) {
		for (int i=0; i<n; i++) {
			addKid();
		}
	}
	
	void addKid() {
		//要添加的小孩new出来。
		Kid k = new Kid();
		k.id = index;
		
		//如果圈子里没小孩
		if (index <= 0) {
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		} else {//其他
			first.left = k;
			last.right = k;
			k.right = first;
			k.left = last;
			last = k;
		}
		
		//每添加一个小孩，总数加一。
		index ++;
	}
	
	void delKid(Kid k) {
		//圈子里小孩个数为0
		if (index <= 0) {
			return;
		} else if (index == 1) {//圈子里小孩个数为1
			last = first = null;
		} else {
			k.left.right = k.right;
			k.right.left = k.left;
			
			if (k == first) {
				first = k.right;
			} else if (k == last) {
				last = k.left;
			}
		}
		
		//每减少一个小孩，总数减一
		index --;
	}
	
}