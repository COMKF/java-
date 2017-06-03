package 实验;

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

public class 自定义菜单 extends JFrame {
	protected static final String LINE_SPACE = System.getProperty("line.separator");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					自定义菜单 frame = new 自定义菜单();
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
	public 自定义菜单() {
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
		
		//以下是事件
		
		JFileChooser chooser = new JFileChooser();
		menuItem.addMouseListener(new MouseAdapter(){//菜单，文件，打开的事件
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					openfile(textArea, chooser);//把事件代码重构为方法
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		menuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					savefile(textArea, chooser);//把事件代码重构为方法
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
	public void openfile(JTextArea textArea, JFileChooser chooser) throws IOException {//被重构之后的方法
		System.out.println("1");
//			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//			        "JPG & GIF Images", "jpg", "gif");
//			    chooser.setFileFilter(filter);
		int returnval = chooser.showOpenDialog(contentPane); //选择一个文件，并返回状态，为int型
		if (returnval == JFileChooser.CANCEL_OPTION) {//判断是否取消了选择，若是，则直接返回
			System.out.println("没有选取文件");
			return;
		}
		File file = chooser.getSelectedFile();//选取文件后，进行封装
		textArea.setText("");//清空
		
		//以下是io的技术
		BufferedReader bfr = new BufferedReader(new FileReader(file));
		
		String line = null;
		while ((line = bfr.readLine())!=null) {
			textArea.append(line+LINE_SPACE);//文本框的输入
		}
		
		bfr.close();
	}
	
	protected void savefile(JTextArea textArea, JFileChooser chooser) throws IOException {
		System.out.println("1");
//	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//	        "JPG & GIF Images", "jpg", "gif");
//	    chooser.setFileFilter(filter);
		int returnval = chooser.showSaveDialog(contentPane); //选择一个文件，并返回状态，为int型
		if (returnval == JFileChooser.CANCEL_OPTION) {//判断是否取消了选择，若是，则直接返回
			System.out.println("取消保存");
			return;
		}
		
		File file = chooser.getSelectedFile();
		
		String text = textArea.getText();
		BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
		bfw.write(text);
		bfw.close();
	}
}
