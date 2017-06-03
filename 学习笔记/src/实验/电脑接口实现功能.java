package 实验;
/*用接口扩展笔记本功能，但日后出现什么功能并不知道
 * 定义一个规则，日后出的设备只要符合这个规则就能用来扩展笔记本的功能
 * 在java中这个规则就叫做接口
 */

interface USB{  //先设置接口，为以后功能的扩充做准备(先定义规则)
	public abstract void open();
	public abstract void close();
}

public class 电脑接口实现功能 {

	public static void main(String[] args) {
		//useUSB(null); 		//在接口还没有插入U盘或者鼠标时，不使用USB，所以参数为null
		useUSB(new Upan());	//接口插入了U盘，所以参数为类Upan的实例对象，功能就扩展了
	}
	public static void useUSB(USB u) {  //接口类型的引用，指向其子类实例化的对象(其实这是多态，后面讲)，相当于USB u=new Upan()
		u.open();
		u.close();
	}
}

//下面是笔记本扩充的功能
class Upan implements USB{	//功能是后实现的，并且要符合接口的规则(后实现规则)，这样，功能与电脑的耦合性就降低了
	public void open() {
		System.out.println("U盘启动");
	}
	public void close() {
		System.out.println("U盘拔出");
	}
}
/*class USBMouse implements USB{  //当然可以把USB鼠标当做扩展的功能
	
}
*/
