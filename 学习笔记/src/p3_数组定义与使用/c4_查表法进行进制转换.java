package p3_数组定义与使用;

public class c4_查表法进行进制转换 {
	public static void main(String[] args) {
		trans16(60);
		trans8(60);
		trans2(60);
	}
	
	public static void tran(int num, int base, int offset) {
		if (num==0) {
			System.out.println("0");
			return;
		}
		char[] chs={'0','1','2','3',
					'4','5','6','7',
					'8','9','A','B',
					'C','D','E','F'};
		char[] arr=new char[32];
		int pos=arr.length;
		while (num!=0) {
			int temp = num & base;
			arr[--pos]= chs[temp];
			num=num >>> offset;
		}
		System.out.println("pos="+pos);
		for (int x = pos; x < arr.length;x++) {
			System.out.print(arr[x]);
		}
		System.out.println();
	}
	
	public static void trans16(int num){
		 tran( num,  15 , 4);
	}

	public static void trans8(int num){
		 tran( num,  7 , 3);
	}
	
	public static void trans2(int num){
		 tran( num,  1 , 1);
	}
	

}
