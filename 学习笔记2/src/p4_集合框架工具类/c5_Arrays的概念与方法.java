package p4_集合框架工具类;

import java.util.List;
import java.util.Arrays;

/* Arrays是数组工具类，类里的方法都是静态的。
 * 接下来会介绍Arrays的各种方法。
 * Arrays的方法有：
 * 1.二分查找	binarySearch
 * 2.复制copyOf
 * 3.范围复制	copyOfRange
 * 4.判断两个数组是否相同 equals
 * 5.将数组中元素替换成指定元素 fill
 * 6.计算数组哈希值 hashCode
 * 7.数组排序 sort
 * 8.深度比较 deepEquals	//如果数组内是对象，则比较对象内容是否相同
 * 9.输出数组的字符串形式 toString
 * 10.数组转换成List集合 	List<T> asList(T... a) //从asList方法的源代码可以看出，它使用了(可变参数类型)
 */
public class c5_Arrays的概念与方法 {
	public static void main(String[] args) {
		int [] iarr = {3,3,1,5,6};
		
		System.out.println(Arrays.toString(iarr));	//用Arrays.toString方法输出数组元素
		System.out.println(iarr);	//比较一下，如果直接输出的话，其实输出的是arr的地址		
		
		/* 重点：asList方法，原因：因为数组毕竟方法有限，所以转成集合后，方法扩展，功能更多
		 * 
		 * 好处：可以使用集合的方法操作数组中的元素
		 * 注意：数组的长度是固定的，所以对于集合的增删方法是不可使用的，否则会报错
		 * 
		 * 如果数组中存储的元素是对象，则转成集合时，直接将数组中的元素作为集合中的元素进行存储
		 * 如果数组中存储的元素是基本数据类型，则转成集合时，会将该数组作为集合中的元素进行存储
		 */
		
//		String [] sarr = {"abc","nba","xixi","hehe"};
//		List<String> list= Arrays.asList(sarr);
		List<String> list= Arrays.asList("abc","nba","xixi","hehe");	//这样写用到了(可变参数类型)，简化了书写
		boolean b = list.contains("xixi");
		System.out.println(b);
		System.out.println(list);	//转换的效果
		
		List<int []> list2 = Arrays.asList(iarr);	//因为iarr中存储的是基本数据类型，则list2中存储的是iarr本身，即iarr的地址值，注意此时的泛型
		System.out.println(list2);
		
		Integer [] iarr2 = {1,5,3,9,7};		
		List<Integer> list3 = Arrays.asList(iarr2);
		System.out.println(list3);	//注意比较	
		
		//集合转数组方法：使用Collection接口(注意，不是集合框架Collections)中的toArray方法。转为数组后，不能进行增删操作。
//		String[] sarr2 = list.toArray(new String[1]);	//toArray需要传入参数， 参数格式为 new 类型[长度]	(为了指明数组类型和数组长度)
		//如果长度小于集合的size，那么该方法创建的数组的长度会与集合的size相同。如果长度大于集合的size，那么数组中多余集合的size的位置会默认为null。
		String[] sarr2 = list.toArray(new String[list.size()]);	//优化后的代码，建议长度就直接指定为，集合的size
		System.out.println(Arrays.toString(sarr2));
	}	
}
