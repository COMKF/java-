package p1_各种API之集合框架;

/* 迭代器：  Iterator iterator()
 * 工作原理：在根接口Collection中有一个 iterator()方法。该方法是获取一个实现Iterator接口的对象。
 * 但在实际应用上吗，Collection是接口，接口不能实例化，所以我们要实例实现接口的类，那我们就以ArrayList为例。
 * 1.ArrayList中也有 iterator()方法，而且这个方法覆盖了Collection中的 iterator()方法。
 * 2.ArrayList中会产生一个独特的内部类，该类实现Iterator接口，而这个东西在Collection中没有。
 * 3.通过一个方法，可以获取实现Iterator接口的内部类对象(这种方法可以参考内部类章节)，从而再调用Iterator的方法，迭代获取元素。
 * 值得一提的是：
 * 1.我们不需要关注内部类的名称，比如
 * 		Collection coll = new ArrayList();
 * 		Iterator it = coll.iterator();
 * 		coll实质上是一个用Collection接收的ArrayList对象，所以coll.iterator的意义是用Iterator接收的ArrayList类中专用的实现Iterator接口的内部类对象
 * 2.每一个容器有不同的实现Iterator接口的内部类对象，所以每个容器的iterator()是特有的。
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class c2_集合框架之迭代器及其相关内容 {

	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("ab");
		coll.add("abc");
		coll.add("abcd");
		coll.add("abcde");

		// 调用Collection中的iterator()方法（调用集合中的迭代器方法），获取集合中的迭代器对象
		/*
		 * Iterator it = coll.iterator(); while (it.hasNext()) {
		 * //迭代器的使用方法，先用hasNext()判断还有没有元素 System.out.println(it.next());
		 * //用next()输出元素，相当于一个指针 }
		 */
		// 对以上的iterator()方法进行优化
		for (Iterator it = coll.iterator(); it.hasNext();) {// 这种方法的好处是可以释放coll.iterator()创建的it对象，减少内存浪费
			System.out.println(it.next());
		}
	}

}
