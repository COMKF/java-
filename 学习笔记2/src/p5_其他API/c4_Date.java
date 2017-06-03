package p5_其他API;
/* Date类，时间类。
 * 
 * 对象构造方法：
 * 1.new Date();	//将当前日期和时间封装成Date对象
 * 2.new Date(long date)	//将指定毫秒值封装成Date对象
 * 
 * 常用方法：
 * 3.判断此日期是否在指定日期之后  boolean after(Date when)
 * 4.判断此日期是否在指定日期之前  boolean before(Date when)
 * 5.毫秒值转化为日期对象  void setTime(long time) //无返回值，直接修改在原内容上
 * 6.日期对象转化为毫秒值  long getTime()
 * 7.判断两个日期是否相等  boolean equals(Object obj)
 * 8.比较两个日期的顺序  int compareTo(Date anotherDate)
 */
import java.util.Date;

public class c4_Date {

	public static void main(String[] args) {
		Date date = new Date();	//1
		System.out.println(date);
		long time = System.currentTimeMillis();//获取当前时间的毫秒值，其实new Date()也是调用这个方法。
		System.out.println(time); //2
		System.out.println(new Date(time)); //2
		/* 日期对象和毫秒值之间的转换 :可以通过Date对象的方法对日期中的各个字段(年月日等)进行操作
		 * 毫秒值-->日期对象
		 * 1.通过Date对象的构造方法new Date(long date)
		 * 2.还可以通过setTime设置
		 * 
		 * 日期对象-->毫秒值:可以通过具体的数值进行运算
		 * 1.getTime方法
		 */
		long date_time = date.getTime();	//6
		System.out.println(date_time);
		date.setTime(146038419876l);	//5
		System.out.println(date);
	}
}
