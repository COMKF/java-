package p5_面向对象问题;

//内容有继承的概念，继承体系的使用，覆盖的作用
/* 有分析图：继承.npg
 * 继承：关键字extends，用法 class 子类  extends 父类(又名超类，基类),子类中含有父类的成员变量和成员函数
 * 作用：1.提高代码复用性 2.让类与类产生关系 3.为多态提供基础
 * java支持单继承(一个子类只能有一个直接父类)，不支持多继承，其实是对c++中的多继承进行了改良
 * java支持多层继承，通过“多实现”的方式实现
 */

class A { // A定义这个体系最基本，最共性的功能
}

class B extends A {
	int num = 4;// 若num用private修饰，则变成父类私有，子类就不能使用

	void call() {
		System.out.println("number");
	}
}

class C extends B {
	int num = 5;// 在实际开发中，基本上不会出现有同名的成员变量，但可以有同名的成员函数，这种方法叫做覆盖操作，如下

	void show() {
		System.out.println(this.num + ".." + super.num);// this代表本类对象，可省略，super代表父类空间(二者用法类似)
	}

	void call() {// 覆盖：子父类中出现一模一样的成员函数，会执行子类的函数，也成重写，覆写。
		super.call(); // System.out.println("number"); 这两者等价
		System.out.println("name");// 扩展的功能
	}
}

// 如上，C是B点子类，B是A的子类，这就是一个继承体系。
/*
 * 使用继承体系时： 1.查看体系中的顶层类(A)，了解该体系的基本功能 2.创建体系中的最子类对象，完成功能的使用 是否继承 需要看
 * 类之间是否有所属关系，有就写继承
 */

/*
 * 覆盖注意： 1.子类覆盖父类时，子类权限必须大于等于父类权限 2.父类方法为私有时，不需要覆盖 3.子父类成员函数都应为静态或者非静态
 * 4.覆盖主要用于功能的扩展，仍可用super.方法调用父类功能
 */
public class c4_继承 {
	public static void main(String args[]) {
		C c = new C();
		c.show();
		System.out.println("******");
		c.call();
	}

}
