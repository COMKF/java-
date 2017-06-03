package p5_�����������;

/* Object��������ĸ��࣬�ǲ��ϳ�ȡ�����ģ��߱����ж���Ĺ������ݡ�
 * ���ù��ܣ�
 * 1.equals(Object obj) (ԭ����)ͨ���ж���������ĵ�ֵַ���ж������Ƿ���ͬһ����(�ص�����)
 * 		һ�㶼�Ḳ�Ǵ˷�����ֻ�жϵ�ֵַû��̫�����壬����Ҫ���ݶ�����������ݣ������ж϶����Ƿ���ͬ�����ݡ�
 * 2.hashCode() (ԭ����)���ظö���Ĺ�ϣ��ֵ
 * 3.getClass()(ԭ����)���ظö��������ʱ��
 * 1.toSting()(ԭ����)���ظö�����ַ�����ʾ,�����������า�Ǵ˷�����ԭ����=getgetClass().getName()+@+Integer.toHexString(hashCode())
 */
class Person4{
	private int age;
	public Person4(int age) {
		this.age=age;
	}
	//����Ƚ϶���ĵ�ֵַ����Ƚ��Ƿ���ͬ���ˣ��������дequals(Object obj)����
	public boolean equals(Object obj) {	//(��д��)����(�β�)��Object���൱�ڶ�ʵ�ν���������ת�ͣ������������еı����ͷ������޷�ʹ����
		/*
		 */
		if (!(obj instanceof Person4)) { //����ת��ʱ,��Ҫע��ת���쳣���ж���Ҫת�͵Ķ����Ƿ�����Person4�Ķ���
			throw new ClassCastException("���ʹ����ˣ���");//�׳��쳣�����ڶԴ�����в��Һ��޸�
		}
		Person4 p = (Person4) obj;		//����������ת�ͣ�����ʹ������ı����ͷ�����
		return this.age==p.age;
	}
	//�����˵��ض����ݣ������й�ϣֵ�Ķ���,�����дhashCode()����
	public int hashCode() {
		return age;
	}
	//��дtoString����
	public String toString() {
		return "Person4:"+age;
	}
}
class Pig{
}
public class c8_object���� {
	public static void main(String args[]){
		//equals
		Person4 p1=new Person4(20);
		Person4 p2=new Person4(20);
		Person4 p3=p1;
		Pig p= new Pig();
		System.out.println(p1==p2);//�Ƚϵ�ֵַ����equals�����޹�
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println("*****");
		//System.out.println(p1.equals(p));//���ڲ���
		//hashCode
		System.out.println(p1);
		System.out.println(p1.hashCode());//�����ʮ����
		System.out.println(Integer.toHexString(p1.hashCode()));//ת��Ϊʮ������
		System.out.println("*****");
		//getClass
		System.out.println(p1.getClass());//class �����������.Person4   ����p1������ʱ��
		System.out.println(p1.getClass().getName());//������getclass()�µĵõ������ķ���(���кܶ������ķ���)
		Class cla1=p1.getClass();
		Class cla2=p2.getClass();
		System.out.println(cla1==cla2);	//�϶���ture����Ϊp1��p2����Person4 �Ķ���
		System.out.println("*****");
		//toSting
		System.out.println(p1.toString());//System.out.println(p1); ���ߵȼۣ���ʵprintln(p1)�͵�����p1.toString()����
		System.out.println(p1);
		}

}
/* 
֪ʶ����:class�ļ��Ĳ���
class Class{		//�����е����ļ�(class�ļ�)���ϳ�ȡ���ɵõ����ļ�ȫ������������ʽ����������ļ�����ɲ��֣���java�У���Ҳ��һ������
	name;			//���ļ�������
	field;			//���ļ����ֶ�
	constructor;	//���ļ��Ĺ�����
	method;			//���ļ��ķ���
}
��java�еĹ�����Ĵ��룬���������ʽ����class�ļ���Ҳ���� ����.class���ֽ����ļ�
��������ʱ���Ͱ�������ֽ����ļ���������
 */

 