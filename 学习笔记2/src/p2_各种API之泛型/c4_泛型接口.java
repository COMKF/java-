package p2_����API֮����;

public class c4_���ͽӿ� {

	public static void main(String[] args) {
		InterImpl in = new InterImpl();
		in.show("123");

		InterImpl2<Integer> in2 = new InterImpl2<Integer>(); // ���ǣ������ʹ�õ�ʱ��һ��Ҫ��ȷ�����������������
		in2.show(5);

	}

}

interface Inter<T> { // ���ͽӿڣ������ʱ��һ�㲻��Ҫ��ȷ�����������������
	public void show(T t);
}

class InterImpl2<Q> implements Inter<Q> { // ʹ�ýӿڵ�ʱ�򣬿��Բ���ȷ����������������ͣ������ﱣ֤��ʹ�õķ�����ӿ�ʹ�õķ���һ��

	public void show(Q q) {
		System.out.println("show2:" + q);
	}

}

class InterImpl implements Inter<String> { // ʹ�ýӿڵ�ʱ��Ҳ������ȷ�����������������

	public void show(String t) {
		System.out.println("show:" + t);
	}

}