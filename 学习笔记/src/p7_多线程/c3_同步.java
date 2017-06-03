package p7_多线程;
/* 
 * 关于多线程售票的安全问题，先说明产生原因：
 * 1.多个线程在操作共享的数据
 * 2.操作共享数据的线程有多条
 * 当一个线程在执行操作共享数据的多条代码时，其他线程参与了运算，就会导致安全问题的产生。
 * 按照这个思路，就会发现多线程中的安全问题。
 * 
 * 解决思路：
 * 将多条操作共享数据的线程代码封装起来，当有线程在执行这些代码时，其他线程时不可以参与运算。
 * 必须要当前线程把这些代码都执行完毕后，其他线程才可以参与运算。
 * 在java中，用线程同步的方法就可以解决这个问题
 * 
 * 设置线程同步的两种方法：
 * 1.同步代码块
 * 格式：synchronized(对象){需要被同步的代码；}
 * 2.同步函数
 * 格式：public synchronized void 函数名() {需要被同步的代码；}
 * 
 * 同步的好处：解决了线程的安全问题
 * 同步的弊端：相对降低了效率，因为同步外的线程都会判断同步锁。(当同步的线程冻结时，同步外的线程获得CPU的执行权，但是因为锁的问题，无法往下执行)
 * 
 * 同步的前提：同步中必须有多个线程并使用同一个锁。
 */
/* 同步函数和同步代码块的区别：同步函数的锁是固定的，同步代码块的锁是任意的对象
 * 建议使用同步代码块。同步函数可以看做同步代码块的简写格式，有弊端。
 * 
 * 静态的同步函数使用的锁是 该函数所属的字节码文件对象，可以用get.class方法获取(需要对象)，也可以用 类名.class表示。
 */

class Ticker implements Runnable{
	private int num =100;
	Object obj=new Object();//锁必须设置在run方法外，这样每个线程共用一个锁，才能形成同步
	public void run(){	//千万不能在run方法中加关键字synchronized，这样的话，同步的线程会占据整个run方法，其他的线程根本就不能使用run方法
		//Object obj=new Object();//如果把锁设置在run方法中，则每个线程拥有自己独立的锁，这就不能形成同步，因为各线程不影响
		while (true) {//小心，这里的循环是true，这个循环会一直执行，需要手动停止。否则会让电脑变卡，然后死机
			synchronized (obj) {//这就是同步代码块
			//synchronized (this)//这里可以直接这样写
				//show();//用show方法封装需要同步的代码，然后调用已设置为同步函数的show方法
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
	public synchronized void show(){//同步函数，它的锁是固定的this(对象)
	//public static synchronized void show()//如果同步函数是静态的，那么它内部的变量必须要是静态的，而且它的锁是Ticker.class
		if (num>0) {
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+"...sale..."+num--);
		}
	}
}
public class c3_同步 {
	public static void main(String[] args) {
		Ticker t=new Ticker();		//只创建了一个对象
		Thread t1=new Thread(t);	//通过这个对象创建多个线程，并使用同一个num
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);	
		//Thread t4=new Thread(t);	//为了减轻CPU负荷，在此注释掉
		t1.start();
		t2.start();
		t3.start();
	}

}
