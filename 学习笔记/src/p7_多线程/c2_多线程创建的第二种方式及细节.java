package p7_多线程;
/* 创建线程的第二种方式：实现Runnable接口
 * 1.定义类实现Runnable接口
 * 2.覆盖接口中的run方法，将线程的任务代码封装到run方法中
 * 3.通过Thread类创建线程对象，并将Runnable接口的子类对象作为构造函数的参数进行传递
 * 		因为线程任务都封装在Runnable接口子类对象的run方法中。所以要在线程对象创建时就必须要明确要运行的任务
 * 4.调用线程对象的start方法开启线程
 */
/* 实现Runnable接口的好处：
 * 1.将线程的任务从线程的子类中分离出来，进行了单独的封装。按照面向对象的思想将任务封装成对象。
 * 2.避免了java单继承的局限性。
 * 所以，创建线程的第二种方式较为常用。
 */
class ThreadDemo2 implements Runnable{ //如果一个类已经有父类，那么它就不能继承 Thread类，此时如果需要扩展这个类来使用多线程的功能，就需要用到接口
		//这就是多线程创建的第二种方式，implements Runnable，并覆盖run方法
	public void run() {//注意这种写法，在run方法中调用其他方法，这种写法更好
		show();
	}
	public void show() {
		for (int x = 0; x < 20; x++) {
			System.out.println(Thread.currentThread().getName()+"..."+ ""+x);
		}
	}
}

public class c2_多线程创建的第二种方式及细节 {

	public static void main(String[] args) {
		ThreadDemo2 t=new ThreadDemo2(); //注意，此时的ThreadDemo2没有继承 Thread类，那么ThreadDemo2创建的对象就不是线程对象
		Thread t1=new Thread(t);//用这种方法，可以把t中的run方法加入到Thread类的对象中，让t1作为线程使用t的run方法
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
		}
}
/* 第二种创建线程方法的真实原理
class Thread{
	private Runnable r;
	Thread(){
		
	}
	Thread(Runnable r){
		this.r=r;
	}
	public void run(){
		if (r!=null) {
			r.run();
		}
	}
	public void start(){
		run();
	}
}
 * 
 */
