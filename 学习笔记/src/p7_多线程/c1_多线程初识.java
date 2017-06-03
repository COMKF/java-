package p7_多线程;

/* 进程：正在进行中的程序(直译)
 * 线程：就是进程中一个负责程序执行的控制单元(执行路径)
 * 一个进程中至少要有一个线程
 * 开启多个线程是为了同时运行多部分代码，每一个线程都有自己运行的内容。这个内容称为线程要执行的任务。
 * 多线程好处：解决了多部分同时运行的问题。
 * 多线程弊端：线程太多，CPU效率降低。
 * 其实应用程序和线程的执行都是CPU在做着快速的切换完成的，这个切换时随机的。
 */
/* jvm启动时就启动了多个线程，至少有两个线程可以分析的出来。
 * 1.执行main函数的线程，该线程的任务代码都定义在main函数中。
 * 2.负责垃圾回收的线程。
 */
class 垃圾回收 extends Object{
	public void finalize() {//垃圾回收时，垃圾回收期会从堆中永久删除对象之前，垃圾回收器调用该对象的Finalize方法。
		System.out.println("回收");
	}
}
/* 创建线程方法之一：继承Threa类
 * 步骤：1.定义一个继承Thread的类
 * 2.覆盖Thread类中的run方法
 * 3.直接创建Thread的子类对象，来创建线程
 * 4.调用start方法开启线程并调用线程的任务run方法执行。
 */
//可以通过Thread的getname方法获取线程的名称，名称默认为Thread-编号(从0开始)
//主线程的名字就是main
class ThreadDemo extends Thread{
	private String name;
	ThreadDemo(String name){
		//super();//当子类创建对象时，会先调用父类的初始化方法，这就意味着子类开始创建的时候，就已经获得了默认的线程名称，即Thread-编号
		super(name);//当然，我们也可以通过自定义的方法，为自己创建的线程命名
		this.name=name;
	}
	public void run() {
		for (int x=0;x<10;x++){
			System.out.println(name+"...x="+x+"..name="+Thread.currentThread().getName() );
			//Thread.currentThread()获取当前线程，在类的函数中可以和this等价替换；Thread.currentThread().getName() 获取当前线程的名称
		}
	}
}
public class c1_多线程初识 {
	public static void main(String[] args) {
		//垃圾回收，最明显的线程
		new 垃圾回收();
		new 垃圾回收();
		new 垃圾回收();
		System.gc();//gc()函数的作用，运行垃圾回收器，只是提醒虚拟机：程序员希望进行一次垃圾回收。
					//gc命令不是同步进行的，是异步的,也就是不一定运行之后直接被回收。
		//运行自定义线程
		/* 创建线程的目的是为了开启一条执行路径，去运行指定的代码，和其他代码实现同时运行。
		 * 而运行的指定代码就是这个执行路径的任务。
		 * jvm创建的主线程的任务都定义在主函数中。
		 * 而自定义的线程，它的任务在哪？
		 * Thread类用于描述线程，线程是需要任务的，所以Thread类也是对任务的描述。
		 * 这个任务通过Thread类中的run方法来实现。也就是说，run方法就是自定义线程运行任务的函数。
		 * run方法定义的就是线程要运行的任务代码
		 * 开启线程是为了运行指定代码，所以只有继承Thread类，并覆盖run方法。
		 * 将运行的代码定义在run方法中即可。
		 */
		ThreadDemo t1=new ThreadDemo("中文");
		ThreadDemo t2=new ThreadDemo("pinyin");	
		//t1.run();//直接调用run方法，并没有开启线程，和调用一般函数的效果一样
		t1.start();//start方法的作用，开启线程，同时调用run方法来开启任务
		t2.start();
		//main函数中有多个线程，在此例中，有main线程，t1线程，t2线程。三者分别运行，互不影响，三者都运行完后，jvm才结束。
		for (int x=0;x<10;x++){
			System.out.println(x+"...over..."+Thread.currentThread().getName());//属于main线程
		}
	}

}
