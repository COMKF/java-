package p5_�����������;
/*
 ��̬�����������ж�������һ������ֵ����ͬ�ģ��������Ա����������static���Σ��洢�ڱ��ط�������
 ��̬�������ú���û�з��ʵ��������ݣ���һ�����ʱ��������static����
 */
class Person3{
	static{//��̬����飺�ص㣺���������ã�Ϊ���ʼ������Ϊ�е��಻��Ҫ�����ص㣺ֻ����һ��
		System.out.println("�������!");
	}
	
	{//�������飺�ص㣺���������ã�Ϊ���ж������ͨ�õĳ�ʼ��(ÿ����һ�����󣬵���һ��)
		System.out.println("���󴴽���!");
	}
	
	public Person3(){//���캯�������ã�Ϊ������Ķ�Ӧ�ģ���Եĳ�ʼ��
	}
	
	public static void speak() {//��̬������Ҳ�о�̬����
		System.out.println("���Ƕ���");
	}
}
public class c3_��̬������ {
	public static void main(String[] args){
		System.out.println("****");
		new Person3().speak();
		System.out.println("****");
		new Person3();
		System.out.println("****");
		Person3.speak();
		}
}

//���䣺�ֲ����룬�޶��ֲ���������������
//ִ��˳�򣺾�̬����飬�������飬 ���캯��
