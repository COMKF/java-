package p1_����API֮���Ͽ��;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* ��ֵ�кܶ࣬������棬�����кܶ࣬�ö�ά����档�����кܶ࣬�ö���棬�����кܶ࣬�ü��ϴ档
 * ���ϣ��������ڷ�װ�ص����ݣ����������Ҫ�洢��������������ȷ��������Ҫ�ü��Ͻ��д洢��
 * �ص㣺
 * 1.���ڴ洢���������
 * 2.���ϳ��ȿɱ�
 * 3.���ܴ洢������������ֵ
 */
/* ����������Ϊ�ڲ������ݽṹ��ͬ���ж��־���������
 * �������ϳ�ȡ�����γ��˼��Ͽ�ܡ�
 * �������ܵĶ��㣬����  ���ӿ�Collection
 * Collection�����У�
 * 1.���
 * 1.1���һ���������������  boolean add(E e);//�����E����object
 * 1.2���һ�������еĶ���ָ��������  boolean addAll(Collection c);
 * 2.ɾ��
 * 2.1ɾ��һ�������еĶ��� boolean remove(Object o);
 * 2.2ɾ��һ����������ЩҲ������ָ�������е����ж���  boolean removeAll(Collection c);
 * 2.3��ն��� void clear();
 * 3.�ж�
 * 3.1�ж�һ���������Ƿ���ָ������ boolean contains(Object o);
 * 3.2�ж�һ���������Ƿ������ָ�����ϵ����ж���   boolean containsAll(Collection c);
 * 3.3�жϼ����Ƿ�Ϊ�� boolean isEmpty();
 * 4.��ȡ
 * 4.1.��ȡ���ϵĳ��� int size();
 * 4.2�õ������ķ�����ȡ�����е�Ԫ��  Iterator iterator();
 * 		�ö�����������ھ�����������Ϊÿһ�����������ݽṹ����ͬ�����Ըõ������������������н����ڲ�ʵ�ֵġ�
 * 		��������ʹ���߶��ԣ������ʵ�ֲ�����Ҫ��ֻҪͨ��������ø�ʵ�ֵĵ��������󼴿ɣ�Ҳ����iterator()������
 * 		iterator�ӿھ��Ƕ�����Collection��������Ԫ��ȡ���ĸ��ӿڡ�
 * 5.����
 * 5.1ȡ���� boolean retainAll(Collection c);
 * 5.2������ת��������   Object[] toArray();
 */

public class c1_���Ͽ�ܵĸ��� {

	public static void main(String[] args) {
		Collection coll = new ArrayList();// Collection�ǽӿڣ��ӿڲ���ʵ��������������Ҫʵ��ʵ�ֽӿڵ��࣬��������ArrayList
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		// show(coll);
		show(c1, c2);
	}

	private static void show(Collection c1, Collection c2) {
		c1.add("12");
		c1.add("123");
		c1.add("1234");
		c1.add("12345");

		c2.add("ab");
		c2.add("123");
		c2.add("abcd");
		c2.add("abcde");

		// ����ÿ����ʾһ�����ܣ������๦��ע�͵�
		// c1.addAll(c2);//1.2
		// System.out.println(c1);

		// System.out.println(c1.removeAll(c2));//2.2,�����������е���ͬԪ�شӵ���removeAll�����ļ�����ɾ��
		// System.out.println(c1);

		// System.out.println(c1.containsAll(c2));//3.2���������ȫ��Ԫ�أ��Ż᷵��true
		// System.out.println(c1);

		System.out.println(c1.retainAll(c2));// 5.1��ȡ������������ָ��������ͬ��Ԫ�أ���ɾ����ͬ��Ԫ�أ���removeAll�����෴
												// ����֤����������Ľ����Ϊtrue
	}

	public static void show(Collection coll) {
		coll.add("123");// 1.1
		coll.add("1234");// 1.1
		coll.add("12345");// 1.1
		System.out.println(coll);
		System.out.println(coll.size());// 4.1
		System.out.println(coll.toArray());// 5.2

		coll.remove("1234");// 2.1�����ϵ�ɾ�����ܻ�ı伯�ϵĳ���
		System.out.println(coll);
		coll.clear();// 2.3
		System.out.println(coll);

		System.out.println(coll.contains("123"));// 3.1
		System.out.println(coll.isEmpty());// 3.3

	}

}
