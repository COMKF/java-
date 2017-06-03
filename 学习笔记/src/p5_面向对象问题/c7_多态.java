package p5_面向对象问题;
/* 继承是多态的前提
 * 对象的多态性：一种事物的多种形态。一个对象，两种形态。
 * 多态在代码中的体现：父类或接口的引用指向其子类的对象
 * 多态的好处：提高了代码的扩展性，前期定义的代码可以使用后期子类中的内容
 * 多态的局限：前期定义的代码，不能使用后期子类中特有的内容
 * 多态的前提：1.必须有关系(继承，实现) 2.要覆盖父类或接口的方法
 */
abstract class Animal{
	abstract void eat();
}
class Dog extends Animal{//狗，既可以称为一只狗，也可以称为一只动物，这就是多态
	void eat(){
		System.out.println("啃骨头");
	}
	void lookhome(){
		System.out.println("看家");//对于父类来说，这是特有功能
	}
}
class Cat extends Animal{
	void eat(){
		System.out.println("吃鱼");
	}
	void catchmouse(){
		System.out.println("抓老鼠");//对于父类来说，这是特有功能
	}
}

public class c7_多态 {

	public static void main(String[] args) {
		Cat c =new Cat();	//这是最基本的方法
		mothod(c);
		System.out.println("****");
		Dog d=new Dog();
		mothod(d);
		mothod(new Dog());
		Animal a = new Cat(); //自动类型提升(也是多态最基本的体现)，猫对象提升为动物类型，但是特有功能无法访问，比如不能写a.catchmouse();
					//这种做法可以限制子类中特有功能的访问(这种做法叫向上转型)
		a.eat();
		mothod(a);
		System.out.println("****");
		//如果还想使用特有功能，可以将对象向下转型
		Cat cc=(Cat) a;	//向下转型，目的是为了使用子类中的特有功能
		cc.eat();
		cc.catchmouse();
		//对于转型，自始至终都是子类对象在做着类型的变化
	}
	public static void mothod(Animal a) {	//用父类来接收，可以接收多个子类对象。父类创建的对象指向子类
		a.eat();
		if (a instanceof Cat) {//instanceof 后可跟子类或者接口，用于判断对象的具体类型，只能用于引用数据的判断
			Cat cc=(Cat) a;
			cc.catchmouse();
		}
	}

}
