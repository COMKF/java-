package bean;

import java.io.File;
import java.io.FileFilter;

public class FilterByHidden implements FileFilter{//���ʵ�ֵĽӿ����ļ����������
	//��ȡ�������ļ�
	public boolean accept(File pathname) {
		
		return !pathname.isHidden();
	}

}
