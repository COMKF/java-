package p4_集合框架工具类;

public class c7_参数可变化的函数 {

	public static void main(String[] args) {
		int sum = newadd(5,1,7,3,9);
		System.out.println(sum);
		
		int[] arr = {1,6,8,4,9,5};
		int sum1 = add(arr);
		System.out.println(sum1);
	}

	private static int add(int[] arr) {	//这个方法接收的是数组，把数组中的数值进行相加
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static int newadd(int... arr) {	//这是函数的可变参数。其实也是一个数组，接收的参数是数组中的元素，并自动封装。这样就简化了书写。
		//注意：可变参数类型，如int... arr，必须定义在参数列表的结尾处。
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
