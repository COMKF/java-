package p7_���߳�;
/* 
 * ���ڶ��߳���Ʊ�İ�ȫ���⣬��˵������ԭ��
 * 1.����߳��ڲ������������
 * 2.�����������ݵ��߳��ж���
 * ��һ���߳���ִ�в����������ݵĶ�������ʱ�������̲߳��������㣬�ͻᵼ�°�ȫ����Ĳ�����
 * �������˼·���ͻᷢ�ֶ��߳��еİ�ȫ���⡣
 * 
 * ���˼·��
 * �����������������ݵ��̴߳����װ�����������߳���ִ����Щ����ʱ�������߳�ʱ�����Բ������㡣
 * ����Ҫ��ǰ�̰߳���Щ���붼ִ����Ϻ������̲߳ſ��Բ������㡣
 * ��java�У����߳�ͬ���ķ����Ϳ��Խ���������
 * 
 * �����߳�ͬ�������ַ�����
 * 1.ͬ�������
 * ��ʽ��synchronized(����){��Ҫ��ͬ���Ĵ��룻}
 * 2.ͬ������
 * ��ʽ��public synchronized void ������() {��Ҫ��ͬ���Ĵ��룻}
 * 
 * ͬ���ĺô���������̵߳İ�ȫ����
 * ͬ���ı׶ˣ���Խ�����Ч�ʣ���Ϊͬ������̶߳����ж�ͬ������(��ͬ�����̶߳���ʱ��ͬ������̻߳��CPU��ִ��Ȩ��������Ϊ�������⣬�޷�����ִ��)
 * 
 * ͬ����ǰ�᣺ͬ���б����ж���̲߳�ʹ��ͬһ������
 */
/* ͬ��������ͬ������������ͬ�����������ǹ̶��ģ�ͬ����������������Ķ���
 * ����ʹ��ͬ������顣ͬ���������Կ���ͬ�������ļ�д��ʽ���б׶ˡ�
 * 
 * ��̬��ͬ������ʹ�õ����� �ú����������ֽ����ļ����󣬿�����get.class������ȡ(��Ҫ����)��Ҳ������ ����.class��ʾ��
 */

class Ticker implements Runnable{
	private int num =100;
	Object obj=new Object();//������������run�����⣬����ÿ���̹߳���һ�����������γ�ͬ��
	public void run(){	//ǧ������run�����мӹؼ���synchronized�������Ļ���ͬ�����̻߳�ռ������run�������������̸߳����Ͳ���ʹ��run����
		//Object obj=new Object();//�������������run�����У���ÿ���߳�ӵ���Լ�������������Ͳ����γ�ͬ������Ϊ���̲߳�Ӱ��
		while (true) {//С�ģ������ѭ����true�����ѭ����һֱִ�У���Ҫ�ֶ�ֹͣ��������õ��Ա俨��Ȼ������
			synchronized (obj) {//�����ͬ�������
			//synchronized (this)//�������ֱ������д
				//show();//��show������װ��Ҫͬ���Ĵ��룬Ȼ�����������Ϊͬ��������show����
				if (num>0) {
					try {
						Thread.sleep(10);
					}
					catch (InterruptedException e) {}
					System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
				}
			}
		}
	}
	public synchronized void show(){//ͬ���������������ǹ̶���this(����)
	//public static synchronized void show()//���ͬ�������Ǿ�̬�ģ���ô���ڲ��ı�������Ҫ�Ǿ�̬�ģ�������������Ticker.class
		if (num>0) {
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
		}
	}
}
public class c3_ͬ�� {
	public static void main(String[] args) {
		Ticker t=new Ticker();		//ֻ������һ������
		Thread t1=new Thread(t);	//ͨ��������󴴽�����̣߳���ʹ��ͬһ��num
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);	
		//Thread t4=new Thread(t);	//Ϊ�˼���CPU���ɣ��ڴ�ע�͵�
		t1.start();
		t2.start();
		t3.start();
	}

}
