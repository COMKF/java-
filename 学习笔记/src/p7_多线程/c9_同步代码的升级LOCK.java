package p7_���߳�;

import java.util.concurrent.locks.Condition;		//��Ҫ����İ��������нӿ�Condition
import java.util.concurrent.locks.Lock;				//��Ҫ����İ��������нӿ�Lock
import java.util.concurrent.locks.ReentrantLock;	//��Ҫ����İ���������ʵ�ֽӿ�Lock����ReentrantLock

/* jdk1.5��synchronized�й������Ļ�����ȡ�����������з�װ��������һ���µĽӿڣ�lock
 * ͬʱ��synchronized�У�����������ʽ��ʽ���嵽�����У�����ʽ���������ʾ����
 * ͨ�����lock�ӿڣ���ʵ����ʵ������ӿڵ���ReentrantLock(������)��ʵ��һЩ���ľ��幦��
 * ��ʽΪ��
	import java.util.concurrent.locks.Lock;	//��Ҫ����İ��������нӿ�Lock
	import java.util.concurrent.locks.ReentrantLock;	//��Ҫ����İ���������ʵ�ֽӿ�Lock����ReentrantLock
 	Lock l=new ReentrantLock();
	void show(){
		l.lock();	//��ȡ��
		try {
			System.out.println();	//ͬ���Ĵ���
		} 
		finally{
			l.unlock();	//�ͷ����������ͬ�������г����쳣��Ҳ�����ͷ��������԰��ͷ����Ĵ���д��finally�У���֤�����ͷ�
		}
	}
 */
/* object�еļ���������(wait��notify��notifyAll)Ҳ���ֽ�Ϊ��ͬ�Ķ��󣬷�װ�ڽӿ�Condition�У��Ա���Lock���ʹ��
 * Lock�����synchronized����������ʹ�ã�Condition�����object������������ʹ��
 * ��ͬ���ǣ�synchronizedֻ��һ������ֻ��һ����������������Ϊ���󣬼�Lock����ô��������Ի�ȡ���Condition�������������
 * ����Conditionʵ��ʵ���ϱ��󶨵�һ�����ϣ���Ҫ��������newCondition����
 * Condition�ķ����У�await�ȴ���signal���ѣ�signalAll��������
 * ��ʽΪ��
 * Lock l=new ReentrantLock();
 * Condition c1=l.newCondition();
 * Condition c2=l.newCondition();
 */
/* �������ǿ������ֽ��ǰ��������ˡ�
 * ͨ�����е���������ȡ�����������һ�����������һ��������ѣ����CPUЧ��
 */
/* Lock�ӿڣ������ͬ����������ͬ����������ͬ������ʽ�����������ʵ����������Ϊ������һ�����ϼ��϶��������
 * Condition�ӿڣ������object�еļ���������(wait��notify��notifyAll)������Щ�������з�װ�����Condition���������󣬿������������������
 */
class duck1{//��Ѽ
	private String name;
	private int count=1;
	private boolean flag= false;
	Lock l=new ReentrantLock();//������
	//Condition con=l.newCondition();//ͨ�����е�������������ؼ�����,�ʼ�Ĵ���
	Condition pro_con=l.newCondition();//�����ߵļ�����
	Condition cus_con=l.newCondition();//�����ߵļ���
	
	public void set(String name){
		l.lock();	//��ȡ��
		try {		//��try-finally�ṹ��װ��Ҫͬ���Ĵ���
			while(flag) {
				try {pro_con.await();}	//�ô����ļ�����ʹ����Ӧ��await���������̣߳��������߶���
				catch (InterruptedException e) {}
			}
			this.name=name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
			flag=true;
			//con.signalAll();//�ô����ļ�����ʹ����Ӧ��signalAll�������������߳�,�ʼ�Ĵ���
			cus_con.signal();//�������������ߵ�����һ�������������signalAll��������ʹCPUЧ�ʽ��ͣ��Լ�����Ϊʲô
		}
		finally{
			l.unlock();	//�ͷ�����
		}
	}
	
	public void out() {
		l.lock();
		try {
			while (!flag) {	
				try {cus_con.await();}	//�������߶���
				catch (InterruptedException e) {}
			}
			System.out.println(Thread.currentThread().getName()+".....������....."+this.name);
			flag=false;
			//con.signalAll();//�ʼ�Ĵ���
			pro_con.signal();//�������������ߵ�����һ�������������signalAll��������ʹCPUЧ�ʽ��ͣ��Լ�����Ϊʲô
		}
		finally{
			l.unlock();
		}
	}
}

class Producer1 implements Runnable{//�����ߣ�������Ѽ
	private duck1 d;
	public Producer1(duck1 d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.set("��Ѽ");
		}
	}
}

class Customer1 implements Runnable{//�����ߣ����ѿ�Ѽ
	private duck1 d;
	public Customer1(duck1 d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.out();
		}
	}
}

public class c9_ͬ�����������LOCK {

	public static void main(String[] args) {
		duck1 d= new duck1();
		Producer1 pro= new Producer1(d);
		Customer1 cus= new Customer1(d);
		Thread t0= new Thread(pro);//����������
		Thread t1= new Thread(pro);
		Thread t2= new Thread(cus);//����������
		Thread t3= new Thread(cus);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
