package p4_���Ͽ�ܹ�����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class c3_Collections���������滻 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
//		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
//		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new ComparaByLength()));	//����Ƚ�����reverseOrder����
		//���������TreeSet����ô�������򷽷�����reverseOrder������������Ϊ����д�ڴ������������������������ڲ�����Ƚ�������ת�˱Ƚ������������
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		System.out.println(l);
		
//		Collections.reverse(l);	//reverse��������������������,�������û�м���Ƚ����İ汾
//		Collections.sort(l,new ComparaByLength());	//���Ƚ�����˳������
//		Collections.reverse(l);		//Ȼ���ٽ�������
		Collections.sort(l,Collections.reverseOrder(new ComparaByLength()));
		//���Լ�дΪ�����ʽ����ΪreverseOrder�����ķ���ֵ����һ���Ƚ��������صıȽ����������ǵ�ǰ�Ƚ����������������
		System.out.println(l);
		
		Collections.replaceAll(l, "aab", "dddddddddd");	//replaceAll�������Լ��������е�ָ��Ԫ�����µ�Ԫ���滻
		System.out.println(l);
		
//		Collections.fill(l, "cc");	//fill�������������е�����Ԫ���滻Ϊָ��Ԫ��
//		System.out.println(l);
		
//		Collections.shuffle(l);	//�Լ����е�Ԫ���������(ϴ��)
//		System.out.println(l);
		
//		Enumeration<String> e = Collections.enumeration(l);	//enumeration�����������⼯��ת��Ϊö������
//		ArrayList<String> al= Collections.list(e);	//list��������ö������ת��ΪArrayList����
//		//�����ַ������ʹ�ã�����ʹ���⼯��ת��ΪArrayList���ϡ�����ʹ�õĻ�����ʵ���¾ɼ������͵�ת����
//		System.out.println(al);
	}
}
