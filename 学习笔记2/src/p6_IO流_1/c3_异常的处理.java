package p6_IO流_1;

import java.io.FileWriter;
import java.io.IOException;

public class c3_异常的处理 {
	public static final String Line_separator = System.getProperty("line.separator");
	public static void main(String[] args) {
		//文件异常的try—cat处理机制如下
		FileWriter fw = null;	
		try {
			fw = new FileWriter("test.txt");
			fw.write("abcc"+Line_separator+"haha");
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		finally{
			if (fw != null) //健壮性判断，加入这个判断的原因如下。
				//当fw = new FileWriter("test.txt");这一步失败时，fw=null，下面的fw.close();也会报错。为了避免这个报错，加入这个健壮性判断。
				try {
					fw.close();	//因为无论如何，流都需要被关闭，所以fw.close放在finally中。然后这个fw.close的异常需要单独处理。
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
		}
	}
}
