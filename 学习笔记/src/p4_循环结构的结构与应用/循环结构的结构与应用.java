package p4_循环结构的结构与应用;

public class 循环结构的结构与应用 {

	public static void main(String[] args)
	{ 
		int s=1,count=0;  //输出1~100中能整除6的所有数字的个数
		while (s<=100)  //s为被计算的数字，count为能整除6的个数
		{
			if(s%6==0)
			{
				count+=1;
			}
			s++;
		}
		System.out.println("count="+count);
	
		for (int x=0;x<5;x++)//输出一个等腰三角形
		{              //两个循环进行控制，z循环控制每行*的起始位置，y循环控制“* ”的个数
			for(int z=0;z<x;z++)
			{
				System.out.print(" ");
			}
			for (int y=x;y<5;y++)
			{
				System.out.print("* ");
			}
			System.out.print("\n");
		}
		
		for (int x=1;x<=9;x++)//输出一个99乘法表
		{              
			for (int y=1;y<=x;y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.print("\n");
		}
	}
}
/*
循环有三种结构：
1.while结构，格式为                             特点为：先进行判断，再根据判断结果是否执行大括号内的执行语句
while(布尔表达式)                               其中布尔表达式的值只有真和假两种，真则执行，假则不执行，下同
{
	执行语句；
}
2.do-while结构，格式为                    特点为：先执行一次大括号内的执行语句，再进行判断，
do
{
	执行语句；
}while(布尔表达式)；                       注意：最后有；
3.for语句，格式为
for(语句；布尔表达式；语句)               特点为：使用灵活，for中三个语句均可视情况省略，第一条和第三条可以是各种格式的语句
{                                             第二条必须为布尔表达式，若不写，则为真，循环将一直执行      
	执行语句；
}
*/
