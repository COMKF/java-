package p4_���Ͽ�ܹ�����;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/* Collections�Ǽ��Ͽ�ܹ����࣬����ķ������Ǿ�̬�ġ�
 * �����������Collections�ĸ��ַ�����
 */
public class c1_Collections�ĸ��� {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		System.out.println(l);
		//��List���Ͻ�������
//		Collections.sort(l);	//sort����������sort����ʵ��ԭ����ã�������ܣ���ʹ��Ҳ����
//		mysort(l);
//		Collections.sort(l,new ComparaByLength());//����Ƚ�����sort������������ʵ��ԭ����ã�������ܣ���ʹ��Ҳ����
		mysort(l,new ComparaByLength());
		
		System.out.println(l);
		
	}

	private static <T extends Comparable<? super T>> void mysort(List<T> l) {	//Collections.sort����ʵ��ԭ����T����չ�ԱȽϸ�
		for (int i = 0; i < l.size()-1; i++) {
			for (int j = i+1; j < l.size(); j++) {
				if (l.get(i).compareTo(l.get(j))>0) {
					Collections.swap(l, i, j);
//					T temp = l.get(i);		//Collections.swap����ʵ��ԭ��
//					l.set(i, l.get(j));
//					l.set(j,temp);
				}
			}
		}
	}
	
	private static <T extends Comparable<? super T>> void mysort(List<T> l,Comparator<? super T> comp) {//����Ƚ�����sort������ʵ��ԭ��
		for (int i = 0; i < l.size()-1; i++) {
			for (int j = i+1; j < l.size(); j++) {
				if (comp.compare(l.get(i), l.get(j))>0) {
					Collections.swap(l, i, j);
				}
			}
		}
	}
}

class ComparaByLength implements Comparator<String> { // �����Ƚ���
	public int compare(String o1, String o2) {
		int temp = o1.length() - o2.length();
		return temp == 0 ? o1.compareTo(o2) : temp;
	}
}
