package p5_�����������;

//��һ���������еķ���ȫ�����ǳ��󷽷���ʱ����ʱ���Խ�����������һ����ʽ����ͱ�ʾ���Ǿ��� �ӿ� interface
//��Ȼ�ӿ�Ҳ���࣬���ؼ��ֲ���class����interface
/* �ӿڵ��ص㣺1.�ṩ���Ⱪ¶�Ĺ��� 2.��������չ 3.���������
 * �ӿ��г����ĳ�Ա(������Щ��Ա���й̶������η���)��1.ȫ�ֳ��� public static final  2.���󷽷� public abstract 
 * �ɴ˵ó����ۣ��ӿ��еĳ�Ա�����ǹ�����Ȩ��
 */
interface Demo { //����һ���ӿڣ��������class�ļ�
	public static final int num = 10;//���η�ʾ��(�����д����Щ���η����Զ�����)
	public abstract void show1(); //���η�ʾ��
	void show2();//public abstract���η����Զ����ϣ����Ķ��Ա��������д��
}
//������֮���Ǽ̳й�ϵ������ӿ�֮����ʵ�ֹ�ϵ
//�ӿڲ�����ʵ������ֻ����ʵ���˽ӿڵ����า���˽ӿ������еĳ��󷽷��󣬸�����ſ���ʵ�����������������һ�������ࡣ
class Demo1 implements Demo{//implements��������extends
	public void show1(){//��������η�public
	}
	public void show2(){
	}
}
/* ��java�в�֧�ֶ�̳У���Ϊ����ֵ��õĲ�ȷ���ԣ�����java�Զ�̳л��ƽ����˸���������˶�ʵ��
 * һ�������ʵ�ֶ���ӿ�
 * һ�����ڼ̳���һ�����ͬʱ��������ʵ�ֶ���ӿ�
 */
interface D{
	public void show();
}
interface E extends D,Demo{//�ӿ���ӿ�֮���Ǽ̳й�ϵ�����ҿ��Զ�̳У�����ԭ�����ڽӿڵķ���û�з�����
	public void show();//���D��E��show����һ������int��һ������void,������Test��show�����ᱨ��������������ö�ʵ��,
}
class Test extends Demo1 implements D,E{//�̳���һ�����ͬʱ��ʵ���˶���ӿ�,�����˵��̳еľ�����
	public void show(){System.out.println("***");};
}
public class c6_�ӿ� {

	public static void main(String[] args) {
		Demo1 d= new Demo1();
		System.out.println(d.num);
		System.out.println(Demo1.num);
		System.out.println(Demo.num);
		
		Test t= new Test();
		t.show();
	}
}
/*��������ӿڵ���ͬ�㣺
 * ��ͬ�㣺
 * 		���ǲ������ϳ�ȡ�õ��ġ�
 * ��ͬ�㣺
 * 		1.��������Ҫ���̳У���ֻ�ܵ��̳С�
 * 		  �ӿ���Ҫ��ʵ�֣��ҿ��Զ�ʵ�֡�
 * 		2.�������п��Զ�����󷽷��ͷǳ��󷽷������༯�ɺ󣬿���ֱ��ʹ�÷ǳ��󷽷���
 * 		  �ӿ���ֻ���г��󷽷�������������ȥʵ�֣��ҽӿ��еĳ�Ա���й̶������η���
 * 		3.������ļ̳У���is a ��ϵ���ڶ������ϵ�Ļ����������ݡ�
 * 		  �ӿڵ�ʵ�֣���like a ��ϵ���ڶ�����ϵ�Ķ��⹦�ܡ�
 * 
 * ������
 * Ȯ�����ܷ֣���äȮ������Ȯ�ȡ�
 * 
 * abstract class Ȯ{          //����Ȯ�Ļ������ܣ����������ó����࣬����������̳�
 * 		abstract void ���();
 * }
 * 
 * interface ��ä{				//����Ȯ�Ķ��⹦�ܣ����⹦���ýӿڣ�����������ʵ��
 * 		abstract void ��ä();
 * }
 * class ��äȮ extends Ȯ implements ��ä{
 * 		public void ���(){
 * 		}
 * 		public void ��ä(){
 * 		}
 * } 
 */
