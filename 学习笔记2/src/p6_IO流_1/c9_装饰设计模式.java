package p6_IO流_1;
/* 缓冲区：对流的功能进行了增强，实际上使用的是装饰设计模式。
 * 装饰设计模式：当对一组对象进行功能增强时，就可以使用该设计模式解决问题。
 * 
 * 可见：继承和装饰都能实现功能的扩展和增强。有什么区别呢？
 * 
 * 那么我们可以假设一下，如果把Buffered以继承的形式进行封装，会出现怎样的体系。
 * 以Writer为例：
 * |————Writer：基类
 * 		|————TextWriter：Writer的子类，用来操作文本
 * 				|————BufferedTextWriter：TextWriter的子类，用来增强TextWrite的功能
 * 		|————MediaWriter：Writer的子类，用来操作媒体
 * 				|————BufferedMediaWriter：MediaWriter的子类，用来增强MediaWriter的功能
 * 以上是模拟把缓冲区以子类的形式进行功能的增强，可见在Writer的每一个直接子类下，每一个子类都需要一个特定的Buffered子类来增强功能。
 * 如果以后Writer出现各种各样的直接子类，那么相应的还需要出现子类的Buffered子类，既加大程序员的工作量，也会使整个体系越来越臃肿。
 * 
 * 
 * 那么java设计师是如何设计的呢？
 * 以Writer为例：
 * |————Writer：基类
 * 		|————TextWriter：Writer的子类，用来操作文本
 * 		|————MediaWriter：Writer的子类，用来操作媒体
 * 		|————BufferedWriter：Writer的子类，专门用于增强功能。
 * 从上面的例子可以看出，BufferedTextWriter和BufferedMediaWriter使用的都是缓冲技术，可以向上抽取，进行单独的封装，形成新的类BufferedWriter。
 * BufferedWriter作为Writer的直接子类，用Writer这个父类来接收Writer的各个直接子类，如TextWriter和MediaWriter，这就是多态的巧妙运用。
 * 可见，装饰比继承更加灵活。
 * 特点：装饰类和被装饰类必须所属同一个接口或者父类。
 * 
 * 那么我们把bean.MyBufferedReader再进行进一步优化吧，详见 MyBufferedReader_optimize。(优化的MyBufferedReader)
 */
public class c9_装饰设计模式 {

	public static void main(String[] args) {
		Person p = new Person();
//		p.chifan();
		NewPerson p1 = new NewPerson(p);
		p1.chifan();	//这个就是装饰设计模式，实质上用的还是Person类，并且在Person类的基础上进行功能的增强， 就想房子的装饰一样
		
		
		NewPerson2 p2 = new NewPerson2();
		p2.chifan();
	}
}

class Person{
	void chifan(){
		System.out.println("吃饭");
	}
}

class NewPerson{	//装饰设计模式演示，相当于字符流缓冲区Buffered。实际上各个类型的Buffered采用的大多都是装饰设计模式。
	private Person p;
	public NewPerson(Person p) {
		this.p = p;
	}
	void chifan(){
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
	}
}

class NewPerson2 extends Person{	//继承，和装饰设计模式一样，都能实现增强功能的效果
	void chifan(){
		System.out.println("开胃酒");
		super.chifan();
		System.out.println("甜点");
	}
}
