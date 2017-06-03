package bean;

import java.io.Serializable;

//在此说明，被注释掉且后面有标注(初)的代码，是未加入泛型技术的代码，和加入泛型技术的代码进行比较

/* Serializable：用于给被序列化的类加入ID号，判断类和对象是否是同一版本。
 * 
 */

//public class Person implements Comparable { // 当类需要用到compareTo方法时，必须先实现Comparable接口，然后覆盖compareTo方法。	注：(初)
public class Person implements Comparable<Person>,Serializable { // 在Comparable接口上加入参数(即泛型)Person。
	private static final long serialVersionUID = 1L;	//ID号的声明格式
	
	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {

		return name.hashCode() + age * 23; // 覆盖后的哈希算法，为独特的人提供独特的哈希值，用此值作为对象的地址
	}

	@Override
	public boolean equals(Object obj) { // 如果要判断两者是否相同，必须覆盖equals方法
		// 这个方法不能使用泛型，即不能public boolean equals(Person
		// p)，因为这个方法来自Object。因此这个方法必须加健壮性判断并且用强转。
		if (this == obj) // 加第一个判断，这是健壮性判断，意义是判断是否加入的是同一对象，是，则直接返回true
			return true;
		if (!(obj instanceof Person)) // 加第二个判断，这是健壮性判断，意义是判断传入的对象是否是Person类型，不是，则直接抛出异常
			throw new ClassCastException("类型错误！！！");
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.age == p.age;
	}

	@Override
	public String toString() {

		return this.getName() + ":toString:" + this.getAge();
	}

	@Override
	// public int compareTo(Object o) { // 用person的年龄进行从小到大的排序 注：(初)
	public int compareTo(Person p) { // 在Comparable接口上加入泛型，则覆盖Comparable的方法compareTo也必须加入泛型，好处是，可以不用强转了。
		// Person p = (Person) o; // 任何类型的强转都必须进行健壮性判断，在这里先忽略掉。 注：(初)

		// if (this.age > p.age) //仅作理解，真实开发，这种代码烂透了
		// return 1;
		// if (this.age < p.age)
		// return -1;
		// else {
		// return this.name.compareTo(p.name);
		// }
		int temp = this.age - p.age;
		return temp == 0 ? this.name.compareTo(p.name) : temp;
	}

}
