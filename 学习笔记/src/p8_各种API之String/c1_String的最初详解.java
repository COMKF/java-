package p8_����API֮String;

/* �ַ�����һ������Ķ���
 * �ַ���������ʽ��
 * 1.String str = ��abc����֮���Լ�˫��������ΪString��һ���࣬str��һ�������ͱ�����������˫���ű�ʾ�ַ���
 * 2.String str = new String(��abc��)��
 * ���������Ƶĵط���������ȫ��ͬ
 * 
 * String����ص㣺�ַ�������һ������ʼ���Ͳ��ᱻ�ı�
 */
public class c1_String�������� {

	public static void main(String[] args) {
		// �ַ�������ĵ�һ�ַ�ʽ������ȷ�����ص��ص㡣����û�оͽ������о�ֱ���á�
		// ��������װ��Ҳ�Ƕ�����Stringά���������ر���Ҳ���ڶ��ڴ��п���һ���ռ����ַ�������Щ�������еĶ����ǿ��Ա������
		String s = "abc";// �����ַ���������(Ҳ��buffer)��Ѱ����û��"abc"�ַ�����û�У��򴴽�"abc"�ַ���(�ɹ���Ķ���)�����������ͱ���s
		System.out.println("s=" + s);
		// s="nba";//�����s��ʵ��һ��ָ�룬ǰ��ָ��"nba"��������ָ��"abc"�����ַ�������һ������ʼ���Ͳ��ᱻ�ı�Ĺؼ�����
		// System.out.println(s);
		String s1 = "abc";// �����ַ���������(Ҳ��buffer)��Ѱ����û��"abc"�ַ������У���ֱ�Ӹ���s1
		System.out.println(s == s1);// ����s��s1ָ�����ͬһ��"abc"�����ԱȽϵ�ֵַ��true

		// �ַ�������ĵڶ��ַ�ʽ
		String s2 = new String("abc");// ���ַ�������new�����ڶ��ڴ��д�����String�Ķ�����������ڹ���ʱ�������ַ���"abc"����û���ڳ��������ж���
		// �������"abc"ͨ���������ݾͽ�������s2�����ᱻ����
		System.out.println("s2=" + s2);
		System.out.println(s == s2);// ���ԱȽϵ�ֵַ��false
		System.out.println(s.equals(s2));// ��ΪString��object�����࣬����object��equals�������и��ǣ��������Լ��ıȽϱ�׼���Ƚϵ���ʵ���ַ�������

		// ���췽�����ô����ڿ��԰��ֽ�������ַ��������ַ���
		String s3 = "";// ��Ч��String s3=new String(); ����ַ��ͬ��������Ч��String s3=null��

		byte[] arr = { 65, 66, 67, 68, 97 };
		String s4 = new String(arr);// ���ֽ��������ַ�������������������֣������ƽ̨Ĭ�ϵ��ַ���(������ASCII��)���б��룬�����µ�String
		// ���캯����String(byte[] bytes) ���ã�ͨ��ʹ��ƽ̨Ĭ�ϵ��ַ�������ָ����byte���飬����һ���µ�String
		System.out.println("s4=" + s4);

		char[] arr1 = { 'a', 'b', 'c', 'd', 'e' };
		String s5 = new String(arr1);// ���ַ��������ַ����������Լ�һ��
		System.out.println("s5=" + s5);
		String s6 = new String(arr1, 1, 3);// ������캯���������ǣ���arr1��������1�ű꿪ʼȡ��ȡ3��������һ���µ��ַ���
		System.out.println("s6=" + s6);
		String s7 = new String(arr, 1, 3);
		System.out.println("s7=" + s7);// ���ֹ��췽�����ֽ�����Ҳ����
	}

}
