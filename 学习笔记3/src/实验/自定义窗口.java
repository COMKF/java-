package ʵ��;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
//Ҫ�������ַ����ʾĿ¼
public class �Զ��崰�� extends JFrame {

	protected static final String LINE_SPACE = System.getProperty("line.separator");
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					�Զ��崰�� frame = new �Զ��崰��();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public �Զ��崰��() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(28, 11, 269, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8F6C\u5230");
		btnNewButton.setBounds(316, 10, 93, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();//�������������
		scrollPane.setBounds(28, 51, 381, 190);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		//�������¼�
		btnNewButton.addMouseListener(new MouseAdapter() {//��ť���µ��¼�,��ʾĿ¼

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				showDir(textArea);
			}
			
		});
		
		textField.addKeyListener(new KeyAdapter() {//�ı����¼������س���ʾĿ¼

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//���µİ����ǻس��Ļ�
					showDir(textArea);
				}
			}
			
		});
	}

	/**
	 * @param textArea
	 */
	//��ʾ
	public void showDir(JTextArea textArea) {
		String dir_str = textField.getText();
		File dir = new File(dir_str); //�Ƚ��ı����е��ַ�����װΪFile����
		if (dir.exists() && dir.isDirectory()) {//�жϣ�File�Ƿ������File���ļ�Ŀ¼
			textArea.setText("");//ÿ�����õ�ʱ����Ҫ�������ı�����
			String[] names = dir.list();
			for (String name : names) {
//						textArea.setText(name);//������������ã���Ϊ�´ε��õ�ʱ�򣬻Ḳ��֮ǰд�������
				textArea.append(name+LINE_SPACE);//Ӧ�����������
				
			}
		}
	}
}
