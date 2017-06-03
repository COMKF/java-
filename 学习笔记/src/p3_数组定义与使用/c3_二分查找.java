package p3_数组定义与使用;

public class c3_二分查找 {
	public static void main(String[] args) {
		
		int[] arr2={1,54,56,57,60,66,69,70};
		int index=halfSearch(arr2,60);
		System.out.println("index="+index);
		int add=halfSearch(arr2,59);
		System.out.println("add="+add);
	}
	
	public static int halfSearch(int [] arr,int key) {  // 二分查找
		int min,max,mid;
		min=0;
		max=arr.length-1;
		while (min<=max) {
			mid=max+min>>1;
			if (key>arr[mid]) 
			min=mid+1;
			else if (key<arr[mid]) 
			max=mid-1;
		else return mid;
		}
		return -min-1;
	}

}
