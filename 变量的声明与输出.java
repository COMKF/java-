package p1_变量的声明与输出;

public class 变量的声明与输出
{
	public static void main(String[] args)
	{
		byte a=1;
		short b=12;
		int c=100;
		long d=10000000000000000l;
		//float e=2.3;会报错，通常2.3是双精度数，2.3f后面的f声明2.3必须是单精度数，可解决报错;上面long d同理
		float e=2.3f;
		double f=4.3;
		
		char  ch='a';
		
		boolean k=true;  //false
		//定义变量后，必须为变量赋初始化值；变量的作用域只在变量当前的大括号内
		System.out.println(d);   //与C语言不同，java直接用变量名输出数据
		System.out.println(ch); 
		System.out.println(k); 
	}
}