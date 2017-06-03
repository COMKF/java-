package p5_其他API;

import java.util.Random;

/*
 * Math提供了操作数学运算的方法，都是静态的。
 * 
 * 常用方法：
 * 1.返回绝对值  T abs(T a) //输入数字是什么类型，则返回值也是什么类型
 * 2.返回大于参数的最小整数   double ceil(double a)//返回值和参数都是double型
 * 3.返回小于参数的最大整数   double floor(double a) //返回值和参数都是double型
 * 4.返回四舍五入的值  long round(double a) //参数是double型，返回值是long型
 * 5.返回两个数的较大值  T max(T a, T b)//输入数字是什么类型，则返回值也是什么类型
 * 6.取得a的b次方  double pow(double a, double b) //返回值和参数都是double型
 * 7.返回一个伪随机数  double random()  //返回值是double型
 */
public class c3_Math {

	public static void main(String[] args) {
//		show();
//		showrandom_1();
		showrandom_2();
		
	}

	private static void showrandom_2() {//用Random类创建随机数
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
//			double d = (int)(r.nextDouble()*6+1);//取得1到6的随机数
			int d = r.nextInt(6)+1;//取得1到6的随机数,也可以直接写int型，方法如下
			System.out.println(d);
		}
	}

	private static void showrandom_1() {//用数学方法创建随机数
			for (int i = 0; i < 10; i++) {
//			double d = Math.floor(Math.random()*10)+1;//取得1到10的随机数
//			double d = Math.ceil(Math.random()*10);//取得1到10的随机数
//			double d = (int)(Math.random()*10+1);//取得1到10的随机数
			double d = (int)(Math.random()*6+1);//取得1到6的随机数
			System.out.println(d);
		}
	}

	private static void show() {
		System.out.println(Math.abs(-2.2));
		System.out.println(Math.ceil(12.56));
		System.out.println(Math.floor(12.56));
		System.out.println(Math.round(12.56));
		System.out.println(Math.max(1, 2));
		System.out.println(Math.pow(10, 3));
	}
	
	

}
