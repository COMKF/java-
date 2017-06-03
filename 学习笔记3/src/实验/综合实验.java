package 实验;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//要求：输入地址，显示目录，并且可以在显示的目录打开

public class 综合实验 extends JFrame {
	protected static final String LINE_SPACE = System.getProperty("line.separator");

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					综合实验 frame = new 综合实验();
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
	public 综合实验() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6253\u5F00");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5173\u95ED");
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u67E5\u770B");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5173\u4E8E");
		menu_2.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 296, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8DF3\u8F6C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(331, 10, 93, 30);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		if (table.getRowCount()==0) {
			textField.setText("d:\\");
			showDir(scrollPane);
		}
		
		
		//以下是事件
		btnNewButton.addMouseListener(new MouseAdapter() {//按钮按下的事件,显示目录

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				showDir(scrollPane);
			}
			
		});
		
		textField.addKeyListener(new KeyAdapter() {//文本框事件，按回车显示目录

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//按下的按键是回车的话
					showDir(scrollPane);
				}
			}
			
		});
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if (e.getClickCount()==2) {
					showdir2(scrollPane);
				}
			}
		});
		
		menuItem.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				super.mousePressed(e);
				showdir2(scrollPane);
			}
		});
		
		menuItem_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				System.exit(0);
			}
		});
		
		menuItem_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				
				JDialog jd = new JDialog();
				jd.setTitle("请注意");
				Container c = jd.getContentPane();
				c.setLayout(new FlowLayout(FlowLayout.LEFT));
				c.add(new JLabel("制作者：叶孟豪"));
				c.add(new JLabel("QQ：1943336161"));
				jd.setBounds(150,150,200,100);
				jd.setVisible(true);
				
			}
		});
		
	}
	//显示
	public void showDir(JScrollPane scrollPane) {
		
		
		String dir_str = textField.getText();
		File dir = new File(dir_str); //先将文本框中的字符串封装为File对象
		if (dir.exists() && dir.isDirectory()) {//判断，File是否存在且File是文件目录
			
			//每次新用的时候，需要清空这个文本区域
			String[] names = dir.list();
			int count = names.length;	
			
			//添加table
			table.setShowGrid(false);
			table.setModel(new DefaultTableModel(
				new Object[count][1],
				new String[] {
					"\u6587\u4EF6"
				}
			)
			{
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					
					return false;//重写方法，使其不可编辑
				}
			}
			);
			
			scrollPane.setViewportView(table);
			
			int i = 0;
			for (String name : names) {
				table.setValueAt(name, i, 0);;
				i++;					
			}
		}
	}

	/**
	 * @param scrollPane
	 */
	public void showdir2(JScrollPane scrollPane) {
		int SelectedRow = table.getSelectedRow();
		if (SelectedRow != -1) {
			String str = (String)table.getValueAt(SelectedRow,0);		
			str = textField.getText()+'\\'+str;
			File dir = new File(str);
			if (dir.exists() && dir.isDirectory()) {//判断，File是否存在且File是文件目录
				textField.setText(str);
				showDir(scrollPane);;
			}
		}
	}	
}
