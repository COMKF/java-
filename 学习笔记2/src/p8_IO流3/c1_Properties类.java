package p8_IO流3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/* Properties：表示一个持久的属性集，可保存在流中或者从流中加载(与IO技术联系紧密)。
 * 	持久化：把信息保存在硬盘上，这样存储的时间更长，方便以后的使用。
 * Properties所属于Map类，体系为Map-Hashtable-Properties
 * 特点：
 * 1.集合中的键和值都是字符串类型
 * 2.集合中的数据可以保存在流中，或者从流中获取。
 * 
 * 通常该集合用于操作以键值对形式存在的配置文件。
 * 
 * 特有方法：
 * 1.存  Object setProperty(String key, String value)	//返回值参照Map集合的存储方法，返回前一个与key关联的值，如果没有则返回null
 * 2.取单个元素  V get(Object key) //返回与这个key关联的值，如果没有这个key则返回null
 * 3.取所有元素  先用 Set<String> stringPropertyNames() 获得所有键的集合，再通过方法2获取键所对应的值
 * 
 * 4.打印当前Properties中的所有元素  void list(PrintStream out)//这个方法在调试的时候用的较多，因为可以用这个方法直接在控制台上打印所有的元素，很直观
 * 
 * 5.将Properties中的信息保存到文件中  void store(Writer writer, String comments)//两个参数，第一个是输出流，第二个是key+value的说明，不要写中文
 * 6.将文件中的信息读取到Properties中  void load(InputStream inStream)//参数是读取流
 */
public class c1_Properties类 {

	public static void main(String[] args) throws IOException {
		//创建一个Properties集合
		Properties pro = new Properties();
//		show1(pro);
//		show2(pro);
//		show3(pro);
		show4(pro);
	}

	private static void show1(Properties pro) {	//Properties的基本方法，1，2，3
		//1.存
		pro.setProperty("zhangsan", "22");
		pro.setProperty("lisi", "26");
		pro.setProperty("wagnwu", "24");
		//修改元素
		pro.setProperty("wagnwu", "23"); //用的依然是方法1
		//2.取单个
		System.out.println(pro.get("zhangsan"));
		//3.取所有
		Set<String> keys = pro.stringPropertyNames();
		for(String key : keys){	
			String value = pro.getProperty(key);	//2
			System.out.println(key+":"+value);
		}
	}

	private static void show2(Properties pro) {	//Properties与流集合的方法，4
		pro = System.getProperties(); 
		//4.
		pro.list(System.out);
	}
	
	private static void show3(Properties pro) throws IOException {	//Properties与流集合的方法，5
		//想要将这些集合中的字符串键值对信息持久化存储到文件中，需要关联输出流，用的是store方法
		//1.存
		pro.setProperty("zhangsan", "22");
		pro.setProperty("lisi", "26");
		pro.setProperty("wagnwu", "24");
		//5.将Properties中的信息保存到文件中
		FileOutputStream fos = new FileOutputStream("info.txt");	//写FileWriter也可以
		pro.store(fos,"name+age");	//5
		fos.close();	
	}
	
	private static void show4(Properties pro) throws IOException {	//修改配置信息
		//集合中的数据必须来自同一文件，且文件中的数据必须是键值对
		//当然，需要使用到读取流关联文件
		File f = new File("info.txt");
		if (!f.exists()) {	//健壮性判断
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);	//这里用了字节流
		//5.将文件中的信息读取到Properties中
		pro.load(fis);
		//用方法1修改配置信息
		pro.setProperty("zhangsan", "21");
		pro.list(System.out);
		fis.close();
		
		//创建输出流，把将Properties中的信息保存到文件中
		FileWriter fw = new FileWriter(f);	//这里用了字符流，可以看出，字节流和字符流在这里可以通用，可以选取合适的流进行操作
		//用方法5
		pro.store(fw,"name+age");	//5
		fw.close();	
	}
}

/* 知识扩充：load方法原理。
 * public static void MyLoad() throws IOException {	//模拟load方法，理解其原理
		Properties pro = new Properties();
		BufferedReader bfr = new BufferedReader(new FileReader("info.txt"));
		String line = null;
		while((line = bfr.readLine())!=null){
			if(line.startsWith("#")) continue;	//该判断，舍弃以#开头的注释信息
			String[] arr = line.split("=");	//按=把line切割为两部分
			pro.setProperty(arr[0], arr[1]);
		}
		bfr.close();
		pro.list(System.out);
	}
 */

