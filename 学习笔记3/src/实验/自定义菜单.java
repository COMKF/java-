package ʵ��;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class �Զ���˵� extends JFrame {
	protected static final String LINE_SPACE = System.getProperty("line.separator");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					�Զ���˵� frame = new �Զ���˵�();
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
	public �Զ���˵�() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6253\u5F00");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FDD\u5B58");
		
		menu.add(menuItem_1);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 241);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		//�������¼�
		
		JFileChooser chooser = new JFileChooser();
		menuItem.addMouseListener(new MouseAdapter(){//�˵����ļ����򿪵��¼�
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					openfile(textArea, chooser);//���¼������ع�Ϊ����
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					savefile(textArea, chooser);//���¼������ع�Ϊ����
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
	}
	/**
	 * @param textArea
	 * @param chooser
	 * @throws IOException 
	 */
	public void openfile(JTextArea textArea, JFileChooser chooser) throws IOException {//���ع�֮��ķ���
		System.out.println("1");
//			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//			        "JPG & GIF Images", "jpg", "gif");
//			    chooser.setFileFilter(filter);
		int returnval = chooser.showOpenDialog(contentPane); //ѡ��һ���ļ���������״̬��Ϊint��
		if (returnval == JFileChooser.CANCEL_OPTION) {//�ж��Ƿ�ȡ����ѡ�����ǣ���ֱ�ӷ���
			System.out.println("û��ѡȡ�ļ�");
			return;
		}
		File file = chooser.getSelectedFile();//ѡȡ�ļ��󣬽��з�װ
		textArea.setText("");//���
		
		//������io�ļ���
		BufferedReader bfr = new BufferedReader(new FileReader(file));
		
		String line = null;
		while ((line = bfr.readLine())!=null) {
			textArea.append(line+LINE_SPACE);//�ı��������
		}
		
		bfr.close();
	}
	
	protected void savefile(JTextArea textArea, JFileChooser chooser) throws IOException {
		System.out.println("1");
//	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//	        "JPG & GIF Images", "jpg", "gif");
//	    chooser.setFileFilter(filter);
		int returnval = chooser.showSaveDialog(contentPane); //ѡ��һ���ļ���������״̬��Ϊint��
		if (returnval == JFileChooser.CANCEL_OPTION) {//�ж��Ƿ�ȡ����ѡ�����ǣ���ֱ�ӷ���
			System.out.println("ȡ������");
			return;
		}
		
		File file = chooser.getSelectedFile();
		
		String text = textArea.getText();
		BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
		bfw.write(text);
		bfw.close();
	}
}
