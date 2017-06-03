package p7_IO流_2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/* File类：用来将文件或文件夹封装成类，方便对文件或文件夹的属性进行操作。
 * File对象可以作为参数传递给流的构造函数。
 * 
 * 构造方法：
 * 1.File(String pathname) 	//参数是字符串，可以是文件名(支持绝对路径)，或者路径名，生成相应的File对象
 * 2.File(String parent, String child)	//两个参数都是字符串，左边是文件夹，右边是文件名
 * 3.File(File parent, String child)	//左边参数是File对象，必须是通过路径名生成的File对象，右边参数是字符串，文件名
 * 
 * 常用方法：
 * 1.获取
 * 1.1获取文件名称  String getName()
 * 1.2获取文件路径  String getPath()   String getAbsolutePath()
 * 1.3获取文件大小  long length()
 * 1.4获取文件修改时间  long lastModified()
 * 2.创建与删除
 * 2.1创建新文件  boolean createNewFile()	//如果文件不存在，则创建，返回true；如果文件存在，则不创建，返回false
 * 2.2删除文件或文件夹  boolean delete()	//如果文件存在，则删除，返回true；如果文件不存在，则无法删除，返回false
 * 		//值得注意的是，若文件夹内有文件存在，则文件夹无法删除，返回false
 * 		//另外，当文件被流操作时，无法删除，返回false
 * 2.3创建新文件夹  boolean mkdir()  //如果文件夹不存在，则创建，返回true；如果文件夹存在，则不创建，返回false
 * 2.4创建多级文件夹  boolean mkdirs() //只关注最后一个文件夹是否存在，若不存在，则创建，返回true；若存在，则不创建，返回false
 * 3.判断
 * 3.1判断该文件是否存在  boolean exists()	
 * 3.2判断是否是文件   boolean isFile() 
 * 3.3判断是否是文件夹  boolean isDirectory()  //如果一个文件根本不存在，则这两个判断都为false，所以在进行这两个判断之前，最好先判断是否存在
 * 4.重命名
 * 4.1将文件重命名  boolean renameTo(File dest) //重命名的方法是用目标文件的名称替换原文件的名称，重命名成功则返回true，失败则返回false
 * 		//另外，如果原文件和目标文件不在同一路径下，会删除原文件，并生在目标文件的路径下生成有新名称的新文件，文件里的内容不变
 * 5.获取系统根目录和容量
 * 5.1获取系统根目录  static File[] listRoots()
 * 5.2获取剩余空间  long getFreeSpace()  //这个较为常用
 * 5.3获取总容量  long getTotalSpace()
 * 5.4获取可用空间  long getUsableSpace()
 * 6.获取目录内容
 * 6.1获取目录内容的名称  String[] list() //返回值为String[]，里面是所有文件的文件名，包含隐藏文件。
 * 		//注意，调用该方法的File对象中封装的必须是目录(文件夹),否则会发生空指针异常，如果访问的是系统级目录，也会发生这种异常
 * 6.2获取目录内容的对象  File[] listFiles() //返回值为File[]，里面是所有文件的对象，包含隐藏文件。这个较为常用
 */
public class c7_File类 {

	public static void main(String[] args) throws IOException {
//		show1();
//		show2();
//		show3();
//		show4();
//		show5();
//		show6();
		show7();
								
	}
	private static void show1() {	//构造方法演示
		//构造方法演示，可以将一个已存在的或不存在的文件或文件夹封装成对象
		File f1 = new File("f.txt");//1
//		File file = new File("G:\\java实验\\f.txt");	//支持绝对路径
		File f2 = new File("G:\\java实验\\","f.txt");	//2，两个参数，左边是文件夹，右边是文件名，好处是两个参数可以修改。
		File f = new File("G:\\java实验\\");	//1，把文件夹封装成File对象
		File f3 = new File(f,"f.txt");	//3，这样的好处是，可以把文件夹用File对象来操作
		
		File file = new File("G:"+File.separator+"java实验"+File.separator+"f.txt");	//File.separator，名称分隔符(即\\)
	}
	private static void show2() {	//常用方法演示，获取
		File f1 = new File("test.txt");	//这种写法其实就是一个相对路径
		//1.获取
		String fname = f1.getName();	//1.1，获取文件名
		String fPath = f1.getPath();	//1.2，获取相对路径，这个输出结果，其实是new File("test.txt")里的路径，写什么就输出什么
		String fAbsPath = f1.getAbsolutePath();//1.2，获取绝对路径。相对路径与绝对路径的区别，从盘符开始就是绝对路径，否则就是相对路径
		String fParent = f1.getParent();	//获得父目录，写法是new File("test.txt")的话，其值为null，写绝对路径的话就会显示具体的父目录
		long flen = f1.length();	//1.3,获取文件大小
		long ftime = f1.lastModified();//1.4,获取最后修改时间
		Date fDate = new Date(ftime);	//将修改时间转换为Date型
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);	//获取日期格式器，并设置为LONG型
		String str_date = dateFormat.format(fDate);	//转换日期格式，返回值为字符串。
		
