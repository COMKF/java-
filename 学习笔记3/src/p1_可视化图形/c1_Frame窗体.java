package p1_可视化图形;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class c1_Frame窗体 {

	public static void main(String[] args) {
		Frame f = new Frame("MyFrame");//构造一个不可见的窗体，同时开启一个新的线程
		f.setSize(500, 300);//设置窗口的大小，第一个参数是横轴500像素，第二个参数是纵轴300像素
		f.setLocation(400, 100);//设置窗口的位置，第一个参数是距左边400像素，第二个参数是距上边100像素
//		f.setBounds(400, 100, 500, 300);//这个方法是以上两个方法的集合
		
		Button but = new Button("一个按钮");
		
		f.add(but);//添加按钮到窗体中，因为窗体自动生成时，会自动使用边界式布局，所以添加不作说明的按钮时，会自动拉伸平铺到整个窗体中
		f.setLayout(new FlowLayout());//设置窗体布局为流式布局，这样的话按钮就会在第一行居中
		f.setVisible(true);//设置可见属性为true
		System.out.println("over");
	
		//因此，做窗体有四步：1.构建窗体并设置  2.构建基本组件  3.添加组件  4.显示窗体
		
		//事件监听机制：1.事件源（组件） 2.事件  3.监听器  4.事件处理
		
		f.addWindowListener(new WindowAdapter() {//事件源f，绑定事件监听器

			@Override
			public void windowClosing(WindowEvent e) {//接收事件
				
				//下面是作出处理
				super.windowClosing(e);
				System.out.println("closing....."+e);
				System.exit(0);
				
			}
			
		});
		
		
		//在按钮上加入监听器
		
		but.addActionListener(new ActionListener() {//按钮绑定活动事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button down");
				System.exit(0);
			}
		});
	}
}
