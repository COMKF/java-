package bean;

import java.io.File;
import java.io.FileFilter;

public class FilterByHidden implements FileFilter{//这个实现的接口是文件对象过滤器
	//获取非隐藏文件
	public boolean accept(File pathname) {
		
		return !pathname.isHidden();
	}

}
