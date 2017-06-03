package p4_集合框架工具类;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* foreach语句：
 * 格式:
 * for(类型  变量 : Collection集合|数组)
 * {
 * }
 * 
 * 传统for语句和foreach语句的区别：
 * 1.传统for语句可以完成对语句的多次执行，因为可以定义控制循环的增量和条件。
 * 2.foreach语句是一种简化的写法，它必须要有被遍历的目标，该目标必须是数组或者Collection单列集合。
 * 所以只是进行遍历的话，可以用foreach语句。需要操作的话，需要使用传统for语句。
 */
import java.util.Map;

public class c6_Foreach循环方法 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		for (String s : l) {	//foreach语句，jdk1.5出现的技术，好处在于简化书写，把迭代动作简化为语句，实际上底层用的还是迭代器技术
			System.out.println(s);
		}
		//用Iterator迭代器，可以在迭代时，对取出的元素进行操作。而foreach语句则不能，所以foreach语句通常只是用于遍历集合。
		
		int [] iarr = {3,3,1,5,6};
		for (int i : iarr) {
			System.out.println(i);	//可见，foreach语句也可以应用在数组中
		}
		
		//foreach语句能遍历Map集合吗？不能！但是我们可以换个思路，将Map转成单列的Set。
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "lihua");
		map.put(7, "ye");
		for(Integer key : map.keySet() ){	//法一
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		for (Map.Entry<Integer, String> me : map.entrySet()){	//法二
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
	}

}
