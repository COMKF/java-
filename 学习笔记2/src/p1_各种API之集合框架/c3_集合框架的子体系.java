package p1_各种API之集合框架;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Collection下有两个子体系：List和Set
 * List：有序的序列。此接口的用户可以对列表中每个元素的插入位置进行精确的控制，用户可以根据元素在列表中的正数索引，访问元素，并搜索列表中的元素。
 * 		List中的元素可以重复
 * Set：不包含重复元素的序列，无序(某些情况下，有可能会有序)，并且最多有一个null。
 */
/* List是Collection的子类，现在对共有方法不再说明，只研究List的特有方法。
 * List的特有方法有一个共性特点，那就是都可以操作脚标。
 * 1.添加
 * 1.1根据脚标添加元素 void add(int index, E element);
 * 1.2根据脚标添加指定集合中的元素 boolean addAll(int index, Collection c);
 * 2.删除
 * 2.1根据脚标删除元素    E remove(int index);//返回的是被删除的元素
 * 3.修改
 * 3.1根据脚标修改元素    E set(int index, E element);
 * 4.获取
 * 4.1根据脚标获取元素    E get(int index);
 * 4.2查找指定元素的第一次出现的位置  int indexOf(Object o);
 * 4.3查找指定元素的最后一次次出现的位置     int lastIndexOf(Object o);
 * 4.4截取一段List(包含头，不包含尾)  List subList(int fromIndex, int toIndex);
 * 所以，List是可以完成对元素的增删改查的。
 */
public class c3_集合框架的子体系 {

	public static void main(String[] args) {
		List l = new ArrayList();
		show(l);
	}

	private static void show(List l) {
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		System.out.println(l);

		l.add(1, "999");// 1.1
		System.out.println(l);

		System.out.println(l.remove(3));// 2.1
		System.out.println(l);

		System.out.println(l.set(1, "888"));// 3.1
		System.out.println(l);

		System.out.println(l.get(2));// 4.1
	}

}
