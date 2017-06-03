package p8_IO流3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import bean.Person;

/* 操作对象的流：ObjectInputStream和ObjectOutputStream。
 * 可以把对象持久化。
 * 对象的默认序列化机制(将多个对象进行排列的方式)写入的内容是：对象的类，类签名，以及非瞬态和非静态字段的值。
 * 
 * 用ObjectOutputStream写入的对象，就会自动的进行序列化。序列化时会加入关于类的一些信息，这些信息是二进制数字，所以普通的解读和读取，都是乱码。
 * 必须用ObjectInputStream读取对象，ObjectInputStream有反序列化的功能，能正确的取出被存储的对象及其属性。
 */
/* 只有实现了Serializable接口(标记接口)的类和对象，才能被序列化。详见bean.Person。
 * 实现了Serializable接口的类，如果未声明serialVersionUID时，当序列化运行，Serializable接口会为类分配一个serialVersionUID，写入到存储文件中。
 * 此ID号是由编译器和系统用特定的算法计算出来的，所以在反序列化时，编译器会先对需要还原的类计算ID号，和存储文件中的进行ID号匹配。
 * 若相同，则可进行反序列化，若不相同，则抛出异常。这样就保证了对象的准确还原。
 * 
 * 因为ID号的算法，与编译器和系统相关。如果要跨平台的话，即使使用一模一样的类，也会因为ID号不同而抛出异常。该如何解决呢？
 * 可以进行ID号的声明，而且是强烈建议进行这种声明。这样的话，就可以跨平台使用。
 */
public class c7_操作对象 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeobj();
		readobj();	
	}

	private static void writeobj() throws IOException, IOException {
		//创建ObjectOutputStream流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
		/* 事实上，我们只需要把对象存进去，取出来时用特定的方法来读取。因为存储时有一些二进制信息是无法解读的，我们也不需要解读，只需要用的时候直接用就行。
		 * 所以，干脆就直接把扩展名设定为object，表明这是一个存储对象的文件，类似的java思想还有之前的properties文件。
		 */
		oos.writeObject(new Person("xiaoqiang",30));
		oos.close();
	}
	
	private static void readobj() throws IOException, ClassNotFoundException {
		//创建ObjectInputStream，它能反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		
		Person p = (Person)ois.readObject();//取出来时，对象其实已经提升为object类了，这里必须用强转恢复为原来的类，即Person
		
		System.out.println(p.getName()+":"+p.getAge());
		ois.close();
	}

}
/* 知识扩充：transient关键字，该关键字必须存在实现序列化接口的类中
 * public class Person implements Comparable<Person>,Serializable { // 在Comparable接口上加入参数(即泛型)Person。
	private static final long serialVersionUID = 1L;	//ID号的声明格式
	
	private transient String name;//transient关键字，非静态数据，该数据可以写入对象中，这个关键字的作用是，被修饰的数据不会被序列化后写到硬盘上
	private static int age;	//加入static静态关键字后，该数据会存放到本地方法区内，所有对象共用这个数据，不会被存储到对象中，也就不会写到硬盘上
	//所以，transient和static的区别在于：1.非静态与静态 2.存储在对象中与存储在本地方法区中； 共同效果是：不会被写入到硬盘上

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
 * 
 */
