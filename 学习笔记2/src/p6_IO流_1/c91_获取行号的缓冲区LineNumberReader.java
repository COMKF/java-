package p6_IO��_1;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/* LineNumberReader:BufferedReader�����࣬�����кŵĻ����ַ���������
 * 
 * ���÷�����
 * 1.��ȡ�к�	 int getLineNumber()
 * 2.�����к�  void setLineNumber(int lineNumber)
 * 3.ͬʱ���и���BufferedReader�ķ�������read��readLine�ȡ�
 */
public class c91_��ȡ�кŵĻ�����LineNumberReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("buffer_test.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		
		String line = null;
		lnr.setLineNumber(100);	//������ʼ�кţ�������ʱĬ��Ϊ0
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber()+":"+line);
		}
		lnr.close();
	}

}
