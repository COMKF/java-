package 实验;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* 定义功能：获取一个程序启动的次数，如果超过5次，给出使用次数已到上限，请注册的提示。并不能再运行程序。
 * 
 * 思路：
 * 1.需要定义一个计数器，程序每次启动都需要计数一次，并在原有次数上进行计数。
 * 2.把该计数器当作一个配置文件使用。
 * 
 */
public class 用Properties计数器记录程序启动次数 {

	public static void main(String[] args) throws IOException {
//		count();
		count2();
		
	}

	private static void count() throws IOException {	//计数器第一种方法
		//把计数器的配置文件封装成对象
		File f = new File("计数器.ini");	//注意，Windows配置文件的后缀一般为ini。而java的配置文件后缀为properties
		//创建Properties对象
		Properties pro = new Properties();
		if (!f.exists()) {	//健壮性判断
			f.createNewFile();
			pro.setProperty("count", "1");	//直接设初值
			FileOutputStream fos = new FileOutputStream(f);	//输出流关联文件，为Properties写入文件作准备
			pro.store(fos,"count");	//写入文件
			System.out.println("这是您初次使用，你还可以用5次！");	//控制台反馈
			fos.close();
		}
		else {
			FileInputStream fis = new FileInputStream(f);	//读取流关联文件，为文件写入Properties作准备
			pro.load(fis);	//写入Properties
			fis.close();
			int value = Integer.parseInt(pro.getProperty("count"));	//取得程序启动次数，并转化为int型变量
			if (value < 5) {
				value++;	//自增
				pro.setProperty("count", String.valueOf(value));	//修改程序启动次数
				FileOutputStream fos = new FileOutputStream(f);	//输出流关联文件，为Properties写入文件作准备
				pro.store(fos,"count");	//写入文件
				System.out.println("您的剩余可用次数为"+(6-value)+"次");	//控制台反馈
				fos.close();
			}
			else {
				System.out.println("请注册！！");	//控制台反馈
			}
		}
	}
	
	private static void count2() throws IOException {	//计数器第二种方法，好处在于，把fis和fos提取出来，简化了代码，提高了效率
		//把计数器的配置文件封装成对象
		File f = new File("计数器.ini");	//注意，Windows配置文件的后缀一般为ini。而java的配置文件后缀为properties
		//创建Properties对象
		Properties pro = new Properties();
		if (!f.exists()) {	//健壮性判断
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);	//读取流关联文件，为文件写入Properties作准备
		pro.load(fis);	//写入Properties
		if (pro.getProperty("count") == null) {
			pro.setProperty("count", "0");	//设初值
		}
		int value = Integer.parseInt(pro.getProperty("count"));	//取得程序启动次数，并转化为int型变量
		if (value >= 5) {
//			System.out.println("请注册！！");	//控制台反馈
//			return;	//return是一种办法，但我们可以用另一个非常聪明的办法--抛出异常
			throw new RuntimeException("使用次数已到，请注册");
		}else {
			value++;	//自增
			pro.setProperty("count", String.valueOf(value));	//修改程序启动次数
		}
		
		FileOutputStream fos = new FileOutputStream(f);	//输出流关联文件，为Properties写入文件作准备
		pro.store(fos,"count");	//写入文件
		System.out.println("您的剩余可用次数为"+(6-value)+"次");	//控制台反馈
		
		fos.close();
		fis.close();
	}
	
//第47节先略过。以后再看吧。。
}
