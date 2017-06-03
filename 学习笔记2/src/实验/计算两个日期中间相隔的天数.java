package 实验;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* 练习：
 * str_date1 = "2016-3-25"
 * str_date2 = "2016-4-08"
 * 两个日期中间有多少天？
 */

public class 计算两个日期中间相隔的天数 {

	public static void main(String[] args) throws ParseException {
		String str_date1 = "2016-3-25";
		String str_date2 = "2016-4-08";
		int num = sub(str_date1,str_date2);
		System.out.println("二者相隔"+num+"天");
	}

	private static int sub(String str_date1, String str_date2) throws ParseException {
		//1.先创建默认的日期格式器
		DateFormat dateFormat = DateFormat.getDateInstance();
		//2.通过DateFormatd的parse方法获取对应的日期对象
		Date date1 = dateFormat.parse(str_date1);
		Date date2 = dateFormat.parse(str_date2);
		//3.获取两个日期对象的毫秒值
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		//4.获取两个毫秒值之间的差值
		long time = Math.abs(time1 - time2);	//用到Math类的绝对值方法
		//5.将差值转化为天数
		int num = (int)(time/1000/60/60/24);
		return num;
	}

}
