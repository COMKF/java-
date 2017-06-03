package p7_多线程;

import java.util.concurrent.locks.Condition;		//需要导入的包，其中有接口Condition
import java.util.concurrent.locks.Lock;				//需要导入的包，其中有接口Lock
import java.util.concurrent.locks.ReentrantLock;	//需要导入的包，其中有实现接口Lock的类ReentrantLock

/* jdk1.5把synchronized中关于锁的机制提取出来，并进行封装，产生了一个新的接口，lock
 * 同时将synchronized中，操作锁的隐式方式定义到对象中，将隐式动作变成显示动作
 * 通过这个lock接口，可实例化实现这个接口的类ReentrantLock(互斥锁)，实现一些锁的具体功能
 * 格式为：
	import java.util.concurrent.locks.Lock;	//需要导入的包，其中有接口Lock
	import java.util.concurrent.locks.ReentrantLock;	//需要导入的包，其中有实现接口Lock的类ReentrantLock
 	Lock l=new ReentrantLock();
	void show(){
		l.lock();	//获取锁
		try {
			System.out.println();	//同步的代码
		} 
		finally{
			l.unlock();	//释放锁。如果在同步代码中出现异常，也必须释放锁，所以把释放锁的代码写在finally中，保证锁的释放
		}
	}
 */
/* object中的监视器方法(wait，notify，notifyAll)也被分解为不同的对象，封装在接口Condition中，以便与Lock组合使用
 * Lock替代了synchronized方法和语句的使用，Condition替代了object监视器方法的使用
 * 不同的是，synchronized只有一个锁，只有一个监视器。当锁成为对象，即Lock，那么这个锁可以获取多个Condition，即多个监视器
 * 所以Condition实例实质上被绑定到一个锁上，需要调用锁的newCondition方法
 * Condition的方法有：await等待，signal唤醒，signalAll唤醒所有
 * 格式为：
 * Lock l=new ReentrantLock();
 * Condition c1=l.newCondition();
 * Condition c2=l.newCondition();
 */
/* 现在我们可以着手解决前面的问题了。
 * 通过已有的锁创建获取两组监视器，一组监视生产，一组监视消费，提高CPU效率
 */
/* Lock接口：替代了同步代码块或者同步函数，将同步的隐式锁操作变成现实锁操作。更为灵活，可以一个锁上加上多组监视器
 * Condition接口：替代了object中的监视器方法(wait，notify，notifyAll)，将这些方法进行封装，变成Condition监视器对象，可以与任意锁进行组合
 */
class duck1{//烤鸭
	private String name;
	private int count=1;
	private boolean flag= false;
	Lock l=new ReentrantLock();//创建锁
	//Condition con=l.newCondition();//通过已有的锁创建锁的相关监视器,最开始的代码
	Condition pro_con=l.newCondition();//生产者的监视器
	Condition cus_con=l.newCondition();//消费者的监视
	
	public void set(String name){
		l.lock();	//获取锁
		try {		//用try-finally结构封装需要同步的代码
			while(flag) {
				try {pro_con.await();}	//用创建的监视器使用相应的await方法冻结线程，让生产者冻结
				catch (InterruptedException e) {}
			}
			this.name=name+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
			flag=true;
			//con.signalAll();//用创建的监视器使用相应的signalAll方法唤醒所有线程,最开始的代码
			cus_con.signal();//单独唤醒消费者的其中一个，如果这里用signalAll，反而会使CPU效率降低，自己想想为什么
		}
		finally{
			l.unlock();	//释放锁。
		}
	}
	
	public void out() {
		l.lock();
		try {
			while (!flag) {	
				try {cus_con.await();}	//让消费者冻结
				catch (InterruptedException e) {}
			}
			System.out.println(Thread.currentThread().getName()+".....消费者....."+this.name);
			flag=false;
			//con.signalAll();//最开始的代码
			pro_con.signal();//单独唤醒生产者的其中一个，如果这里用signalAll，反而会使CPU效率降低，自己想想为什么
		}
		finally{
			l.unlock();
		}
	}
}

class Producer1 implements Runnable{//生产者，生产烤鸭
	private duck1 d;
	public Producer1(duck1 d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.set("烤鸭");
		}
	}
}

class Customer1 implements Runnable{//消费者，消费烤鸭
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

public class c9_同步代码的升级LOCK {

	public static void main(String[] args) {
		duck1 d= new duck1();
		Producer1 pro= new Producer1(d);
		Customer1 cus= new Customer1(d);
		Thread t0= new Thread(pro);//两个生产者
		Thread t1= new Thread(pro);
		Thread t2= new Thread(cus);//两个消费者
		Thread t3= new Thread(cus);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
