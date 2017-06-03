package p1_����API֮���Ͽ��;

import java.util.HashSet;
import java.util.Iterator;

import bean.Person;

/* Set:Ԫ�ز����ظ�������
 * Set�ӿڷ�����Collection����һֱ��
 * Set�������������
 * 1.HashSet���ڲ����ݽṹ�ǹ�ϣ����ͬ����
 * 2.TreeSet
 */

public class c8_Set�е��������ö���֮HashSet {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		// HashSet hs = new LinkedHashSet();
		//����������Դ���LinkedHashSet������������˹�ϣ��������ʵ�������򡣷�����LinkedList��(���˽�)
		hs.add("xixi");
		hs.add("haha");
		hs.add("hehe");
		hs.add("haha");

		for (Iterator it = hs.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		hs.clear();
		System.out.println("*************");
		// ��HashSet�д洢Person�������������������ͬ����Ϊͬһ�ˣ�����ͬԪ�ء�
		hs.add(new Person("lm1", 21));// add������add(E e)��������al.add(new
										// Person());�У�Person����ʵ������ת��Ϊobject����
		hs.add(new Person("lm2", 22));
		hs.add(new Person("lm3", 23));
		hs.add(new Person("lm4", 24));
		// HashSet���ϵ����ݽṹ�ǹ�ϣ�����Դ洢Ԫ�ص�ʱ��ʹ��Ԫ�ص�hashcode����ȷ��λ�ã����λ����ͬ����ͨ��Ԫ�ص�equals������ȷ���Ƿ���ͬ
		hs.add(new Person("lm3", 23));// ��һ�δ��������ظ���"lm3",
										// 23������Ϊ��������object��hashcode������equals������
										// object�ķ���ֻ���жϵ�ֵַ������ϵͳ��Ϊ�����ǲ�ͬ�Ķ������Գ������ظ���Ԫ�أ���"lm3",
										// 23��
										// �������Ľ���취�������Լ����ݶ����ص������Ƿ���ʵ�������equals��������ҪʱҲ��Ҫ����hashcode������
		for (Iterator it = hs.iterator(); it.hasNext();) {
			Person p = (Person) it.next();// �������������ת�ͣ�������it.nextָ����������
			System.out.println(p.getName() + ":" + p.getAge());
		}
	}

}
/*
 * ֪ʶ���䣺 ��ϣ��ȷ��Ԫ���Ƿ���ͬ�� 1.�ж�����Ԫ�صĹ�ϣֵ�Ƿ���ͬ�������ͬ�����ж���������������Ƿ���ͬ��
 * 2.�жϹ�ϣֵ��ͬ����ʵ�жϵ��Ƕ����hashCode()�ķ������ж�������ͬ���õ���equals��������������ͬ�����ж���ͬһԪ�أ����ٴ洢��
 * ע�⣬1.�����ϣֵ��ͬ���ǲ���Ҫ�ж�equals�ġ�
 * 2.hashCode()��object�ķ�����ͨ������������һ����ֵַ(�����ԭ��)��������������Զ��塣
 */
