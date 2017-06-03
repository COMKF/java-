package bean;

import java.io.Serializable;

//�ڴ�˵������ע�͵��Һ����б�ע(��)�Ĵ��룬��δ���뷺�ͼ����Ĵ��룬�ͼ��뷺�ͼ����Ĵ�����бȽ�

/* Serializable�����ڸ������л��������ID�ţ��ж���Ͷ����Ƿ���ͬһ�汾��
 * 
 */

//public class Person implements Comparable { // ������Ҫ�õ�compareTo����ʱ��������ʵ��Comparable�ӿڣ�Ȼ�󸲸�compareTo������	ע��(��)
public class Person implements Comparable<Person>,Serializable { // ��Comparable�ӿ��ϼ������(������)Person��
	private static final long serialVersionUID = 1L;	//ID�ŵ�������ʽ
	
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {

		return name.hashCode() + age * 23; // ���Ǻ�Ĺ�ϣ�㷨��Ϊ���ص����ṩ���صĹ�ϣֵ���ô�ֵ��Ϊ����ĵ�ַ
	}

	@Override
	public boolean equals(Object obj) { // ���Ҫ�ж������Ƿ���ͬ�����븲��equals����
		// �����������ʹ�÷��ͣ�������public boolean equals(Person
		// p)����Ϊ�����������Object����������������ӽ�׳���жϲ�����ǿת��
		if (this == obj) // �ӵ�һ���жϣ����ǽ�׳���жϣ��������ж��Ƿ�������ͬһ�����ǣ���ֱ�ӷ���true
			return true;
		if (!(obj instanceof Person)) // �ӵڶ����жϣ����ǽ�׳���жϣ��������жϴ���Ķ����Ƿ���Person���ͣ����ǣ���ֱ���׳��쳣
			throw new ClassCastException("���ʹ��󣡣���");
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.age == p.age;
	}

	@Override
	public String toString() {

		return this.getName() + ":toString:" + this.getAge();
	}

	@Override
	// public int compareTo(Object o) { // ��person��������д�С��������� ע��(��)
	public int compareTo(Person p) { // ��Comparable�ӿ��ϼ��뷺�ͣ��򸲸�Comparable�ķ���compareToҲ������뷺�ͣ��ô��ǣ����Բ���ǿת�ˡ�
		// Person p = (Person) o; // �κ����͵�ǿת��������н�׳���жϣ��������Ⱥ��Ե��� ע��(��)

		// if (this.age > p.age) //������⣬��ʵ���������ִ�����͸��
		// return 1;
		// if (this.age < p.age)
		// return -1;
		// else {
		// return this.name.compareTo(p.name);
		// }
		int temp = this.age - p.age;
		return temp == 0 ? this.name.compareTo(p.name) : temp;
	}

}
