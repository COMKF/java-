package p9_各种API之基本数据类型对象包装类;

/* 基本数据类型对象包装类
 * 为了方便操作基本数据类型值，对其封装成对象，在对象中定义了属性和行为丰富了对该数据的操作，用于描述该对象的类就会称为基本数据类型对象包装类。
 * 
 * 数据类型	数据类型对应的对象包装类
 * byte		Byte
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 * char		Character
 * boolean	Boolean
 * 需要注意的是，数据类型 和 数据类型对应的对象包装类 是不同的类，不同的概念，在操作上不完全一样。
 * 比如，要求一个int型数据的二进制表示方式，int本身没有这样的方法，可以调用Integer的方法，让int数据作为参数。
 */
/* 该包装对象主要用于基本类型和字符串之间的转换。
 * 
 * 基本类型——>字符串类型
 * 				1.基本类型数值+""
 * 				2.用String类中静态方法valueOf(基本类型数值)
 * 				3.用Integer的静态方法toString(基本类型数值)。注意，这个方法和toString(int i, int radix)意义不一样，radix是基数
 * 字符串类型——>基本类型
 * 				1.使用包装类中的静态方法 xxx parseXxx(string "xxx");//比如， parseint的功能是将数字组成的字符串转化为int型数据
 * 					只有Character没有parseXxx方法，因为它的对象本身装的就是字符。
 * 				2.如果字符串被Integer进行了对象的封装。可以使用另一个非静态的方法，intValue();将一个Integer对象转成基本数据类型值。
 */
/* 整数的不同进制转换。(必须是Integer的方法)
 * 十进制——>其他进制:
 * 		String toBinaryString(int i)//转二进制
 * 		String toOctalString(int i)//转八进制
 * 		String toHexString(int i)//转十六进制
 * 		String toString(int i, int radix)//转任意进制
 * 其他进制——>十进制
 * 		int parseInt(String s, int radix)//radix，基数。radix进制的s转换为十进制数
 */
/* Integer对象的方法：
 * 		equals方法，先把两个对象转换为int型数据，再进行数值比较，结果是true或false
 * 		compareTo方法，先把两个对象转换为int型数据，再进行大小比较，结果是-1,0,1
 */
/* 在jdk1.5版本之后，Integer的某些操作和int一致，这就是自动装箱，简化书写。
 */
public class c1_基本数据类型对象包装类的概念 {

	public static void main(String[] args) {
		int num = -6;
		System.out.println(Integer.MAX_VALUE);// Integer的静态方法，取得int型数据的最大值
		System.out.println(Integer.toBinaryString(num));// int本身没有转化为二进制数的方法这里调用Integer的方法，让int数据作为参数。

		Integer i = new Integer("123");
		System.out.println(i.intValue() + 1);// Integer对象转换为int型

		System.out.println(Integer.toBinaryString(12));// 转二进制
		System.out.println(Integer.toOctalString(12));// 转八进制
		System.out.println(Integer.toHexString(12));// 转十六进制

		System.out.println(Integer.toString(12, 3));// 转三进制

		System.out.println(Integer.toString(12 + 1) + 1);// 只是转为字符串类型

		System.out.println(Integer.parseInt("60", 8));// 把八进制的60转换为十进制数

		Integer a = new Integer("3");
		Integer b = new Integer(3);
		System.out.println(a == b);// 比较的是地址，当然是false
		System.out.println(a.equals(b));// integer的equals方法进行了覆写，该方法是先把两个对象转换为int型数据，再进行数值比较

		System.out.println(a.compareTo(10));

		Integer c = 4;// Integer a = new Integer(4);自动装箱，简化书写
		c = c + 4;// c=new Integer(c.intValue()+4);用到了自动拆箱和自动装箱
		Integer d = 127;
		Integer e = 127;
		System.out.println(d == e);// 结果是true。如果装箱的是一个字节，那么该数据会被共享，不会重新开辟空间。
	}

}
