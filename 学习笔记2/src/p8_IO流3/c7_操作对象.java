package p8_IO��3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import bean.Person;

/* �������������ObjectInputStream��ObjectOutputStream��
 * ���԰Ѷ���־û���
 * �����Ĭ�����л�����(���������������еķ�ʽ)д��������ǣ�������࣬��ǩ�����Լ���˲̬�ͷǾ�̬�ֶε�ֵ��
 * 
 * ��ObjectOutputStreamд��Ķ��󣬾ͻ��Զ��Ľ������л������л�ʱ�����������һЩ��Ϣ����Щ��Ϣ�Ƕ��������֣�������ͨ�Ľ���Ͷ�ȡ���������롣
 * ������ObjectInputStream��ȡ����ObjectInputStream�з����л��Ĺ��ܣ�����ȷ��ȡ�����洢�Ķ��������ԡ�
 */
/* ֻ��ʵ����Serializable�ӿ�(��ǽӿ�)����Ͷ��󣬲��ܱ����л������bean.Person��
 * ʵ����Serializable�ӿڵ��࣬���δ����serialVersionUIDʱ�������л����У�Serializable�ӿڻ�Ϊ�����һ��serialVersionUID��д�뵽�洢�ļ��С�
 * ��ID�����ɱ�������ϵͳ���ض����㷨��������ģ������ڷ����л�ʱ�����������ȶ���Ҫ��ԭ�������ID�ţ��ʹ洢�ļ��еĽ���ID��ƥ�䡣
 * ����ͬ����ɽ��з����л���������ͬ�����׳��쳣�������ͱ�֤�˶����׼ȷ��ԭ��
 * 
 * ��ΪID�ŵ��㷨�����������ϵͳ��ء����Ҫ��ƽ̨�Ļ�����ʹʹ��һģһ�����࣬Ҳ����ΪID�Ų�ͬ���׳��쳣������ν���أ�
 * ���Խ���ID�ŵ�������������ǿ�ҽ���������������������Ļ����Ϳ��Կ�ƽ̨ʹ�á�
 */
public class c7_�������� {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeobj();
		readobj();	
	}

	private static void writeobj() throws IOException, IOException {
		//����ObjectOutputStream��
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
		/* ��ʵ�ϣ�����ֻ��Ҫ�Ѷ�����ȥ��ȡ����ʱ���ض��ķ�������ȡ����Ϊ�洢ʱ��һЩ��������Ϣ���޷�����ģ�����Ҳ����Ҫ�����ֻ��Ҫ�õ�ʱ��ֱ���þ��С�
		 * ���ԣ��ɴ��ֱ�Ӱ���չ���趨Ϊobject����������һ���洢������ļ������Ƶ�java˼�뻹��֮ǰ��properties�ļ���
		 */
		oos.writeObject(new Person("xiaoqiang",30));
		oos.close();
	}
	
	private static void readobj() throws IOException, ClassNotFoundException {
		//����ObjectInputStream�����ܷ����л�
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		
		Person p = (Person)ois.readObject();//ȡ����ʱ��������ʵ�Ѿ�����Ϊobject���ˣ����������ǿת�ָ�Ϊԭ�����࣬��Person
		
		System.out.println(p.getName()+":"+p.getAge());
		ois.close();
	}

}
/* ֪ʶ���䣺transient�ؼ��֣��ùؼ��ֱ������ʵ�����л��ӿڵ�����
 * public class Person implements Comparable<Person>,Serializable { // ��Comparable�ӿ��ϼ������(������)Person��
	private static final long serialVersionUID = 1L;	//ID�ŵ�������ʽ
	
	private transient String name;//transient�ؼ��֣��Ǿ�̬���ݣ������ݿ���д������У�����ؼ��ֵ������ǣ������ε����ݲ��ᱻ���л���д��Ӳ����
	private static int age;	//����static��̬�ؼ��ֺ󣬸����ݻ��ŵ����ط������ڣ����ж�����������ݣ����ᱻ�洢�������У�Ҳ�Ͳ���д��Ӳ����
	//���ԣ�transient��static���������ڣ�1.�Ǿ�̬�뾲̬ 2.�洢�ڶ�������洢�ڱ��ط������У� ��ͬЧ���ǣ����ᱻд�뵽Ӳ����

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
 * 
 */
