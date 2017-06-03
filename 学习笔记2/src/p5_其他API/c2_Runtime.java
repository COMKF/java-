package p5_其他API;

import java.io.IOException;

/* 每个java程序都有一个Runtime类实例，是应用程序能与其运行环境相连接(比如应用程序的进程和空间等资源)。可以通过getRuntime方法获取当前运行时。
 * Runtime类没有构造方法摘要，说明该类不可以创建对象，又发现还有非静态方法。
 * 说明该类应该能提供静态的返回该类对象的方法，而且只有一个，说明使用了单例设计模式。
 * 
 * Runtime类的常用功能：
 * 1.开启程序  Process exec(String command)//返回类型为Process，实际上是一个进程
 * 
 * Process类的常用功能：
 * 1.杀掉子进程  void destroy();
 * 
 */
public class c2_Runtime {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("notepad.exe 1.txt");//调用exec方法需要抛出或者捕捉异常，异常为IOException(输入输出异常)，从当前路径和Path路径下找
//		r.exec("E:\\QQ\\Bin\\QQ.exe");//这样写也是可以的，这样用的是绝对路径，注意：\为转译符，如\t是制表符，所以这里用\\作为文件分隔符
//		r.exec("notepad.exe 1.txt");//这种写法的意义是，用前一个exe程序解析后一个文件，但是要注意两者需匹配。如palyer.exe  XX.avi
		Thread.sleep(5000);
		p.destroy();//注意，destroy只能杀掉自己的进程，而不能杀掉其他的进程。
	}

}
