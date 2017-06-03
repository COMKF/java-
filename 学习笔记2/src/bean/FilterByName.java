package bean;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByName implements FilenameFilter{//这个实现的接口是文件名过滤器
	////获取以.zip结尾的文件
	public boolean accept(File dir, String name) {
		
		return name.endsWith(".zip");
	}

}
