package p3_����API֮Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import bean.Person;
import bean.Student;

/* Map���õ����ࣺ
 * 1.Hashtable���ڲ��ṹ�ǹ�ϣ����ͬ���ġ�������null��Ϊ����ֵ��(��һ������Properties����IO������ϣ��������������Ȳ���)
 * 2.HashMap���ڲ��ṹ�ǹ�ϣ���ǲ�ͬ���ġ�����null��Ϊ����ֵ��
 * 3.TreeMap���ڲ��ṹ�Ƕ��������ǲ�ͬ���ġ����Զ�Map�еļ���������
 * 
 */

public class c2_Map���õ�������� {

	public static void main(String[] args) {
//		HashMap<Student, String> hm = new HashMap<Student, String>();
		HashMap<Student, String> hm = new LinkedHashMap<Student, String>();//LinkedHashMap��HashMap�����࣬�����ص������������÷�һ����
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new ComparaByName());	//��Ȼ�����TreeMapҲ�����ñȽ���
		method(hm);
		System.out.println("******");
		method2(tm);
	}


	private static void method(HashMap<Student, String> hm) {	//��ʾHashMap
		
		hm.put(new Student("lihua",20), "����");		//ѧ���뻧���ص�ӳ���ϵ
		hm.put(new Student("baibai",27), "����");
		hm.put(new Student("xiaoqiang",25), "�Ϻ�");
		hm.put(new Student("wagncai",22), "����");
		hm.put(new Student("baibai",27), "����");
		
		for (Iterator<Student> it = hm.keySet().iterator(); it.hasNext();) {	//����������ֱ������д
			Student key = it.next();
			String value = hm.get(key);
			System.out.println(key.getName() + ":" +key.getAge()+"---"+ value );
		}
	}
	
	private static void method2(TreeMap<Student, String> tm) {	//��ʾTreeMap
		tm.put(new Student("lihua",20), "����");
		tm.put(new Student("baibai",27), "����");
		tm.put(new Student("xiaoqiang",25), "�Ϻ�");
		tm.put(new Student("wagncai",22), "����");
		tm.put(new Student("baibai",27), "����");
		
		for (Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Student, String> me = it.next(); 
			Student key = me.getKey(); 
			String value = me.getValue(); 
			System.out.println(key.getName() + ":" +key.getAge()+"---"+ value );
		}
	}
}

class ComparaByName implements Comparator<Person> { // �����Ƚ���������Ƚ���������Ϊ����ʽ����Ϊ����Ƚ��������˷���

	public int compare(Person p1, Person p2) {
		int temp = p1.getName().compareTo(p2.getName());
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}

}
