package p4_集合框架工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c4_Collections实现同步的集合 {

	public static void main(String[] args) {
//		ArrayList l = new ArrayList();	//这样创建的ArrayList是不同步的
		ArrayList list =  new MyArrayList().synList(new ArrayList());	//这样创建的ArrayList是同步的
		
		//通过Collections方法创建同步集合，以下的集合都是同步的
		List l = Collections.synchronizedList(new ArrayList());	//这个方法的返回值是List
//		ArrayList al = (ArrayList) Collections.synchronizedList(new ArrayList());	//可以强转来创建ArrayList
		Set s = Collections.synchronizedSet(new HashSet());		//这个方法的返回值是Set
//		HashSet hs = (HashSet) Collections.synchronizedSet(new HashSet());	//可以强转来创建HashSet
		Map m = Collections.synchronizedMap(new HashMap());
//		HashMap hm = (HashMap) Collections.synchronizedMap(new HashMap());	//可以强转来创建HashMap
		
	}
}

class MyArrayList{
	public ArrayList synList(ArrayList l){
		return new MyList(l);
	}
	
	private class MyList extends ArrayList{	//把MyList作为MyCollections的内部类，且继承ArrayList
		private ArrayList l ;
		
		private final Object lock = new Object(); 
		
		MyList(ArrayList l){
			this.l=l;
		}
		public boolean add(Object obj){
			synchronized(lock){	//把List的方法封装起来，然后加锁同步
				return l.add(obj);
			}
		}
		
		public boolean remove(Object obj){
			synchronized(lock){	//把List的方法封装起来，然后加锁同步
				return l.remove(obj);
			}
		}
	}
}

