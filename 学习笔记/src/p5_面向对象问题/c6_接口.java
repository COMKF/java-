package p5_面向对象问题;

//当一个抽象类中的方法全部都是抽象方法的时候，这时可以将抽象类用另一种形式定义和表示，那就是 接口 interface
//虽然接口也是类，但关键字不是class，是interface
/* 接口的特点：1.提供对外暴露的规则 2.程序功能扩展 3.降低耦合性
 * 接口中常见的成员(而且这些成员都有固定的修饰方法)：1.全局常量 public static final  2.抽象方法 public abstract 
 * 由此得出结论，接口中的成员，都是公共的权限
 */
interface Demo { //定义一个接口，编译后还是class文件
	public static final int num = 10;//修饰符示例(如果不写，这些修饰符会自动加上)
	public abstract void show1(); //修饰符示例
	void show2();//public abstract修饰符会自动加上，但阅读性变差，所以最好写上
}
//类与类之间是继承关系，类与接口之间是实现关系
//接口不可以实例化，只能由实现了接口的子类覆盖了接口中所有的抽象方法后，该子类才可以实例化，否则该子类是一个抽象类。
class Demo1 implements Demo{//implements，类似于extends
	public void show1(){//必须加修饰符public
	}
	public void show2(){
	}
}
/* 在java中不支持多继承，因为会出现调用的不确定性，所以java对多继承机制进行了改良，变成了多实现
 * 一个类可以实现多个接口
 * 一个类在继承另一个类的同时，还可以实现多个接口
 */
interface D{
	public void show();
}
interface E extends D,Demo{//接口与接口之间是继承关系，而且可以多继承，根本原因在于接口的方法没有方法体
	public void show();//如果D和E中show方法一个返回int，一个返回void,下面类Test的show方法会报错，这种情况不能用多实现,
}
class Test extends Demo1 implements D,E{//继承另一个类的同时，实现了多个接口,避免了单继承的局限性
	public void show(){System.out.println("***");};
}
public class c6_接口 {

	public static void main(String[] args) {
		Demo1 d= new Demo1();
		System.out.println(d.num);
		System.out.println(Demo1.num);
		System.out.println(Demo.num);
		
		Test t= new Test();
		t.show();
	}
}
/*抽象类与接口的异同点：
 * 相同点：
 * 		都是不断向上抽取得到的。
 * 不同点：
 * 		1.抽象类需要被继承，且只能单继承。
 * 		  接口需要被实现，且可以多实现。
 * 		2.抽象类中可以定义抽象方法和非抽象方法。子类集成后，可以直接使用非抽象方法。
 * 		  接口中只能有抽象方法，必须由子类去实现，且接口中的成员都有固定的修饰符。
 * 		3.抽象类的继承，是is a 关系，在定义该体系的基本共性内容。
 * 		  接口的实现，是like a 关系，在定义体系的额外功能。
 * 
 * 分析：
 * 犬按功能分：导盲犬，缉毒犬等。
 * 
 * abstract class 犬{          //这是犬的基本功能，基本功能用抽象类，可以让子类继承
 * 		abstract void 吼叫();
 * }
 * 
 * interface 导盲{				//这是犬的额外功能，额外功能用接口，可以让子类实现
 * 		abstract void 导盲();
 * }
 * class 导盲犬 extends 犬 implements 导盲{
 * 		public void 吼叫(){
 * 		}
 * 		public void 导盲(){
 * 		}
 * } 
 */
