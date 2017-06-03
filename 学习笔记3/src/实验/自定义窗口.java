package 实验;

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
//要求：输入地址，显示目录
public class 自定义窗口 extends JFrame {

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
					自定义窗口 frame = new 自定义窗口();
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
	public 自定义窗口() {
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
		
		JScrollPane scrollPane = new JScrollPane();//带滚动条的面板
		scrollPane.setBounds(28, 51, 381, 190);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		//以下是事件
		btnNewButton.addMouseListener(new MouseAdapter() {//按钮按下的事件,显示目录

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				showDir(textArea);
			}
			
		});
		
		textField.addKeyListener(new KeyAdapter() {//文本框事件，按回车显示目录

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//按下的按键是回车的话
					showDir(textArea);
				}
			}
			
		});
	}

	/**
	 * @param textArea
	 */
	//显示
	public void showDir(JTextArea textArea) {
		String dir_str = textField.getText();
		File dir = new File(dir_str); //先将文本框中的字符串封装为File对象
		if (dir.exists() && dir.isDirectory()) {//判断，File是否存在且File是文件目录
			textArea.setText("");//每次新用的时候，需要清空这个文本区域
			String[] names = dir.list();
			for (String name : names) {
//						textArea.setText(name);//这个方法不可用，因为下次调用的时候，会覆盖之前写入的内容
				textArea.append(name+LINE_SPACE);//应该用这个方法
				
			}
		}
	}
}
