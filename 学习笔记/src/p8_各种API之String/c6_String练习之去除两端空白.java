package p8_各种API之String;
/* 去除字符串两端的空白
 * 思路：
 * 1.定义两个变量，一个变量作为从头开始判断字符串空格的角标，不断++，一个变量作为从尾开始判断字符串空格的角标，不断--。
 * 2.判断到不是空格为止，取头尾之间的字符串即可。
 * 
 */
public class c6_String练习之去除两端空白 {

	public static void main(String[] args) {
		String s = "   a   b   c   ";
		System.out.println(s);
		
		s=myTrim(s);
		System.out.println(s);
	}

	private static String myTrim(String s) {
		int start=0,end=s.length()-1;
		while (start<=end&&s.charAt(start)==' ' ) {
			start++;
		}
		while (start<=end&&s.charAt(end)==' ' ) {
			end--;
		}
		return s.substring(start,end+1);
	}
}
