package p1_����API֮���Ͽ��;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;

/* List�µ��������������Ҫ����ʱ�õıȽ϶�ľ�������������
 * 1.Vector(1.0�汾����):�ڲ����������ݣ���ͬ���ģ�Ч�ʵͣ���ɾ��ɾ��ѯ��������
 * 2.ArrayList(1.2�汾����)���ڲ����������ݣ��ǲ�ͬ���ģ�Ч�ʸߣ���ѯ�ٶȿ졣
 * 			���������Vector�����Ҫ�õ����̣߳����Ը�ArrayList�����ȷ�ʽ��������Vector��
 * 3.LinkedList(1.2�汾����)���ڲ����������ݽṹ���ǲ�ͬ���ģ�Ч�ʸߣ���ɾԪ�ص��ٶȺܿ졣
 */

public class c5_List�е��������ö���֮Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement("abc1");
		v.addElement("abc2");
		v.addElement("abc3");
		v.addElement("abc4");

		for (Enumeration en = v.elements(); en.hasMoreElements();) {
			System.out.println(en.nextElement());
		}
		/*
		 * ֪ʶ���䣺Enumeration��Iterator�����ظ�����������ֻ��Ҫ�˽�Enumeration�Ϳ����ˣ��Ժ󿪷���Iterator��
		 * ������ԭ��
		 * 1.Enumerationֻ��Vector�еĽӿڣ�����List��û��Enumeration�ӿڡ�Vector�ѱ���̭��
		 * 2.Iterator�����١� �������ݽ����˽⡣
		 */

	}

}
