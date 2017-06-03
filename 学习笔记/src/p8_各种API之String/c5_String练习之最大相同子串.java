package p8_各种API之String;

/* 找出两个字符串中最大相同子串
 * 思路：
 * 1.既然是取最大子串，先看短的字符串是否在长的那个字符串中。如果存在，短的那个字符串就是最大子串
 * 2.如果不是，就将短的子串进行长度递减的方式，去长串中判断是否存在，如果存在，就不用再找了
 */

public class c5_String练习之最大相同子串 {

	public static void main(String[] args) {
		String s1 = "adfadaabcdgsd";
		String s2 = "adabcda";
		String s = getMaxSubString(s2, s1);
		System.out.println(s);
	}

	private static String getMaxSubString(String s1, String s2) {

		String max = null, min = null;
		max = (s1.length() > s2.length()) ? s1 : s2;
		min = (max.equals(s1)) ? s2 : s1;
		System.out.println(max);
		System.out.println(min);

		for (int i = 0; i < min.length(); i++) {
			for (int a = 0, b = min.length() - i; b != min.length() + 1; a++, b++) {
				String sub = min.substring(a, b);
				// System.out.println(sub);
				if (max.contains(sub))
					return sub;
			}
		}

		return null;
	}

}
