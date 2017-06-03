package p7_IO��_2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/* File�ࣺ�������ļ����ļ��з�װ���࣬������ļ����ļ��е����Խ��в�����
 * File���������Ϊ�������ݸ����Ĺ��캯����
 * 
 * ���췽����
 * 1.File(String pathname) 	//�������ַ������������ļ���(֧�־���·��)������·������������Ӧ��File����
 * 2.File(String parent, String child)	//�������������ַ�����������ļ��У��ұ����ļ���
 * 3.File(File parent, String child)	//��߲�����File���󣬱�����ͨ��·�������ɵ�File�����ұ߲������ַ������ļ���
 * 
 * ���÷�����
 * 1.��ȡ
 * 1.1��ȡ�ļ�����  String getName()
 * 1.2��ȡ�ļ�·��  String getPath()   String getAbsolutePath()
 * 1.3��ȡ�ļ���С  long length()
 * 1.4��ȡ�ļ��޸�ʱ��  long lastModified()
 * 2.������ɾ��
 * 2.1�������ļ�  boolean createNewFile()	//����ļ������ڣ��򴴽�������true������ļ����ڣ��򲻴���������false
 * 2.2ɾ���ļ����ļ���  boolean delete()	//����ļ����ڣ���ɾ��������true������ļ������ڣ����޷�ɾ��������false
 * 		//ֵ��ע����ǣ����ļ��������ļ����ڣ����ļ����޷�ɾ��������false
 * 		//���⣬���ļ���������ʱ���޷�ɾ��������false
 * 2.3�������ļ���  boolean mkdir()  //����ļ��в����ڣ��򴴽�������true������ļ��д��ڣ��򲻴���������false
 * 2.4�����༶�ļ���  boolean mkdirs() //ֻ��ע���һ���ļ����Ƿ���ڣ��������ڣ��򴴽�������true�������ڣ��򲻴���������false
 * 3.�ж�
 * 3.1�жϸ��ļ��Ƿ����  boolean exists()	
 * 3.2�ж��Ƿ����ļ�   boolean isFile() 
 * 3.3�ж��Ƿ����ļ���  boolean isDirectory()  //���һ���ļ����������ڣ����������ж϶�Ϊfalse�������ڽ����������ж�֮ǰ��������ж��Ƿ����
 * 4.������
 * 4.1���ļ�������  boolean renameTo(File dest) //�������ķ�������Ŀ���ļ��������滻ԭ�ļ������ƣ��������ɹ��򷵻�true��ʧ���򷵻�false
 * 		//���⣬���ԭ�ļ���Ŀ���ļ�����ͬһ·���£���ɾ��ԭ�ļ���������Ŀ���ļ���·���������������Ƶ����ļ����ļ�������ݲ���
 * 5.��ȡϵͳ��Ŀ¼������
 * 5.1��ȡϵͳ��Ŀ¼  static File[] listRoots()
 * 5.2��ȡʣ��ռ�  long getFreeSpace()  //�����Ϊ����
 * 5.3��ȡ������  long getTotalSpace()
 * 5.4��ȡ���ÿռ�  long getUsableSpace()
 * 6.��ȡĿ¼����
 * 6.1��ȡĿ¼���ݵ�����  String[] list() //����ֵΪString[]�������������ļ����ļ��������������ļ���
 * 		//ע�⣬���ø÷�����File�����з�װ�ı�����Ŀ¼(�ļ���),����ᷢ����ָ���쳣��������ʵ���ϵͳ��Ŀ¼��Ҳ�ᷢ�������쳣
 * 6.2��ȡĿ¼���ݵĶ���  File[] listFiles() //����ֵΪFile[]�������������ļ��Ķ��󣬰��������ļ��������Ϊ����
 */
public class c7_File�� {

	public static void main(String[] args) throws IOException {
//		show1();
//		show2();
//		show3();
//		show4();
//		show5();
//		show6();
		show7();
								
	}
	private static void show1() {	//���췽����ʾ
		//���췽����ʾ�����Խ�һ���Ѵ��ڵĻ򲻴��ڵ��ļ����ļ��з�װ�ɶ���
		File f1 = new File("f.txt");//1
//		File file = new File("G:\\javaʵ��\\f.txt");	//֧�־���·��
		File f2 = new File("G:\\javaʵ��\\","f.txt");	//2������������������ļ��У��ұ����ļ������ô����������������޸ġ�
		File f = new File("G:\\javaʵ��\\");	//1�����ļ��з�װ��File����
		File f3 = new File(f,"f.txt");	//3�������ĺô��ǣ����԰��ļ�����File����������
		
		File file = new File("G:"+File.separator+"javaʵ��"+File.separator+"f.txt");	//File.separator�����Ʒָ���(��\\)
	}
	private static void show2() {	//���÷�����ʾ����ȡ
		File f1 = new File("test.txt");	//����д����ʵ����һ�����·��
		//1.��ȡ
		String fname = f1.getName();	//1.1����ȡ�ļ���
		String fPath = f1.getPath();	//1.2����ȡ���·�����������������ʵ��new File("test.txt")���·����дʲô�����ʲô
		String fAbsPath = f1.getAbsolutePath();//1.2����ȡ����·�������·�������·�������𣬴��̷���ʼ���Ǿ���·��������������·��
		String fParent = f1.getParent();	//��ø�Ŀ¼��д����new File("test.txt")�Ļ�����ֵΪnull��д����·���Ļ��ͻ���ʾ����ĸ�Ŀ¼
		long flen = f1.length();	//1.3,��ȡ�ļ���С
		long ftime = f1.lastModified();//1.4,��ȡ����޸�ʱ��
		Date fDate = new Date(ftime);	//���޸�ʱ��ת��ΪDate��
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);	//��ȡ���ڸ�ʽ����������ΪLONG��
		String str_date = dateFormat.format(fDate);	//ת�����ڸ�ʽ������ֵΪ�ַ�����
		
