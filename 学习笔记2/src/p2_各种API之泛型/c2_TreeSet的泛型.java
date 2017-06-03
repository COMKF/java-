package p2_各种API之泛型;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import bean.Person;

//养成良好习惯，在创建容器的时候，就使用泛型。
public class c2_TreeSet的泛型 {

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

class ComparaByName implements Comparator<Person> { // 创建包含泛型的Comparator比较器
	public int compare(Person p1, Person p2) { // Comparator比较器加入泛型，则覆盖Comparator比较器的compare方法也必须加入泛型
		int temp = p1.getName().compareTo(p2.getName()); // 不再需要强转了
		return temp == 0 ? p1.getAge() - p2.getAge() : temp;
	}
}
