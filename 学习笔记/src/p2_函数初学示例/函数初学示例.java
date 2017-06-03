package p2_函数初学示例;

public class 函数初学示例{
	public static void main(String args[])
	{                    //各种函数是同级的，所以不能再一个函数中定义另一个函数，如不能再main函数中定义add函数
		int a= add(3,4); //main函数主要是通过调用其他函数实现各种功能的，所以各种功能应单独封装成一个函数，写在main函数外
		//  a= add(3,4); //这里，main函数中调用了add函数，因为main函数是静态的(用static修饰)，所以add函数必须也是静态的
		System.out.println("a="+a);
		myPrint();
		draw(4,5);
	}
	
	static int add(int x,int y) //函数格式：修饰词  返回值类型  函数名(参数类型  形式参数1，参数类型  形式参数2......) 
	{
		int z;
		z=x+y;
		return z; //return 返回值必不可少 ，除非该函数是void类型，这时return后直接写分号 
	}  //return的作用：1.返回值  2.结束该函数，不再执行下面的语句(对于java来说，如果编写了执行不到的语句，就会报错
	static void myPrint()  //函数名书写规范：第一个单词用小写，从第二个单词之后，首字母都用大写
	{
		System.out.println("hello world");  //void类型函数 return语句是可以不写的
	}
	
	static void draw(int x,int y) //void函数示例
	{
		for(int m=0;m<x;m++)
			{
				for(int n=0;n<y;n++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		//return ;  // 可写可不写
	}
}
//main函数示例    public static是修饰词     void是返回值  main是函数名 String是参数类型  args[]是形式参数