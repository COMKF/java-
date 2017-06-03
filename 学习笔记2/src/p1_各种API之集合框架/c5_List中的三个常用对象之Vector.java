package p1_各种API之集合框架;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;

/* List下的三个子类对象，主要开发时用的比较多的就是这三个对象：
 * 1.Vector(1.0版本就有):内部是数组数据，是同步的，效率低，增删增删查询都很慢。
 * 2.ArrayList(1.2版本才有)：内部是数组数据，是不同步的，效率高，查询速度快。
 * 			所以替代了Vector（如果要用到多线程，可以给ArrayList加锁等方式，不再用Vector）
 * 3.LinkedList(1.2版本才有)：内部是链表数据结构，是不同步的，效率高，增删元素的速度很快。
 */

public class c5_List中的三个常用对象之Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");

		for (Enumeration en = v.elements(); en.hasMoreElements();) {
			System.out.println(en.nextElement());
		}
		/*
		 * 知识扩充：Enumeration与Iterator功能重复，但是我们只需要了解Enumeration就可以了，以后开发用Iterator。
		 * 有两个原因：
		 * 1.Enumeration只是Vector中的接口，其他List中没有Enumeration接口。Vector已被淘汰。
		 * 2.Iterator代码少。 本节内容仅作了解。
		 */

	}

}
