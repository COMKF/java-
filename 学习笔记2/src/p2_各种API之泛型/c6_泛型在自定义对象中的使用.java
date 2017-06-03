package p2_����API֮����;

//��c5�У������Ѿ��ܹ��÷��ʹ�ӡ���������������͡���������Ҫֻ��ӡ�Զ���������������ͣ�������ӡ����������������
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import bean.Person;
import bean.Student;
import bean.Worker;

public class c6_�������Զ�������е�ʹ�� {

	public static void main(String[] args) {
		ArrayList<Person> af = new ArrayList<Person>();
		af.add(new Person("P10", 10));
		af.add(new Person("P20", 20));

		ArrayList<Student> a1 = new ArrayList<Student>();
		a1.add(new Student("S1", 1));
		a1.add(new Student("S2", 2));

		ArrayList<Worker> a2 = new ArrayList<Worker>();
		a2.add(new Worker("W3", 3));
		a2.add(new Worker("W4", 4));

		ArrayList<String> as = new ArrayList<String>(); // ������ﲻ�ӷ��ͣ�����<String>����ôaf.addAll(as);���ᱨ���ͻ���ɰ�ȫ������
		as.add("S5");
		as.add("S6");

		printCollection(af); // �ܽ���Person��������
		printCollection(a1); // �ܽ���Person��������
		printCollection(a2);// �ܽ���Person��������
		System.out.println("*****");
		printCollection2(af);// �ܽ���Student���丸��
		printCollection2(a1);// �ܽ���Student���丸��
		// printCollection2(a2); //�ܽ���Student���丸�࣬����

		// ��ʾ��addAll��һ��洢Ԫ�ص�ʱ���õ������ޡ���Ϊȡ����ʱ�򣬶��ǰ��ո�����ȡ�������㣬������ְ�ȫ������
		// �������޵���ʾ���������޵�ʹ�ý��٣�������ʾ�������˽⣬��Ƶ������Day18�ĵ�10���У��Ƚ��ѡ�
		// af.addAll(as); //����as�����˷���<String>,����ͻ�ֱ�ӱ��������ڱ�д����ʱ�ͷ��ְ�ȫ������nice����
		af.addAll(a1); // public boolean addAll(Collection<? extends E> c),����addAll��Դ���룬���Կ������������ʵ�޶������ޡ�
						// ע�⣬��ʱ���ø������������Ķ������ǿ��Եģ�����������ȡ���Ĳ���ʱ���ǰ��ո�����(��Person)ȡ���ġ�
		System.out.println("*****");
		printCollection(af);
		
		af.containsAll(as);	//public boolean containsAll(Collection<?> c)������containsAll��Դ���룬���Կ���������������ж����⼯�ϣ�
							//�����ԭ��������ΪcontainsAll���õ���equals���������ԭ����removeAll��ͬ��
		af.removeAll(as);
	}

	/*
	 * �����͵��޶��� 1.? extend E������E���������ͣ���������ޡ� 2.? super E������E���丸���ͣ���������ޡ�
	 */
	// private static void printCollection(Collection<Person> a) {
	// ����д������Ϊ��������Ϊ���յ�����ֻ��Person��������и���
	private static void printCollection(Collection<? extends Person> a) { // �������ǽ��յ�����ֻ��Person�������࣬������͵��޶������ޡ�
		for (Iterator<? extends Person> it = a.iterator(); it.hasNext();) { // ����ѵ������޶�ΪPerson��������,���ã�������ôд
			// System.out.println(it.next());
			Person p = it.next();
			System.out.println(p); // ��������д�ˡ��������ǰ�������д��Iterator<?> it =
									// a.iterator(); �Ͳ�������д��
		}
	}

	private static void printCollection2(Collection<? super Student> a) { // ������յ���Student���丸�࣬���ޡ�
		for (Iterator<? super Student> it = a.iterator(); it.hasNext();) { // ����ѵ������޶�ΪStudent���丸��
			System.out.println(it.next());
			// Person p = it.next();
			// System.out.println(p); // ������ôд��
		}
	}
}
