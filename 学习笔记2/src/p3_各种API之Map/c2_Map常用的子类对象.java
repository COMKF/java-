package p3_各种API之Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import bean.Person;
import bean.Student;

/* Map常用的子类：
 * 1.Hashtable：内部结构是哈希表，是同步的。不允许null作为键和值。(有一个子类Properties能与IO技术结合，很厉害，现在先不讲)
 * 2.HashMap：内部结构是哈希表，是不同步的。允许null作为键和值。
 * 3.TreeMap：内部结构是二叉树，是不同步的。可以对Map中的键进行排序。
 * 
 */

public class c2_Map常用的子类对象 {

	public static void main(String[] args) {
//		HashMap<Student, String> hm = new HashMap<Student, String>();
		HashMap<Student, String> hm = new LinkedHashMap<Student, String>();//LinkedHashMap是HashMap的子类，它的特点是有序。其余用法一样。
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new ComparaByName());	//当然，这个TreeMap也可以用比较器
		method(hm);
		System.out.println("******");
		method2(tm);
	}


	private static void method(HashMap<Student, String> hm) {	//演示HashMap
		
		hm.put(new Student("lihua",20), "北京");		//学生与户籍地的映射关系
		hm.put(new Student("baibai",27), "深圳");
		hm.put(new Student("xiaoqiang",25), "上海");
		hm.put(new Student("wagncai",22), "广州");
		hm.put(new Student("baibai",27), "河南");
		
		for (Iterator<Student> it = hm.keySet().iterator(); it.hasNext();) {	//迭代器可以直接这样写
			Student key = it.next();
			String value = hm.get(key);
			System.out.println(key.getName() + ":" +key.getAge()+"---"+ value );
		}
	}
	
	private static void method2(TreeMap<Student, String> tm) {	//演示TreeMap
		tm.put(new Student("lihua",20), "北京");
		tm.put(new Student("baibai",27), "深圳");
		tm.put(new Student("xiaoqiang",25), "上海");
		tm.put(new Student("wagncai",22), "广州");
		tm.put(new Student("baibai",27), "河南");
		
		for (Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Student, String> me = it.next(); 
			Student key = me.getKey(); 
			String value = me.getValue(); 
			System.out.println(key.getName() + ":" +key.getAge()+"---"+ value );
		}
	}
}

class ComparaByName implements Comparator<Person> { // 创建比较器，这个比较器以名字为排序方式，且为这个比较器加入了泛型

	public int compare(Person p1, Person p2) {
		int temp = p1.getName().compareTo(p2.getName());
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}

}
