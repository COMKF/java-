package p3_����API֮Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Map��һ�����һ��Ԫ�ء���Collection��ͬ��һ�����һ��Ԫ�ء�
 * MapҲ��Ϊ˫�м��ϣ�Collection��Ϊ���м��ϡ�
 * ��ʵMap�д洢�ľ��Ǽ�ֵ�ԣ���Map�����б��뱣֤����Ψһ�ԡ�
 * 
 * ���÷�����
 * 1.���
 * 1.1���һ����ֵ�� V put(K key, V value);//����ǰһ����key������ֵ�����û���򷵻�null
 * 2.ɾ��
 * 1.2����ָ����keyɾ�������ֵ�� V remove(Object key);//���������key������ֵ�����û�����key�򷵻�null
 * 2.2���Map���� void clear();
 * 3.�ж�
 * 3.1�ж�Map�����Ƿ����ӵ�����key�ļ�ֵ��  boolean containsKey(Object key);
 * 3.2�ж�Map�����Ƿ����ӵ�����value�ļ�ֵ��  boolean containsValue(Object value);
 * 3.3�ж�Map�����Ƿ�Ϊ��   boolean isEmpty();
 * 4.��ȡ
 * 4.1����ָ����key��ȡֵ  V get(Object key);//���������key������ֵ�����û�����key�򷵻�null
 * 4.2��ȡ���ϵĳ��� int size();
 */
/* ����Map���ϵ����ַ�����
 * 1.ȡ��ӳ��(Map����)�������������еļ�  Set<K> keySet();//���ص������м���Set���ϡ� (�˷����ص�����)
 * 		��ͨ��Set�ĵ�������ȡÿһ��������ͨ��get������ȡÿ������Ӧ��ֵ��
 * 2.ȡ��ӳ��(Map����)������ӳ���ϵ  Set<Map.Entry<K, V>> entrySet();//���ص�������ӳ���ϵ��Set���ϡ�
 * 		��Щӳ���ϵ����Map.Entry(��ʵ��Map���ڲ��ӿڵ����ͣ�����ӿ�Ҳ���ǳ����ӳ���ϵ),�ӿ����л�ȡ����getKey()�����ͻ�ȡֵ��getValue������
 * 
 * ����һ�ֻ�ȡ��������ֵ�ķ�����   Collection<V> values();//���ص�������ֵ��Collection���ϣ�֮������Collection������Ϊֵ�����ظ���
 * 		��ͨ������������ֱ�Ӵ�ӡ�ķ��������Щֵ��
 */

public class c1_Map�ĸ��� {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
 		method(map);
		System.out.println("******");
 		method2(map);
 		System.out.println("******");
		method3(map);

	}
	
	public static void method(Map<Integer, String> map) { // ����ѧ�ź������ļ���
		// ���
		System.out.println(map.put(8, "wangcai")); // 1.1
		System.out.println(map.put(8, "xiaoqiang"));// ����ͬ�ļ���ֵ�ᱻ����
		map.put(2, "lihua");
		map.put(7, "ye");

		// ɾ��
		System.out.println(map.remove(7)); // 2.1

		// �ж�
		System.out.println(map.containsKey(2)); // 3.1

		// ��ȡ
		System.out.println(map.get(8)); // 4.1

		System.out.println(map);
		
		Collection<String>  values = map.values();	//��ȡ��������ֵ�ķ���
		System.out.println(values);
	}

	private static void method2(Map<Integer, String> map) { // ����Map���Ϸ���һ
		map.put(8, "xiaoqiang");
		map.put(2, "lihua");
		map.put(7, "ye");

		Set<Integer> keySet = map.keySet();

		for (Iterator<Integer> it = keySet.iterator(); it.hasNext();) {
			Integer key = it.next();
			System.out.println(key + ":" + map.get(key));
		}
	}

	private static void method3(Map<Integer, String> map) { // ����Map���Ϸ�����
		map.put(8, "xiaoqiang");
		map.put(2, "lihua");
		map.put(7, "ye");

		Set<Map.Entry<Integer, String>> entrySet = map.entrySet(); // �����entrySet()��Map��һ����������ȡ����һ��Set����
		// ��������Set������װ����Map.Entry(Map��һ���ڲ��ӿ�)����Map.Entry<Integer,String>�е�Integerָ���˼���Integer����ֵͬ��
		for (Iterator<Map.Entry<Integer, String>> it = entrySet.iterator(); it.hasNext();) {
			Map.Entry<Integer, String> me = it.next(); // ͨ�����������Ի�ȡ����Map.Entry�ӿڣ�ÿ���ӿ���ʵ�������Եļ�ֵ�Ե�ӳ���ϵ
			Integer key = me.getKey(); // ͨ��getKey������ȡ���Map.Entry�ӿڣ�Ҳ�������ӳ���ϵ��key
			String value = me.getValue(); // ͨ��getValue������ȡ���Map.Entry�ӿڣ�Ҳ�������ӳ���ϵ��Value
			System.out.println(key + ":" + value);
		}
	}
}