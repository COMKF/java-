package p7_多线程;
/* 对多个程序的多线程进行优化，使其输入一个之后就输出一个。
 * 需要使用到等待/唤醒机制
 * 设计的方法：
 * 1.wait()等待，让线程处于冻结状态，被wait的线程会被存储在线程使用的锁的线程池中
 * 2.notify()唤醒线程池任一线程
 * 3.notifyAll()唤醒线程池全部线程
 * 这三个方法都定义在object类中，使用它们时需要有监视器，即锁，它监视着这个线程的运行状态
 * 这些方法都必须定义在同步中，因为这些方法都是用于操作线程的方法，必须要明确到底操作哪个锁的哪个线程
 * 
 * 为什么这三个方法都定义在object中？因为这些方法都是监视器方法。
 * 锁可以是任意对象，而任意对象的方法一定定义在object中
 */
/* 小知识：
 * wait()和sleep()的区别？
 * 1.wait可以指定时间也可以不指定时间，sleep必须指定时间
 * 2.wait：释放执行权，释放锁。 sleep：释放执行权，不释放锁。
 */
class Resource1{ //资源
	String name;
	String sex;
	boolean flag=false;
}
class Input1 implements Runnable{//输入
	Resource1 r;
	Input1(Resource1 r){
		this.r=r;
	}
	public void run(){//输入
		int x=0;
		while (true){//不能把while循环放在同步里，否则同步会一直在这个地方转圈
			synchronized (r) {//r是锁，也就是对象监视器
				if (r.flag) {//r的flag属性
					try {r.wait();}//使用wait和notify必须用监视器调用，即r.wait()和r.notify()，调用之后线程会被冻结，存储在锁r的线程池中
					catch (InterruptedException e) {}//wait和sleep都需要捕捉异常，且它们的异常类相同，都是InterruptedException
				}
					if (x==0) {
						r.name="xiaoqiang";
						r.sex="nan";
					}
					else{
						r.name="小红";
						r.sex="女女女";
					}
				r.flag=true;
				r.notify();
			}
			x=(x+1)%2;
		}
	}
}
class Output1 implements Runnable{//输出
	Resource1 r;
	Output1(Resource1 r){
		this.r=r;
	}
	public void run(){//输出
		while (true){
			synchronized (r) {
				if (!r.flag) {
					try {r.wait();}
					catch (InterruptedException e) {}
				}
				System.out.println(r.name+"..."+r.sex);
				r.flag=false;
				r.notify();
			}
		}
	}
}

public class c6_多程序多线程下的wait和notify {
	public static void main(String[] args) {
		//创建资源
		Resource1 r= new Resource1();
		//创建任务
		Input1 in= new Input1(r);
		Output1 out= new Output1(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
	}

}
