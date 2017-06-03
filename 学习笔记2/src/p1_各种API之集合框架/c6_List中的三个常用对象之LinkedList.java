package p1_各种API之集合框架;

/* Linklist特有功能：
 * 1.添加
 * 1.1将元素添加到列表的开头  public void addFirst(E e)
 * 1.2将元素添加到列表的结尾  public void addLast(E e)
 * 扩充：jdk1.6以后，offer替代了add。offer方法在操作成功后会返回true，而add方法则什么都不返回。
 * 2.删除
 * 2.1删除列表中第一个元素  public E removeFirst()	//且将该元素返回
 * 2.1删除列表中最后一个元素  public E removeLast()	//且将该元素返回
 * 扩充：jdk1.6以后，poll替代了remove。因为remove方法在列表为空时抛出异常，而poll方法在列表为空时返回null
 * 3.获取
 * 3.1获取列表中第一个元素  public E getFirst()
 * 3.2获取列表中最后一个元素  public E getLast()
 * 扩充：：jdk1.6以后，peek替代了get。因为get方法在列表为空时抛出异常，而peek方法在列表为空时返回null
 * 可见Linkedlist的特有操作大多数都是对首尾的操作
 */

import java.util.Iterator;
import java.util.LinkedList;

public class c6_List中的三个常用对象之LinkedList {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.offerFirst("abc1");
		l.addFirst("abc2");
		l.addFirst("abc3");
		l.addLast("abc4");

		for (Iterator it = l.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println("******");

		System.out.println(l.getFirst());
		System.out.println(l.getFirst());
		System.out.println("******");

		System.out.println(l.removeFirst());
		System.out.println(l.removeFirst());
	}
}
