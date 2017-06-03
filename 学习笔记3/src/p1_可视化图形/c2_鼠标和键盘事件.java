package p1_可视化图形;

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

public class c2_鼠标和键盘事件 {

	private Frame f; //窗体
	private TextField tf;	//文本框
	private Button but;

	public c2_鼠标和键盘事件() {
		init();//用自定义方法进行初始化
	}


	private void init() {
		f = new Frame("鼠标和键盘事件 ");
		f.setBounds(400, 100, 500, 300);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(35);//构造文本框，并设置宽度
		but = new Button("一个按钮");
		
		f.add(tf);
		f.add(but);
		
		MyEvent();
		
		f.setVisible(true);
	}


	private void MyEvent() {
		//窗体的关闭功能
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		//按钮上的事件监听
		
		but.addMouseListener(new MouseAdapter() {	//按钮绑定鼠标事件

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
			public void mouseClicked(MouseEvent e) {//单击事件
				System.out.println(e);
				if (e.getClickCount() == 2) {
					tf.setText("mouse double click..."+count++);
				}
			}
			
		});
		
		//文本框上的事件监听
		tf.addKeyListener(new KeyAdapter() {//文本框绑定键盘事件

			@Override
			public void keyTyped(KeyEvent e) {//键入
				super.keyTyped(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {//按下
//				System.out.println("key run..."+e.getKeyChar()+e.getKeyCode());//输出按下键的char类型和整型类型
				int code = e.getKeyCode();//取得按下键的整型类型
//				if (!(code>=KeyEvent.VK_0 && code<= KeyEvent.VK_9)) {//判断输入是否是数字
//					System.out.println("必须是数字");
//					e.consume();//不按默认情况继续写入
//				}
				if (e.isControlDown() && code == e.VK_ENTER) {	//判断同时按下ctrl和enter，组合键
					System.out.println("enter");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {//释放
				super.keyReleased(e);
			}	
			
		});
	}
	
	public static void main(String[] args) {
		new c2_鼠标和键盘事件();
	}
	

}
