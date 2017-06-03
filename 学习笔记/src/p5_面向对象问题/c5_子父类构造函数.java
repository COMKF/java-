package p5_面向对象问题;
class Fu{
	Fu(){		//父类构造函数
		super();//任何类都是object的子类，这里类Fu虽然没有extends父类，但隐含extends object，super指向object
		show();
		//return ;  return被省略，不影响
	}
	void show(){
		System.out.println("fu run");
	}
}
//子类继承父类时，构造函数是不能被覆盖，也是不能被继承的。
/* 子类的实例化过程：子类中所有的构造函数都会访问父类中空参数的构造函数
 * 如果父类中没有定义空参数的构造函数，那么子类的构造函数必须用super明确要调用父类哪个构造函数，
 * 例如，父类中的构造函数只有Fu(int x){}，那么子类的构造函数第一行必须是super(x)。参数对应。
 * 同时，如果子类构造函数用this调用了本类构造函数，则super()就不能存在，因为二者必须都定义在第一行，所以只能有一个，
 * 但可以确定，子类肯定有其他构造函数访问父类的构造函数
 */
class Zi extends Fu{//子类继承父类
	int num=8;//相当于构造代码块，进行通用初始化(即显示初始化)
	Zi(){		//子类构造函数
		super();//这个super指向父类的空间，super()代表父类的构造方法，且super()必须在第一行，因为父类的初始化必须先完成
		//super();是可以省略的，如果不写，java会自动添加
		System.out.println("zi run2:"+num);//super()之后进行显示初始化(通用初始化，详见构造代码块)，即执行num=8
		num=10;								//构造函数内的特定初始化
		System.out.println("zi run3:"+num);
	}
	void show(){//子父类中有一模一样的函数，子类函数覆盖父类函数
		System.out.println("zi run:"+num);
	}
}

public class c5_子父类构造函数 {
	public static void main(String args[]){
		Zi z=new Zi();//观察结果，想想num=0的原因(子父类中都有show()，但子类的show()覆盖了父类的show()，所以输出了子类show()的内容)
		z.show();
	}
}
/* 一个对象的实例化过程：
 * Person p=new Person();
 * 1.JVM会读取指定路径下的Person.class文件，并加载进内存，并会先加载类Person的父类(如果有父类的话，当然，object除外)
 * 2.在堆内存中开辟空间，分配地址
 * 3.并在对象中，对对象的属性进行默认初始化
 * 4.调用对应的构造函数进行初始化
 * 5.在构造函数中，第一行会调用父类的构造函数进行初始化
 * 6.父类初始化完毕后，对子类的属性进行显示初始化
 * 7.进行子类构造函数的特定初始化
 * 8.初始化完毕后，将地址值赋给引用变量p
 */
