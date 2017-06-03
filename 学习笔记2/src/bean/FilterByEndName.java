package bean;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByEndName implements FilenameFilter{//���ʵ�ֵĽӿ����ļ���������
	//����ʲô��׺��������ʲô��׺��Ϊ���˱�׼
	private String suffix;
	public FilterByEndName(String suffix){
		this.suffix = suffix;
	}
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
	}

}
