package p5_其他API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * DateFormat类：日期格式器，用来格式化(日期-->文本)和解析日期字符串(文本-->日期)，有一个子类SimpleDateFormat，这个子类用于创建自定义风格。 
 * 
 * 常用方法：
 * 1.获取日期格式器  DateFormat getDateInstance()//静态方法，返回一个DateFormat类的对象
 * 2.获取日期时间格式器  DateFormat getDateTimeInstance()//静态方法，返回一个DateFormat类的对象
 * 3.取得格式化的日期或者时间  String format(Date date)//参数为date对象，返回值为String
 * 4.在获取日期格式器的静态方法中可以通过加入字段作为参数，设置给定的格式化风格。字段有：FULL(全)  LONG(长)  SHORT(短)    MEDIUM(默认)
 * 5.取得对应的日期对象  Date parse(String source)//参数为String，返回值为date对象，与format方法相反
 */

public class c5_DateFormat {

	public static void main(String[] args) throws ParseException {
//		show1();
		show2();
	}

	private static void show2() throws ParseException {	//解析日期字符串(文本-->日期)，使用的是DateFormat类中的parse方法
		String str_date = "2016-04-11";
		str_date = "2016年04月11日";
		str_date = "2016--04--11";
		
		
		DateFormat dateFormat = DateFormat.getDateInstance();//2016-04-11是默认风格的，直接用最初的日期格式器就可以完成解析
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);//2016年04月11日是LONG风格的，用字段LONG作为参数传入即可完成解析
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");//2016--04--11是自定义风格，需要创建SimpleDateFormat类对象，并传入自定义格式的参数
		Date date = dateFormat.parse(str_date);	//5，parse方法需要抛出异常，该异常是ParseException
		System.out.println(date);
		
	}

	private static void show1() {	//格式化(日期-->文本)，使用的是DateFormat类中的format方法
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance();	//1，通过静态方法获取日期格式器，具备默认的风格
		dateFormat = DateFormat.getDateInstance(DateFormat.FULL);	//4，通过静态方法获取日期格式器，并给定风格为FULL
		dateFormat = DateFormat.getDateTimeInstance();	//2，通过静态方法获取日期及时间格式器，具备默认的风格
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.LONG);	//4，通过静态方法获取日期及时间格式器
						//这里给定了两个风格，第一个风格对日期进行设置，第二个风格对时间进行设置(必须这样做)
	
		//如何制定自定义格式？
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");//直接创建SimpleDateFormat类的对象，并加入String参数，且参数有一定的格式
		
		String str_date =  dateFormat.format(date);	//3，调用日期格式器的format方法，参数为date对象，返回值为String
		System.out.println(str_date);
	}

}
