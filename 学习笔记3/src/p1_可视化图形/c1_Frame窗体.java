package p1_���ӻ�ͼ��;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class c1_Frame���� {

	public static void main(String[] args) {
		Frame f = new Frame("MyFrame");//����һ�����ɼ��Ĵ��壬ͬʱ����һ���µ��߳�
		f.setSize(500, 300);//���ô��ڵĴ�С����һ�������Ǻ���500���أ��ڶ�������������300����
		f.setLocation(400, 100);//���ô��ڵ�λ�ã���һ�������Ǿ����400���أ��ڶ��������Ǿ��ϱ�100����
//		f.setBounds(400, 100, 500, 300);//����������������������ļ���
		
		Button but = new Button("һ����ť");
		
		f.add(but);//��Ӱ�ť�������У���Ϊ�����Զ�����ʱ�����Զ�ʹ�ñ߽�ʽ���֣�������Ӳ���˵���İ�ťʱ�����Զ�����ƽ�̵�����������
		f.setLayout(new FlowLayout());//���ô��岼��Ϊ��ʽ���֣������Ļ���ť�ͻ��ڵ�һ�о���
		f.setVisible(true);//���ÿɼ�����Ϊtrue
		System.out.println("over");
	
		//��ˣ����������Ĳ���1.�������岢����  2.�����������  3.������  4.��ʾ����
		
		//�¼��������ƣ�1.�¼�Դ������� 2.�¼�  3.������  4.�¼�����
		
		f.addWindowListener(new WindowAdapter() {//�¼�Դf�����¼�������

			@Override
			public void windowClosing(WindowEvent e) {//�����¼�
				
				//��������������
				super.windowClosing(e);
				System.out.println("closing....."+e);
				System.exit(0);
				
			}
			
		});
		
		
		//�ڰ�ť�ϼ��������
		
		but.addActionListener(new ActionListener() {//��ť�󶨻�¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button down");
				System.exit(0);
			}
		});
	}
}
