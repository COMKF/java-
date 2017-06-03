package p5_面向对象问题;

public class c_详解主函数 {
	public static void main(String[] args){
		System.out.println(args);
		System.out.println(args.length);
		for(int i=0;i<args.length;i++) 
			System.out.println(args[i]);
		
	}
}
/* 
 主函数：格式固定，被jvm识别和调用
 public 权限最大 
 static 静态，不需要对象，直接用类名调用
 void 没有返回值，但是有返回方向，程序结束后返回给jvm
 main 函数名，不是关键字，只是可以被jvm的固定的名字
 string[] args 主函数的参数列表，是数组参数，元素是字符串(人们可以自己设置参数传入main中，字符串数据是最通用的数据)
*/