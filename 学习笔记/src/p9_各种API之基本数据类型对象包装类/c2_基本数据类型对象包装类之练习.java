package p9_����API֮�����������Ͷ����װ��;

import java.util.Arrays;//�����

import ʵ��.���鹤����;//�����
/* ��һ���ַ�������ֵ���д�С���������
 * ˼·��
 * 1.����int���������û���⡣
 * 2.��λ�ȡ��Щ��Ҫ�������ֵ��
 * ������Щ�ַ��������Կո�������ֵ���зָ��ġ�
 * ���Ծ��뵽���ַ���������и���Ѵ󴮱�ɶ��С����
 * 3.��ֵ���ձ��С�ַ�������ô��������أ�
 * ����ʹ�ð�װ�ࡣ
 */

public class c2_�����������Ͷ����װ��֮��ϰ {
	private static final String space_string = " "; // �����ճ�������ո��

	public static void main(String[] args) {
		String numStr = "20 19 50 22 76 99";
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);

	}

	private static String sortStringNumber(String numStr) {
		// ���ַ�������ַ�������
		String[] Str_arr = StringToArray(numStr);
		// ���ַ���������int����
		int[] Num_arr = tointArray(Str_arr);
		// ��int�����������
		mySortArray(Num_arr);
		// ������õ�int�������ַ���
		String str = ArraytoString(Num_arr);
		return str;
	}

	private static String ArraytoString(int[] num_arr) {// ���ַ�����������int����ת��Ϊ�ַ�������������
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num_arr.length; i++) {
			if (i != num_arr.length - 1)
				sb.append(num_arr[i] + space_string);
			else
				sb.append(num_arr[i]);
		}
		return sb.toString();// �����Ҫת��Ϊ�ַ���
	}

	private static void mySortArray(int[] num_arr) {
		// Arrays.sort(num_arr);//���õ���İ��ķ���
		���鹤����.selectSort(num_arr);// ���õ���İ��ķ���
	}

	private static int[] tointArray(String[] str_arr) {
		int[] arr = new int[str_arr.length];// ��ȷ�����鳤��
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	private static String[] StringToArray(String numStr) {// ��Ȼ�����װֻ��һ����룬�Ҵ˹���String������
		return numStr.split(space_string); // �������������������������壬���˸�������⣬����ʱӦ��������˼�룬�鷳һ��ûʲô��
	}
}
