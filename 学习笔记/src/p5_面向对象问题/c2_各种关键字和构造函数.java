package p5_�����������;

class Person{//�ࣺ��   ���ԣ����������䣬����
	String name;//һ�����������Ĵ��������ڣ��������ͷŶ���ʧ(����)
	private int age;//private�ؼ��֣����η�����ʾһ��˽�����ԣ���main�У�������ֱ�����õķ�����������ֵ����������(1)�ǲ��е�
	static String country="�й�";//static�ؼ��֣����η�����Ĭ������ͨ��������������Ķ����country��ֵ�����й������������ж����е�(����)�����Ĵ洢��ʽҲ��ͬ�������洢�ڱ��ط�������
								//static�����ε����ԣ������Ա���ֱ�ӵ��ã�Ҳ���Ա�������á���ֻ������Ĳ��������ڣ�������ͷŶ���ʧ���ڶ������ǰ�����ʹ����ˡ�
	public Person() {//���캯��һ��Ҫ��������������ͬ��������в�д���캯����java���Զ�����һ���յĹ��캯���������������
	}            //(���캯��ֻ����һ�Σ����ڴ��������ʱ����)
	//��Ա����(һ������)Ҳ����Ϊʵ����������̬����Ҳ����Ϊ�����
	public Person(String name){//���캯��������������ʱ�����ù��캯��������Ϊ������г�ʼ����������캯���������Ǹ���������
		this.name = name;//this�ؼ��֣�����ǰ������ʵ��ÿ��ʹ�����еķ���ʱ��java�����Զ�����һ��this��ָ��ʹ����������Ķ����������ǿ���ֱ��ʹ��this���޸Ķ��������ֵ
	}
	public Person(String name,int age){//���캯���������п�д������캯����ֻҪ������ͬ���ɣ�������캯���������Ǹ�������������������
		this(name);//���ù��캯��һ�����������Ψһ�ɵ����������캯���ķ��������Թ��캯��֧��Ƕ�ף�����˸�����(���ҵ��ù��캯�������䣬��������ͷ����֤���Ͻ���)
		setAge(age);//��װ
		//this.age=age; //��Ϊ�����������ã�����ֱ����������ֵ�ķ�������private����Ҳ����
	}

	public String getName() {//���е�set��get�������Ƿ�װ���ô����ں����ڲ�ϸ�ڣ�ʵ�ֹ���,��߰�ȫ�ԣ���߸�����
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {//������set�����м�����ƣ�����age����Ϊ����������setage�����м���if��䣬�����õĲ����׵����䷵�ش���
		this.age = age;
	}
	public void speak() {//���ֺ�����Ҳ�ɳ�Ϊһ�㺯�������Ǹ�ȷ�е�˵���������еķ������ɱ�����(���)����
		System.out.println(name+":"+age+":"+country);//������������еķ���������name��ageǰ�涼ʡ����this��
	}												//��country��ͬ������һ�����η�static��������ǰ��ʡ�Ե���Person��
	
	public boolean result(Person p) {//�Ƚ��������ǲ���ͬ���ˣ��Ƿ���ture�����Ƿ���false
		return this.age==p.age;
	}
}

public class c2_���ֹؼ��ֺ͹��캯�� {
	int num=10;
	public static void main(String[] args) {//mian��������static�ؼ��֣�����staticͬ���������η�������̬����ֻ�ܷ��ʾ�̬��Ա�����Ҳ�����this��super�ؼ���
		Person p= new Person();
		//p.age=25; //(1)�ǲ��е�
		p.setAge(25);//ʹ�÷�װ�ķ������Ըı�age����ֵ
		p.speak();
		
		Person p1= new  Person("С��");
		p1.speak();
		
		Person p2= new  Person("Сǿ",30);
		p2.speak();
		boolean result=p1.result(p2);//boolean result=p2.result(p1); ����д��Ҳ��
		System.out.println(result);
		
		new c2_���ֹؼ��ֺ͹��캯��().show();//��̬�������÷Ǿ�̬������ֻ��ͨ����new�½�����ʵ��
		//show(); //������ֱ�ӵ��÷Ǿ�̬�����ǲ��еģ�����ͨ����show�������Ϲؼ���static�����µ���������ˣ�static��show��������ʹ�÷Ǿ�̬����num������Ҫ��numǰ����ؼ���static
	}				//����ȥ��showǰ��ע�ͣ��Լ����԰�
	public void show() {
		System.out.print(num);
	}
}

