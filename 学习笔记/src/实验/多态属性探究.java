package ʵ��;

/* ��̬����Ա���ص㣺
 * 1.��Ա������
 * 		����ʱ���ο������ͱ��������������Ƿ��е��õĳ�Ա�������У�����ͨ����û�У�����ʧ�ܡ�
 * 		����ʱ���ο������ͱ��������������Ƿ��е��õĳ�Ա�����������и��������еĳ�Ա������
 * 		��˵����������ж��ο���ߡ�
 * 2.��Ա������(�Ǿ�̬)(��������)
 * 		����ʱ���ο������ͱ��������������Ƿ��е��õĺ������У�����ͨ����û�У�����ʧ�ܡ�
 * 		����ʱ���ο����Ƕ��������������Ƿ��е��õĺ�����
 * 		��˵�����뿴��ߣ����п��ұ�
 * 3.��̬������(����������)
 * 		����ʱ���ο������ͱ��������������Ƿ��е��õľ�̬������
 * 		����ʱ���ο������ͱ��������������Ƿ��е��õľ�̬������
 * 		��˵����������ж��ο���ߡ�
 * 		��ʵ�����ھ�̬�����ǲ���Ҫ����ģ�ֱ�����������ü��ɡ�
 */

class Fu{
	int num=5;
	void show(){
		System.out.println("fu show");
	}
	static void method(){
		System.out.println("fu method");
	}
}
class Zi extends Fu{
	int num=10;
	void show(){
		System.out.println("zi show");
	}
	static void method(){
		System.out.println("zi method");
	}
}

public class ��̬����̽�� {
	public static void main(String[] args) {
		Fu f=new Zi();
		System.out.println(f.num);
		f.show();
		f.method();
		
		Zi z=new Zi();
		System.out.println(z.num);
		z.show();
		z.method();
		
	}

}
