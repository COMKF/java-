package p1_���ӻ�ͼ��;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class c2_���ͼ����¼� {

	private Frame f; //����
	private TextField tf;	//�ı���
	private Button but;

	public c2_���ͼ����¼�() {
		init();//���Զ��巽�����г�ʼ��
	}


	private void init() {
		f = new Frame("���ͼ����¼� ");
		f.setBounds(400, 100, 500, 300);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(35);//�����ı��򣬲����ÿ��
		but = new Button("һ����ť");
		
		f.add(tf);
		f.add(but);
		
		MyEvent();
		
		f.setVisible(true);
	}


	private void MyEvent() {
		//����Ĺرչ���
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		//��ť�ϵ��¼�����
		
		but.addMouseListener(new MouseAdapter() {	//��ť������¼�

			int count = 0 ;
			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println("mouse enter..."+count++);
				tf.setText("mouse enter..."+count++);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouse out");
			}

			@Override
			public void mouseClicked(MouseEvent e) {//�����¼�
				System.out.println(e);
				if (e.getClickCount() == 2) {
					tf.setText("mouse double click..."+count++);
				}
			}
			
		});
		
		//�ı����ϵ��¼�����
		tf.addKeyListener(new KeyAdapter() {//�ı���󶨼����¼�

			@Override
			public void keyTyped(KeyEvent e) {//����
				super.keyTyped(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {//����
//				System.out.println("key run..."+e.getKeyChar()+e.getKeyCode());//������¼���char���ͺ���������
				int code = e.getKeyCode();//ȡ�ð��¼�����������
//				if (!(code>=KeyEvent.VK_0 && code<= KeyEvent.VK_9)) {//�ж������Ƿ�������
//					System.out.println("����������");
//					e.consume();//����Ĭ���������д��
//				}
				if (e.isControlDown() && code == e.VK_ENTER) {	//�ж�ͬʱ����ctrl��enter����ϼ�
					System.out.println("enter");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {//�ͷ�
				super.keyReleased(e);
			}	
			
		});
	}
	
	public static void main(String[] args) {
		new c2_���ͼ����¼�();
	}
	

}
