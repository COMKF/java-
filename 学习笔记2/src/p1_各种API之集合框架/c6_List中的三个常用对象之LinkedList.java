package p1_����API֮���Ͽ��;

/* Linklist���й��ܣ�
 * 1.���
 * 1.1��Ԫ����ӵ��б�Ŀ�ͷ  public void addFirst(E e)
 * 1.2��Ԫ����ӵ��б�Ľ�β  public void addLast(E e)
 * ���䣺jdk1.6�Ժ�offer�����add��offer�����ڲ����ɹ���᷵��true����add������ʲô�������ء�
 * 2.ɾ��
 * 2.1ɾ���б��е�һ��Ԫ��  public E removeFirst()	//�ҽ���Ԫ�ط���
 * 2.1ɾ���б������һ��Ԫ��  public E removeLast()	//�ҽ���Ԫ�ط���
 * ���䣺jdk1.6�Ժ�poll�����remove����Ϊremove�������б�Ϊ��ʱ�׳��쳣����poll�������б�Ϊ��ʱ����null
 * 3.��ȡ
 * 3.1��ȡ�б��е�һ��Ԫ��  public E getFirst()
 * 3.2��ȡ�б������һ��Ԫ��  public E getLast()
 * ���䣺��jdk1.6�Ժ�peek�����get����Ϊget�������б�Ϊ��ʱ�׳��쳣����peek�������б�Ϊ��ʱ����null
 * �ɼ�Linkedlist�����в�����������Ƕ���β�Ĳ���
 */

import java.util.Iterator;
import java.util.LinkedList;

public class c6_List�е��������ö���֮LinkedList {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.offerFirst("abc1");
		l.addFirst("abc2");
		l.addFirst("abc3");
		l.addLast("abc4");

		for (Iterator it = l.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println("******");

		System.out.println(l.getFirst());
		System.out.println(l.getFirst());
		System.out.println("******");

		System.out.println(l.removeFirst());
		System.out.println(l.removeFirst());
	}
}
