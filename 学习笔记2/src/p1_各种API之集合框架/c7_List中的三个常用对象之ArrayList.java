package p1_����API֮���Ͽ��;

import java.util.ArrayList;
import java.util.ListIterator;

import bean.Person;

public class c7_List�е��������ö���֮ArrayList {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new Person("lm1", 21));// add������add(E e)��������al.add(new Person());�У�Person����ʵ������ת��Ϊobject����
		al.add(new Person("lm2", 22));// ��ʵ��ӵ�al�е��ǵ�ַ(�����Ե���ο������������ͣ����ഴ������ĸ���)
		al.add(new Person("lm3", 23));
		al.add(new Person("lm4", 24));

		for (ListIterator it = al.listIterator(); it.hasNext();) {
			Person p = (Person) it.next();// �������������ת�ͣ�������it.nextָ����������
			System.out.println(p.getName() + ":" + p.getAge());
			// System.out.println(((Person) it.next()).getName()+":"+((Person)it.next()).getAge());
			// ������ע�����㣺1.��(.)�����ȼ��ܸߣ������ŵķ�Χ 2.��������it.nextָ����������
		}
		al.add(5);// ʵ���ϵ���al.add(new Integer(5));ʹ�����Զ�װ��ķ�������֤��add������ӵı��붼�Ƕ���
		
		for (int i = 0; i < al.size(); i++) {	//���ݽű��ȡԪ��
			System.out.println(al.get(i));
		}
	}
}
