package bean;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByName implements FilenameFilter{//���ʵ�ֵĽӿ����ļ���������
	////��ȡ��.zip��β���ļ�
	public boolean accept(File dir, String name) {
		
		return name.endsWith(".zip");
	}

}
