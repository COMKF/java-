package p8_各种API之String;

/* 给定一个字符串数组，按字典顺序进行从小到大排序
 * 思路：
 * 1.对数组排序。可以用选择，冒泡排序
 * 2.for嵌套和比较以及换位
 * 3.问题：以前排序的是正数，比较用的是比较运算符，可是现在是字符串对象
 * 		字符串对象比较用方法。
 */

public class c3_String练习之字符数组排序 {

	public static void main(String[] args) {
		String[] arr = { "nba", "abc", "dfg", "xcvb", "rty", "kj" };

		printArray(arr);

		sortString(arr);

		printArray(arr);

	}

	private static void printArray(String[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1)
				System.out.print(arr[i] + ",");
			else {
				System.out.println(arr[i] + "]");
			}
		}
	}

	private static void sortString(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) { // 字符串比较用compareTo方法
					swap(arr, i, j);
				}

			}
		}
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
