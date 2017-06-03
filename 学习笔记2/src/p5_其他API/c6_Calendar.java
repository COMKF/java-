package p5_其他API;

import java.util.Calendar;

/* Calendar类：日历类，有多种关于日期的字段。
 * 
 */
public class c6_Calendar {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();//默认使用当前时间作为日历的参数
		showDate(c);
		int year = 2000;
		setDate(c,year);
	}

	private static void setDate(Calendar c,int year) {
		c.set(year,2,1);	//可以用set方法设置c的时间,月份的计数，输入11，其实是12月，原因是月的计数是从0开始，到11结束。
		c.add(Calendar.YEAR, 3);//日期的偏移，set方法的两个参数，第一个是字段，第二个是偏移量
		c.add(Calendar.YEAR, -3);
		c.add(Calendar.MONTH,0);
		c.add(Calendar.DAY_OF_MONTH,-1);	//通过此方法可以直接看出传入的年份的二月有多少天
		showDate(c);
	}

	private static void showDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MARCH)+1;	//因为月的计数是从0开始，到11结束，所以后面需要+1
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getWeek(c.get(Calendar.DAY_OF_WEEK));	//在老外的编号里，星期日是1，星期一是2，以此类推
		System.out.println(year+"年"+month+"月"+day+"日"+" "+week);
	}

	private static String getWeek(int i) {
		String[] week = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return week[i];
	}

}
