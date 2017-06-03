package p8_各种API之String;

/* StringBuffer和String是不同的类，因为内容不多，所以用了String的包。
 * StringBuffer：字符串缓冲区，用于存储数据的容器。
 * 特点：1.长度是可变的。2.可存储不同类型的数据。3.最终要转成字符串进行使用。4.可对字符串进行修改。
 * 既然是一个容器对象，那应该具备什么功能呢？
 * 1.添加  StringBuffer  append（data）//任何数据类型添加到StringBuffer对象中，都会转变为StringBuffer类型
 * 			 StringBuffer insert(int offset, String str)	//从指定位置开始替换字符串
 * 2.删除  StringBuffer  delete(int start, int end)//包含头，不包含尾
 * 			StringBuffer  deleteCharAt(int index)//删除指定位置的字符
 * 3.查找 char charAt(int index) //查找具体脚标下的字符
 * 			int indexOf(String str)//查找子串在字符串中第一次出现的位置
 * 			int lastIndexOf(String str)//查找子串在字符串中最后一次出现的位置
 * 4.修改 StringBuffer replace(int start, int end, String str)//根据指定位置替换字符串
 * 			void setCharAt(int index, char ch)//在指定位置更改字符
 * 增删改查（C：creatr,U:update,R:read,D:delete）是对数据的基本操作。必须要会
 * 5.设置长度 void setLength(int newLength)//设置缓冲区的长度
 * 6.翻转 StringBuffer reverse()//让字符串的字符顺序反转
 */
/* StringBuffer长度可变的具体原因：
 * 当构造一个StringBuffer时，它的默认长度是16。
 * 当需要装第17个字符时，StringBuffer会再创建一个长度为32的StringBuffer缓冲区，并将之前StringBuffer内的字符串复制进去，再添加第17个字符。
 * 每次添加的字符数超过StringBuffer的长度时，就会创建一个新的StringBuffer，长度比之前的StringBuffer长16.
 * 
 * 那么我们是不是只需要构造一个默认的StringBuffer就行了呢？
 * 不是的，假如如果我们确定数据量在40以内，那就直接创建一个长度为40的StringBuffer。
 * 如果用默认的话，会多创建两次StringBuffer，这样就会降低效率，浪费时间，浪费内存空间。
 */
public class c7_Stringbuffer的基本概念 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		// 1
		sb.append(4); // sb加入数据后，结果还是返回给sb
		sb.append(true);
		System.out.println(sb);
		sb.append(false).append("haha");// 连续调用链
		System.out.println(sb);
		sb.insert(2, "aaa");
		System.out.println(sb);
		// 2
		sb.delete(1, 3);
		System.out.println(sb);
		sb.deleteCharAt(3);
		System.out.println(sb);
		// sb.delete(0, sb.length());//清空缓冲区，缓冲区中数据没有了，但是缓冲区还在
		// System.out.println(sb);
		// 3
		System.out.println(sb.charAt(5));
		System.out.println(sb.indexOf("a"));
		System.out.println(sb.lastIndexOf("a"));
		// 4
		sb.replace(1, 3, "nba");
		System.out.println(sb);
		sb.setCharAt(0, 'h');
		System.out.println(sb);
		// 5
		sb.setLength(3);
		System.out.println(sb);
		sb.setLength(5);
		System.out.println(sb);
		// 6
		System.out.println(sb.reverse());

	}

}
