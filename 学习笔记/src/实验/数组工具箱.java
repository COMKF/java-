package 实验;
	/**
	 *设计一个单独的程序，把各种功能封装在一起，命名为数组工具箱，功能有求数组最大值，排序等
	 * @author mk 
	 * @version v1.0
	 */
public class 数组工具箱 {
	private 数组工具箱() {}//因为该类的所有方法都是静态的，所以该类不需要创建对象，可以将构造函数私有化，保证不让其他程序创建该类对象
	
	/** 
	 * 获取整型数组的最大值
	 * @param arr 接受一个元素为int型的数组
	 * @return 该数组最大的元素值
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
	 * 对数组进行从小到大的冒泡排序
	 * @param arr 接受一个元素为int型的数组
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
	 * 用于给数组进行元素的位置置换
	 * @param arr 接受一个元素为int型的数组
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		}
	/**
	 * 获取指定元素在指定数组中的索引
	 * @param arr 接受一个元素为int型的数组
	 * @param key 指定的元素
	 * @return 返回元素第一次出现的位置，如果没有就返回-1
	 */
	public static int getIndex(int[] arr,int key) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==key)
				return i;
		}
		return -1;
	}
	/**
	 * 将int数组转换成字符串，格式为[e1,e2,e3...]
	 * @param arr 接受一个元素为int型的数组
	 * @return 发挥该数组的字符串表现形式
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
