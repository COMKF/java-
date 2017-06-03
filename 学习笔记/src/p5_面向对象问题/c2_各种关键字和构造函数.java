package p5_面向对象问题;

class Person{//类：人   属性：姓名，年龄，国籍
	String name;//一般属性随对象的创建而存在，随对象的释放而消失(特有)
	private int age;//private关键字，修饰符，表示一个私有属性，在main中，不能用直接设置的方法设置属性值，比如下面(1)是不行的
	static String country="中国";//static关键字，修饰符，它默认所有通过这个类所创建的对象的country的值都是中国，即它是所有对象共有的(共享)，它的存储方式也不同，它被存储在本地方法区内
								//static所修饰的属性，它可以被类直接调用，也可以被对象调用。它只会随类的产生而存在，随类的释放而消失。在对象产生前，它就存在了。
	public Person() {//构造函数一，要求函数名与类名相同，如果类中不写构造函数，java会自动设置一个空的构造函数，就像先在这个
	}            //(构造函数只能用一次，就在创建对象的时候用)
	//成员变量(一般属性)也被称为实例变量，静态变量也被称为类变量
	public Person(String name){//构造函数二，创建对象时，调用构造函数，可以为对象进行初始化，这个构造函数的作用是给对象命名
		this.name = name;//this关键字，代表当前对象。事实上每当使用类中的方法时，java都会自动产生一个this，指向使用这个方法的对象。所以我们可以直接使用this，修改对象的属性值
	}
	public Person(String name,int age){//构造函数三。类中可写多个构造函数，只要参数不同即可，这个构造函数的作用是给对象命名和设置年龄
		this(name);//调用构造函数一，这个方法是唯一可调用其他构造函数的方法，所以构造函数支持嵌套，提高了复用性(而且调用构造函数这个语句，必须放在最开头，保证了严谨性)
		setAge(age);//封装
		//this.age=age; //因为是在类里设置，所以直接设置属性值的方法对于private属性也适用
	}

	public String getName() {//所有的set和get方法都是封装，好处在于忽略内部细节，实现功能,提高安全性，提高复用性
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {//可以在set方法中加入控制，比如age不能为负，可以在setage函数中加入if语句，对设置的不靠谱的年龄返回错误
		this.age = age;
	}
	public void speak() {//这种函数，也可称为一般函数，但是更确切的说，它是类中的方法，可被对象(多次)调用
		System.out.println(name+":"+age+":"+country);//这个函数是类中的方法，所以name和age前面都省略了this。
	}												//但country不同，它有一个修饰符static，所以它前面省略的是Person。
	
	public boolean result(Person p) {//比较两个人是不是同龄人，是返回ture，不是返回false
		return this.age==p.age;
	}
}

public class c2_各种关键字和构造函数 {
	int num=10;
	public static void main(String[] args) {//mian函数中有static关键字，所以static同样可以修饰方法，静态方法只能访问静态成员，而且不能用this，super关键字
		Person p= new Person();
		//p.age=25; //(1)是不行的
		p.setAge(25);//使用封装的方法可以改变age属性值
		p.speak();
		
		Person p1= new  Person("小明");
		p1.speak();
		
		Person p2= new  Person("小强",30);
		p2.speak();
		boolean result=p1.result(p2);//boolean result=p2.result(p1); 这种写法也可
		System.out.println(result);
		
		new c2_各种关键字和构造函数().show();//静态方法调用非静态方法。只能通过用new新建类来实现
		//show(); //像这样直接调用非静态方法是不行的，可以通过给show函数加上关键字static，但新的问题产生了，static的show函数不能使用非静态变量num，又需要在num前加入关键字static
	}				//可以去掉show前的注释，自己试试吧
	public void show() {
		System.out.print(num);
	}
}

