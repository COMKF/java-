package p6_异常;
/* 异常需要被声明或者捕捉，二者有一即可。
 * 声明的方式已经学过，用throws关键字，如public int method(int[] arr,int index) throws FushuIndexException，这就是声明的方法
 * 下面是捕捉的方法，try-catch代码块。
 */
/* 异常处理的捕捉：这是可以对异常进行针对性处理的方式。
 * 具体格式：
 * try{
 * 		需要被检测异常的代码
 * }
 * catch(异常类 变量){
 * 		处理异常的代码
 * }
 * finally{
 * 		一定会被执行的代码
 * }
 * 原则上，能处理就用try，不能处理就用抛。
 */
public class c2_异常捕捉代码块 {
	public static void main(String[] args){
		int arr[]=new int[3];
		Errortry e=new Errortry();
		//try-catch结构
		try{
			int num=e.method(arr,30);
			//int num=e.method(null, 30);
			System.out.println("num="+num);
		}
		catch(FushuIndexException f){//相当于 FushuIndexException f = new FushuIndexException("角标为负");
			System.out.println("角标负数！！！");	//catch代码块，使用了异常信息，并未抛出，而是执行内部代码，然后向下运行
			System.out.println("Message:"+f.getMessage());//使用异常f的效果
			System.out.println(f.toString());//使用异常f的效果
			System.out.println(f);//使用异常f的效果。其实调用了f.toString()方法
			f.printStackTrace();//jvm默认的异常处理机制就是在调用异常对象的这个方法
		}
		//多catch
		catch (ArrayIndexOutOfBoundsException f) {//多catch的使用,从上到下依次判断异常的类型是否与当前catch符合。若符合，就执行该catch的代码
			System.out.println(f);
			//return;	//即使catch中有return，finally的代码也会执行
			//System.exit(0);//如果是这条代码，则finally的代码不会执行，因为这个代码的作用是退出jvm
		}
		catch (NullPointerException f) {
			System.out.println(f);
		}
		catch (Exception ee){	//一般可不写父类异常，如果要写，一定要写在最下面，因为父类异常可接收一切异常。否则编译失败
			System.out.println(ee);
		}
		//catch与finally之间不能有代码
		finally{	//finally是一定会被执行到的代码 ,通常用于关闭(释放)资源
			System.out.println("finally");
		}
		System.out.println("over");
	}
}
/* 异常处理的原则：
 * 1.函数内容如果需要抛出需要检测的异常，那么函数上必须要声明。否则必须要在函数内用try-catch捕捉，否则编译失败。
 * 2.如果遇到了声明函数的异常，要么try-catch要么throws，否则编译失败。
 * 3.功能内容可以解决，用catch。解决不了，用throws告诉调用者，让调用者解决。
 * 4.一个功能如果抛出多个异常，那么调用时，必须有多个catch进行针对性的处理。
 * 		内部有几个需要检测的异常，就抛几个异常，抛出几个，就catch几个。 
 */
/* 集中常见的try-catch-finally组合
 * 1.try-catch-finally(常见)
 * 2.try-catch(可多个) 当没有资源需要释放时，可以不定义finally
 * 3.try-finally (常见)没有catch，则这个异常的处理方式是必须是抛出(没有直接处理)，必须声明异常。这个组合的目的是，要关闭资源(非常必要)
 */