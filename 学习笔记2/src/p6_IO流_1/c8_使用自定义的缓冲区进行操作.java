package p6_IO��_1;
//��c7�Ĵ���һ����ֻ���������Զ���Ļ�������MyBufferedReader��
import java.io.FileReader;
import java.io.IOException;
import bean.MyBufferedReader;

public class c8_ʹ���Զ���Ļ��������в��� {

	public static void main(String[] args) throws IOException {
		show();
		show2();
	}

	private static void show() throws IOException {	//ͨ��readLine()������ȡ�ı��ļ�����ȡһ���ַ�
		FileReader fr = new FileReader("buffer_test.txt");
		MyBufferedReader bffr = new MyBufferedReader(fr);
		String line = null;
		while ((line = bffr.MyReadLine()) != null) {
			System.out.println(line);
		}
		bffr.Myclose();
	}

	private static void show2() throws IOException {	//ͨ��read()������ȡ�ı��ļ�,��ȡ�����ַ�
		FileReader fr = new FileReader("buffer_test.txt");
		MyBufferedReader bffr = new MyBufferedReader(fr);
		//ע�⣬bffr.read()�����Ǵӻ�����ȡ���ַ����ݣ�Ҳ����ֱ�Ӵ��ڴ���ȡ�����ԱȽϸ�Ч�����ʵ�������read()�����Ѿ������˸����read()������
		int ch;
		while((ch = bffr.MyRead()) != -1){
			System.out.print((char)ch);
		}
		bffr.Myclose();
	}
}
