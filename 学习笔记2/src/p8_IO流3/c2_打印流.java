package p8_IO��3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/* ��ӡ������������PrintWriter(�ַ���ӡ��)��PrintStream(�ֽڴ�ӡ��)����ӡ����ֱ�Ӳ��������ļ���
 * PrintStream��Ϊ�������������˹��ܣ�ʹ�����ܷ���Ĵ�ӡ�������ݵı�ʾ��ʽ(����������)�������׳�IO�쳣��
 * ���캯����
 * 1.�ַ���·��
 * 2.File����
 * 3.�ֽ������
 * 
 * ���з�����
 * 1.void print(int i)	//�����ݱ���ԭ����д�뵽Ŀ�ĵ��У���֤�����ݵı�ʾ��ʽ
 * ֪ʶ���䣺void write(XX xx)//�÷���д�����һ�����ݵ����8λ����һ���ֽڣ�������ӽڻᱻ������
 */
/* PrintWriter�����ı��������ӡ��ʽ���ı�ʾ��ʽ��
 * ���캯����
 * 1.�ַ���·��
 * 2.File����
 * 3.�ֽ������
 * 4.�ַ������  PrintWriter(OutputStream out, boolean autoFlush)//������������һ��������һ����������ڶ������������Ƿ��Զ�ˢ��
 * 
 * ���з�����
 * 1. void print(String x) //�����ݱ���ԭ����д�뵽Ŀ�ĵ��У���֤�����ݵı�ʾ��ʽ
 */
public class c2_��ӡ�� {

	public static void main(String[] args) throws IOException {
//		PrintStr();
		PrintWri();
	}
	
	private static void PrintStr() throws FileNotFoundException {
		PrintStream out = new PrintStream("print.txt");
		out.write(97);	//��97��ASCII��ת�룬Ȼ��д�룬��Ҳ����������д�����
		
		out.write(609);	//�ɼ�д��97��609��Ч����һ���ģ���Ϊȡ�õĶ������8λ
		//1.
		out.print(97);	//��97�ȱ���ַ����������ݱ���ԭ����д�뵽Ŀ�ĵ��У����Ǵ�ӡ�����е�д�����
		
		out.close();
	}

	private static void PrintWri() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(System.out,true);	//���ں������ڶ���������true����ÿ�ε���println��format����ʱ���Զ�ˢ��
		String line = null;
		while ((line = bfr.readLine())!=null) {
			if ("over".endsWith(line)) {
				break;
			}
			out.println(line);
//			out.flush();	//ÿ�����У�����ˢ��
		}	
		out.close();
		bfr.close();
		
	}
}
