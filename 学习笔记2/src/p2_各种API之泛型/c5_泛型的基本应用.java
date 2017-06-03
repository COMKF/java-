package p2_各种API之泛型;

/* 泛型的基础应用：
 * 使用泛型的通配符：?，未知类型。
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class c5_泛型的基本应用 {

	public static void main(String[] args) {
		ArrayList<String> a =new ArrayList<String>();
		a.add("12");
		a.add("123");
		
		ArrayList<Integer> a2 =new ArrayList<Integer>();
		a2.add(22);
		a2.add(2234);
		
		printCollection(a);
		printCollection(a2);
	}

	/**
	 * 迭代并打印集合中的元素
	 * @param a
	 */
	//private static void printCollection(ArrayList<String> a) { //如果只用ArrayList，那么只能接收ArrayList集合的元素，为了扩展，可以优化代码
	//private static void printCollection(Collection<String> a) {	//这样就可以接收任何Collection中的集合，List和Set都行，第一次优化
	private static void printCollection(Collection<?> a) {	//用通配符？代替String，可接收任意引用数据类型的任意Collection集合，第二次优化
		for (Iterator<?> it = a.iterator(); it.hasNext();) {	//那么迭代器也必须用通配符
//			String str = it.next();
//			System.out.println(str);
			System.out.println(it.next());	//第二次优化后因为使用了通配符，所以不能使用 ? str = it.next();因为类型未知，只能直接使用it.next()
			
		}
	}

}
/* 知识扩展：如果使用通配符不能使用 ? str = it.next();(这样不能对具体的对象进行操作)，但是我想对具体的对象进行操作，怎么办？
 * 解决的代码：
 * 	private static <T> void printCollection(Collection<T> a) {	//定义一个<T>，并使用<T>
		for (Iterator<T> it = a.iterator(); it.hasNext();) {	//那么迭代器也必须定义并使用<T>
			T str = it.next();			//这样就可以用这种方法对具体的对象进行操作，这种方法和通配符方法只有这一点不一样，其余的完全一样
			System.out.println(str);
		}
	也就是说，需要对具体的对象进行操作时，可以定义一个不明确的引用数据类型。
	而对?来说，只仅在不明确类型，并不对具体对象进行操作时使用。大多数情况是这种的情况，所以?可以解决大多数的问题了。
 */
