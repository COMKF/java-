package ʵ��;

import java.util.LinkedList;

/*
 * ��ջ���Ƚ����(FILO),Ҳ�ɳƺ���ȳ�(LIFO)
 * ���У��Ƚ��ȳ�(FIFO)
 * ����Ӧ������һ����������ʹ�����ṩ�������������������ֽṹ
 */
class MyLink { // ��LinkedList�����з�����װ����������һ���µ���������ʹ����ʹ��
	private LinkedList link;

	public MyLink() {
		link = new LinkedList();
	}

	public void myadd(Object obj) {
		link.addLast(obj);
	}

	public Object mygetduilie() { // ģ�����
		return link.removeFirst();
	}

	public Object mygetduizhan() { // ģ���ջ
		return link.removeLast();
	}

	public boolean isnull() {
		return link.isEmpty();
	}
}

public class ʹ��LinkedListģ���ջ��������ݽṹ {

	public static void main(String[] args) {
		MyLink m = new MyLink();
		m.myadd("abc1");
		m.myadd("abc2");
		m.myadd("abc3");
		m.myadd("abc4");

		/*
		 * while (!m.isnull()) { System.out.println(m.mygetduilie());
		 * 
		 * }
		 */

		while (!m.isnull()) {
			System.out.println(m.mygetduizhan());
		}
	}

}
