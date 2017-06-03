package p1_各种API之集合框架;

import java.util.HashSet;
import java.util.Iterator;

import bean.Person;

/* Set:元素不可重复，无序。
 * Set接口方法和Collection方法一直。
 * Set有两个子类对象：
 * 1.HashSet：内部数据结构是哈希表，不同步。
 * 2.TreeSet
 */

public class c8_Set中的两个常用对象之HashSet {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		// HashSet hs = new LinkedHashSet();
		//在这里，还可以创建LinkedHashSet容器，它结合了哈希表与链表，实现了有序。方法如LinkedList。(仅了解)
		hs.add("xixi");
		hs.add("haha");
		hs.add("hehe");
		hs.add("haha");

		for (Iterator it = hs.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		hs.clear();
		System.out.println("*************");
		// 在HashSet中存储Person对象。如果姓名和年龄相同，视为同一人，即相同元素。
		hs.add(new Person("lm1", 21));// add方法是add(E e)，所以在al.add(new
										// Person());中，Person类其实是向上转型为object类了
		hs.add(new Person("lm2", 22));
		hs.add(new Person("lm3", 23));
		hs.add(new Person("lm4", 24));
		// HashSet集合的数据结构是哈希表，所以存储元素的时候，使用元素的hashcode方法确定位置，如果位置相同，再通过元素的equals方法来确定是否相同
		hs.add(new Person("lm3", 23));// 第一次代码会出现重复的"lm3",
										// 23，是因为它调用了object的hashcode方法和equals方法。
										// object的方法只是判断地址值，所以系统认为它们是不同的对象，所以出现了重复的元素，即"lm3",
										// 23。
										// 这个问题的解决办法，就是自己根据对象特点来覆盖符合实际情况的equals方法，必要时也需要覆盖hashcode方法。
		for (Iterator it = hs.iterator(); it.hasNext();) {
			Person p = (Person) it.next();// 在这里必须向下转型，避免了it.next指针跳了两次
			System.out.println(p.getName() + ":" + p.getAge());
		}
	}

}
/*
 * 知识扩充： 哈希表确定元素是否相同： 1.判断两个元素的哈希值是否相同。如果相同，再判断两个对象的内容是否相同。
 * 2.判断哈希值相同，其实判断的是对象的hashCode()的方法。判断内容相同，用的是equals方法。两个都相同，则判断是同一元素，不再存储。
 * 注意，1.如果哈希值不同，是不需要判断equals的。
 * 2.hashCode()是object的方法，通过这个方法算出一个地址值(无序的原因)，这个方法可以自定义。
 */
