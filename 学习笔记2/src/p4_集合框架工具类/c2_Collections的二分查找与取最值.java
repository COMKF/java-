package p4_���Ͽ�ܹ�����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c2_Collections�Ķ��ֲ�����ȡ��ֵ {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		Collections.sort(l);	//���ж��ֲ���ǰ�����Ƚ�����������
		System.out.println(l);
		//���ֲ���
		int index = Collections.binarySearch(l, "aaa");	//���ֲ��ң�ȡ��ָ�������ڼ����еĽű�
		System.out.println("index="+index);
		//ȡ��ֵ
		String max = Collections.max(l);	//max������ȡ�ü����е����ֵ
		System.out.println(max);
		max = Collections.max(l, new ComparaByLength());	//����Ƚ�����max������ȡ�ñȽ��������¼����е����ֵ
		System.out.println(max);
		
		String min = Collections.min(l);	//min������ȡ�ü����е���Сֵ
		System.out.println(min);
		min = Collections.min(l, new ComparaByLength());	//����Ƚ�����min������ȡ�ñȽ��������¼����е���Сֵ
		System.out.println(min);
		
		
	}

}
