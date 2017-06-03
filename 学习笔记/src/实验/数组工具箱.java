package ʵ��;
	/**
	 *���һ�������ĳ��򣬰Ѹ��ֹ��ܷ�װ��һ������Ϊ���鹤���䣬���������������ֵ�������
	 * @author mk 
	 * @version v1.0
	 */
public class ���鹤���� {
	private ���鹤����() {}//��Ϊ��������з������Ǿ�̬�ģ����Ը��಻��Ҫ�������󣬿��Խ����캯��˽�л�����֤�����������򴴽��������
	
	/** 
	 * ��ȡ������������ֵ
	 * @param arr ����һ��Ԫ��Ϊint�͵�����
	 * @return ����������Ԫ��ֵ
	*/	
	public static int getMax(int[] arr) {
		int maxindex=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[maxindex])
				maxindex=i;
		}
		return arr[maxindex];
	}
	/**
	 * ��������д�С�����ð������
	 * @param arr ����һ��Ԫ��Ϊint�͵�����
	 * 
	 */
	public static void  selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {	
					swap(arr,i,j);
				}
			}
			
		}
	}
	/**
	 * ���ڸ��������Ԫ�ص�λ���û�
	 * @param arr ����һ��Ԫ��Ϊint�͵�����
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		}
	/**
	 * ��ȡָ��Ԫ����ָ�������е�����
	 * @param arr ����һ��Ԫ��Ϊint�͵�����
	 * @param key ָ����Ԫ��
	 * @return ����Ԫ�ص�һ�γ��ֵ�λ�ã����û�оͷ���-1
	 */
	public static int getIndex(int[] arr,int key) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==key)
				return i;
		}
		return -1;
	}
	/**
	 * ��int����ת�����ַ�������ʽΪ[e1,e2,e3...]
	 * @param arr ����һ��Ԫ��Ϊint�͵�����
	 * @return ���Ӹ�������ַ���������ʽ
	 */
	public static String arrarToString(int[] arr) {
		String str="[";
		for (int i = 0; i < arr.length; i++) {
			if (i!=arr.length-1) 
				str=str+arr[i]+",";
			else 
				str=str+arr[i]+"]";
		}
		
		return str;
	}
}
