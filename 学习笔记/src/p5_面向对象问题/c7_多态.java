package p5_�����������;
/* �̳��Ƕ�̬��ǰ��
 * ����Ķ�̬�ԣ�һ������Ķ�����̬��һ������������̬��
 * ��̬�ڴ����е����֣������ӿڵ�����ָ��������Ķ���
 * ��̬�ĺô�������˴������չ�ԣ�ǰ�ڶ���Ĵ������ʹ�ú��������е�����
 * ��̬�ľ��ޣ�ǰ�ڶ���Ĵ��룬����ʹ�ú������������е�����
 * ��̬��ǰ�᣺1.�����й�ϵ(�̳У�ʵ��) 2.Ҫ���Ǹ����ӿڵķ���
 */
abstract class Animal{
	abstract void eat();
}
class Dog extends Animal{//�����ȿ��Գ�Ϊһֻ����Ҳ���Գ�Ϊһֻ�������Ƕ�̬
	void eat(){
		System.out.println("�й�ͷ");
	}
	void lookhome(){
		System.out.println("����");//���ڸ�����˵���������й���
	}
}
class Cat extends Animal{
	void eat(){
		System.out.println("����");
	}
	void catchmouse(){
		System.out.println("ץ����");//���ڸ�����˵���������й���
	}
}

public class c7_��̬ {

	public static void main(String[] args) {
		Cat c =new Cat();	//����������ķ���
		mothod(c);
		System.out.println("****");
		Dog d=new Dog();
		mothod(d);
		mothod(new Dog());
		Animal a = new Cat(); //�Զ���������(Ҳ�Ƕ�̬�����������)��è��������Ϊ�������ͣ��������й����޷����ʣ����粻��дa.catchmouse();
					//�������������������������й��ܵķ���(��������������ת��)
		a.eat();
		mothod(a);
		System.out.println("****");
		//�������ʹ�����й��ܣ����Խ���������ת��
		Cat cc=(Cat) a;	//����ת�ͣ�Ŀ����Ϊ��ʹ�������е����й���
		cc.eat();
		cc.catchmouse();
		//����ת�ͣ���ʼ���ն�������������������͵ı仯
	}
	public static void mothod(Animal a) {	//�ø��������գ����Խ��ն��������󡣸��ഴ���Ķ���ָ������
		a.eat();
		if (a instanceof Cat) {//instanceof ��ɸ�������߽ӿڣ������ж϶���ľ������ͣ�ֻ�������������ݵ��ж�
			Cat cc=(Cat) a;
			cc.catchmouse();
		}
	}

}
