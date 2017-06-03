package p4_���Ͽ�ܹ�����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c4_Collectionsʵ��ͬ���ļ��� {

	public static void main(String[] args) {
//		ArrayList l = new ArrayList();	//����������ArrayList�ǲ�ͬ����
		ArrayList list =  new MyArrayList().synList(new ArrayList());	//����������ArrayList��ͬ����
		
		//ͨ��Collections��������ͬ�����ϣ����µļ��϶���ͬ����
		List l = Collections.synchronizedList(new ArrayList());	//��������ķ���ֵ��List
//		ArrayList al = (ArrayList) Collections.synchronizedList(new ArrayList());	//����ǿת������ArrayList
		Set s = Collections.synchronizedSet(new HashSet());		//��������ķ���ֵ��Set
//		HashSet hs = (HashSet) Collections.synchronizedSet(new HashSet());	//����ǿת������HashSet
		Map m = Collections.synchronizedMap(new HashMap());
//		HashMap hm = (HashMap) Collections.synchronizedMap(new HashMap());	//����ǿת������HashMap
		
	}
}

class MyArrayList{
	public ArrayList synList(ArrayList l){
		return new MyList(l);
	}
	
	private class MyList extends ArrayList{	//��MyList��ΪMyCollections���ڲ��࣬�Ҽ̳�ArrayList
		private ArrayList l ;
		
		private final Object lock = new Object(); 
		
		MyList(ArrayList l){
			this.l=l;
		}
		public boolean add(Object obj){
			synchronized(lock){	//��List�ķ�����װ������Ȼ�����ͬ��
				return l.add(obj);
			}
		}
		
		public boolean remove(Object obj){
			synchronized(lock){	//��List�ķ�����װ������Ȼ�����ͬ��
				return l.remove(obj);
			}
		}
	}
}

