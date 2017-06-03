package 实验;

import java.io.File;

/* 递归：函数自身直接或者间接的调用到了自身。
 * 一个功能在被重复使用，并在每次使用时，参与运算的结果和上一次调用有关，这是可以用递归解决问题。
 * 
 * 注意：
 * 1.递归一定要明确条件，否则容易栈溢出。
 * 2.注意递归的次数。
 */
/* 练习：删除一个目录。
 * 
 * 原理：必须要从最里面往外删。这是Windows的删除规则。
 * 需要进行深度遍历。
 */
public class 使用递归删除目录 {

	public static void main(String[] args) {
		File dir = new File("G:\\java实验\\");	//创建一个封装目录的File对象
		deleteDir(dir);
//		deleteDir2(dir);
		//其实这两种方法的本质一样，只不过用的循环不一样
	}
	
	private static void deleteDir(File dir) {	//第一种方法
		File[] files = dir.listFiles();
		for(int i = 0 ; i < files.length; i++){	//传统for循环
			if (files[i].isDirectory()) {
				deleteDir(files[i]);	//递归
			}
			else
				System.out.println("file:"+files[i].delete());	//先删除目录内的所有非目录文件
		}
		System.out.println("dir:"+dir.delete());	//删除完之后，再删除目录文件
	}

	private static void deleteDir2(File dir) {	//第二种方法
		File[] files = dir.listFiles();
		for(File file : files){	//高级for循环，传统for循环的简写
			if (file.isDirectory()) {
				deleteDir(file);	//递归
			}
			else
				System.out.println("file:"+file.delete());	//先删除目录内的所有非目录文件
		}
		System.out.println("dir:"+dir.delete());	//删除完之后，再删除目录文件
	}

}
