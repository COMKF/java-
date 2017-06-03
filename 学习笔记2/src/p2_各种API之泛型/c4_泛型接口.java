package p2_各种API之泛型;

public class c4_泛型接口 {

	public static void main(String[] args) {
		InterImpl in = new InterImpl();
		in.show("123");

		InterImpl2<Integer> in2 = new InterImpl2<Integer>(); // 但是，在最后使用的时候，一定要明确具体的引用数据类型
		in2.show(5);

	}

}

interface Inter<T> { // 泛型接口，定义的时候，一般不需要明确具体的引用数据类型
	public void show(T t);
}

class InterImpl2<Q> implements Inter<Q> { // 使用接口的时候，可以不明确具体的引用数据类型，但这里保证类使用的泛型与接口使用的泛型一致

	public void show(Q q) {
		System.out.println("show2:" + q);
	}

}

class InterImpl implements Inter<String> { // 使用接口的时候，也可以明确具体的引用数据类型

	public void show(String t) {
		System.out.println("show:" + t);
	}

}