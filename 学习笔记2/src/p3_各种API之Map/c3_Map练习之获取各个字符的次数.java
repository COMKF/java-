package p3_各种API之Map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/*
 * 练习：获取一个字符串中，每个字母出现的次数
 * 要求打印结果是：a(2)b(3)c(1)d(2)....
 * 
 * 分析：字母和次数之间存在着映射关系，而且这种关系很多。
 * 很多就需要存储，能存储映射关系的容器就是数组和Map集合。
 * 关系有有序的编号吗？没有！
 * 那就是Map集合。又发现键保持一定的顺序：abcd..
 * 所以可用TreeMap集合。
 * 
 * 这个集合最终应该存储的是字母和次数的对应关系。
 * 1.因为操作的是字符串中的字母，所以应先把字符串变为字符数组。
 * 2.遍历字符数组，用每一个字母作为键去查Map集合这个表。
 * 如果该字母不存在，就将该字母作为键，且值为1存储到Map集合中。
 * 如果该字母存在，就将该字母的值取出并加1，再存储到Map集合中。
 * 键相同就会覆盖，这样就记录了该字母的次数。
 * 3.遍历结束，Map集合就记录了所有字母出现的次数。
 */
public class c3_Map练习之获取各个字符的次数 {

	public static void main(String[] args) {
		String str = "aabbccd   +-+  AS adadf";
		TreeMap<Character,Integer> map = strtomap(str);
		for (Iterator<Character> it = map.keySet().iterator(); it.hasNext();) {
			Character ch = it.next();
			System.out.print(ch+"("+map.get(ch)+")");
		}
		
	}

	private static TreeMap<Character, Integer> strtomap(String str) {
		//1.把字符串变为字符数组
		char[] chars = str.toCharArray();
		//2.遍历字符数组，用每一个字母作为键去查Map集合这个表
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		Set<Character> keySet = map.keySet();
		for (int i = 0; i < chars.length; i++) {
			if((chars[i]>='a' && chars[i]<='z')||(chars[i]>='A' &&chars[i]<='Z' )){	//健壮性判断，消除不是字母的字符
				if (!keySet.contains(chars[i])) {
					map.put(chars[i], 1);
				}
				else {
					map.put(chars[i],map.get(chars[i])+1);
				}
			}		
		}
		return map;
	}
}
