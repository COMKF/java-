package p5_�����������;

abstract class Dan{
	abstract void show();
}

interface Inter{
	void show1();
	void show2();
}

class Outer2 {
	int num=3;
	/* �ڲ������ھֲ�λ����
	 */
	void  method(int y){
		int x=5;
		class Inner2{		//λ�ڷ����е��ڲ��࣬����ʵ����������method()����������ڲ����û���κ�����
			void show(){
				System.out.println("show.."+x);
				System.out.println("show2.."+num);
				System.out.println("show2.."+y);
			}
		}
		Inner2 i= new Inner2(); //ֻ�������ﴴ��Inner2����
		i.show();
	}
	//Inner2 i= new Inner2();  ��ΪInner2����ڲ�������method()�����У������ﲻ�ܴ�������
	//i.show();
	
	/* �����ڲ��࣬�����ڲ���ļ�д��ʽ
	 * ������ǰ�᣺�ڲ������̳�һ���ⲿ���ʵ��һ���ӿ�
	 * �����ڲ��࣬��ʵ����һ�������������
	 * ��ʽ��new �����ӿ� (){��������}
	 * ͨ��ʹ�ó�����1.�����������ǽӿ�����ʱ�����ҽӿ��еķ�������������ʱ�������������ڲ�����Ϊʵ�ʲ������д���
	 */
	/*
	 * class Inner2 {	//дInner2��
		void show(){
			System.out.println("show3.."+num);
		}
	}
	 */
	void method(){  
		//new Inner2().show();	//���������ֵ����
		 new Dan(){	//�����ڲ���
			void show(){	//���������ڲ�������������ҪдInner2���Լ����������
				System.out.println("show3.."+num);
			}
		}.show();
		/*
		Dan d=new Dan(){	
			void show(){	
				System.out.println("show3.."+num);
			}
		};
		d.show();	//�����������ڲ������ж�������������ø������ô��������ڲ���Ķ�����ͨ��������ö������
		 */
	}
}

public class c91_�ڲ������� {
	class Inner{	//�Ǿ�̬��
	}
	public static void main(String[] args) {
		int y = 9;
		new Outer2().method(y);
		new Outer2().method();
		show(new Inter() {	//�����ڲ����ʹ��
			public void show2() {
				System.out.println("Inter2");
			}
			public void show1() {
				System.out.println("Inter1");
			}
		});
		//new Inner();//��̬�����в���ֱ��new�����Ǿ�̬���࣬��������֮ǰ�ӹؼ��� static
	}
	
	public static void show(Inter i) {
		i.show1();
		i.show2();
	}
	
}
