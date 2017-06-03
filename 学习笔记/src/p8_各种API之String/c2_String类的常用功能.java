package p8_各种API之String;

/* 1.获取
 * 1.1获取字符串中字符的个数(长度)。 int length()；
 * 1.2根据位置获取字符。 char charAt(int index)；
 * 1.3根据字符获取在字符串中的第一次出现的位置。 (必须会，重点掌握)
 * 		int indexOf(int ch)//从0脚标进行ch的索引，找第一次出现的位置
 * 		int indexOf(int ch，int fromIndex)//从指定位置进行ch的索引，找第一次出现的位置
 * 		int indexOf(String str)//进行字符串的索引
 * 		int indexOf(String str，int fromIndex)
 * 		根据字符获取在字符串中的最后一次出现的位置
 * 		lastIndexOf(int ch)
 * 		lastIndexOf(int ch，int fromIndex)
 * 		lastIndexOf(String str)
 * 		lastIndexOf(String str，int fromIndex)
 * 1.4获取字符串中的一部分字符串，也叫做子串。 
 * 		String substring(int beginIndex)//取从开始脚标到最后的子串
 * 		String substring(int beginIndex，int endIndex)//取从开始脚标到(终止脚标-1)的子串，即包含begin，不包含end
 */
/* 2.转换
 * 2.1将字符串变成字符串数组(字符串的切割)。(必须会，重点掌握) String[]  split(String regex)	(涉及到正则表达式)
 * 2.2将字符串变成字符数组。 char[] toCharArray()
 * 2.3将字符串变成字节数组。byte[] getBytes()
 * 2.4将将字符串中的字母变成大小写。
 * 		String toUpperCase()//变大写
 * 		String toLowerCase()//变小写
 * 2.5将字符串中的内容进行替换。 
 * 		String  replace(char oldch,char newch)//替换字符
 * 		String  replace(String oldStr,String newStr)//替换字符串
 * 2.6将字符串两端的空格去除。String trim()
 * 2.7将字符串进行连接。String concat()
 * 2.8将任何类型变量变成字符串变量，这些方法是静态方法，可以直接用String调用。 String  String.valueOf(任意类型)。
 */
/* 3.判断
 * 3.1两个长字符串内容是否相同? boolean equals(object obj)，需要注意的是string中的equals已经进行了重写
 * 		boolean equalsIgnoreCase(String Str)//忽略大小写对字符串进行判断。
 * 3.2字符串中是否包含某一字符串？boolean contains(String Str)
 * 3.3查找是否有以指定字符串开头的字符串？ boolean startsWith(String Str)
 * 		查找是否有以指定字符串结尾的字符串？ boolean endsWith(String Str)
 */
/* 4.比较(基本数值的比较用>或<等等的运算符，对象的比较用方法，字符串是对象，所以用方法进行比较)
 * 4.1比较字符串的大小。(必须会，重点掌握)  
 * 		按ASCII表，解码为相对应的数字，然后进行比较。如果两者相等，则返回值为0，如果小于目标字符串，则为负数；大于目标字符串，则为正数。
 * 		int compareTo(String Str) //按每个字符进行比较，相等则比较下一字符；不等，则输出结果，不再进行后续字符的比较
 * 		int compareToIgnoreCase(String Str)//忽略大小写对字符串进行比较。
 */
// 5.1 String intern()//返回字符串对象的规范化表示方法，该方法对字符串池进行操作。(此方法开发一般不用，仅供了解)

public class c2_String类的常用功能 {
	public static void main(String[] args) {
		String s = "abcd efag";

		System.out.println("length:" + s.length());// 1.1，需要注意的是，空格也是一个字符
		System.out.println("char:" + s.charAt(2));// 1.2
		// System.out.println("char:"+s.charAt(20));//1.2,StringIndexOutOfBoundsException
		// 字符串脚标越界
		System.out.println("index:" + s.indexOf('a'));// 1.3
		// System.out.println("index:"+s.indexOf('k'));//1.3，结果是-1，说明字符串中没有这个字符
		System.out.println("lastindex:" + s.lastIndexOf("a"));// 1.3，字符用单引号，字符串用双引号，在这里因为只有一个a，所以单引双引都可以
		System.out.println("substring:" + s.substring(2));// 1.4，
		System.out.println("substring:" + s.substring(2, s.length()));// 1.4，同上等效，其实取的是从2到s.length()-1
		System.out.println("substring2:" + s.substring(2, 6));// 1.4，同理，取的是2到5，

		String s1 = "ab张三,李四,王五";

		String[] arr = s1.split(",");// 2.1
		// String[] arr=s1.split("\\.");
		// //如果需要切的是.,因为它是特殊符号，则必须用这种格式(暂时先记住)，不能用普通方法(涉及到正则规则)
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		char[] arr1 = s1.toCharArray();// 2.2
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		byte[] arr2 = s1.getBytes();// 2.3，汉子占两个字节，如果变成字节数组，则两个字节会分别编码，且首位都是1，所以是负数
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("Asd".toUpperCase());// 2.4
		System.out.println("Asd".toLowerCase());// 2.4
		System.out.println("java".replace('a', 'o'));// 2.5

		System.out.println("-" + "   a b   c   ".trim() + "-");// 2.6

		System.out.println("java".concat("se"));// 2.7，两者等效，但这个用到面向对象思想，所以开发时用这个更好
		System.out.println("java" + "se");// 2.7
		System.out.println(4 + 1);// 2.8
		System.out.println(String.valueOf(4) + 1);// 2.8

		String s2 = "abc";
		System.out.println(s2.equalsIgnoreCase("ABC")); // 3.1
		System.out.println(s2.contains("bc"));// 3.2

		String s3 = "ArrayDome.java";
		System.out.println(s3.startsWith("Array"));// 3.3，实际用处：查找所有数组的
		System.out.println(s3.endsWith(".java"));// 3.3，实际用处：查找所有java文件

		System.out.println(s2.compareTo(s3));// 4.1

		String s4 = new String("bcd");// 5.1，这是对象s4，"bcd"是s4的私有属性
		String s5 = s4.intern();// 字符串池中找不到"bcd"，则在池中创建并引用
		System.out.println(s4 == s5);// 一个在堆内存的池中，一个在堆内存的对象中，两者地址不一样
		System.out.println(s4.equals(s5));
	}
}
