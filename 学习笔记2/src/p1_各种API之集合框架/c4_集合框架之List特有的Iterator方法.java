package p1_����API֮���Ͽ��;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class c4_���Ͽ��֮List���е�Iterator���� {

	public static void main(String[] args) {
		List l = new ArrayList();
		show(l);
	}

	private static void show(List l) {
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		/*
		 * for (Iterator it = l.iterator(); it.hasNext();)
		 * {//���Ǹ������Ϲ��еķ������õ�����ȡԪ�أ���Ϊ���ӿ�Collection���� iterator����
		 * System.out.println(it.next()); }
		 */
		/*
		 * for (int i = 0; i < l.size(); i++) { //����List���е�ȡ��Ԫ�ط�ʽ֮һ
		 * System.out.println("get:"+l.get(i)); }
		 */
		/*
		 * for (Iterator it = l.iterator(); it.hasNext();) { Object
		 * obj=it.next(); if (obj.equals("abc2")) {
		 * l.add("abc9");//java.util.ConcurrentModificationException
		 * ,��������⵽����Ĳ����޸ģ����������޸�ʱ���׳����쳣 //�ڵ����������У���ʹ�ü��Ͻ��в������ͻ�����쳣�����Ե������о�����
		 * //���������⣬����ʹ��ListIterator(Listר�õ�����) } else {
		 * System.out.println("next:"+obj); }
		 * 
		 * } System.out.println(l);
		 */
		System.out.println(l);
		for (ListIterator it = l.listIterator(); it.hasNext();) {// ListIterator(Listר�õ�����)
			// ��ʵ���ڵ�����������ɶ�Ԫ�ص���ɾ�Ĳ飬ע�⣬ֻ��List�������и÷�����

			System.out.println("Previous:" + it.hasPrevious());// �ж��Ƿ���ǰһ��Ԫ�أ����Ը������������������ü���

			Object obj = it.next();
			if (obj.equals("abc2")) {
				// it.add("abc9");//ע�⣬���ﲻ�ü����ˣ������õ���it,add�������ں�������ż���"abc9"
				it.set("abc9");// set������ֱ���滻Ϊ"abc9"
			} else {
				System.out.println("next:" + obj);
			}
			System.out.println("Next:" + it.hasNext());// �ж��Ƿ��к�һ��Ԫ�أ����Ը���������������ü���

			System.out.println("Previous:" + it.hasPrevious());// �ж��Ƿ���ǰһ��Ԫ�أ����Ը������������������ü���
		}
		System.out.println(l);
	}
}
