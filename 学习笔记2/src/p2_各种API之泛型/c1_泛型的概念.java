package p2_各种API之泛型;
/* 已经学习完了集合，在学习泛型之前，可以先看看集合的一些技巧：

需要唯一吗？
需要：Set
	需要制定顺序： 
			需要： TreeSet
			不需要：HashSet
			但是想要一个和存储一致的顺序(有序):LinkedHashSet
不需要：List
	需要频繁增删吗？
		需要：LinkedList
		不需要：ArrayList
		
如何记录每一个容器的结构和所属体系呢？

看名字！


List
	|--ArrayList
	|--LinkedList

Set
	|--HashSet
	|--TreeSet

后缀名就是该集合所属的体系。

前缀名就是该集合的数据结构。

看到array：就要想到数组，就要想到查询快，有角标.	
看到link：就要想到链表，就要想到增删快，就要想要 add get remove+frist last的方法 
看到hash:就要想到哈希表，就要想到唯一性，就要想到元素需要覆盖hashcode方法和equals方法。 
看到tree：就要想到二叉树，就要想要排序，就要想到两个接口Comparable，Comparator 。

而且通常这些常用的集合容器都是不同步的。 
 */

import java.util.ArrayList;
import java.util.Iterator;

/* 泛型是jdk1.5之后出现的安全机制，该技术的出现是为了解决问题。
 * 好处：
 * 1.将运行时期出现的异常ClassCastException转换成了编译时期的错误。
 * 2.避免了强制转换的麻烦。
 * 
 * <>什么时候用？
 * 当操作的引用数据类型不确定的时候。就用<>。将要操作的引用数据类型传入即可。
 * 其实<>就是一个用于接收具体引用数据类型的参数范围。
 * 在程序中，只要用到了带有<>的类或者接口，就要明确传入的引用数据类型。
 * 
 * 泛型技术是给编译器使用的技术，用于编译时期，确保类型安全。
 * 
 * 泛型的擦除：运行时，会将泛型去掉，生成的class文件是不带泛型的，这称为泛型的擦除。(仅作了解)
 * 为什么要擦除呢？因为兼容运行的类加载器.(以前没有泛型，所以类加载器也不会加载带泛型的class文件)
 * 泛型的补偿：运行时，通过获取元素的类型进行一个自动转换的操作，不需要使用者强制转换，这称为泛型的补偿。(仅作了解)
 */
public class c1_泛型的概念 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("abc2");

		for (Iterator<String> it = al.iterator(); it.hasNext();) { // 迭代器加入泛型，意义是，自动添加了一个强制转换
			String str = it.next();
			System.out.println(str);
		}
	}

}