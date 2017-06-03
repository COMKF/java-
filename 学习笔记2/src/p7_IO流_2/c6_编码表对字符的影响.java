package p7_IO��_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* ��Ϊ�ַ���=�ֽ���+���������ʵ�����ַ����Ѿ���Ĭ�ϵı������б���ͽ����ˣ����Ĭ�ϵ�������ϵͳĬ�ϵ����
 * ���ǣ����������Ҫָ���������б����أ�
 * 
 * �Ǿ�ֻ�����ֽ�����д��Ȼ����Ϊ��ָ����Ҫʹ�õ����
 * �������Ҫ�õ�ת��������һ�����ܡ�������ָ�����
 * 
 * �����������ȷ��ʹ��ָ��������Ͳ���ʹ��FileWriter��FileReader����ΪFileWriter��FileReader�ڲ�ʹ�õ���Ĭ�ϵı������
 * ֻ��ʹ���丸��OutputStreamWriter��InputStreamReader��
 * OutputStreamWriter����һ���ֽ���������󣬼�Ȼ�ǲ����ļ�����ô�ö����Ӧ����FileOutputStream
 * ������ǣ�OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8");
 * ͬ��InputStreamReader isr = new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8");	
 * ��չ����Ҫ��Ч��
 * BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8"));
 * ͬ��BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8"));
 * 
 * ���Ͽɿ������ֽ���+�����=ת����������ת�������ַ�����ʱ�ǵȼ۵ġ�
 * 
 * ��ôʱ��ʹ��ת�����أ�
 * 1.Դ����Ŀ�Ķ�Ӧ�����ֽ�������������ȴ���ı����ݣ�����ʹ��ת������Ϊ��������߶��ı��Ĳ����ٶȡ�
 * 2.һ���ı��Ĳ����漰�������ָ���ı����ʱ������Ҫʹ��ת������
 */
public class c6_�������ַ���Ӱ�� {

	public static void main(String[] args) throws IOException {
		writer1();
		writer2();
		writer3();
		writer4();
		reader1();
		reader2();
	}
	private static void writer1() throws IOException {	//ʹ���ַ�������Ĭ�ϵ������б���
		FileWriter fw = new FileWriter("gbk_1.txt");	//(1)���������ĵ�WindowsĬ�������gbk����������Ҳ�����ַ���ʹ�õ����
		fw.write("���");
		fw.close();
	}
	private static void writer2() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_2.txt"));//(2)
		osw.write("���");
		osw.close();
	}
	private static void writer3() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk_3.txt"),"GBK");//(3)��
		//��ʵ(1)(2)(3)�Ĺ����ǵ�ͬ�ģ�FileWriter����ת����ָ���˱���Ĭ���������֡��������ת������������󣬿��Է�������ı��ļ���
		osw.write("���");
		osw.close();
	}
	private static void writer4() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("U8_1.txt"),"UTF-8");//��ָ�������Ϊ����
		osw.write("���");
		osw.close();
	}
	private static void reader1() throws IOException {
//		FileReader fr = new FileReader("gbk_1.txt");	//�����ûʲô����GBK���룬GBK����
		FileReader fr = new FileReader("U8_1.txt");	//����������ͻᷢ�ֽ����  你好 ����ʵ�������롣�����ԭ����������������ģ����˲�ͬ�����
		
		char[] buf = new char[10];
		int len = fr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		
		fr.close();
	}
	private static void reader2() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("U8_1.txt"),"UTF-8");	//����Ҫ�ö�Ӧ����������Ӧ���ı��ļ�
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk_1.txt"),"UTF-8");//��������������??��˵����������δ֪����
		
		char[] buf = new char[10];
		int len = isr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		
		isr.close();
	}
}
