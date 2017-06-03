package p7_���߳�;
/* �����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿ�
 * 1.������ʵ��Runnable�ӿ�
 * 2.���ǽӿ��е�run���������̵߳���������װ��run������
 * 3.ͨ��Thread�ഴ���̶߳��󣬲���Runnable�ӿڵ����������Ϊ���캯���Ĳ������д���
 * 		��Ϊ�߳����񶼷�װ��Runnable�ӿ���������run�����С�����Ҫ���̶߳��󴴽�ʱ�ͱ���Ҫ��ȷҪ���е�����
 * 4.�����̶߳����start���������߳�
 */
/* ʵ��Runnable�ӿڵĺô���
 * 1.���̵߳�������̵߳������з�������������˵����ķ�װ��������������˼�뽫�����װ�ɶ���
 * 2.������java���̳еľ����ԡ�
 * ���ԣ������̵߳ĵڶ��ַ�ʽ��Ϊ���á�
 */
class ThreadDemo2 implements Runnable{ //���һ�����Ѿ��и��࣬��ô���Ͳ��ܼ̳� Thread�࣬��ʱ�����Ҫ��չ�������ʹ�ö��̵߳Ĺ��ܣ�����Ҫ�õ��ӿ�
		//����Ƕ��̴߳����ĵڶ��ַ�ʽ��implements Runnable��������run����
	public void run() {//ע������д������run�����е�����������������д������
		show();
	}
	public void show() {
		for (int x = 0; x < 20; x++) {
			System.out.println(Thread.currentThread().getName()+"..."+ ""+x);
		}
	}
}

public class c2_���̴߳����ĵڶ��ַ�ʽ��ϸ�� {

	public static void main(String[] args) {
		ThreadDemo2 t=new ThreadDemo2(); //ע�⣬��ʱ��ThreadDemo2û�м̳� Thread�࣬��ôThreadDemo2�����Ķ���Ͳ����̶߳���
		Thread t1=new Thread(t);//�����ַ��������԰�t�е�run�������뵽Thread��Ķ����У���t1��Ϊ�߳�ʹ��t��run����
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
		}
}
/* �ڶ��ִ����̷߳�������ʵԭ��
class Thread{
	private Runnable r;
	Thread(){
		
	}
	Thread(Runnable r){
		this.r=r;
	}
	public void run(){
		if (r!=null) {
			r.run();
		}
	}
	public void start(){
		run();
	}
}
 * 
 */
