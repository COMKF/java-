package p8_各种API之String;

//将一个字符数组变成字符串

public class c9_StringBuffer练习 {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 9, 2 };
		String s1 = ArrayToString(arr);
		System.out.println(s1);
		String s2 = ArrayToString2(arr);
		System.out.println(s2);
	}

	private static String ArrayToString(int[] arr) {// 两者效果一样，但是内部过程不一样
		String str = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				str += arr[i] + ",";// 这种方法，每次添加新字符后，就会增加字符串常量池中的字符串对象，浪费空间
			} else {
				str += arr[i] + "]";
			}
		}
		return str;
	}

	private static String ArrayToString2(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				sb.append(arr[i] + ","); // 这种方法只是改变容器中的内容，空间浪费小，所以这种方法更好，以后开发就应该多用这种方法
			} else {
				sb.append(arr[i] + "]"); // 而且从此例可以看出，数据一多就找容器，这种设计思想
			}
		}
		return sb.toString();
	}
}
