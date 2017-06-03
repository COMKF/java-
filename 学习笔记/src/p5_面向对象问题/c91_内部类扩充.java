package p5_面向对象问题;

abstract class Dan{
	abstract void show();
}

interface Inter{
	void show1();
	void show2();
}

class Outer2 {
	int num=3;
	/* 内部类存放于局部位置中
	 */
	void  method(int y){
		int x=5;
		class Inner2{		//位于方法中的内部类，不能实例化，脱离method()方法，这个内部类就没有任何意义
			void show(){
				System.out.println("show.."+x);
				System.out.println("show2.."+num);
				System.out.println("show2.."+y);
			}
		}
		Inner2 i= new Inner2(); //只能在这里创建Inner2对象
		i.show();
	}
	//Inner2 i= new Inner2();  因为Inner2这个内部类存放在method()方法中，在这里不能创建对象
	//i.show();
	
	/* 匿名内部类，就是内部类的简写格式
	 * 必须有前提：内部类必须继承一个外部类或实现一个接口
	 * 匿名内部类，其实就是一个匿名子类对象
	 * 格式：new 子类或接口 (){子类内容}
	 * 通常使用场景：1.当函数参数是接口类型时，而且接口中的方法不超过三个时，可以用匿名内部类作为实际参数进行传递
	 */
	/*
	 * class Inner2 {	//写Inner2类
		void show(){
			System.out.println("show3.."+num);
		}
	}
	 */
	void method(){  
		//new Inner2().show();	//这是有名字的情况
		 new Dan(){	//匿名内部类
			void show(){	//这是匿名内部类的情况，不需要写Inner2类以及创建其对象
				System.out.println("show3.."+num);
			}
		}.show();
		/*
		Dan d=new Dan(){	
			void show(){	
				System.out.println("show3.."+num);
			}
		};
		d.show();	//如果这个匿名内部类中有多个方法，可以用父类引用创建匿名内部类的对象，再通过对象调用多个方法
		 */
	}
}

public class c91_内部类扩充 {
	class Inner{	//非静态类
	}
	public static void main(String[] args) {
		int y = 9;
		new Outer2().method(y);
		new Outer2().method();
		show(new Inter() {	//匿名内部类的使用
			public void show2() {
				System.out.println("Inter2");
			}
			public void show1() {
				System.out.println("Inter1");
			}
		});
		//new Inner();//静态方法中不能直接new创建非静态的类，除非在类之前加关键字 static
	}
	
	public static void show(Inter i) {
		i.show1();
		i.show2();
	}
	
}
