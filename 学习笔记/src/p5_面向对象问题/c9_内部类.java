package p5_面向对象问题;

/* 将一个类定义在另一个类的里面，对里面的那个类就称为内部类(内置类，嵌套类)
 * 访问特点：1.内部类可以直接访问外部类中的成员，包括私有成员
 * 			2.而外部类要访问内部类中的成员必须要建立内部类的对象
 * 一般用于类的设计
 * 分析事物时，发现该事物描述中还有事物，而且这个事物还在访问被描述事物的内容。
 * 这时就把还有的事物定义为内部类来描述
 * 为什么内部类能直接访问外部类的成员？因为内部类持有外部类.this
 */
class Outer{
	static private int num=31;
	class Inner{
		void show(){
			System.out.println("show run..."+num);//内部类直接访问内部类的成员
		}
	}
	void method(){  //外部类访问内部类用方法
		Inner i = new Inner();
		i.show();
	}
	
	static class Inner2{	//如果内部类是静态的，相当于一个外部类
		void show(){
			System.out.println("show run..."+num);//Inner2是静态的，所以num也必须是静态的
		}
		static void fun(){	//如果内部类有静态方法，那么内部类必须是静态的
			System.out.println("fun run..."+num);
		}
	}
}

public class c9_内部类 {
	public static void main(String[] args) {
		new Outer().method();
		Outer.Inner i=new Outer().new Inner();//创建内部类对象的方法(记住格式)
		i.show();
		
		Outer.Inner2 i2= new Outer.Inner2();	//创建静态内部类的方法(记住格式)
		i2.show();
		Outer.Inner2.fun();//静态内部类，静态方法可直接用类调用方法
		
	}

}
