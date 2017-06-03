package bean;

import java.io.IOException;
import java.io.Reader;

//�ص��������ԭ��
public class MyBufferedReader_optimize extends Reader{	//ʵ����BufferedReader������Reader�����࣬�������Զ����BufferedҲ�̳�Reader

//	private FileReader fr;
	private Reader r;	//����ֱ����Reader������������գ��Ϳ��Խ���һ��Reader������
	//����һ��������Ϊ������
	private char[] buf = new char[1024];
	
	//����һ��ָ������������������е�Ԫ�أ������������һ��Ԫ��ʱ��ָ��Ӧ�ù�0
	private int pos = 0;
	
	//����һ�������������ڼ�¼�������е����ݸ����������ݼ���0ʱ���ʹ�Դ�л�ȡ���ݵ���������
	private int count = 0;
	
	public MyBufferedReader_optimize(Reader r) {
		this.r = r;
	}
	
	public int MyRead() throws IOException{
		if (count == 0) {
			count = r.read(buf);
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
		r.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {	//���������Ҫ��д����Ĺ��ܣ��ڴ�ʡ��
		
		return 0;
	}

	@Override
	public void close() throws IOException {	//���������Ҫ��д����Ĺ��ܣ��ڴ�ʡ��
	}

}
