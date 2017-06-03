package p7_多线程;
//多生产多消费问题
/* if判断标记，只判断一次，会导致不该运行的程序运行了，出现数据错误的情况。
 * whlie判断标记，解决了线程获得执行权后，是否要运行！
 * notify：只能唤醒一个线程，如果本方换新本方，没有意义。而且while+notify会导致死锁。
 * notifyAll：本方一定会唤醒对方线程。所以以前开发时用while+notifyAll。
 * 但是问题又出现了，notifyAll也会唤醒本方线程，这样的话CPU执行效率就会下降，这样该如何解决呢？
 * jdk1.5版本针对这个问题进行了补充，具体的解决方法下一节进行说明。
 */
class duck{//烤鸭
	private String name;
	private int count=1;
	private boolean flag= false;	//false代表没有烤鸭，true代表有烤鸭
	public synchronized void set(String name){
		//if(flag)	//最开始的代码
		while (flag) {	//优化后使用while
			try {this.wait();}
			catch (InterruptedException e) {}
		}
		this.name=name+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"..生产者.."+this.name);
		flag=true;
		//this.notify();	//最开始的代码
		this.notifyAll();	//优化后使用this.notifyAll
	}
	
	public synchronized void out() {
		//if(flag)	//最开始的代码
		while (!flag) {	//优化后使用while
			try {wait();}
			catch (InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName()+".....消费者....."+this.name);
		flag=false;
		//notify();	//最开始的代码
		notifyAll();	//优化后使用notifyAll
	}
}

class Producer implements Runnable{//生产者，生产烤鸭
	private duck d;
	public Producer(duck d) {
		this.d=d;
	}
	public void run() {
		while(true){
			d.set("烤鸭");
		}
	}
}

class Customer implements Runnable{//消费者，消费烤鸭
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
public class c8_生产者消费者问题 {

	public static void main(String[] args) {
		duck d= new duck();
		Producer pro= new Producer(d);
		Customer cus= new Customer(d);
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
/* 生产者消费者问题产生：
 * 初始状态：t0(活)t1(活)t2(活)t3(活)
 * 发展：CPU执行t0，flag=false，执行else，生产烤鸭1， flag=true。同时唤醒任一线程(无效果，所有线程都在运行)。
 * 		CPU执行t0， flag=true，执行if，t0冻结(注意，t0在这里冻结，也就在这里唤醒，所以唤醒时不会进行if判断)。
 *		CPU执行t1，flag=true，执行if，t1冻结(注意，t1在这里冻结，也就在这里唤醒，所以唤醒时不会进行if判断)。
 * 		CPU执行t2， flag=true，执行else，消费烤鸭1， flag=false。唤醒线程t0或t1(任意一个都行，不影响)。
 * 		CPU执行t2， flag=false，执行if，t2冻结(注意，t0在这里冻结，也就在这里唤醒，所以唤醒时不会进行if判断)。
 * 		CPU执行t3， flag=false，执行if，t3冻结(注意，t0在这里冻结，也就在这里唤醒，所以唤醒时不会进行if判断)。
 * 		CPU执行t0，flag=false，执行else，生产烤鸭2， flag=true。同时唤醒任一线程，问题就出在这里！！！！
 * 此时的状态：t0(活)t1(冻结)t2(冻结)t3(冻结)
 * 		如果唤醒的是t1的话，则t1(活)，而且被唤醒时已经判断过if了，不再进行if判断。
 * 		CPU执行t0， flag=true，执行if，t0冻结(注意，t0在这里冻结，也就在这里唤醒，所以唤醒时不会进行if判断)。
 * 		t0此时冻结，CPU只能执行t1
 * 		CPU执行t1，虽然此时 flag=true，但是不再进行判断，而是直接向下执行，生产烤鸭3， flag=true。同时唤醒任一线程。
 * 此时的状态：t0(冻结)t1(活)t2(冻结)t3(冻结)
 * 		如果再次唤醒的是t0，那么就有可能出现t0,t1互相唤醒而不消费的状态，直到某一时刻t2或t3被唤醒。
 * 结果：出现多次生产，一次消费的问题。
 *		出现一次生产，多次消费的问题原理一样。
 *
 *问题如何解决？
 *因为是if判断的问题，我们可以把if改为whlie。这样的话即使被唤醒，也会再次进行判断，避免出现多生产或多消费的问题。
 *但是使用while之后，会发现一个问题，死锁。(原理自己推吧)
 *再次解决这个问题？
 *把notify()优化为notifyAll()，目的是唤醒所有被冻结的线程。
 *至此，问题圆满解决。
 */
