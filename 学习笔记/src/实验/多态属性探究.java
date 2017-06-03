package 实验;

/* 多态，成员的特点：
 * 1.成员变量：
 * 		编译时，参考引用型变量所属的类中是否有调用的成员变量。有，编译通过，没有，编译失败。
 * 		运行时，参考引用型变量所属的类中是否有调用的成员变量，并运行该所属类中的成员变量。
 * 		简单说，编译和运行都参考左边。
 * 2.成员函数：(非静态)(依赖对象)
 * 		编译时，参考引用型变量所属的类中是否有调用的函数。有，编译通过，没有，编译失败。
 * 		运行时，参考的是对象所属的类中是否有调用的函数。
 * 		简单说，编译看左边，运行看右边
 * 3.静态函数：(不依赖对象)
 * 		编译时，参考引用型变量所属的类中是否有调用的静态方法。
 * 		运行时，参考引用型变量所属的类中是否有调用的静态方法。
 * 		简单说，编译和运行都参考左边。
 * 		其实，对于静态方法是不需要对象的，直接用类名调用即可。
 */

class Fu{
	int num=5;
	void show(){
		System.out.println("fu show");
	}
	static void method(){
		System.out.println("fu method");
	}
}
class Zi extends Fu{
	int num=10;
	void show(){
		System.out.println("zi show");
	}
	static void method(){
		System.out.println("zi method");
	}
}

public class 多态属性探究 {
	public static void main(String[] args) {
		Fu f=new Zi();
		System.out.println(f.num);
		f.show();
		f.method();
		
		Zi z=new Zi();
		System.out.println(z.num);
		z.show();
		z.method();
		
	}

}
