package 实验;

public class 测试数组 {

	public static void main(String[] args) {
		int[] arr={15,65,8,27,69,33,46}; 
		
		int max=数组工具箱.getMax(arr);
		System.out.println(max);
		
		//数组工具箱.selectSort(arr);
		
		int index=数组工具箱.getIndex(arr, 27);
		System.out.println(index);
		
		String str=数组工具箱.arrarToString(arr);
		System.out.println(str);
		

	}

}
