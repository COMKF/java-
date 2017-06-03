package p3_各种API之Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Map：一次添加一对元素。与Collection不同，一次添加一个元素。
 * Map也称为双列集合，Collection称为单列集合。
 * 其实Map中存储的就是键值对，且Map集合中必须保证键的唯一性。
 * 
 * 常用方法：
 * 1.添加
 * 1.1添加一个键值对 V put(K key, V value);//返回前一个与key关联的值，如果没有则返回null
 * 2.删除
 * 1.2根据指定的key删除这个键值对 V remove(Object key);//返回与这个key关联的值，如果没有这个key则返回null
 * 2.2清空Map集合 void clear();
 * 3.判断
 * 3.1判断Map集合是否包含拥有这个key的键值对  boolean containsKey(Object key);
 * 3.2判断Map集合是否包含拥有这个value的键值对  boolean containsValue(Object value);
 * 3.3判断Map集合是否为空   boolean isEmpty();
 * 4.获取
 * 4.1根据指定的key获取值  V get(Object key);//返回与这个key关联的值，如果没有这个key则返回null
 * 4.2获取集合的长度 int size();
 */
/* 遍历Map集合的两种方法：
 * 1.取得映射(Map集合)中所包含的所有的键  Set<K> keySet();//返回的是所有键的Set集合。 (此方法重点掌握)
 * 		再通过Set的迭代器获取每一个键，再通过get方法获取每个键对应的值。
 * 2.取得映射(Map集合)中所有映射关系  Set<Map.Entry<K, V>> entrySet();//返回的是所有映射关系的Set集合。
 * 		这些映射关系就是Map.Entry(其实是Map的内部接口的类型，这个接口也就是抽象的映射关系),接口中有获取键的getKey()方法和获取值的getValue方法。
 * 
 * 还有一种获取集合所有值的方法：   Collection<V> values();//返回的是所有值的Collection集合，之所以用Collection，是因为值可以重复。
 * 		再通过迭代器或者直接打印的方法输出这些值。
 */

public class c1_Map的概念 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
 		method(map);
		System.out.println("******");
 		method2(map);
 		System.out.println("******");
		method3(map);

	}
	
	public static void method(Map<Integer, String> map) { // 操作学号和姓名的集合
		// 添加
		System.out.println(map.put(8, "wangcai")); // 1.1
		System.out.println(map.put(8, "xiaoqiang"));// 存相同的键，值会被覆盖
		map.put(2, "lihua");
		map.put(7, "ye");

		// 删除
		System.out.println(map.remove(7)); // 2.1

		// 判断
		System.out.println(map.containsKey(2)); // 3.1

		// 获取
		System.out.println(map.get(8)); // 4.1

		System.out.println(map);
		
		Collection<String>  values = map.values();	//获取集合所有值的方法
		System.out.println(values);
	}

	private static void method2(Map<Integer, String> map) { // 遍历Map集合方法一
		map.put(8, "xiaoqiang");
		map.put(2, "lihua");
		map.put(7, "ye");

		Set<Integer> keySet = map.keySet();

		for (Iterator<Integer> it = keySet.iterator(); it.hasNext();) {
			Integer key = it.next();
			System.out.println(key + ":" + map.get(key));
		}
	}

	private static void method3(Map<Integer, String> map) { // 遍历Map集合方法二
		map.put(8, "xiaoqiang");
		map.put(2, "lihua");
		map.put(7, "ye");

		Set<Map.Entry<Integer, String>> entrySet = map.entrySet(); // 解读：entrySet()是Map的一个方法，获取的是一个Set集合
		// 解读：这个Set集合里装的是Map.Entry(Map的一个内部接口)，而Map.Entry<Integer,String>中的Integer指明了键是Integer对象，值同理
		for (Iterator<Map.Entry<Integer, String>> it = entrySet.iterator(); it.hasNext();) {
			Map.Entry<Integer, String> me = it.next(); // 通过迭代器可以获取各个Map.Entry接口，每个接口其实包含各自的键值对的映射关系
			Integer key = me.getKey(); // 通过getKey方法获取这个Map.Entry接口，也就是这个映射关系的key
			String value = me.getValue(); // 通过getValue方法获取这个Map.Entry接口，也就是这个映射关系的Value
			System.out.println(key + ":" + value);
		}
	}
}