package p1_各种API之集合框架;

import java.util.ArrayList;
import java.util.ListIterator;

import bean.Person;

public class c7_List中的三个常用对象之ArrayList {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new Person("lm1", 21));// add方法是add(E e)，所以在al.add(new Person());中，Person类其实是向上转型为object类了
		al.add(new Person("lm2", 22));// 其实添加到al中的是地址(很明显的嘛，参考引用数据类型，即类创建对象的概念)
		al.add(new Person("lm3", 23));
		al.add(new Person("lm4", 24));

		for (ListIterator it = al.listIterator(); it.hasNext();) {
			Person p = (Person) it.next();// 在这里必须向下转型，避免了it.next指针跳了两次
			System.out.println(p.getName() + ":" + p.getAge());
			// System.out.println(((Person) it.next()).getName()+":"+((Person)it.next()).getAge());
			// 在这里注意两点：1.点(.)的优先级很高，看括号的范围 2.用了两次it.next指针跳了两次
		}
		al.add(5);// 实质上等于al.add(new Integer(5));使用了自动装箱的方法，保证了add方法添加的必须都是对象
		
		for (int i = 0; i < al.size(); i++) {	//根据脚标获取元素
			System.out.println(al.get(i));
		}
	}
}
