package p4_集合框架工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class c3_Collections的逆序与替换 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
//		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
//		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new ComparaByLength()));	//加入比较器的reverseOrder方法
		//如果集合是TreeSet，那么逆序排序方法，即reverseOrder方法，可以作为参数写在创建方法里，这个方法还可以在内部加入比较器，逆转了比较器的排序规则
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		System.out.println(l);
		
//		Collections.reverse(l);	//reverse方法，将集合逆序排序,这个方法没有加入比较器的版本
//		Collections.sort(l,new ComparaByLength());	//按比较器的顺序排序
//		Collections.reverse(l);		//然后再进行逆序
		Collections.sort(l,Collections.reverseOrder(new ComparaByLength()));
		//可以简写为这个形式，因为reverseOrder方法的返回值还是一个比较器，返回的比较器的内容是当前比较器的逆序排序规则
		System.out.println(l);
		
		Collections.replaceAll(l, "aab", "dddddddddd");	//replaceAll方法，对集合中所有的指定元素用新的元素替换
		System.out.println(l);
		
//		Collections.fill(l, "cc");	//fill方法，将集合中的所有元素替换为指定元素
//		System.out.println(l);
		
//		Collections.shuffle(l);	//对集合中的元素随机排序(洗牌)
//		System.out.println(l);
		
//		Enumeration<String> e = Collections.enumeration(l);	//enumeration方法，将任意集合转换为枚举类型
//		ArrayList<String> al= Collections.list(e);	//list方法，将枚举类型转换为ArrayList集合
//		//这两种方法结合使用，可以使任意集合转换为ArrayList集合。单独使用的话，可实现新旧集合类型的转换。
//		System.out.println(al);
	}
}
