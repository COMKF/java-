package p8_����API֮String;

//��һ���ַ��������ַ���

public class c9_StringBuffer��ϰ {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 9, 2 };
		String s1 = ArrayToString(arr);
		System.out.println(s1);
		String s2 = ArrayToString2(arr);
		System.out.println(s2);
	}

	private static String ArrayToString(int[] arr) {// ����Ч��һ���������ڲ����̲�һ��
		String str = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				str += arr[i] + ",";// ���ַ�����ÿ��������ַ��󣬾ͻ������ַ����������е��ַ��������˷ѿռ�
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
				sb.append(arr[i] + ","); // ���ַ���ֻ�Ǹı������е����ݣ��ռ��˷�С���������ַ������ã��Ժ󿪷���Ӧ�ö������ַ���
			} else {
				sb.append(arr[i] + "]"); // ���ҴӴ������Կ���������һ������������������˼��
			}
		}
		return sb.toString();
	}
}
