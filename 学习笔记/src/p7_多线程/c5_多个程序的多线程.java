package p7_多线程;
/* 多线程通讯：多线程处理同一资源，但任务却不同
 * 让输入和输出操作同一对象
 */
class Resource{ //资源，再次说明，不要搞static，对象也好，变量也好，千万不能static
	String name;
	String sex;
}
class Input implements Runnable{//输入
	Resource r;
	Input(Resource r){//用构造函数，对Input和Output两个线程传入相同的r(资源)
		this.r=r;
	}
	//Object obj=new Object();//在之前的多线程开发中，可以用obj当做锁，但是在这里不行，因为有两个任务，相当于每个任务有自己独立的锁
	public void run(){//输入
		int x=0;
		while (true){//不能把while循环放在同步里，否则同步会一直在这个地方转圈
			synchronized (r) {//所以选取共同持有的对象r，作为共同的锁。不是r也可以，只要是相同的锁即可，不过这里显然r更方便。
				if (x==0) {
					r.name="xiaoqiang";
					r.sex="nan";
				}
				else{
					r.name="小红";
					r.sex="女女女";
				}
				
			}
			x=(x+1)%2;
		}
	}
}
class Output implements Runnable{//输出
	Resource r;
	Output(Resource r){//用构造函数，对Input和Output两个线程传入相同的r(资源)
		this.r=r;
	}
	//Object obj=new Object();//在之前的多线程开发中，可以用obj当做锁，但是在这里不行，因为有两个任务，相当于每个任务有自己独立的锁
	public void run(){//输出
		while (true){
			synchronized (r) {//所以选取共同持有的对象r，作为共同的锁。不是r也可以，只要是相同的锁即可，不过这里显然r更方便。
				System.out.println(r.name+"..."+r.sex);
				
			}
		}
	}
}

public class c5_多个程序的多线程 {
	public static void main(String[] args) {
		//创建资源
		Resource r= new Resource();
		//创建任务
		Input in= new Input(r);
		Output out= new Output(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
	}
}
