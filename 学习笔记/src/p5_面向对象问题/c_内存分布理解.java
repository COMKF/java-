package p5_面向对象问题;

class Person2{//类：人   属性：姓名，年龄，国籍
	private String name;//一般属性(针对静态属性而言，也叫非静态属性)
	private int age;//一般属性
	static String country="中国";//静态属性
	
	public Person2(String name,int age){
		this.name = name;
		this.age=age;
	}
	public void show() {
		System.out.println(Person2.country+":"+this.name+":"+this.age);	
	}
	public static void method() {
		System.out.println(Person2.country);	
	}
}
public class c_内存分布理解 {   //图片记录在本地文件夹，名  内存分布理解.png  注：主函数所在的 “内存分布理解”也是一个类
	public static void main(String[] args){
		Person2.method();
		Person2 p= new Person2("小明", 10);
		p.show();
	}

}
