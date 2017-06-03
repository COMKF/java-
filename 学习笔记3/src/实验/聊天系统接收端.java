package 实验;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class 聊天系统接收端 implements Runnable {
	private DatagramSocket ds;

	public 聊天系统接收端(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				ds.receive(dp);

				String ip = dp.getAddress().getHostAddress();
				int port = dp.getPort();
				String text = new String(dp.getData(), 0, dp.getLength());
				
				System.out.println(ip + "::" + text);
				if(text.equals("886")){
					System.out.println(ip+"....退出聊天室");
				}

			}
		} catch (Exception e) {

		}

	}

}
