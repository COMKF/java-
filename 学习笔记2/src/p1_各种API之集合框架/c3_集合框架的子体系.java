package p1_����API֮���Ͽ��;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Collection������������ϵ��List��Set
 * List����������С��˽ӿڵ��û����Զ��б���ÿ��Ԫ�صĲ���λ�ý��о�ȷ�Ŀ��ƣ��û����Ը���Ԫ�����б��е���������������Ԫ�أ��������б��е�Ԫ�ء�
 * 		List�е�Ԫ�ؿ����ظ�
 * Set���������ظ�Ԫ�ص����У�����(ĳЩ����£��п��ܻ�����)�����������һ��null��
 */
/* List��Collection�����࣬���ڶԹ��з�������˵����ֻ�о�List�����з�����
 * List�����з�����һ�������ص㣬�Ǿ��Ƕ����Բ����űꡣ
 * 1.���
 * 1.1���ݽű����Ԫ�� void add(int index, E element);
 * 1.2���ݽű����ָ�������е�Ԫ�� boolean addAll(int index, Collection c);
 * 2.ɾ��
 * 2.1���ݽű�ɾ��Ԫ��    E remove(int index);//���ص��Ǳ�ɾ����Ԫ��
 * 3.�޸�
 * 3.1���ݽű��޸�Ԫ��    E set(int index, E element);
 * 4.��ȡ
 * 4.1���ݽű��ȡԪ��    E get(int index);
 * 4.2����ָ��Ԫ�صĵ�һ�γ��ֵ�λ��  int indexOf(Object o);
 * 4.3����ָ��Ԫ�ص����һ�δγ��ֵ�λ��     int lastIndexOf(Object o);
 * 4.4��ȡһ��List(����ͷ��������β)  List subList(int fromIndex, int toIndex);
 * ���ԣ�List�ǿ�����ɶ�Ԫ�ص���ɾ�Ĳ�ġ�
 */
public class c3_���Ͽ�ܵ�����ϵ {

	public static void main(String[] args) {
		List l = new ArrayList();
		show(l);
	}

	private static void show(List l) {
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		System.out.println(l);

		l.add(1, "999");// 1.1
		System.out.println(l);

		System.out.println(l.remove(3));// 2.1
		System.out.println(l);

		System.out.println(l.set(1, "888"));// 3.1
		System.out.println(l);

		System.out.println(l.get(2));// 4.1
	}

}
