package 实验;

import bean.Person;

//public class 操作Person的泛型工具类 {
//	private Object object;	//在这里，不直接创建Person，而是创建Person的父类对象，object。这样的话，不仅可以操作Person，而且可以操作任何对象。
//
//	public Object getObject() {
//		return object;
//	}
//
//	public void setObject(Object object) {
//		this.object = object;
//	}
//	
//}
/* 在jdk1.5之后，使用泛型来接收类中要操作的引用数据类型。
 * 这就是泛型类。什么时候用？当类中的操作的引用数据类型不确定的时候，就用泛型来表示
 */
public class 操作Person的泛型工具类<EE> { // 用EE来代替自定义的对象，可以不指定具体对象。
	private EE e;

	public EE getE() {
		return e;
	}

	public void setE(EE e) {
		this.e = e;
	}

	public <W> /* 这就是声明(也叫作定义)，且位置一定是在返回值类型前 */void show(W str) { // 可以将泛型定义在方法上，在使用这个泛型时，应先声明
		System.out.println("show:" + str);	//虽然这里str意义上是字符串，但是我们不能用字符串里的方法，如length(),为什么？
					//因为这里用的是泛型，在方法上，编译器并不能识别用户将要传入的引用数据类型是什么，所以不能用特定的方法，但是能用object的方法。
	}

	public void print(EE str) { // 这里的泛型与泛型类上定义的泛型一致，都是EE
		System.out.println("print:" + str);
	}

	public static <Y> void method(Y object) { // 当方法静态时，不能使用类上定义的泛型(即EE)，只能将泛型定义在方法上
		System.out.println("method:" + object);
	}

}