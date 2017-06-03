package ʵ��;

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

//Ҫ�������ַ����ʾĿ¼�����ҿ�������ʾ��Ŀ¼��

public class �ۺ�ʵ�� extends JFrame {
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
					�ۺ�ʵ�� frame = new �ۺ�ʵ��();
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
	public �ۺ�ʵ��() {
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
		
		
		//�������¼�
		btnNewButton.addMouseListener(new MouseAdapter() {//��ť���µ��¼�,��ʾĿ¼

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				showDir(scrollPane);
			}
			
		});
		
		textField.addKeyListener(new KeyAdapter() {//�ı����¼������س���ʾĿ¼

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//���µİ����ǻس��Ļ�
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
				jd.setTitle("��ע��");
				Container c = jd.getContentPane();
				c.setLayout(new FlowLayout(FlowLayout.LEFT));
				c.add(new JLabel("�����ߣ�Ҷ�Ϻ�"));
				c.add(new JLabel("QQ��1943336161"));
				jd.setBounds(150,150,200,100);
				jd.setVisible(true);
				
			}
		});
		
	}
	//��ʾ
	public void showDir(JScrollPane scrollPane) {
		
		
		String dir_str = textField.getText();
		File dir = new File(dir_str); //�Ƚ��ı����е��ַ�����װΪFile����
		if (dir.exists() && dir.isDirectory()) {//�жϣ�File�Ƿ������File���ļ�Ŀ¼
			
			//ÿ�����õ�ʱ����Ҫ�������ı�����
			String[] names = dir.list();
			int count = names.length;	
			
			//���table
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
					
					return false;//��д������ʹ�䲻�ɱ༭
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
			if (dir.exists() && dir.isDirectory()) {//�жϣ�File�Ƿ������File���ļ�Ŀ¼
				textField.setText(str);
				showDir(scrollPane);;
			}
		}
	}	
}
