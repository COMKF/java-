package p1_����API֮���Ͽ��;

/* ��������  Iterator iterator()
 * ����ԭ���ڸ��ӿ�Collection����һ�� iterator()�������÷����ǻ�ȡһ��ʵ��Iterator�ӿڵĶ���
 * ����ʵ��Ӧ������Collection�ǽӿڣ��ӿڲ���ʵ��������������Ҫʵ��ʵ�ֽӿڵ��࣬�����Ǿ���ArrayListΪ����
 * 1.ArrayList��Ҳ�� iterator()�����������������������Collection�е� iterator()������
 * 2.ArrayList�л����һ�����ص��ڲ��࣬����ʵ��Iterator�ӿڣ������������Collection��û�С�
 * 3.ͨ��һ�����������Ի�ȡʵ��Iterator�ӿڵ��ڲ������(���ַ������Բο��ڲ����½�)���Ӷ��ٵ���Iterator�ķ�����������ȡԪ�ء�
 * ֵ��һ����ǣ�
 * 1.���ǲ���Ҫ��ע�ڲ�������ƣ�����
 * 		Collection coll = new ArrayList();
 * 		Iterator it = coll.iterator();
 * 		collʵ������һ����Collection���յ�ArrayList��������coll.iterator����������Iterator���յ�ArrayList����ר�õ�ʵ��Iterator�ӿڵ��ڲ������
 * 2.ÿһ�������в�ͬ��ʵ��Iterator�ӿڵ��ڲ����������ÿ��������iterator()�����еġ�
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class c2_���Ͽ��֮����������������� {

	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("ab");
		coll.add("abc");
		coll.add("abcd");
		coll.add("abcde");

		// ����Collection�е�iterator()���������ü����еĵ���������������ȡ�����еĵ���������
		/*
		 * Iterator it = coll.iterator(); while (it.hasNext()) {
		 * //��������ʹ�÷���������hasNext()�жϻ���û��Ԫ�� System.out.println(it.next());
		 * //��next()���Ԫ�أ��൱��һ��ָ�� }
		 */
		// �����ϵ�iterator()���������Ż�
		for (Iterator it = coll.iterator(); it.hasNext();) {// ���ַ����ĺô��ǿ����ͷ�coll.iterator()������it���󣬼����ڴ��˷�
			System.out.println(it.next());
		}
	}

}
