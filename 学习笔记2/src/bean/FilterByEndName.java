package bean;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByEndName implements FilenameFilter{//这个实现的接口是文件名过滤器
	//传入什么后缀名，就以什么后缀名为过滤标准
	private String suffix;
	public FilterByEndName(String suffix){
		this.suffix = suffix;
	}
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
	}

}
