package p7_IO流_2;

import java.io.File;

/* 需求：对指定目录进行所有内容的列出(包含字，目录中的内容)
 * 也可以理解为深度遍历
 */
public class c9_深度遍历 {

	public static void main(String[] args) {
		File f = new File("G:\\java实验\\");	//创建一个封装目录的File对象
		System.out.println(f.isDirectory());
		ListAll(f,0);
	}

	private static void ListAll(File f,int level) {	//加入level，是为了能够缩进，显示的更加好看
		
		System.out.println(getSpace(level)+"dir:"+f.getAbsolutePath());
		level++;
		//获取指定目录下当前所有的文件对象和文件夹对象
		File[] files = f.listFiles();
		for(int i = 0 ; i < files.length; i++){
			if (files[i].isDirectory()) {
				ListAll(files[i],level);	//自身调用自身的方法，递归调用，属于直接递归，递归的使用详细请参考实验中的使用递归删除目录
			}
			else
				System.out.println(getSpace(level)+"file:"+files[i].getName());
		}
	}

	private static String getSpace(int level) {	//缩进方法
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < level; i++){
			sb.append("|--");
		}
		return sb.toString();
	}

}
