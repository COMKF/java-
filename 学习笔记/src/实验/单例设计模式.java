package 实验;
/*
 *设计模式：其实是一种思想，通过学习这种方法，解决问题，不能受限于JAVA语言。
 *
 * 对程序来说，一个程序通常只能有一个配置信息，我们要对配置信息进行修改的时候，必须要保证配置信息的唯一性
 * 如何保证配置唯一？
 * 1.不允许其他程序用new创建该配置信息的对象
 * 2.在该配置信息中自己创建一个实例
 * 3.对外提供一个方法可以让其他程序获得该实例
 * 
 * 步骤：
 * 1.私有化该类的构造函数
 * 2.在本类中通过new创建对象
 * 3.定义一个方法，让创建的对象返回
 */

class config{
	private int num=0;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	private config() {}//构造函数私有化(懒汉式)
	private static config c=new config();//所以该实例也必须是静态的，private私有，保证其他程序不能用直接设置的方法获取config实例，且这种方法不可控制
	public static config getConfig() {//静态的成员函数，且可以在函数中添加控制条件，比如if语句
		return c;					//所以为了java程序的严谨性，尽可能的为类中的所有的属性设置私有化
	}
	public void show() {
		System.out.println(num);
	}
}
public class 单例设计模式 {
	public static void main(String args[]){
		config cc=config.getConfig();//用类调用成员函数(类.方法)的方法获得Config的实例，因此该成员函数必须是静态的
		cc.setNum(10);
		cc.show();
		config cc2=config.getConfig();
		cc2.setNum(20);
		cc2.show();
		cc.show();
		System.out.println(cc==cc2);
	}
}

/* 单例设计的另一个方法(饿汉式)   这个方法的好处在于类加载时，对象并不会创建，只有当被其他程序调用时，才会创建对象(延迟加载)
class config{  //但是这个方法有个安全隐患，多线程调用时，可能会产生多个对象。所以开发时基本不用
	private config() {}//构造函数私有化
	private static config c=null;
	public static config getConfig() {
	if(c==null) c=new config();
		return c;					
	}
}
*/
