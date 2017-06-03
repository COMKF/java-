package p2_各种API之泛型;

//详见	实验包里的操作Person的泛型工具类
import bean.Student;
import bean.Worker;
import 实验.操作Person的泛型工具类;

public class c3_泛型类 {

	public static void main(String[] args) {
		操作Person的泛型工具类<Student> tool = new 操作Person的泛型工具类<Student>(); // 用Student传入EE，为这个泛型类加入限制

		tool.setE(new Student("lihua", 19));
		// /tool.setE(new Worker()); //有了泛型类的限制，这里不能再传入Worker，会直接报错
		Student stu = tool.getE(); // 也省去了强转的麻烦

		tool.show(4); // 这里可以show(4),是因为泛型定义在方法上，同时进行了装箱，实质上传入的是new Integer(4)
		// tool.print(4);	//这里不能print(4)，是因为使用的参数是EE，而EE已经确定了，是Student，再传入Integer对象就会报错
		// 通过这个例子，要明白泛型的实质
		tool.method(new Integer(4));
	}

}
