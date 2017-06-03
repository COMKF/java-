package p2_各种API之泛型;

//在c5中，我们已经能够用泛型打印基本引用数据类型。这里我们要只打印自定义的引用数据类型，而不打印基本引用数据类型
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import bean.Person;
import bean.Student;
import bean.Worker;

public class c6_泛型在自定义对象中的使用 {

	public static void main(String[] args) {
		ArrayList<Person> af = new ArrayList<Person>();
		af.add(new Person("P10", 10));
		af.add(new Person("P20", 20));

		ArrayList<Student> a1 = new ArrayList<Student>();
		a1.add(new Student("S1", 1));
		a1.add(new Student("S2", 2));

		ArrayList<Worker> a2 = new ArrayList<Worker>();
		a2.add(new Worker("W3", 3));
		a2.add(new Worker("W4", 4));

		ArrayList<String> as = new ArrayList<String>(); // 如果这里不加泛型，比如<String>，那么af.addAll(as);不会报错，就会造成安全隐患。
		as.add("S5");
		as.add("S6");

		printCollection(af); // 能接收Person及其子类
		printCollection(a1); // 能接收Person及其子类
		printCollection(a2);// 能接收Person及其子类
		System.out.println("*****");
		printCollection2(af);// 能接收Student及其父类
		printCollection2(a1);// 能接收Student及其父类
		// printCollection2(a2); //能接收Student及其父类，报错

		// 演示：addAll，一般存储元素的时候，用的是上限。因为取出的时候，都是按照父类来取或者运算，不会出现安全隐患。
		// 关于下限的演示，由于下限的使用较少，不再演示，仅作了解，视频内容在Day18的第10节中，比较难。
		// af.addAll(as); //上面as加入了泛型<String>,这里就会直接报错，可以在编写代码时就发现安全隐患，nice！！
		af.addAll(a1); // public boolean addAll(Collection<? extends E> c),这是addAll的源代码，可以看出这个方法其实限定了下限。
						// 注意，此时，用父类接收了子类的对象，这是可以的，但是在作出取出的操作时，是按照父类型(即Person)取出的。
		System.out.println("*****");
		printCollection(af);
		
		af.containsAll(as);	//public boolean containsAll(Collection<?> c)，这是containsAll的源代码，可以看出这个方法可以判断任意集合，
							//具体的原理，还是因为containsAll调用的是equals方法，这个原理与removeAll相同。
		af.removeAll(as);
	}

	/*
	 * 对类型的限定： 1.? extend E：接收E及其子类型，这叫做上限。 2.? super E：接收E及其父类型，这叫做下限。
	 */
	// private static void printCollection(Collection<Person> a) {
	// 这样写出错，因为编译器认为接收的类型只有Person，下面进行改正
	private static void printCollection(Collection<? extends Person> a) { // 这样才是接收的类型只是Person及其子类，这叫类型的限定，上限。
		for (Iterator<? extends Person> it = a.iterator(); it.hasNext();) { // 这里把迭代器限定为Person及其子类,更好，建议这么写
			// System.out.println(it.next());
			Person p = it.next();
			System.out.println(p); // 可以这样写了。但是如果前面迭代器写成Iterator<?> it =
									// a.iterator(); 就不能这样写。
		}
	}

	private static void printCollection2(Collection<? super Student> a) { // 这里接收的是Student及其父类，下限。
		for (Iterator<? super Student> it = a.iterator(); it.hasNext();) { // 这里把迭代器限定为Student及其父类
			System.out.println(it.next());
			// Person p = it.next();
			// System.out.println(p); // 不能这么写了
		}
	}
}
