package p8_����API֮String;

/* �ҳ������ַ����������ͬ�Ӵ�
 * ˼·��
 * 1.��Ȼ��ȡ����Ӵ����ȿ��̵��ַ����Ƿ��ڳ����Ǹ��ַ����С�������ڣ��̵��Ǹ��ַ�����������Ӵ�
 * 2.������ǣ��ͽ��̵��Ӵ����г��ȵݼ��ķ�ʽ��ȥ�������ж��Ƿ���ڣ�������ڣ��Ͳ���������
 */

public class c5_String��ϰ֮�����ͬ�Ӵ� {

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
