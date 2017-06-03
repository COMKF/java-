package p8_IO流3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/* 管道流：PipedInputStream，PipedOutputStream。输入输出可直接进行连接，通过结合线程使用。
 * 而且，管道流的过程是先写再读，如果没有写，则读一直等待，阻塞式。
 */

public class c9_管道流 {

	public static void main(String[] args) throws IOException {
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		input.connect(output); //用input的connect方法连接input和output
		//创建两个线程对象
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
			out.write("嘿，管道来了！".getBytes());
		} catch (Exception e) {
			
		}
	}
}
