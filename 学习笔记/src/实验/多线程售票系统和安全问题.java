package ʵ��;
//Ŀ����Ҫ����100��Ʊ����4����������
class Ticker implements Runnable{//�̴߳����ĵڶ��ַ��������ַ������������������(1)
	private int num =100;
	public void run(){
		while (true) {//С�ģ������ѭ����true�����ѭ����һֱִ�У���Ҫ�ֶ�ֹͣ��������õ��Ա俨��Ȼ������
			if (num>0) {
				try {
					Thread.sleep(10);//sleep�������ܻᵼ���쳣�������쳣����Ҫ�׳����߲�׽��
					//���Ǵ�ʱ��Thread���е�run����û���׳�����ô��Ϊ�����и��ǵ�run����Ҳ���ܹ��׳�������ֻ�ܲ�׽
					//sleep��������ֵ��쳣�������InterruptedException���У�����catch�е��쳣����ΪInterruptedException e��
				}
				catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
			}
			
		}
	}
}
//��ȫ���⣺��һ���߳�ȡ��num=1ʱ��CPUȴ�л�����̣߳���ʱ������߳�ȡ����num���Լ������������Ծͻ����num=0��������num=-1�������������Ƿǳ�Σ�յ�
//Ϊ�˱�¶������⣬���ԷŴ�CPU�л��ĸ��ʣ���������sleep�������߳���ʱ���ᣬ��CPU�ͻ������л��ˣ�����
/* �����ȫ���������ԭ��
 * 1.����߳��ڲ������������
 * 2.�����������ݵ��߳��ж���
 * ��һ���߳���ִ�в����������ݵĶ�������ʱ�������̲߳��������㣬�ͻᵼ�°�ȫ����Ĳ�����
 * �������˼·���ͻᷢ�ֶ��߳��еİ�ȫ���⡣
 */

public class ���߳���Ʊϵͳ�Ͱ�ȫ���� {
	public static void main(String[] args) {
		Ticker t=new Ticker();		//ֻ������һ������
		Thread t1=new Thread(t);	//ͨ��������󴴽�����̣߳���ʹ��ͬһ��num
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);	//Ϊ�˼���CPU���ɣ��ڴ�ע�͵�
		//Thread t4=new Thread(t);
		t1.start();
		t2.start();
		t3.start();//���к󣬿ɱ�¶num=0��num=-1�����ȫ���⣬��Ϊ��Ʊ��������0��Ʊ������������-1��Ʊ
		
		
	}

}

//��һ�ַ���ʾ�����Լ�ȱ��
/*
 * 
class Ticker extends Thread{//�̴߳����ĵ�һ�ַ���
	private int num =100;//���(1)����numǰ����static�ؼ��֣�ʹnum��Ϊ�������Խ��������⡣���Ǽ���static���պ���ܻ���ָ�������⣬���Բ�ʹ��
	public void run(){
		while (true) {
			if (num>0) {
				System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
			}
			
		}
	}
}
public class ���߳���Ʊϵͳ�Ͱ�ȫ���� {
	public static void main(String[] args) {
		Ticker t1=new Ticker();
		Ticker t2=new Ticker();
		Ticker t3=new Ticker();
		Ticker t4=new Ticker();
		
		t1.start();// �������������һ��������(1)��������4������ÿ��������100��Ʊ����͵��³�����400��Ʊ�������ⲻ����
		t2.start();
		t3.start();
		t4.start();
		//���(1)�����⣬����ʹ��ͬһ���󣬴���ͬһ����Ķ���̣߳�����
		/* 
		Ticker t1=new Ticker();
		t1.start();//����Ҳ�ǲ����еģ���Ϊͬһ�̲߳��ܷ���ʹ��start�����������ܷ�������
		t1.start();
		t1.start();
		t1.start();
		 */
		/*
		Ticker t1=new Ticker();
		Ticker t2=t1;
		t1.start();//ͬ�����ַ���Ҳ�ǲ��е�
		t2.start();
		 */
/*
	}
}
*/