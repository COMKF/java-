package p2_����API֮����;

/* ���͵Ļ���Ӧ�ã�
 * ʹ�÷��͵�ͨ�����?��δ֪���͡�
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class c5_���͵Ļ���Ӧ�� {

	public static void main(String[] args) {
		ArrayList<String> a =new ArrayList<String>();
		a.add("12");
		a.add("123");
		
		ArrayList<Integer> a2 =new ArrayList<Integer>();
		a2.add(22);
		a2.add(2234);
		
		printCollection(a);
		printCollection(a2);
	}

	/**
	 * ��������ӡ�����е�Ԫ��
	 * @param a
	 */
	//private static void printCollection(ArrayList<String> a) { //���ֻ��ArrayList����ôֻ�ܽ���ArrayList���ϵ�Ԫ�أ�Ϊ����չ�������Ż�����
	//private static void printCollection(Collection<String> a) {	//�����Ϳ��Խ����κ�Collection�еļ��ϣ�List��Set���У���һ���Ż�
	private static void printCollection(Collection<?> a) {	//��ͨ���������String���ɽ������������������͵�����Collection���ϣ��ڶ����Ż�
		for (Iterator<?> it = a.iterator(); it.hasNext();) {	//��ô������Ҳ������ͨ���
//			String str = it.next();
//			System.out.println(str);
			System.out.println(it.next());	//�ڶ����Ż�����Ϊʹ����ͨ��������Բ���ʹ�� ? str = it.next();��Ϊ����δ֪��ֻ��ֱ��ʹ��it.next()
			
		}
	}

}
/* ֪ʶ��չ�����ʹ��ͨ�������ʹ�� ? str = it.next();(�������ܶԾ���Ķ�����в���)����������Ծ���Ķ�����в�������ô�죿
 * ����Ĵ��룺
 * 	private static <T> void printCollection(Collection<T> a) {	//����һ��<T>����ʹ��<T>
		for (Iterator<T> it = a.iterator(); it.hasNext();) {	//��ô������Ҳ���붨�岢ʹ��<T>
			T str = it.next();			//�����Ϳ��������ַ����Ծ���Ķ�����в��������ַ�����ͨ�������ֻ����һ�㲻һ�����������ȫһ��
			System.out.println(str);
		}
	Ҳ����˵����Ҫ�Ծ���Ķ�����в���ʱ�����Զ���һ������ȷ�������������͡�
	����?��˵��ֻ���ڲ���ȷ���ͣ������Ծ��������в���ʱʹ�á��������������ֵ����������?���Խ��������������ˡ�
 */
