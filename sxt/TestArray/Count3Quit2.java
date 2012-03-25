//��������д��

public class Count3Quit2 {
	public static void main(String args[]) {
		CircleKid ck = new CircleKid(500);
		int countNum = 0;//��1�� 2�� 3��
		Kid k = ck.first;//��һ��С��
		
		while (ck.index > 1) {
			countNum ++;
			if (countNum == 3) {
				countNum = 0;
				ck.delKid(k);
			}
			//������Σ�����һ������������һ��С���������֣��൱��k������Ȧ�Ӷ���
			k = k.right;
		}
		
		System.out.println("The " + (ck.first.id + 1) + "th kid.");
	}
	
}

class Kid {
	int id;//С���ĺ�
	Kid left, right;//С������ߡ��ұ�
}

class CircleKid {
	int index = 0;//������ʾС���ĸ���
	Kid first, last;//��һ�������һ��
	
	CircleKid(int n) {
		for (int i=0; i<n; i++) {
			addKid();
		}
	}
	
	void addKid() {
		//Ҫ��ӵ�С��new������
		Kid k = new Kid();
		k.id = index;
		
		//���Ȧ����ûС��
		if (index <= 0) {
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		} else {//����
			first.left = k;
			last.right = k;
			k.right = first;
			k.left = last;
			last = k;
		}
		
		//ÿ���һ��С����������һ��
		index ++;
	}
	
	void delKid(Kid k) {
		//Ȧ����С������Ϊ0
		if (index <= 0) {
			return;
		} else if (index == 1) {//Ȧ����С������Ϊ1
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
		
		//ÿ����һ��С����������һ
		index --;
	}
	
}