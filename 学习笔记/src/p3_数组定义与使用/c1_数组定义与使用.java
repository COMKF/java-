package p3_数组定义与使用;

public class c1_数组定义与使用 {

	public static void main(String[] args) {
		int[] arr1={1,5,7};           //数组定义，法三,与c语言有点类似
		//int[] arr1=new int[]{1,5,7};  //数组定义，法二		
		/*
		int[] arr1=new int[3];   // 数组定义，法一
		for (int x=0,y=1;x<3;x++)
		{
			arr1[x]=y;
			y+=2;
		}
		*/
		for (int x=0;x<3;x++)
		{
			System.out.println("arr1["+x+"]="+arr1[x]);
		}
	}
}