package p1_���ӻ�ͼ��;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class c3_���ӻ����� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					c3_���ӻ����� window = new c3_���ӻ�����();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public c3_���ӻ�����() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(e);//�Ѳ���д�������ⲿ
			}
		});
		button.setBounds(150, 77, 152, 67);
		frame.getContentPane().add(button);
	}

	protected void buttonAction(ActionEvent e) {//�Ѳ���д�������ⲿ
		System.exit(0);
	}
}
