package p4_���Ͽ�ܹ�����;

public class c7_�����ɱ仯�ĺ��� {

	public static void main(String[] args) {
		int sum = newadd(5,1,7,3,9);
		System.out.println(sum);
		
		int[] arr = {1,6,8,4,9,5};
		int sum1 = add(arr);
		System.out.println(sum1);
	}

	private static int add(int[] arr) {	//����������յ������飬�������е���ֵ�������
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static int newadd(int... arr) {	//���Ǻ����Ŀɱ��������ʵҲ��һ�����飬���յĲ����������е�Ԫ�أ����Զ���װ�������ͼ�����д��
		//ע�⣺�ɱ�������ͣ���int... arr�����붨���ڲ����б�Ľ�β����
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
