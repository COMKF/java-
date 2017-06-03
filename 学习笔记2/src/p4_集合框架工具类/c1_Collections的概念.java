package p4_集合框架工具类;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/* Collections是集合框架工具类，类里的方法都是静态的。
 * 接下来会介绍Collections的各种方法。
 */
public class c1_Collections的概念 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		System.out.println(l);
		//对List集合进行排序
//		Collections.sort(l);	//sort方法，掌握sort方法实现原理更好，如果不能，会使用也可以
//		mysort(l);
//		Collections.sort(l,new ComparaByLength());//加入比较器的sort方法，掌握其实现原理更好，如果不能，会使用也可以
		mysort(l,new ComparaByLength());
		
		System.out.println(l);
		
	}

	private static <T extends Comparable<? super T>> void mysort(List<T> l) {	//Collections.sort方法实现原理，用T，扩展性比较高
		for (int i = 0; i < l.size()-1; i++) {
			for (int j = i+1; j < l.size(); j++) {
				if (l.get(i).compareTo(l.get(j))>0) {
					Collections.swap(l, i, j);
//					T temp = l.get(i);		//Collections.swap方法实现原理
//					l.set(i, l.get(j));
//					l.set(j,temp);
				}
			}
		}
	}
	
	private static <T extends Comparable<? super T>> void mysort(List<T> l,Comparator<? super T> comp) {//加入比较器的sort方法，实现原理
		for (int i = 0; i < l.size()-1; i++) {
			for (int j = i+1; j < l.size(); j++) {
				if (comp.compare(l.get(i), l.get(j))>0) {
					Collections.swap(l, i, j);
				}
			}
		}
	}
}

class ComparaByLength implements Comparator<String> { // 创建比较器
	public int compare(String o1, String o2) {
		int temp = o1.length() - o2.length();
		return temp == 0 ? o1.compareTo(o2) : temp;
	}
}
