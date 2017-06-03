package p8_各种API之String;

/* 字符串是一个特殊的对象。
 * 字符串创建格式：
 * 1.String str = “abc”；之所以加双引号是因为String是一个类，str是一个引用型变量，所以用双引号标示字符串
 * 2.String str = new String(“abc”)；
 * 两者有相似的地方，但不完全相同
 * 
 * String类的特点：字符串对象一旦被初始化就不会被改变
 */
public class c1_String的最初详解 {

	public static void main(String[] args) {
		// 字符串定义的第一种方式，并明确常量池的特点。池中没有就建立，有就直接用。
		// 常量池中装的也是对象，由String维护，常量池本身也会在堆内存中开辟一个空间存放字符串，这些常量池中的对象是可以被共享的
		String s = "abc";// 先在字符串常量池(也叫buffer)中寻找有没有"abc"字符串，没有！则创建"abc"字符串(可共享的对象)。赋给引用型变量s
		System.out.println("s=" + s);
		// s="nba";//这里的s其实是一个指针，前面指向"nba"对象，现在指向"abc"对象。字符串对象一旦被初始化就不会被改变的关键在这
		// System.out.println(s);
		String s1 = "abc";// 先在字符串常量池(也叫buffer)中寻找有没有"abc"字符串，有！则直接赋给s1
		System.out.println(s == s1);// 所以s和s1指向的是同一个"abc"，所以比较地址值是true

		// 字符串定义的第二种方式
		String s2 = new String("abc");// 这种方法是用new方法在堆内存中创建了String的对象，这个对象在构造时接收了字符串"abc"，并没有在常量池中有动作
		// 所以这个"abc"通过参数传递就仅仅属于s2，不会被共享
		System.out.println("s2=" + s2);
		System.out.println(s == s2);// 所以比较地址值是false
		System.out.println(s.equals(s2));// 因为String是object的子类，它对object的equals方法进行覆盖，建立了自己的比较标准，比较的其实是字符串内容

		// 构造方法，好处在于可以把字节数组和字符数组变成字符串
		String s3 = "";// 等效于String s3=new String(); 但地址不同，但不等效于String s3=null。

		byte[] arr = { 65, 66, 67, 68, 97 };
		String s4 = new String(arr);// 将字节数组变成字符串，如果数组里是数字，会根据平台默认的字符集(这里是ASCII表)进行编码，构造新的String
		// 构造函数是String(byte[] bytes) 作用：通过使用平台默认的字符集解码指定的byte数组，构建一个新的String
		System.out.println("s4=" + s4);

		char[] arr1 = { 'a', 'b', 'c', 'd', 'e' };
		String s5 = new String(arr1);// 将字符数组变成字符串，这个相对简单一点
		System.out.println("s5=" + s5);
		String s6 = new String(arr1, 1, 3);// 这个构造函数的意义是，从arr1这个数组的1脚标开始取，取3个，构造一个新的字符串
		System.out.println("s6=" + s6);
		String s7 = new String(arr, 1, 3);
		System.out.println("s7=" + s7);// 这种构造方法对字节数组也适用
	}

}
