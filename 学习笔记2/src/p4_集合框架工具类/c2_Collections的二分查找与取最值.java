package p4_集合框架工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c2_Collections的二分查找与取最值 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		Collections.sort(l);	//进行二分查找前必须先进行有序排序
		System.out.println(l);
		//二分查找
		int index = Collections.binarySearch(l, "aaa");	//二分查找，取得指定数据在集合中的脚标
		System.out.println("index="+index);
		//取最值
		String max = Collections.max(l);	//max方法，取得集合中的最大值
		System.out.println(max);
		max = Collections.max(l, new ComparaByLength());	//加入比较器的max方法，取得比较器规则下集合中的最大值
		System.out.println(max);
		
		String min = Collections.min(l);	//min方法，取得集合中的最小值
		System.out.println(min);
		min = Collections.min(l, new ComparaByLength());	//加入比较器的min方法，取得比较器规则下集合中的最小值
		System.out.println(min);
		
		
	}

}