		System.out.println("name:"+fname);
		System.out.println("Path:"+fPath);
		System.out.println("AbsPath:"+fAbsPath);
		System.out.println("Parent:"+fParent);
		System.out.println("len:"+flen);
		System.out.println("time:"+ftime);
		System.out.println("Date:"+fDate);
		System.out.println("str_date:"+str_date);
	}
	private static void show3() throws IOException {	//常用方法演示，创建与删除
		//2.创建与删除
		File f2 = new File("f.txt");
		boolean bc = f2.createNewFile();//2.1，创建新文件
//		f2.deleteOnExit();//这里介绍一个deleteOnExit方法，无返回值。这个方法的作用是，创建一个临时的文件，在系统退出时删除。本质上还是属于创建方法。
		
		System.out.println("bc="+bc);
		boolean bd = f2.delete();
		System.out.println("bd="+bd);//2.2，删除文件
		
		File dir1 = new File("aaa");
		boolean bm = dir1.mkdir();//2.3，创建新文件夹(也叫目录),mkdir,make directory
		System.out.println("bm="+bm);
		System.out.println(dir1.delete());	//2.2删除文件夹
		
		File dir2 = new File("bbb\\c\\sc\\ff\\gg\\hh");
		boolean bms = dir2.mkdirs();//2.4，创建多级文件夹，使用这个方法时，new File("bbb\\c\\sc\\ff\\gg\\hh")也必须与之对应
		System.out.println("bms="+bms);
		System.out.println(dir2.delete());	//多级文件夹的删除，只删除最后的文件夹，即hh
	}
	private static void show4() {	//常用方法演示，判断
		//3.判断
		File f3 = new File("test.txt");
		boolean be = f3.exists();	//3.1,判断该文件是否存在
//		f3.mkdir(); //在这里，我想用f3创建一个文件夹，但是实际上f3指向的这个test.txt文件已存在，这句代码无效
		//若之前的代码是new File("qqq.txt")时，f3.exists();会判断为不存在，此时的f3.mkdir();会创建一个名为qqq.txt的文件夹，而不再是txt文件
		System.out.println("be="+be);
		System.out.println(f3.isFile()); //3.2，判断是否是文件
		System.out.println(f3.isDirectory());//3.3，判断是否是文件夹
	}
	private static void show5() {	//常用方法演示，重命名
		//4.重命名
		File f4 = new File("test.txt");
		File f5 = new File("test_test.txt");
		boolean br = f4.renameTo(f5);	//4.1，将文件重命名，且只有这一种方法。
		System.out.println(br);
		System.out.println(f5.renameTo(f4));
	}
	private static void show6() {	//常用方法演示，获取系统根目录和容量
		//5.获取系统根目录和容量
		File[] files = File.listRoots();//5.1，获取系统根目录
		for(File file : files){
			System.out.println(file);
		}
		File f6 = new File("F:\\");
		System.out.println(f6.getFreeSpace());//5.2，获取剩余空间 
		System.out.println(f6.getTotalSpace());//5.3，获取总容量  
		System.out.println(f6.getUsableSpace());//5.4，获取可用空间 
	}
	private static void show7() {	//常用方法演示，获取目录内容
		//6.获取目录内容
		File f7 = new File("F:\\");
		String[] names = f7.list();	//6.1，获取目录内容的名称 
		for(String name : names){
			System.out.println(name);
		}
		File[] files = f7.listFiles();	//6.2获取目录内容的对象
		for(File file : files){
			System.out.println(file);
		}
	}

}
