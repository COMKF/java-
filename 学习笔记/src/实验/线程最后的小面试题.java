package 实验;
//小面试1
/*
class ThreadTest implements Runnable{//为什么错误在这一行？因为Runnable，是个接口，必须覆盖run()方法，且Runnable中的run方法是无参数的
	public void run(Object obj){	//这个run方法显然是不能覆盖Runnable中的run方法的，所以这个ThreadTest类只能是抽象类
	}								//解决方法：1.类前加abstract关键字，使其成为抽象类 2.覆盖run方法
}
 */

public class 线程最后的小面试题 {
	public static void main(String[] args) {
		//了解
		new Thread(){
			public void run(){
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName()+"..i="+i);
				}
			}
		}.start();//开启线程的方法,匿名线程
		
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+"..i="+i);
		}
		
		Runnable r =new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName()+"..i="+i);
				}
			}
		};
		new Thread(r).start();//开启线程的方法，匿名线程接入Runnable接口
		
		//小面试2
		new Thread(new Runnable() {//如果什么都不写，就执行Thread本身的run方法，也就是空白
			public void run() {//Runnable接口传入参数，添加run方法
				System.out.println("Runnable...run");//
			}
		}){
			public void run(){//这里实质意义是子类run方法覆盖父类run方法
				System.out.println("Thread...run");//覆盖Thread的run方法(最后打印的是这个，必须以子类为主啊)
			}
		}.start();//读懂这个题意，这段代码是没有问题的。问：最后打印的是什么？
		//所以线程执行的顺序，先以子类为主，后任务，最后Thread本身run方法
	}
				
}
