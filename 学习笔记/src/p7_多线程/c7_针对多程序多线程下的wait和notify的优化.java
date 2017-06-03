package p7_多线程;
//设置private属性，创建set和get方法，提高安全性
//真实开发就应该是这样的
class Resource2{ //资源
	private String name;
	private String sex;
	private boolean flag=false;
	
	public synchronized void set(String name,String sex) {//直接在这里设置同步函数
		if (flag) {
			try {this.wait();}//this可省略，因为同步函数的锁已经默认为就是类中的这个对象
			catch (InterruptedException e) {}
		}
		this.name = name;
		this.sex = sex;
		flag=true;
		this.notify();//this可省略，因为同步函数的锁已经默认为就是类中的这个对象
	}
	
	
	public synchronized void get(){//直接在这里设置同步函数
		if (!flag) {
			try {wait();}
			catch (InterruptedException e) {}
		}
		System.out.println(name+"..."+sex);
		flag=false;
		notify();
	}
}
class Input2 implements Runnable{//输入
	Resource2 r;
	Input2(Resource2 r){
		this.r=r;
	}
	public void run(){//输入
		int x=0;
		while (true){//不能把while循环放在同步里，否则同步会一直在这个地方转圈
			if (x==0) {
				r.set("xiaoqiang", "nan");
			}
			else{
				r.set("小红", "女女女");
			}
			x=(x+1)%2;
		}
	}
}
class Output2 implements Runnable{//输出
	Resource2 r;
	Output2(Resource2 r){
		this.r=r;
	}
	public void run(){//输出
		while (true){
			r.get();
		}
	}
}

public class c7_针对多程序多线程下的wait和notify的优化  {
	public static void main(String[] args) {
		//创建资源
		Resource2 r= new Resource2();
		//创建任务
		Input2 in= new Input2(r);
		Output2 out= new Output2(r);
		//创建线程
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//开启线程
		t1.start();
		t2.start();
	}

}
