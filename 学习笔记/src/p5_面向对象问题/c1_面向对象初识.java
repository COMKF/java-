package p5_�����������;//�࣬�����������͡����ഴ����Ķ������ڶ��ڴ��У���main������һ�㺯�������ջ�ڴ��У�������ϣ��ڴ�ͻ��ͷ�

public class c1_��������ʶ {

	public static void main(String[] args) {
		Car c1=new Car();// ��new�½�����
		c1.num=4;
		c1.run();
		Car c2=new Car();// ��new�½�����
		c2.color="red";
		c2.run();
		
		Car c3=new Car();// ��new�½�����
		show(c3);
		System.out.println(11111111);
		c3.run();//һ�㺯�������βΣ�ʵ��ֵ���䡣�����ڴ�����ͬ�������βΣ�ʵ�����Ǵ��ݶ��ڴ�Ķ���ĵ�ַ��ʵ�λ��溯�����ö��ı� 
		System.out.println(11111111);
		new Car().run(); //ʹ����������(����Է���������һ�ε��õ�ʱ�򣬿ɼ�Ϊ��������)
		show(new Car()); //����������Ϊ��������
	}
	
	public static void show(Car c){ //һ�㺯�� 
		c.num=3;
		c.color="black";
		c.run();
	}
}

class Car{ //���� �Լ��� ���� �����Խ��ж���
	int num;
	String color;
	void run()//�����ڵĺ�����Ҳ��Ϊ����
	{
		System.out.println(num+"..."+color);
	}
}