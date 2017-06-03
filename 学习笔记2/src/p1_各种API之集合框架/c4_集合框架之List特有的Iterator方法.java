package p1_各种API之集合框架;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class c4_集合框架之List特有的Iterator方法 {

	public static void main(String[] args) {
		List l = new ArrayList();
		show(l);
	}

	private static void show(List l) {
		l.add("abc1");
		l.add("abc2");
		l.add("abc3");
		/*
		 * for (Iterator it = l.iterator(); it.hasNext();)
		 * {//这是各个集合共有的方法，用迭代器取元素，因为根接口Collection中有 iterator方法
		 * System.out.println(it.next()); }
		 */
		/*
		 * for (int i = 0; i < l.size(); i++) { //这是List特有的取出元素方式之一
		 * System.out.println("get:"+l.get(i)); }
		 */
		/*
		 * for (Iterator it = l.iterator(); it.hasNext();) { Object
		 * obj=it.next(); if (obj.equals("abc2")) {
		 * l.add("abc9");//java.util.ConcurrentModificationException
		 * ,当方法检测到对象的并发修改，但不允许修改时，抛出此异常 //在迭代器过程中，又使用集合进行操作，就会产生异常。所以迭代器有局限性
		 * //针对这个问题，可以使用ListIterator(List专用迭代器) } else {
		 * System.out.println("next:"+obj); }
		 * 
		 * } System.out.println(l);
		 */
		System.out.println(l);
		for (ListIterator it = l.listIterator(); it.hasNext();) {// ListIterator(List专用迭代器)
			// 可实现在迭代过程中完成对元素的增删改查，注意，只有List容器中有该方法。

			System.out.println("Previous:" + it.hasPrevious());// 判断是否有前一个元素，可以根据这个方法反向遍历该集合

			Object obj = it.next();
			if (obj.equals("abc2")) {
				// it.add("abc9");//注意，这里不用集合了，这里用的是it,add作用是在后面紧跟着加上"abc9"
				it.set("abc9");// set作用是直接替换为"abc9"
			} else {
				System.out.println("next:" + obj);
			}
			System.out.println("Next:" + it.hasNext());// 判断是否有后一个元素，可以根据这个方法遍历该集合

			System.out.println("Previous:" + it.hasPrevious());// 判断是否有前一个元素，可以根据这个方法反向遍历该集合
		}
		System.out.println(l);
	}
}
