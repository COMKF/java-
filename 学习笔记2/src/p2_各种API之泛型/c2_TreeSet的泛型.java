package p2_����API֮����;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import bean.Person;

//��������ϰ�ߣ��ڴ���������ʱ�򣬾�ʹ�÷��͡�
public class c2_TreeSet�ķ��� {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<Person>(new ComparaByName());

		ts.add(new Person("lm1", 21));
		ts.add(new Person("lm2", 22));
		ts.add(new Person("lm3", 23));
		ts.add(new Person("lm4", 24));
		ts.add(new Person("lm3", 23));
		ts.add(new Person("lm4", 22));

		for (Iterator<Person> it = ts.iterator(); it.hasNext();) {
			Person p = it.next();
			System.out.println(p.getName() + ":" + p.getAge());
		}
	}

}

class ComparaByName implements Comparator<Person> { // �����������͵�Comparator�Ƚ���
	public int compare(Person p1, Person p2) { // Comparator�Ƚ������뷺�ͣ��򸲸�Comparator�Ƚ�����compare����Ҳ������뷺��
		int temp = p1.getName().compareTo(p2.getName()); // ������Ҫǿת��
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}
}
