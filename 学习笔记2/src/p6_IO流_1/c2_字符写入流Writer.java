package p6_IO��_1;

import java.io.FileWriter;
import java.io.IOException;

/* Writer:�ַ�д������Ҳ��Ϊ�ַ��������
 * ������Writer������FileWriter����ʾ��
 * FileWriter������д���ַ��ļ��ı���ࡣ
 * 
 * ���췽�������췽��û�пղεģ���˼�Ǵ�������ʱ�ͱ���Ҫ��ȷ���ݵ�Ŀ�ĵء�
 * 
 * ���÷������̳�Writer�ķ�����
 * 1.д������  void write(T t) //����д���ָ�ʽ������
 * 2.���  Writer append(T t)	//����д���ָ�ʽ������(��ʱ����)
 * 3.ˢ�»��壬�������������е�����д�뵽Ŀ�ĵ���  void flush()
 * 4.�ر���   void close()//�ڹر�ǰ��ִ��һ��flush()
 */
public class c2_�ַ�д����Writer {

	public static final String Line_separator = System.getProperty("line.separator");//����һ�������������û��з�
	
	public static void main(String[] args) throws IOException {
		show1();
//		show2();
	}

	private static void show1() throws IOException {
		/* ����һ���������ļ���д���ַ����ݵ��ַ����������
		 * 
		 * ��Ȼ����һ���ļ���д���ַ����ݣ���ô�ڴ�������ʱ���ͱ�����ȷ���ļ�(���ڴ洢���ݵ�Ŀ�ĵ�)��
		 * ����ļ������ڣ��ͻ��Զ�����������ļ����ڣ���ᱻ���ǡ�
		 */
		FileWriter fw = new FileWriter("test.txt");	//�����ַ����������ʱ����Ҫ�׳��쳣�����쳣��IOException
		
		/* ����Writer�����е�writer(String)����д�����ݡ�
		 * ��ʵ����д�뵽����ʱ�洢�������С�
		 */
		fw.write("abcc");//1
//		fw.write(Line_separator);//�����Ϳ���ʵ�ֻ��У��ô��ǿ������κ�ƽ̨����ֲ
		fw.write("haha");
//		fw.write("abcc"+Line_separator+"haha");//Ҳ��������д
//		fw.flush();
		fw.close();//�ر����Ĳ�����һ��Ҫ�У��������Թر���Դ
		//˵����flush�����ö�Σ���closeֻ����һ��
	}
	
	private static void show2() throws IOException {
		//������캯�������м���true�����ʵ�ֶ��ļ�����д
		FileWriter fw = new FileWriter("test.txt",true);
		fw.write(Line_separator);
		fw.write("xixi");
		fw.close();
		
	}
}
