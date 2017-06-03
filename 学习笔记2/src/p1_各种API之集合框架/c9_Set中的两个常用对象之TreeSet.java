package p1_各种API之集合框架;

/* TreeSet：可以对set集合中的元素基于元素的字典顺序进行排序。
 * 判断对象唯一性的方法：就是根据比较方法(compareTo方法)的返回结果是否是0，若是0，则认为是同一对象
 * TreeSet对元素进行排序有两种方法：
 * 1.元素自身具备比较功能，即compareTo方法。而自定义对象需要先实现Comparable接口，然后覆盖compareTo方法。
 * 但是：如果我们不想要按照对象中具备的自然顺序进行排序(比如对字符串按长度的排序，此时没办法覆盖字符串内部的compareTo方法)？如果对象不具备自然顺序？
 * 2.可以使用TreeSet的第二种排序方式，让集合本身具有对对象进行排序的功能，即将比较器(实现Comparator接口的类，并覆盖compare方法)作为参数传递给TreeSet。
 * 可以看出，TreeSet的排序顺序是，先用比较器排序，后用元素自身方法排序。
 * 补充：二叉树，查找或添加元素时会自动对已有数据进行二分查找。
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import bean.Person;

public class c9_Set中的两个常用对象之TreeSet {

	public static void main(String[] args) {
		// TreeSet ts = new TreeSet();
		TreeSet ts = new TreeSet(new ComparaByName()); // 创建一个自带比较器的TreeSet容器
		// ts.add("1234"); // 为什么字符串能直接在TreeSet中排序？因为字符串本身就有compareTo方法。
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

class ComparaByName implements Comparator { // 创建比较器，这个比较器以名字为排序方式

	@Override
	public int compare(Object o1, Object o2) {
		Person p1 = (Person) o1;
		Person p2 = (Person) o2;
		int temp = p1.getName().compareTo(p2.getName());
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}

}
