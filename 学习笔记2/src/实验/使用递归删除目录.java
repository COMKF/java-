package ʵ��;

import java.io.File;

/* �ݹ飺��������ֱ�ӻ��߼�ӵĵ��õ�������
 * һ�������ڱ��ظ�ʹ�ã�����ÿ��ʹ��ʱ����������Ľ������һ�ε����йأ����ǿ����õݹ������⡣
 * 
 * ע�⣺
 * 1.�ݹ�һ��Ҫ��ȷ��������������ջ�����
 * 2.ע��ݹ�Ĵ�����
 */
/* ��ϰ��ɾ��һ��Ŀ¼��
 * 
 * ԭ������Ҫ������������ɾ������Windows��ɾ������
 * ��Ҫ������ȱ�����
 */
public class ʹ�õݹ�ɾ��Ŀ¼ {

	public static void main(String[] args) {
		File dir = new File("G:\\javaʵ��\\");	//����һ����װĿ¼��File����
		deleteDir(dir);
//		deleteDir2(dir);
		//��ʵ�����ַ����ı���һ����ֻ�����õ�ѭ����һ��
	}
	
	private static void deleteDir(File dir) {	//��һ�ַ���
		File[] files = dir.listFiles();
		for(int i = 0 ; i < files.length; i++){	//��ͳforѭ��
			if (files[i].isDirectory()) {
				deleteDir(files[i]);	//�ݹ�
			}
			else
				System.out.println("file:"+files[i].delete());	//��ɾ��Ŀ¼�ڵ����з�Ŀ¼�ļ�
		}
		System.out.println("dir:"+dir.delete());	//ɾ����֮����ɾ��Ŀ¼�ļ�
	}

	private static void deleteDir2(File dir) {	//�ڶ��ַ���
		File[] files = dir.listFiles();
		for(File file : files){	//�߼�forѭ������ͳforѭ���ļ�д
			if (file.isDirectory()) {
				deleteDir(file);	//�ݹ�
			}
			else
				System.out.println("file:"+file.delete());	//��ɾ��Ŀ¼�ڵ����з�Ŀ¼�ļ�
		}
		System.out.println("dir:"+dir.delete());	//ɾ����֮����ɾ��Ŀ¼�ļ�
	}

}
