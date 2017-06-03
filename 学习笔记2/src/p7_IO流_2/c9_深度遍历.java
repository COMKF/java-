package p7_IO��_2;

import java.io.File;

/* ���󣺶�ָ��Ŀ¼�����������ݵ��г�(�����֣�Ŀ¼�е�����)
 * Ҳ�������Ϊ��ȱ���
 */
public class c9_��ȱ��� {

	public static void main(String[] args) {
		File f = new File("G:\\javaʵ��\\");	//����һ����װĿ¼��File����
		System.out.println(f.isDirectory());
		ListAll(f,0);
	}

	private static void ListAll(File f,int level) {	//����level����Ϊ���ܹ���������ʾ�ĸ��Ӻÿ�
		
		System.out.println(getSpace(level)+"dir:"+f.getAbsolutePath());
		level++;
		//��ȡָ��Ŀ¼�µ�ǰ���е��ļ�������ļ��ж���
		File[] files = f.listFiles();
		for(int i = 0 ; i < files.length; i++){
			if (files[i].isDirectory()) {
				ListAll(files[i],level);	//�����������ķ������ݹ���ã�����ֱ�ӵݹ飬�ݹ��ʹ����ϸ��ο�ʵ���е�ʹ�õݹ�ɾ��Ŀ¼
			}
			else
				System.out.println(getSpace(level)+"file:"+files[i].getName());
		}
	}

	private static String getSpace(int level) {	//��������
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < level; i++){
			sb.append("|--");
		}
		return sb.toString();
	}

}
