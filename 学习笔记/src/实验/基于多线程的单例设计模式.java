package 实验;
 class Single{
	private static Single s= new Single();//饿汉式，开发时用这个更多，因为简单啊
	private Single(){}
	public static Single getSingle(){//这里不需要同步代码块，因为已经创建了唯一的一个对象
			return s;
		}
 }
/*
class Single {
	private static Single s= null;//懒汉式。面试时这个出现几率高，因为技术要求高
	private Single(){}
	public static Single getSingle(){
		if(s==null){	//如果之前的线程已经创建了对象，这里用if跳过其他线程判断同步锁的这一步，提高了效率。双重判断解决了懒汉式的效率和安全问题
			synchronized (Single.class) {//同步代码块，这里用字节码文件作为锁，因为getSingle的方法是静态的。
				if(s==null) s=new Single();
			}
		}
		return s;
	}
}
 */

public class 基于多线程的单例设计模式 {

	public static void main(String[] args) {

	}

}
