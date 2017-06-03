package p7_多线程;
/* 停止线程：1.stop方法，已过时，不再详说。2.run方法结束。
 * 
 * 怎么控制线程任务结束？  任务中都会有循环结构，只要控制住循环就可以结束任务。通常用定义标记来完成。
 * 为什么要开启线程？被执行的代码块复杂，通常有循环，且运行时会影响到其他代码执行，此时希望多个代码块同时执行，这样的情况就适合开启线程。
 * 过于简单的代码没必要开启线程。
 * 
 * 但是标记不能解决全部的情况。
 * 比如，线程处于冻结状态，是无法读取标记的，此时整个程序处于等待状态，无法进行也不结束，怎么处理？
 * 
 * interrupt方法：中断线程，作用是将线程从冻结状态强制回复到运行状态，让线程具备CPU的执行资格。
 * 但是这个强制动作会导致InterruptedException异常，必须要处理。
 * 
 * setDaemon(boolean on)方法：将线程标记为守护线程(后台线程)或用户线程。
 * 之前写的线程都是前台线程。
 * 后台线程的意义是，所有前台线程都结束的话，后台线程自动结束。
 */
//以下方法仅作了解即可
/* join方法：是等待该线程终止。线程申请加入并运行，临时加入一个线程运算时可以使用join方法。
 * 	作用：主线程释放执行权，释放执行资格，等同于处于冻结状态(所以有异常)，等待join线程运行结束，主线程才能抢夺CPU执行权。
 * toString方法：返回该线程的字符串形式，包括线程名，优先级，线程组。
 * 优先级：指的是线程获取CPU执行权的几率，优先级越大，获得CPU执行权的频率越高。范围在1-10中。
 * 优先级字段：MAX_PRIORITY，MIN_PRIORITY，NORM_PRIORITY。用法见下面
 * 
 * 线程组：表示一个线程的集合。好处在于可以对处于一个组内的所有线程共同操作，比如，等待，唤醒，中断线程，更改为后台线程等等。
 * 
 * 
 * yield方法：暂停当前正在执行的线程，释放执行权，但还是具备执行资格。
 */

class StopTest implements Runnable{
	private boolean flag=true;
	public synchronized void run() {
		while(flag){//这个flag就是控制循环的标记
			try {wait();}
			catch (InterruptedException e){	//能调用wait的方法必须是同步的方法
				System.out.println(Thread.currentThread().getName()+"....e");
				setflag();//所以把setflag()方法放在catch里，作为异常处理的措施进行补救，这是very nice的，最后run方法可以结束
			}
			System.out.println(Thread.currentThread().toString()+"........run");
			//Thread.yield();	//用的不多，了解即可
		}
	}
	public void setflag(){
		flag=false;
	}
	
}
public class c91_线程最后的知识补充 {

	public static void main(String[] args)  throws InterruptedException {//这个是join方法的异常，为了方便，这里选择抛出
		//ThreadGroup g=new  ThreadGroup("xx");//创建一个线程组
		StopTest s= new StopTest();
		Thread t1=new Thread(s);
		Thread t2=new Thread(s);
		t1.start();
		//t1.setPriority(Thread.MAX_PRIORITY);//优先级的设置，这是最大，10
		//t1.setPriority(Thread.MIN_PRIORITY);//优先级的设置，这是最小，1
		//t1.setPriority(Thread.NORM_PRIORITY);//优先级的设置，这是正常，也是默认，5
		//t1.join();//这里不做演示，只是说明。在main运行到这里时，不往下进行，等待t1运行结束后再向下运行。这使t2还没有开启。
		t2.setDaemon(true);//设置t2为守护线程，必须在t2开启前设置
		t2.start();
		//t1.join();//这里t2已经开启，所以此时主线程冻结，t1和t2共同抢夺CPU执行权。如果t1结束，t2未结束，则主线程和t2共同抢夺CPU执行权。
					//说明主线程只是等待t1结束，与t2无关。
		
		int num=1;
		for (; ;) {//死循环
			if (++num==50) {
				//s.setflag();//在循环跳出前，设置flag为false，就控制了线程中的循环
				t1.interrupt();//清除了冻结状态，但是这种唤醒是不是正常唤醒，是强制唤醒，会发生异常
				//t2.interrupt();//清除了冻结状态，但是这种唤醒是不是正常唤醒，是强制唤醒，会发生异常
				
				break;
			}
			System.out.println("main...."+num);
		}
		System.out.println("over");
	}

}
