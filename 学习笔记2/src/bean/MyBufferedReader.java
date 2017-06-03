package bean;

import java.io.FileReader;
import java.io.IOException;

/* �Զ���Ķ�ȡ��������ģ��һ��BufferedReader,�����������Ỻ������ʵ��ԭ��
 * 
 * ������
 * ���������Ƿ�װ��һ�����飬�������ṩ�˸���ķ�����������з��ʣ���ʵ��Щ�������ղ����Ķ�������Ľűꡣ
 * 
 * �����ԭ��
 * ��ʵ���Ǵ�Դ�л�ȡһ������װ���������У��ڻ������в��ϵ�ȡ��һ�������ݡ�
 * �ڴ˴�ȡ����ٴ�Դ�ж�ȡһ�����ݵ��������У���Դ�е�����ȡ��ʱ����-1���������
 */

public class MyBufferedReader {
	private FileReader fr;
	
	//����һ��������Ϊ������
	private char[] buf = new char[1024];
	
	//����һ��ָ������������������е�Ԫ�أ������������һ��Ԫ��ʱ��ָ��Ӧ�ù�0
	private int pos = 0;
	
	//����һ�������������ڼ�¼�������е����ݸ����������ݼ���0ʱ���ʹ�Դ�л�ȡ���ݵ���������
	private int count = 0;
	
	public MyBufferedReader(FileReader fr) {
		this.fr = fr;
	}
	
	public int MyRead() throws IOException{
//		//1.��Դ�л�ȡһ�����ݵ��������С���Ҫ�����жϣ�ֻ�м�����Ϊ0ʱ������Ҫ��Դ�л�ȡ���ݡ�
//		if (count == 0) {
//			count = fr.read(buf);
//			if(count < 0) return -1;
//			//ÿ�λ�ȡ���ݵ��������󣬽ű��0
//			pos = 0;
//			char ch = buf[pos];
//			pos++;
//			count--;
//			return ch;
//		}else if (count > 0) {
//			char ch = buf[pos];
//			pos++;
//			count--;
//			return ch;
//		}
//		return 0;
		
		//�Ż���Ĵ���
		if (count == 0) {
			count = fr.read(buf);
			pos = 0;
		}
		if(count < 0) return -1;
		char ch = buf[pos++];
		count--;
		return ch;
	}
	
	public String MyReadLine() throws IOException{
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		while ((ch = MyRead())!= -1) {
			if (ch == '\r') continue;
			if (ch == '\n') return sb.toString();
			//���������ж������ַ����洢�����������ݵĻ�������
			sb.append((char)ch);
		}
		if (sb.length() != 0) {	//��׳���жϣ���ʱ���ļ�����ʱ��û�д�س�������ô���ļ��������ַ���β�������������жϣ��ͻᶪʧ���һ�����ݡ�
			return sb.toString();
		}
		return null;
	}
	
	public void Myclose() throws IOException {
		fr.close();
	}
	
}
