package p5_面向对象问题;
//继承的弊端：因为可以覆盖，所以能够打破封装性
/* final 关键字，修饰符
 * 1.可以修饰类，方法，变量
 * 2.final修饰的类不能被继承
 * 3.final修饰的方法不能被覆盖
 * 4.final修饰的变量是常量，且只能赋值一次
 */
public class c_关键字final {

	public static void main(String[] args) {
		final int x = 9;
		System.out.println(x);
		System.out.println(9);//理论上这二者等价，但实际上9是无字面意思的，但x有，比如我们把x改成age，就可以看出这是年龄，增强阅读性
	}
}
