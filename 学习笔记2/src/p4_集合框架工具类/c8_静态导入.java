package p4_集合框架工具类;

//静态导入，用的不多，了解即可。
import java.util.ArrayList;
//import java.util.Collections;				//可省略
import java.util.List;
import static java.util.Collections.sort; //静态导入，其实导入的是类中的静态成员(方法和变量)
import static java.util.Collections.max; //同理
//import static java.util.Collections.*;	//这样可以直接导入Collections里所有的静态方法和变量
import static java.lang.System.*;

public class c8_静态导入 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");

		// System.out.println(l);
		out.println(l); // 对于System的导入，out是静态的，但是println方法不是，println方法需要对象，所以简化只能到这一步了

		// Collections.sort(l);	//每次写Collections.sort(l);都要先写Collections.，可以省略吗？可以，用静态导入该方法就可以了
		sort(l); // 导入该静态方法后，就可以直接使用了。但值得注意的是，如果两个包中有同名的方法或者变量，则不能这样省略前缀了。

		// System.out.println(l);
		out.println(l);

		// String max = Collections.max(l);
		String max = max(l); // 同理

		// System.out.println(max);
		out.println(max);
	}

}
