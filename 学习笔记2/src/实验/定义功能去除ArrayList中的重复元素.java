package ʵ��;

import java.util.ArrayList;
import java.util.Iterator;

import bean.Person;

public class ���幦��ȥ��ArrayList�е��ظ�Ԫ�� {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("1234");
		al.add("123");
		al.add("12345");
		al.add("123");

		System.out.println(al);
		al = removeRepeatElement(al);
		System.out.println(al);

		al.clear();
		System.out.println("*************");

		al.add(new Person("lm1", 21));
		al.add(new Person("lm2", 22));
		al.add(new Person("lm3", 23));
		al.add(new Person("lm4", 24));
		al.add(new Person("lm3", 23));
		al.add(new Person("lm2", 22));

		System.out.println(al);
		al = removeRepeatElement(al); // ��ȥ���ظ�Ԫ�صķ���Ҳ��ȥ���ظ��Զ������ԭ����ڣ�
		// ��Ϊcontains�������ڲ����ݵĻ���equals������������Ѿ�������equals����������ȥ���ظ�Ԫ�صķ���Ҳ��Ч�ˡ�(����������person����ע�͵�equals����)
		// al = removeRepeatObject(al); //ֻ�Ƕ��ա�������д��
		System.out.println(al);
		System.out.println(al.remove(new Person("lm0", 20))); // ��������Ҫɾ��һ���´�����Person����
		System.out.println(al.remove(new Person("lm2", 22))); // ��������Կ���remove�������ڲ����ݵĻ���equals������

	}

	private static ArrayList removeRepeatObject(ArrayList al) { // ȥ���ظ��Զ������

		return null;
	}

	private static ArrayList removeRepeatElement(ArrayList al) { // ȥ���ظ�Ԫ��
		// 1.����һ����ʱ����
		ArrayList temp = new ArrayList();
		// 2.����al����
		for (Iterator it = al.iterator(); it.hasNext();) {
			Object obj = it.next();
			// 3.�жϱ���������Ԫ���Ƿ�����ʱ�����д���
			if (!temp.contains(obj))
				temp.add(obj);
		}

		return temp;
	}

}
