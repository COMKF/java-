package ʵ��;
/* ����ʦ�õ����Ͽ�
 * �������󣺱���ʦ������
 * �������е����⣺����������ð��
 *  
 */
class LanpinException extends Exception{//��������
	LanpinException(String msg){
		super(msg);
	}
}
class MaoyanException extends Exception{//����ð��
	MaoyanException(String msg){
		super(msg);
	}
}
class NoPlanException extends Exception{//�γ̽����޷����
	NoPlanException(String msg){
		super(msg);
	}
}
class Computer{
	private int state=2;//��־����״̬
	public void run() throws MaoyanException,LanpinException {
		if (state==1)
			throw new LanpinException("������������");
		if (state==2) 
			throw new MaoyanException("����ð������");
		System.out.println("�������У�");
	}
	public void reset() {
		System.out.println("������������");
		state=0;
	}
}
class Teacher{
	private String name;
	private Computer comp;
	Teacher(String name) {
		this.name =name;
		comp= new Computer();
	}
	void prelect() throws NoPlanException{
		try {
			comp.run();
			System.out.println(name+"����");
		} 
		catch (LanpinException e) {//��ʵ�ʿ����У�catch�ڵĴ�����Ҫ�������Դ���������⣬������ֻ�����׳�
			System.out.println(e);//���������Ƚ��б���
			comp.reset();//������ʵ�Ĵ���ʽдcatch���룬����������Ҫ���������ǿɴ�������⣬��ô�Ϳ���ͨ����������Ԥ����
			prelect();//Ȼ���������
		}
		catch (MaoyanException e) {
			System.out.println(e);//���������Ƚ��б���
			test();//������ʵ�Ĵ���ʽдcatch���룬����ð�̾��ô������ϰ�����ǲ��ɴ��������
			//throw e;//Ȼ�������׳���������ѵ��˾ֻ������ʦ���Σ������ֵ���ð�̵����⹫˾Ҳ�޷������������������׳��ǲ������
					//����Ӧ���׳�һ���ù�˾�ܹ�����ģ������빫˾��ص�����
			//���ԶԵ��Խ���ά�ޣ����������Բ����߹�˾��
			//������������漰���γ̲��ܰ�ʱ��ɵ����⣬��������Ǻ͹�˾��صģ������׳�����������������⣬���׳���
			throw new NoPlanException("�γ̽����޷���ɣ�ԭ���ǣ�"+e.getMessage());//������쳣ת����Ҳ�ǿ��Ե�,����ʵ�ʿ��������õ�
		}
	}
	void test(){
		System.out.println("�������ϰ");
	}
}
public class �쳣Ӧ�ü�ת�� {

	public static void main(String[] args) {
		Teacher t=new Teacher("����ʦ");
		try {
			t.prelect();
		} 
		catch (NoPlanException e) {
			System.out.println(e.toString()+".....");
			System.out.println("����");
		}
		finally{
		}
	}
}
/* �쳣��ע�����
 * 1.�����ڸ��Ǹ��෽��ʱ������ķ�������׳����쳣����ô����ķ���ֻ���׳�������쳣���߸��쳣�����ࡣ
 * 2.����������׳�����쳣����ô����ֻ���׳������쳣���Ӽ���
 * ��˵�����า�Ǹ��࣬����ֻ���׳�������쳣�����쳣�����༰�Ӽ���
 * ע�⣺������෽��û���ܳ��쳣����ô���า��ʱ���Բ����׳��쳣����ֻ��try��
 */


