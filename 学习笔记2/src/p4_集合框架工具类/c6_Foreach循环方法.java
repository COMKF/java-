package p4_���Ͽ�ܹ�����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* foreach��䣺
 * ��ʽ:
 * for(����  ���� : Collection����|����)
 * {
 * }
 * 
 * ��ͳfor����foreach��������
 * 1.��ͳfor��������ɶ����Ķ��ִ�У���Ϊ���Զ������ѭ����������������
 * 2.foreach�����һ�ּ򻯵�д����������Ҫ�б�������Ŀ�꣬��Ŀ��������������Collection���м��ϡ�
 * ����ֻ�ǽ��б����Ļ���������foreach��䡣��Ҫ�����Ļ�����Ҫʹ�ô�ͳfor��䡣
 */
import java.util.Map;

public class c6_Foreachѭ������ {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(); 
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");
		
		for (String s : l) {	//foreach��䣬jdk1.5���ֵļ������ô����ڼ���д���ѵ���������Ϊ��䣬ʵ���ϵײ��õĻ��ǵ���������
			System.out.println(s);
		}
		//��Iterator�������������ڵ���ʱ����ȡ����Ԫ�ؽ��в�������foreach������ܣ�����foreach���ͨ��ֻ�����ڱ������ϡ�
		
		int [] iarr = {3,3,1,5,6};
		for (int i : iarr) {
			System.out.println(i);	//�ɼ���foreach���Ҳ����Ӧ����������
		}
		
		//foreach����ܱ���Map�����𣿲��ܣ��������ǿ��Ի���˼·����Mapת�ɵ��е�Set��
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "lihua");
		map.put(7, "ye");
		for(Integer key : map.keySet() ){	//��һ
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		for (Map.Entry<Integer, String> me : map.entrySet()){	//����
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
	}

}
