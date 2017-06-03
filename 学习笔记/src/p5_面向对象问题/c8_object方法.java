package p5_面向对象问题;

/* Object：所有类的根类，是不断抽取而来的，具备所有对象的共性内容。
 * 常用功能：
 * 1.equals(Object obj) (原方法)通过判断两个对象的地址值，判断两者是否是同一对象(重点掌握)
 * 		一般都会覆盖此方法，只判断地址值没有太大意义，所以要根据对象的特有内容，建立判断对象是否相同的依据。
 * 2.hashCode() (原方法)返回该对象的哈希码值
 * 3.getClass()(原方法)返回该对象的运行时类
 * 1.toSting()(原方法)返回该对象的字符串表示,建议所有子类覆盖此方法，原方法=getgetClass().getName()+@+Integer.toHexString(hashCode())
 */
class Person4{
	private int age;
	public Person4(int age) {
		this.age=age;
	}
	//不想比较对象的地址值，想比较是否是同龄人，则可以重写equals(Object obj)方法
	public boolean equals(Object obj) {	//(重写后)参数(形参)是Object，相当于对实参进行了向上转型，所以子类特有的变量和方法就无法使用了
		/*
		 */
		if (!(obj instanceof Person4)) { //向下转型时,需要注意转换异常，判断需要转型的对象是否是类Person4的对象
			throw new ClassCastException("类型错误了！！");//抛出异常，便于对错误进行查找和修改
		}
		Person4 p = (Person4) obj;		//进行了向下转型，可以使用子类的变量和方法了
		return this.age==p.age;
	}
	//按照人的特定数据，来进行哈希值的定义,则可重写hashCode()方法
	public int hashCode() {
		return age;
	}
	//重写toString方法
	public String toString() {
		return "Person4:"+age;
	}
}
class Pig{
}
public class c8_object方法 {
	public static void main(String args[]){
		//equals
		Person4 p1=new Person4(20);
		Person4 p2=new Person4(20);
		Person4 p3=p1;
		Pig p= new Pig();
		System.out.println(p1==p2);//比较地址值，与equals方法无关
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		System.out.println("*****");
		//System.out.println(p1.equals(p));//用于测试
		//hashCode
		System.out.println(p1);
		System.out.println(p1.hashCode());//结果是十进制
		System.out.println(Integer.toHexString(p1.hashCode()));//转换为十六进制
		System.out.println("*****");
		//getClass
		System.out.println(p1.getClass());//class 面向对象问题.Person4   就是p1的运行时类
		System.out.println(p1.getClass().getName());//调用了getclass()下的得到类名的方法(还有很多其他的方法)
		Class cla1=p1.getClass();
		Class cla2=p2.getClass();
		System.out.println(cla1==cla2);	//肯定是ture，因为p1和p2都是Person4 的对象
		System.out.println("*****");
		//toSting
		System.out.println(p1.toString());//System.out.println(p1); 二者等价，其实println(p1)就调用了p1.toString()方法
		System.out.println(p1);
		}

}
/* 
知识扩充:class文件的产生
class Class{		//把所有的类文件(class文件)向上抽取，可得到类文件全部都是这种形式，这就是类文件的组成部分，在java中，这也是一个对象
	name;			//类文件的名字
	field;			//类文件的字段
	constructor;	//类文件的构造器
	method;			//类文件的方法
}
把java中的关于类的代码，按照这个方式产生class文件，也就是 类名.class的字节码文件
创建对象时，就按照这个字节码文件创建对象
 */

 