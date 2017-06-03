package p3_����API֮Map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 * ��ϰ����ȡһ���ַ����У�ÿ����ĸ���ֵĴ���
 * Ҫ���ӡ����ǣ�a(2)b(3)c(1)d(2)....
 * 
 * ��������ĸ�ʹ���֮�������ӳ���ϵ���������ֹ�ϵ�ܶࡣ
 * �ܶ����Ҫ�洢���ܴ洢ӳ���ϵ���������������Map���ϡ�
 * ��ϵ������ı����û�У�
 * �Ǿ���Map���ϡ��ַ��ּ�����һ����˳��abcd..
 * ���Կ���TreeMap���ϡ�
 * 
 * �����������Ӧ�ô洢������ĸ�ʹ����Ķ�Ӧ��ϵ��
 * 1.��Ϊ���������ַ����е���ĸ������Ӧ�Ȱ��ַ�����Ϊ�ַ����顣
 * 2.�����ַ����飬��ÿһ����ĸ��Ϊ��ȥ��Map���������
 * �������ĸ�����ڣ��ͽ�����ĸ��Ϊ������ֵΪ1�洢��Map�����С�
 * �������ĸ���ڣ��ͽ�����ĸ��ֵȡ������1���ٴ洢��Map�����С�
 * ����ͬ�ͻḲ�ǣ������ͼ�¼�˸���ĸ�Ĵ�����
 * 3.����������Map���Ͼͼ�¼��������ĸ���ֵĴ�����
 */
public class c3_Map��ϰ֮��ȡ�����ַ��Ĵ��� {

	public static void main(String[] args) {
		String str = "aabbccd   +-+  AS adadf";
		TreeMap<Character,Integer> map = strtomap(str);
		for (Iterator<Character> it = map.keySet().iterator(); it.hasNext();) {
			Character ch = it.next();
			System.out.print(ch+"("+map.get(ch)+")");
		}
		
	}

	private static TreeMap<Character, Integer> strtomap(String str) {
		//1.���ַ�����Ϊ�ַ�����
		char[] chars = str.toCharArray();
		//2.�����ַ����飬��ÿһ����ĸ��Ϊ��ȥ��Map���������
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		Set<Character> keySet = map.keySet();
		for (int i = 0; i < chars.length; i++) {
			if((chars[i]>='a' && chars[i]<='z')||(chars[i]>='A' &&chars[i]<='Z' )){	//��׳���жϣ�����������ĸ���ַ�
				if (!keySet.contains(chars[i])) {
					map.put(chars[i], 1);
				}
				else {
					map.put(chars[i],map.get(chars[i])+1);
				}
			}		
		}
		return map;
	}
}
