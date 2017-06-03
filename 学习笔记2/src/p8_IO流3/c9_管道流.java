package p8_IO��3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/* �ܵ�����PipedInputStream��PipedOutputStream�����������ֱ�ӽ������ӣ�ͨ������߳�ʹ�á�
 * ���ң��ܵ����Ĺ�������д�ٶ������û��д�����һֱ�ȴ�������ʽ��
 */

public class c9_�ܵ��� {

	public static void main(String[] args) throws IOException {
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		input.connect(output); //��input��connect��������input��output
		//���������̶߳���
		new Thread(new Input(input)).start();
		new Thread(new Output(output)).start();
	}

}

class Input implements Runnable{

	private PipedInputStream in;
	Input(PipedInputStream in){
		this.in = in;
	}
	public void run() {
		try{
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			
			String s = new String(buf,0,len);
			System.out.println("s="+s);
			in.close();
		}
		catch(Exception e){
			
		}
	}
}

class Output implements Runnable{

	private PipedOutputStream out;
	Output(PipedOutputStream out){
		this.out = out;
	}
	public void run() {
		try {
			out.write("�٣��ܵ����ˣ�".getBytes());
		} catch (Exception e) {
			
		}
	}
}
