package ʵ��;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ����ϵͳ���ն� implements Runnable {
	private DatagramSocket ds;

	public ����ϵͳ���ն�(DatagramSocket ds) {
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
					System.out.println(ip+"....�˳�������");
				}

			}
		} catch (Exception e) {

		}

	}

}
