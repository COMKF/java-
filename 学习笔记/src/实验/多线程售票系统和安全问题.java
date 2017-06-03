package 实验;
//目标是要卖完100张票，分4个窗口卖。
class Ticker implements Runnable{//线程创建的第二种方法，这种方法可以完美解决问题(1)
	private int num =100;
	public void run(){
		while (true) {//小心，这里的循环是true，这个循环会一直执行，需要手动停止。否则会让电脑变卡，然后死机
			if (num>0) {
				try {
					Thread.sleep(10);//sleep方法可能会导致异常，出现异常则需要抛出或者捕捉。
					//但是此时，Thread类中的run方法没有抛出，那么作为子类中覆盖的run方法也不能够抛出，所以只能捕捉
					//sleep方法会出现的异常，存放在InterruptedException类中，所以catch中的异常参数为InterruptedException e。
				}
				catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
			}
			
		}
	}
}
//安全问题：当一个线程取得num=1时，CPU却切换这个线程，此时后面的线程取得了num可以继续操作，所以就会出现num=0，甚至是num=-1的溢出情况，这是非常危险的
//为了暴露这个问题，可以放大CPU切换的概率，方法是用sleep方法让线程暂时冻结，则CPU就会马上切换了，如下
/* 这个安全问题产生的原因：
 * 1.多个线程在操作共享的数据
 * 2.操作共享数据的线程有多条
 * 当一个线程在执行操作共享数据的多条代码时，其他线程参与了运算，就会导致安全问题的产生。
 * 按照这个思路，就会发现多线程中的安全问题。
 */

public class 多线程售票系统和安全问题 {
	public static void main(String[] args) {
		Ticker t=new Ticker();		//只创建了一个对象
		Thread t1=new Thread(t);	//通过这个对象创建多个线程，并使用同一个num
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);	//为了减轻CPU负荷，在此注释掉
		//Thread t4=new Thread(t);
		t1.start();
		t2.start();
		t3.start();//运行后，可暴露num=0和num=-1这个安全问题，因为卖票不可能买0号票，更不可能买-1号票
		
		
	}

}

//第一种方法示例，以及缺陷
/*
 * 
class Ticker extends Thread{//线程创建的第一种方法
	private int num =100;//解决(1)，在num前加上static关键字，使num成为共享，可以解决这个问题。但是加上static，日后可能会出现更大的问题，所以不使用
	public void run(){
		while (true) {
			if (num>0) {
				System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
			}
			
		}
	}
}
public class 多线程售票系统和安全问题 {
	public static void main(String[] args) {
		Ticker t1=new Ticker();
		Ticker t2=new Ticker();
		Ticker t3=new Ticker();
		Ticker t4=new Ticker();
		
		t1.start();// 这种做法会出现一个大问题(1)，创建了4个对象，每个对象有100张票，这就导致出现了400张票，与题意不符。
		t2.start();
		t3.start();
		t4.start();
		//解决(1)的问题，猜想使用同一对象，创建同一对象的多个线程，如下
		/* 
		Ticker t1=new Ticker();
		t1.start();//这样也是不可行的，因为同一线程不能反复使用start方法，即不能反复启动
		t1.start();
		t1.start();
		t1.start();
		 */
		/*
		Ticker t1=new Ticker();
		Ticker t2=t1;
		t1.start();//同理，这种方法也是不行的
		t2.start();
		 */
/*
	}
}
*/