package p5_�����������;

class Person2{//�ࣺ��   ���ԣ����������䣬����
	private String name;//һ������(��Ծ�̬���Զ��ԣ�Ҳ�зǾ�̬����)
	private int age;//һ������
	static String country="�й�";//��̬����
	
	public Person2(String name,int age){
		this.name = name;
		this.age=age;
	}
	public void show() {
		System.out.println(Person2.country+":"+this.name+":"+this.age);	
	}
	public static void method() {
		System.out.println(Person2.country);	
	}
}
public class c_�ڴ�ֲ���� {   //ͼƬ��¼�ڱ����ļ��У���  �ڴ�ֲ����.png  ע�����������ڵ� ���ڴ�ֲ���⡱Ҳ��һ����
	public static void main(String[] args){
		Person2.method();
		Person2 p= new Person2("С��", 10);
		p.show();
	}

}
