package p3_数组定义与使用;

public class c2_数组中找最大值 {
	public static void main(String[] args) {
		int[] arr3={1,54,56,57,90,60,66,69,70};
		int max =getMax(arr3);
		System.out.print("max="+max);
	}
	public static int getMax(int[] arr){
		int max=arr[0];
		for (int x=1;x<arr.length;x++) {
			if(max<arr[x]){
				max=arr[x];
			}
			
		}
		return max;
	
		
	}

}