		System.out.println("name:"+fname);
		System.out.println("Path:"+fPath);
		System.out.println("AbsPath:"+fAbsPath);
		System.out.println("Parent:"+fParent);
		System.out.println("len:"+flen);
		System.out.println("time:"+ftime);
		System.out.println("Date:"+fDate);
		System.out.println("str_date:"+str_date);
	}
	private static void show3() throws IOException {	//���÷�����ʾ��������ɾ��
		//2.������ɾ��
		File f2 = new File("f.txt");
		boolean bc = f2.createNewFile();//2.1���������ļ�
//		f2.deleteOnExit();//�������һ��deleteOnExit�������޷���ֵ����������������ǣ�����һ����ʱ���ļ�����ϵͳ�˳�ʱɾ���������ϻ������ڴ���������
		
		System.out.println("bc="+bc);
		boolean bd = f2.delete();
		System.out.println("bd="+bd);//2.2��ɾ���ļ�
		
		File dir1 = new File("aaa");
		boolean bm = dir1.mkdir();//2.3���������ļ���(Ҳ��Ŀ¼),mkdir,make directory
		System.out.println("bm="+bm);
		System.out.println(dir1.delete());	//2.2ɾ���ļ���
		
		File dir2 = new File("bbb\\c\\sc\\ff\\gg\\hh");
		boolean bms = dir2.mkdirs();//2.4�������༶�ļ��У�ʹ���������ʱ��new File("bbb\\c\\sc\\ff\\gg\\hh")Ҳ������֮��Ӧ
		System.out.println("bms="+bms);
		System.out.println(dir2.delete());	//�༶�ļ��е�ɾ����ֻɾ�������ļ��У���hh
	}
	private static void show4() {	//���÷�����ʾ���ж�
		//3.�ж�
		File f3 = new File("test.txt");
		boolean be = f3.exists();	//3.1,�жϸ��ļ��Ƿ����
//		f3.mkdir(); //�����������f3����һ���ļ��У�����ʵ����f3ָ������test.txt�ļ��Ѵ��ڣ���������Ч
		//��֮ǰ�Ĵ�����new File("qqq.txt")ʱ��f3.exists();���ж�Ϊ�����ڣ���ʱ��f3.mkdir();�ᴴ��һ����Ϊqqq.txt���ļ��У���������txt�ļ�
		System.out.println("be="+be);
		System.out.println(f3.isFile()); //3.2���ж��Ƿ����ļ�
		System.out.println(f3.isDirectory());//3.3���ж��Ƿ����ļ���
	}
	private static void show5() {	//���÷�����ʾ��������
		//4.������
		File f4 = new File("test.txt");
		File f5 = new File("test_test.txt");
		boolean br = f4.renameTo(f5);	//4.1�����ļ�����������ֻ����һ�ַ�����
		System.out.println(br);
		System.out.println(f5.renameTo(f4));
	}
	private static void show6() {	//���÷�����ʾ����ȡϵͳ��Ŀ¼������
		//5.��ȡϵͳ��Ŀ¼������
		File[] files = File.listRoots();//5.1����ȡϵͳ��Ŀ¼
		for(File file : files){
			System.out.println(file);
		}
		File f6 = new File("F:\\");
		System.out.println(f6.getFreeSpace());//5.2����ȡʣ��ռ� 
		System.out.println(f6.getTotalSpace());//5.3����ȡ������  
		System.out.println(f6.getUsableSpace());//5.4����ȡ���ÿռ� 
	}
	private static void show7() {	//���÷�����ʾ����ȡĿ¼����
		//6.��ȡĿ¼����
		File f7 = new File("F:\\");
		String[] names = f7.list();	//6.1����ȡĿ¼���ݵ����� 
		for(String name : names){
			System.out.println(name);
		}
		File[] files = f7.listFiles();	//6.2��ȡĿ¼���ݵĶ���
		for(File file : files){
			System.out.println(file);
		}
	}

}
