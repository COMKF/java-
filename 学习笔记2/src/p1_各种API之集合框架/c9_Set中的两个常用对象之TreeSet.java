package p1_����API֮���Ͽ��;

/* TreeSet�����Զ�set�����е�Ԫ�ػ���Ԫ�ص��ֵ�˳���������
 * �ж϶���Ψһ�Եķ��������Ǹ��ݱȽϷ���(compareTo����)�ķ��ؽ���Ƿ���0������0������Ϊ��ͬһ����
 * TreeSet��Ԫ�ؽ������������ַ�����
 * 1.Ԫ������߱��ȽϹ��ܣ���compareTo���������Զ��������Ҫ��ʵ��Comparable�ӿڣ�Ȼ�󸲸�compareTo������
 * ���ǣ�������ǲ���Ҫ���ն����о߱�����Ȼ˳���������(������ַ��������ȵ����򣬴�ʱû�취�����ַ����ڲ���compareTo����)��������󲻾߱���Ȼ˳��
 * 2.����ʹ��TreeSet�ĵڶ�������ʽ���ü��ϱ�����жԶ����������Ĺ��ܣ������Ƚ���(ʵ��Comparator�ӿڵ��࣬������compare����)��Ϊ�������ݸ�TreeSet��
 * ���Կ�����TreeSet������˳���ǣ����ñȽ������򣬺���Ԫ������������
 * ���䣺�����������һ����Ԫ��ʱ���Զ����������ݽ��ж��ֲ��ҡ�
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import bean.Person;

public class c9_Set�е��������ö���֮TreeSet {

	public static void main(String[] args) {
		// TreeSet ts = new TreeSet();
		TreeSet ts = new TreeSet(new ComparaByName()); // ����һ���Դ��Ƚ�����TreeSet����
		// ts.add("1234"); // Ϊʲô�ַ�����ֱ����TreeSet��������Ϊ�ַ����������compareTo������
		// ts.add("123");
		// ts.add("12345");
		// ts.add("123");
		//
		// for (Iterator it = ts.iterator(); it.hasNext();) {
		// System.out.println(it.next());
		// }
		//
		// ts.clear();
		// System.out.println("*************");

		ts.add(new Person("lm1", 21));
		ts.add(new Person("lm2", 22));
		ts.add(new Person("lm3", 23));
		ts.add(new Person("lm4", 24));
		ts.add(new Person("lm3", 23));
		ts.add(new Person("lm4", 22));

		for (Iterator it = ts.iterator(); it.hasNext();) {
			Person p = (Person) it.next();
			System.out.println(p.getName() + ":" + p.getAge());
		}
	}
}

class ComparaByName implements Comparator { // �����Ƚ���������Ƚ���������Ϊ����ʽ

	@Override
	public int compare(Object o1, Object o2) {
		Person p1 = (Person) o1;
		Person p2 = (Person) o2;
		int temp = p1.getName().compareTo(p2.getName());
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}

}
