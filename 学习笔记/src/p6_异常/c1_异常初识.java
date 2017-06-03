package p6_异常;
/* 异常：是在运行时发生的不正常情况
 * 在java中用类的形式对这些不正常的情况进行了描述和封装对象。
 * 描述不正常情况的类，就叫异常类。
 * 以前正常代码与问题处理代码结合。现在将正常代码与问题处理代码分离，提高阅读性。
 * 其实异常就是java通过面向对象思想将出现的问题封装成对象，用异常类对其进行描述。 
 * 不同的问题就用不同的类进行具体的描述。
 */

/* 异常体系：问题多，意味着出现的异常类也很多，将这些类向上抽取共性，就形成了异常体系。
 * 最终可以把问题(Throwable，不正常情况)分成两大类：
 * 		1.一般不可处理的。Error		特点：由jvm抛出的严重性问题，这种问题发生一般不针对性处理，因为处理不了。直接修改程序。
 * 		2.可以处理的。Exception	
 * 无论是Error还是Exception，问题发生就应该可以抛出，让调用者知道并处理。
 * 该体系的特点就在于Throwable及其子类都具有可抛性。
 * 可抛如何体现？怎么实现？		其实是通过throw 和  throws 两个关键字来体现的。凡是可以被这两个关键字操作的类和对象都具备可抛性。
 * 该体系的特点：子类名都是用父类名作为后缀，阅读性很强。 
 */
/* 对于java中没有定义，但确实存在的问题，可以自己去定义它。
 * 这种自定义的问题，称为自定义异常，方法就是，按照java异常的创建思想，将问题自定义描述，并封装成对象。
 * 对于自定义异常，必须要继承异常体系，因为只有称为异常体系的子类才能具有可抛性，才能被throw和throws关键字操作。
 */
//java检查错误的机制：先检查语法错误，再检查逻辑错误。
/* 异常的分类：
 * 1.编译时被检测异常：只要是Exception及其子类都是，除了特殊子类RuntiemException体系。
 * 		这种问题一旦出现，希望在编译时就进行检测，让这种问题有对应的处理方式，这种问题都可以针对性的处理。
 * 2.编译时不检测异常(运行时异常)：就是Exception中的RuntiemException和子类。
 * 		这种问题的发生，无法让功能继续，运算无法进行，更多是因为调用者的原因或者引发了内部状态的改变导致的。
 * 		这种问题一般不处理，直接编译通过，在运行时，让调用者调用时的程序强制停止，让调用者对代码进行修正。
 * 对于自定义异常，要么继承Exception(需要声明,声明方法是throws，后面讲)，要么继承RuntimeException(不需要声明)。
 */
/* throws 和 throw 的区别：
 * 1.throws使用在函数上，用于声明异常，throw使用在函数内
 * 2.throws抛出的是异常类，可以抛出多个，用逗号隔开。throw抛出的是异常对象。
 */
class FushuIndexException extends Exception{//如果自定义异常继承的是RuntiemException类，则可以不需要声明，如下
	FushuIndexException(String str){
		super(str);	//直接用父类Exception的方法即可
	}
}
class Errortry{
	public int method(int[] arr,int index) throws FushuIndexException{//自定义异常必须先进行捕捉或者声明，符合函数中先声明后使用的原则
		if (arr==null) {
			throw new NullPointerException("数组指针为空");//关键字throw，抛出异常。好处在于，可以自己控制异常的处理，提高阅读性
		}
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("角标越界");	//这里使用java中已定义的异常
		}
		if(index<0){
			throw new FushuIndexException("角标为负");	//在这里使用了自定义异常
		}
		return arr[index];	//java发现异常后，用默认的方式抛出异常，不便于阅读
		//System.out.println("haha");
	}
}
public class c1_异常初识 {
	public static void main(String[] args) throws FushuIndexException{//method方法中声明了自定义异常，那么调用method方法的main函数也得声明
		int arr[]=new int[3];
		Errortry e=new Errortry();
		//e.method(null, 0);
		int num=e.method(arr, -30);		//method方法中有异常，异常被返回到main函数中method方法所在的地方
		System.out.println("num="+num);
		System.out.println("over");
	}

}
