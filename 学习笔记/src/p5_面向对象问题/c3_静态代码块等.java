package p5_面向对象问题;
/*
 静态变量：当所有对象中有一个属性值是相同的，则这个成员变量可以用static修饰，存储在本地方法区中
 静态函数：该函数没有访问到特有数据，即一般变量时，可以用static修饰
 */
class Person3{
	static{//静态代码块：特点：无名，作用：为类初始化，因为有的类不需要对象。特点：只加载一次
		System.out.println("类加载了!");
	}
	
	{//构造代码块：特点：无名，作用：为所有对象进行通用的初始化(每创建一个对象，调用一次)
		System.out.println("对象创建了!");
	}
	
	public Person3(){//构造函数：作用：为对象进的对应的，针对的初始化
	}
	
	public static void speak() {//静态函数，也叫静态方法
		System.out.println("我是对象！");
	}
}
public class c3_静态代码块等 {
	public static void main(String[] args){
		System.out.println("****");
		new Person3().speak();
		System.out.println("****");
		new Person3();
		System.out.println("****");
		Person3.speak();
		}
}

//补充：局部代码，限定局部变量的生命周期
//执行顺序：静态代码块，构造代码块， 构造函数
