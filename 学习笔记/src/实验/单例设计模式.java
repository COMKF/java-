package ʵ��;
/*
 *���ģʽ����ʵ��һ��˼�룬ͨ��ѧϰ���ַ�����������⣬����������JAVA���ԡ�
 *
 * �Գ�����˵��һ������ͨ��ֻ����һ��������Ϣ������Ҫ��������Ϣ�����޸ĵ�ʱ�򣬱���Ҫ��֤������Ϣ��Ψһ��
 * ��α�֤����Ψһ��
 * 1.����������������new������������Ϣ�Ķ���
 * 2.�ڸ�������Ϣ���Լ�����һ��ʵ��
 * 3.�����ṩһ���������������������ø�ʵ��
 * 
 * ���裺
 * 1.˽�л�����Ĺ��캯��
 * 2.�ڱ�����ͨ��new��������
 * 3.����һ���������ô����Ķ��󷵻�
 */

class config{
	private int num=0;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	private config() {}//���캯��˽�л�(����ʽ)
	private static config c=new config();//���Ը�ʵ��Ҳ�����Ǿ�̬�ģ�private˽�У���֤������������ֱ�����õķ�����ȡconfigʵ���������ַ������ɿ���
	public static config getConfig() {//��̬�ĳ�Ա�������ҿ����ں�������ӿ�������������if���
		return c;					//����Ϊ��java������Ͻ��ԣ������ܵ�Ϊ���е����е���������˽�л�
	}
	public void show() {
		System.out.println(num);
	}
}
public class �������ģʽ {
	public static void main(String args[]){
		config cc=config.getConfig();//������ó�Ա����(��.����)�ķ������Config��ʵ������˸ó�Ա���������Ǿ�̬��
		cc.setNum(10);
		cc.show();
		config cc2=config.getConfig();
		cc2.setNum(20);
		cc2.show();
		cc.show();
		System.out.println(cc==cc2);
	}
}

/* ������Ƶ���һ������(����ʽ)   ��������ĺô����������ʱ�����󲢲��ᴴ����ֻ�е��������������ʱ���Żᴴ������(�ӳټ���)
class config{  //������������и���ȫ���������̵߳���ʱ�����ܻ��������������Կ���ʱ��������
	private config() {}//���캯��˽�л�
	private static config c=null;
	public static config getConfig() {
	if(c==null) c=new config();
		return c;					
	}
}
*/
