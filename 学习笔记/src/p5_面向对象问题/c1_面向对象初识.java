package p5_面向对象问题;//类，引用数据类型。由类创造出的对象存放在堆内存中，而main函数，一般函数存放在栈内存中，方法完毕，内存就会释放

public class c1_面向对象初识 {

	public static void main(String[] args) {
		Car c1=new Car();// 用new新建对象
		c1.num=4;
		c1.run();
		Car c2=new Car();// 用new新建对象
		c2.color="red";
		c2.run();
		
		Car c3=new Car();// 用new新建对象
		show(c3);
		System.out.println(11111111);
		c3.run();//一般函数传递形参，实参值不变。而堆内存中则不同，传递形参，实际上是传递堆内存的对象的地址，实参会随函数作用而改变 
		System.out.println(11111111);
		new Car().run(); //使用匿名对象(对象对方法仅进行一次调用的时候，可简化为匿名对象)
		show(new Car()); //匿名对象作为参数传递
	}
	
	public static void show(Car c){ //一般函数 
		c.num=3;
		c.color="black";
		c.run();
	}
}

class Car{ //对象 以及对 对象 的属性进行定义
	int num;
	String color;
	void run()//对象内的函数，也称为方法
	{
		System.out.println(num+"..."+color);
	}
}