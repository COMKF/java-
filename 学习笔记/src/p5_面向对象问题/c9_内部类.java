package p5_�����������;

/* ��һ���ඨ������һ��������棬��������Ǹ���ͳ�Ϊ�ڲ���(�����࣬Ƕ����)
 * �����ص㣺1.�ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�г�Ա
 * 			2.���ⲿ��Ҫ�����ڲ����еĳ�Ա����Ҫ�����ڲ���Ķ���
 * һ������������
 * ��������ʱ�����ָ����������л����������������ﻹ�ڷ��ʱ�������������ݡ�
 * ��ʱ�Ͱѻ��е����ﶨ��Ϊ�ڲ���������
 * Ϊʲô�ڲ�����ֱ�ӷ����ⲿ��ĳ�Ա����Ϊ�ڲ�������ⲿ��.this
 */
class Outer{
	static private int num=31;
	class Inner{
		void show(){
			System.out.println("show run..."+num);//�ڲ���ֱ�ӷ����ڲ���ĳ�Ա
		}
	}
	void method(){  //�ⲿ������ڲ����÷���
		Inner i = new Inner();
		i.show();
	}
	
	static class Inner2{	//����ڲ����Ǿ�̬�ģ��൱��һ���ⲿ��
		void show(){
			System.out.println("show run..."+num);//Inner2�Ǿ�̬�ģ�����numҲ�����Ǿ�̬��
		}
		static void fun(){	//����ڲ����о�̬��������ô�ڲ�������Ǿ�̬��
			System.out.println("fun run..."+num);
		}
	}
}

public class c9_�ڲ��� {
	public static void main(String[] args) {
		new Outer().method();
		Outer.Inner i=new Outer().new Inner();//�����ڲ������ķ���(��ס��ʽ)
		i.show();
		
		Outer.Inner2 i2= new Outer.Inner2();	//������̬�ڲ���ķ���(��ס��ʽ)
		i2.show();
		Outer.Inner2.fun();//��̬�ڲ��࣬��̬������ֱ��������÷���
		
	}

}
