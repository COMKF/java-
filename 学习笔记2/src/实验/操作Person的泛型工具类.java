package ʵ��;

import bean.Person;

//public class ����Person�ķ��͹����� {
//	private Object object;	//�������ֱ�Ӵ���Person�����Ǵ���Person�ĸ������object�������Ļ����������Բ���Person�����ҿ��Բ����κζ���
//
//	public Object getObject() {
//		return object;
//	}
//
//	public void setObject(Object object) {
//		this.object = object;
//	}
//	
//}
/* ��jdk1.5֮��ʹ�÷�������������Ҫ�����������������͡�
 * ����Ƿ����ࡣʲôʱ���ã������еĲ����������������Ͳ�ȷ����ʱ�򣬾��÷�������ʾ
 */
public class ����Person�ķ��͹�����<EE> { // ��EE�������Զ���Ķ��󣬿��Բ�ָ���������
	private EE e;

	public EE getE() {
		return e;
	}

	public void setE(EE e) {
		this.e = e;
	}

	public <W> /* ���������(Ҳ��������)����λ��һ�����ڷ���ֵ����ǰ */void show(W str) { // ���Խ����Ͷ����ڷ����ϣ���ʹ���������ʱ��Ӧ������
		System.out.println("show:" + str);	//��Ȼ����str���������ַ������������ǲ������ַ�����ķ�������length(),Ϊʲô��
					//��Ϊ�����õ��Ƿ��ͣ��ڷ����ϣ�������������ʶ���û���Ҫ�������������������ʲô�����Բ������ض��ķ�������������object�ķ�����
	}

	public void print(EE str) { // ����ķ����뷺�����϶���ķ���һ�£�����EE
		System.out.println("print:" + str);
	}

	public static <Y> void method(Y object) { // ��������̬ʱ������ʹ�����϶���ķ���(��EE)��ֻ�ܽ����Ͷ����ڷ�����
		System.out.println("method:" + object);
	}

}