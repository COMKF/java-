package p4_���Ͽ�ܹ�����;

//��̬���룬�õĲ��࣬�˽⼴�ɡ�
import java.util.ArrayList;
//import java.util.Collections;				//��ʡ��
import java.util.List;
import static java.util.Collections.sort; //��̬���룬��ʵ����������еľ�̬��Ա(�����ͱ���)
import static java.util.Collections.max; //ͬ��
//import static java.util.Collections.*;	//��������ֱ�ӵ���Collections�����еľ�̬�����ͱ���
import static java.lang.System.*;

public class c8_��̬���� {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("aab");
		l.add("nba");
		l.add("acdff");
		l.add("bba");
		l.add("zz");
		l.add("zzz");

		// System.out.println(l);
		out.println(l); // ����System�ĵ��룬out�Ǿ�̬�ģ�����println�������ǣ�println������Ҫ�������Լ�ֻ�ܵ���һ����

		// Collections.sort(l);	//ÿ��дCollections.sort(l);��Ҫ��дCollections.������ʡ���𣿿��ԣ��þ�̬����÷����Ϳ�����
		sort(l); // ����þ�̬�����󣬾Ϳ���ֱ��ʹ���ˡ���ֵ��ע����ǣ��������������ͬ���ķ������߱�������������ʡ��ǰ׺�ˡ�

		// System.out.println(l);
		out.println(l);

		// String max = Collections.max(l);
		String max = max(l); // ͬ��

		// System.out.println(max);
		out.println(max);
	}

}
