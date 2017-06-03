package p5_其他API;

import java.util.Properties;
import java.util.Set;

/* System类有三个字段：
 * 1.err：标准错误输出流
 * 2.in：标准输入流
 * 3.out：标准输出流
 * 
 * System类中的方法和属性都是静态的。
 * 
 * 常用方法：
 * 1.获取当前时间的毫秒值  long currentTimeMillis()//返回当前时间与协调世界时之间午夜的时间差(以毫秒为单位)
 * 2.取得当前的系统属性  Properties getProperties()//返回系统属性，存储到Properties集合中，Hashtable的子类，继承Map
 */

public class c1_System {
	public static final String Line_separator = System.getProperty("line.separator");
	//getProperty方法，根据键获取一个属性，这里获取的是换行	

	public static void main(String[] args) { 
		//1
		long l1 = 1460303718781l;//System.currentTimeMillis();	//直接写数字，其值默认为int型，在数字后加l，就可以改为long型
		System.out.println(l1);	//单位是毫秒
		System.out.println(l1/1000/60/60/24);//转换为单位是天
		long l2 =System.currentTimeMillis();
		System.out.println(l2-l1);//currentTimeMillis()方法的基本用法，计算时间差
		//2，Properties集合中存储的都是String类型的键和值，最好使用它自己的存储和取出的方法来完成对元素的操作。
		Properties pro = System.getProperties();//获取所有系统属性
		Set<String> nameSet = pro.stringPropertyNames();	//stringPropertyNames方法，获取Properties集合中的键，存放到Set集合中
		System.out.println(1+Line_separator+2);	//换行效果展示
		System.setProperty("mykey", "myvalue");	//setProperty方法，可以将自己设置的键值对添加到系统属性中
		for(String name : nameSet){
			String value = pro.getProperty(name);//getProperty方法，根据键获取一个属性
//			System.out.println(name+"::::"+value);
		}
	}

}
