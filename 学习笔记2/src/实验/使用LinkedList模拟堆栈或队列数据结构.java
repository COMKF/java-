package 实验;

import java.util.LinkedList;

/*
 * 堆栈：先进后出(FILO),也可称后进先出(LIFO)
 * 队列：先进先出(FIFO)
 * 我们应该描述一个容器，给使用者提供这个容器对象完成这两种结构
 */
class MyLink { // 把LinkedList的所有方法封装起来，生成一个新的容器，供使用者使用
	private LinkedList link;

	public MyLink() {
		link = new LinkedList();
	}

	public void myadd(Object obj) {
		link.addLast(obj);
	}

	public Object mygetduilie() { // 模拟队列
		return link.removeFirst();
	}

	public Object mygetduizhan() { // 模拟堆栈
		return link.removeLast();
	}

	public boolean isnull() {
		return link.isEmpty();
	}
}

public class 使用LinkedList模拟堆栈或队列数据结构 {

	public static void main(String[] args) {
		MyLink m = new MyLink();
		m.myadd("abc1");
		m.myadd("abc2");
		m.myadd("abc3");
		m.myadd("abc4");

		/*
		 * while (!m.isnull()) { System.out.println(m.mygetduilie());
		 * 
		 * }
		 */

		while (!m.isnull()) {
			System.out.println(m.mygetduizhan());
		}
	}

}
