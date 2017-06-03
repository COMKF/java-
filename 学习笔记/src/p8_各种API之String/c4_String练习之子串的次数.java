package p8_各种API之String;

/* 一个子串在整串中出现的次数
 * 思路：
 * 1.要找的子串是否存在，如果存在，获取其出现的位置，这个可以使用indexOf完成
 * 2.如果找到了，那么就记录出现的位置并在剩余的字符串中继续查找该子串。而剩余字符串的起始位置是出现位置+子串的长度。
 * 3.以此类推，通过循环完成查找，如果找不到就是-1，并对每次找到用计数器记录。
 * 
 */
public class c4_String练习之子串的次数 {

	public static void main(String[] args) {
		String str = "nbajkl'nbajkl;nbahjklnbahjklnbajjnbajj";
		String key = "nba";
		// int count = getKeyStringCount(str, key);
		int count = getKeyStringCount2(str, key);
		System.out.println("count=" + count);

	}

	private static int getKeyStringCount(String str, String key) {
		// 1.定义计数器
		int count = 0;
		// 2.定义变量记录key出现的位置
		int index = 0;
		while ((index = str.indexOf(key)) != -1) {
			str = str.substring(index + key.length()); // 这种办法是截取字符串，每次都会在字符串常量池中产生新的字符串，不太好
			count++;
		}
		return count;
	}

	private static int getKeyStringCount2(String str, String key) {
		// 1.定义计数器
		int count = 0;
		// 2.定义变量记录key出现的位置
		int index = 0;
		while ((index = str.indexOf(key, index)) != -1) { // 这种办法用str.indexOf的位置索引,不用过多产生字符串常量。所以这种方法更好
			index = index + key.length();
			count++;
		}
		return count;
	}
}
