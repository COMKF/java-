package p1_各种API之集合框架;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* 数值有很多，用数组存，数组有很多，用二维数组存。数据有很多，用对象存，对象有很多，用集合存。
 * 集合：对象用于封装特点数据，对象多了需要存储，如果对象个数不确定，就需要用集合进行存储。
 * 特点：
 * 1.用于存储对象的容器
 * 2.集合长度可变
 * 3.不能存储基本数据类型值
 */
/* 集合容器因为内部的数据结构不同，有多种具体容器。
 * 不断向上抽取，就形成了集合框架。
 * 而这个框架的顶层，就是  根接口Collection
 * Collection方法有：
 * 1.添加
 * 1.1添加一个对象进到集合里  boolean add(E e);//在这库E就是object
 * 1.2添加一个集合中的对象到指定集合中  boolean addAll(Collection c);
 * 2.删除
 * 2.1删除一个集合中的对象 boolean remove(Object o);
 * 2.2删除一个集合中那些也包含在指定集合中的所有对象  boolean removeAll(Collection c);
 * 2.3清空对象 void clear();
 * 3.判断
 * 3.1判断一个集合中是否有指定对象 boolean contains(Object o);
 * 3.2判断一个集合中是否包含有指定集合的所有对象   boolean containsAll(Collection c);
 * 3.3判断集合是否为空 boolean isEmpty();
 * 4.获取
 * 4.1.获取集合的长度 int size();
 * 4.2用迭代器的方法获取集合中的元素  Iterator iterator();
 * 		该对象必须依赖于具体容器，因为每一个容器的数据结构都不同。所以该迭代器对象是在容器中进行内部实现的。
 * 		对于容器使用者而言，具体的实现并不重要，只要通过容器获得该实现的迭代器对象即可，也就是iterator()方法。
 * 		iterator接口就是对所有Collection容器进行元素取出的根接口。
 * 5.其他
 * 5.1取交集 boolean retainAll(Collection c);
 * 5.2将集合转换成数组   Object[] toArray();
 */

public class c1_集合框架的概念 {

	public static void main(String[] args) {
		Collection coll = new ArrayList();// Collection是接口，接口不能实例化，所以我们要实例实现接口的类，这个类就是ArrayList
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		// show(coll);
		show(c1, c2);
	}

	private static void show(Collection c1, Collection c2) {
		c1.add("12");
		c1.add("123");
		c1.add("1234");
		c1.add("12345");

		c2.add("ab");
		c2.add("123");
		c2.add("abcd");
		c2.add("abcde");

		// 建议每次演示一个功能，将其余功能注释掉
		// c1.addAll(c2);//1.2
		// System.out.println(c1);

		// System.out.println(c1.removeAll(c2));//2.2,将两个集合中的相同元素从调用removeAll方法的集合中删除
		// System.out.println(c1);

		// System.out.println(c1.containsAll(c2));//3.2，必须包含全部元素，才会返回true
		// System.out.println(c1);

		System.out.println(c1.retainAll(c2));// 5.1，取交集，保留和指定集合相同的元素，而删除不同的元素，和removeAll功能相反
												// 经验证，这个方法的结果恒为true
	}

	public static void show(Collection coll) {
		coll.add("123");// 1.1
		coll.add("1234");// 1.1
		coll.add("12345");// 1.1
		System.out.println(coll);
		System.out.println(coll.size());// 4.1
		System.out.println(coll.toArray());// 5.2

		coll.remove("1234");// 2.1，集合的删除功能会改变集合的长度
		System.out.println(coll);
		coll.clear();// 2.3
		System.out.println(coll);

		System.out.println(coll.contains("123"));// 3.1
		System.out.println(coll.isEmpty());// 3.3

	}

}
