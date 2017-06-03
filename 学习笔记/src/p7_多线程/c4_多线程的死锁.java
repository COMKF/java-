package p7_多线程;
//深刻理解这个程序，这是锁的精髓，可以背下来
//死锁：常见情景之一，同步的嵌套
class Deadlock implements Runnable{
	private boolean flag;
	Deadlock(boolean flag){
		this.flag=flag;
	}
	public void run(){
		if(flag){
			while(true){//小心，这里的循环是true，这个循环会一直执行，需要手动停止。否则会让电脑变卡，然后死机
				synchronized(MyLock.locka){
					System.out.println(Thread.currentThread().getName()+"...if locka....");
					synchronized (MyLock.lockb) {
						System.out.println(Thread.currentThread().getName()+"...if lockb....");
					}
				}
				
			}
		}
		
		else {
			while(true){//小心，这里的循环是true，这个循环会一直执行，需要手动停止。否则会让电脑变卡，然后死机
				synchronized(MyLock.lockb){
					System.out.println(Thread.currentThread().getName()+"...else lockb....");
					synchronized (MyLock.locka) {
						System.out.println(Thread.currentThread().getName()+"...else locka....");
					}
				}
				
			}
		}
	}
}
class MyLock{
	public static final Object locka=new Object();//先设置两个锁
	public static final Object lockb=new Object();
}

public class c4_多线程的死锁 {
	public static void main(String[] args) {
		Deadlock a=new Deadlock(true);
		Deadlock b=new Deadlock(false);
		
		Thread t1= new Thread(a);//a去拿locka锁，想要往下进行，需要lockb锁，等待b释放lockb锁
		Thread t2= new Thread(b);//b去拿lockb锁，想要往下进行，需要locka锁，等待a释放locka锁
		t1.start();
		t2.start();
	}

}
