package p8_����API֮String;

/* ����һ���ַ������飬���ֵ�˳����д�С��������
 * ˼·��
 * 1.���������򡣿�����ѡ��ð������
 * 2.forǶ�׺ͱȽ��Լ���λ
 * 3.���⣺��ǰ��������������Ƚ��õ��ǱȽ�������������������ַ�������
 * 		�ַ�������Ƚ��÷�����
 */

public class c3_String��ϰ֮�ַ��������� {

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
				if (arr[i].compareTo(arr[j]) > 0) { // �ַ����Ƚ���compareTo����
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
