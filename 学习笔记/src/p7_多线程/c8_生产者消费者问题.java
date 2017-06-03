package p7_���߳�;
//����������������
/* if�жϱ�ǣ�ֻ�ж�һ�Σ��ᵼ�²������еĳ��������ˣ��������ݴ���������
 * whlie�жϱ�ǣ�������̻߳��ִ��Ȩ���Ƿ�Ҫ���У�
 * notify��ֻ�ܻ���һ���̣߳�����������±�����û�����塣����while+notify�ᵼ��������
 * notifyAll������һ���ỽ�ѶԷ��̡߳�������ǰ����ʱ��while+notifyAll��
 * ���������ֳ����ˣ�notifyAllҲ�ỽ�ѱ����̣߳������Ļ�CPUִ��Ч�ʾͻ��½�����������ν���أ�
 * jdk1.5�汾��������������˲��䣬����Ľ��������һ�ڽ���˵����
 */
class duck{//��Ѽ
	private String name;
	private int count=1;
	private boolean flag= false;	//false����û�п�Ѽ��true�����п�Ѽ
	public synchronized void set(String name){
		//if(flag)	//�ʼ�Ĵ���
		while (flag) {	//�Ż���ʹ��while
			try {this.wait();}
			catch (InterruptedException e) {}
		}
		this.name=name+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
		flag=true;
		//this.notify();	//�ʼ�Ĵ���
		this.notifyAll();	//�Ż���ʹ��this.notifyAll
	}
	
	public synchronized void out() {
		//if(flag)	//�ʼ�Ĵ���
		while (!flag) {	//�Ż���ʹ��while
			try {wait();}
			catch (InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName()+".....������....."+this.name);
		flag=false;
		//notify();	//�ʼ�Ĵ���
		notifyAll();	//�Ż���ʹ��notifyAll
	}
}

class Producer implements Runnable{//�����ߣ�������Ѽ
	private duck d;
	public Producer(duck d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.set("��Ѽ");
		}
	}
}

class Customer implements Runnable{//�����ߣ����ѿ�Ѽ
	private duck d;
	public Customer(duck d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.out();
		}
	}
}
public class c8_���������������� {

	public static void main(String[] args) {
		duck d= new duck();
		Producer pro= new Producer(d);
		Customer cus= new Customer(d);
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
/* ���������������������
 * ��ʼ״̬��t0(��)t1(��)t2(��)t3(��)
 * ��չ��CPUִ��t0��flag=false��ִ��else��������Ѽ1�� flag=true��ͬʱ������һ�߳�(��Ч���������̶߳�������)��
 * 		CPUִ��t0�� flag=true��ִ��if��t0����(ע�⣬t0�����ﶳ�ᣬҲ�������﻽�ѣ����Ի���ʱ�������if�ж�)��
 *		CPUִ��t1��flag=true��ִ��if��t1����(ע�⣬t1�����ﶳ�ᣬҲ�������﻽�ѣ����Ի���ʱ�������if�ж�)��
 * 		CPUִ��t2�� flag=true��ִ��else�����ѿ�Ѽ1�� flag=false�������߳�t0��t1(����һ�����У���Ӱ��)��
 * 		CPUִ��t2�� flag=false��ִ��if��t2����(ע�⣬t0�����ﶳ�ᣬҲ�������﻽�ѣ����Ի���ʱ�������if�ж�)��
 * 		CPUִ��t3�� flag=false��ִ��if��t3����(ע�⣬t0�����ﶳ�ᣬҲ�������﻽�ѣ����Ի���ʱ�������if�ж�)��
 * 		CPUִ��t0��flag=false��ִ��else��������Ѽ2�� flag=true��ͬʱ������һ�̣߳�����ͳ������������
 * ��ʱ��״̬��t0(��)t1(����)t2(����)t3(����)
 * 		������ѵ���t1�Ļ�����t1(��)�����ұ�����ʱ�Ѿ��жϹ�if�ˣ����ٽ���if�жϡ�
 * 		CPUִ��t0�� flag=true��ִ��if��t0����(ע�⣬t0�����ﶳ�ᣬҲ�������﻽�ѣ����Ի���ʱ�������if�ж�)��
 * 		t0��ʱ���ᣬCPUֻ��ִ��t1
 * 		CPUִ��t1����Ȼ��ʱ flag=true�����ǲ��ٽ����жϣ�����ֱ������ִ�У�������Ѽ3�� flag=true��ͬʱ������һ�̡߳�
 * ��ʱ��״̬��t0(����)t1(��)t2(����)t3(����)
 * 		����ٴλ��ѵ���t0����ô���п��ܳ���t0,t1���໽�Ѷ������ѵ�״̬��ֱ��ĳһʱ��t2��t3�����ѡ�
 * ��������ֶ��������һ�����ѵ����⡣
 *		����һ��������������ѵ�����ԭ��һ����
 *
 *������ν����
 *��Ϊ��if�жϵ����⣬���ǿ��԰�if��Ϊwhlie�������Ļ���ʹ�����ѣ�Ҳ���ٴν����жϣ�������ֶ�����������ѵ����⡣
 *����ʹ��while֮�󣬻ᷢ��һ�����⣬������(ԭ���Լ��ư�)
 *�ٴν��������⣿
 *��notify()�Ż�ΪnotifyAll()��Ŀ���ǻ������б�������̡߳�
 *���ˣ�����Բ�������
 */
