package 实验;
/* 毕老师用电脑上课
 * 两个对象：毕老师，电脑
 * 分析其中的问题：电脑蓝屏，冒烟
 *  
 */
class LanpinException extends Exception{//电脑蓝屏
	LanpinException(String msg){
		super(msg);
	}
}
class MaoyanException extends Exception{//电脑冒烟
	MaoyanException(String msg){
		super(msg);
	}
}
class NoPlanException extends Exception{//课程进度无法完成
	NoPlanException(String msg){
		super(msg);
	}
}
class Computer{
	private int state=2;//标志电脑状态
	public void run() throws MaoyanException,LanpinException {
		if (state==1)
			throw new LanpinException("电脑蓝屏啦！");
		if (state==2) 
			throw new MaoyanException("电脑冒烟啦！");
		System.out.println("电脑运行！");
	}
	public void reset() {
		System.out.println("电脑重启！！");
		state=0;
	}
}
class Teacher{
	private String name;
	private Computer comp;
	Teacher(String name) {
		this.name =name;
		comp= new Computer();
	}
	void prelect() throws NoPlanException{
		try {
			comp.run();
			System.out.println(name+"讲课");
		} 
		catch (LanpinException e) {//在实际开发中，catch内的代码需要做到可以处理具体问题，而不是只是牌抛出
			System.out.println(e);//出现问题先进行报告
			comp.reset();//用最真实的处理方式写catch代码，电脑蓝屏需要重启，这是可处理的问题，那么就可以通过方法进行预处理
			prelect();//然后继续讲课
		}
		catch (MaoyanException e) {
			System.out.println(e);//出现问题先进行报告
			test();//用最真实的处理方式写catch代码，电脑冒烟就让大家做练习，这是不可处理的问题
			//throw e;//然后将问题抛出，但是培训公司只是让老师讲课，而这种电脑冒烟的问题公司也无法处理，所以这个问题的抛出是不合理的
					//所以应该抛出一个让公司能够解决的，或者与公司相关的问题
			//可以对电脑进行维修，这个问题可以不告诉公司。
			//但是这个问题涉及到课程不能按时完成的问题，这个问题是和公司相关的，必须抛出，否则就是隐藏问题，容易出事
			throw new NoPlanException("课程进度无法完成，原因是："+e.getMessage());//这就是异常转换，也是可以的,而且实际开发经常用到
		}
	}
	void test(){
		System.out.println("大家做练习");
	}
}
public class 异常应用及转换 {

	public static void main(String[] args) {
		Teacher t=new Teacher("毕老师");
		try {
			t.prelect();
		} 
		catch (NoPlanException e) {
			System.out.println(e.toString()+".....");
			System.out.println("换人");
		}
		finally{
		}
	}
}
/* 异常的注意事项：
 * 1.子类在覆盖父类方法时，父类的方法如果抛出了异常。那么子类的方法只能抛出父类的异常或者该异常的子类。
 * 2.，如果父类抛出多个异常，那么子类只能抛出父类异常的子集。
 * 简单说，子类覆盖父类，子类只能抛出父类的异常或者异常的子类及子集。
 * 注意：如果父类方法没有跑出异常，那么子类覆盖时绝对不能抛出异常，就只能try。
 */


