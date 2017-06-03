package p9_各种API之基本数据类型对象包装类;

import java.util.Arrays;//导入包

import 实验.数组工具箱;//导入包
/* 对一个字符串的数值进行从小到大的排序。
 * 思路：
 * 1.对于int数组的排序，没问题。
 * 2.如何获取这些需要排序的数值？
 * 发现这些字符串都是以空格来对数值进行分隔的。
 * 所以就想到用字符串对象的切割方法把大串变成多个小串。
 * 3.数值最终变成小字符串，怎么变成整数呢？
 * 可以使用包装类。
 */

public class c2_基本数据类型对象包装类之练习 {
	private static final String space_string = " "; // 用最终常量代替空格符

	public static void main(String[] args) {
		String numStr = "20 19 50 22 76 99";
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);

	}

	private static String sortStringNumber(String numStr) {
		// 将字符串变成字符串数组
		String[] Str_arr = StringToArray(numStr);
		// 将字符串数组变成int数组
		int[] Num_arr = tointArray(Str_arr);
		// 对int数组进行排序
		mySortArray(Num_arr);
		// 将排序好的int数组变成字符串
		String str = ArraytoString(Num_arr);
		return str;
	}

	private static String ArraytoString(int[] num_arr) {// 用字符串缓冲区将int数组转换为字符串缓冲区对象
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num_arr.length; i++) {
			if (i != num_arr.length - 1)
				sb.append(num_arr[i] + space_string);
			else
				sb.append(num_arr[i]);
		}
		return sb.toString();// 最后需要转换为字符串
	}

	private static void mySortArray(int[] num_arr) {
		// Arrays.sort(num_arr);//调用导入的包的方法
		数组工具箱.selectSort(num_arr);// 调用导入的包的方法
	}

	private static int[] tointArray(String[] str_arr) {
		int[] arr = new int[str_arr.length];// 先确定数组长度
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	private static String[] StringToArray(String numStr) {// 虽然这个封装只有一句代码，且此功能String类已有
		return numStr.split(space_string); // 但这样做更符合这个程序的意义，让人更容易理解，开发时应多用这种思想，麻烦一点没什么的
	}
}
