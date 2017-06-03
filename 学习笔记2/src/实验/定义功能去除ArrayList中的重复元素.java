package 实验;

import java.util.ArrayList;
import java.util.Iterator;

import bean.Person;

public class 定义功能去除ArrayList中的重复元素 {

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
		al = removeRepeatElement(al); // 用去除重复元素的方法也能去除重复自定义对象？原因何在？
		// 因为contains方法，内部依据的还是equals方法。在这里，已经覆盖了equals方法，所以去除重复元素的方法也生效了。(可以试试在person类中注释掉equals方法)
		// al = removeRepeatObject(al); //只是对照。不再详写。
		System.out.println(al);
		System.out.println(al.remove(new Person("lm0", 20))); // 在这里需要删除一个新创建的Person对象
		System.out.println(al.remove(new Person("lm2", 22))); // 在这里可以看到remove方法，内部依据的还是equals方法。

	}

	private static ArrayList removeRepeatObject(ArrayList al) { // 去除重复自定义对象

		return null;
	}

	private static ArrayList removeRepeatElement(ArrayList al) { // 去除重复元素
		// 1.定义一个临时容器
		ArrayList temp = new ArrayList();
		// 2.迭代al集合
		for (Iterator it = al.iterator(); it.hasNext();) {
			Object obj = it.next();
			// 3.判断被迭代到的元素是否在临时容器中存在
			if (!temp.contains(obj))
				temp.add(obj);
		}

		return temp;
	}

}
