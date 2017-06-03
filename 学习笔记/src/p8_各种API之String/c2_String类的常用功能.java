package p8_����API֮String;

/* 1.��ȡ
 * 1.1��ȡ�ַ������ַ��ĸ���(����)�� int length()��
 * 1.2����λ�û�ȡ�ַ��� char charAt(int index)��
 * 1.3�����ַ���ȡ���ַ����еĵ�һ�γ��ֵ�λ�á� (����ᣬ�ص�����)
 * 		int indexOf(int ch)//��0�ű����ch���������ҵ�һ�γ��ֵ�λ��
 * 		int indexOf(int ch��int fromIndex)//��ָ��λ�ý���ch���������ҵ�һ�γ��ֵ�λ��
 * 		int indexOf(String str)//�����ַ���������
 * 		int indexOf(String str��int fromIndex)
 * 		�����ַ���ȡ���ַ����е����һ�γ��ֵ�λ��
 * 		lastIndexOf(int ch)
 * 		lastIndexOf(int ch��int fromIndex)
 * 		lastIndexOf(String str)
 * 		lastIndexOf(String str��int fromIndex)
 * 1.4��ȡ�ַ����е�һ�����ַ�����Ҳ�����Ӵ��� 
 * 		String substring(int beginIndex)//ȡ�ӿ�ʼ�ű굽�����Ӵ�
 * 		String substring(int beginIndex��int endIndex)//ȡ�ӿ�ʼ�ű굽(��ֹ�ű�-1)���Ӵ���������begin��������end
 */
/* 2.ת��
 * 2.1���ַ�������ַ�������(�ַ������и�)��(����ᣬ�ص�����) String[]  split(String regex)	(�漰��������ʽ)
 * 2.2���ַ�������ַ����顣 char[] toCharArray()
 * 2.3���ַ�������ֽ����顣byte[] getBytes()
 * 2.4�����ַ����е���ĸ��ɴ�Сд��
 * 		String toUpperCase()//���д
 * 		String toLowerCase()//��Сд
 * 2.5���ַ����е����ݽ����滻�� 
 * 		String  replace(char oldch,char newch)//�滻�ַ�
 * 		String  replace(String oldStr,String newStr)//�滻�ַ���
 * 2.6���ַ������˵Ŀո�ȥ����String trim()
 * 2.7���ַ����������ӡ�String concat()
 * 2.8���κ����ͱ�������ַ�����������Щ�����Ǿ�̬����������ֱ����String���á� String  String.valueOf(��������)��
 */
/* 3.�ж�
 * 3.1�������ַ��������Ƿ���ͬ? boolean equals(object obj)����Ҫע�����string�е�equals�Ѿ���������д
 * 		boolean equalsIgnoreCase(String Str)//���Դ�Сд���ַ��������жϡ�
 * 3.2�ַ������Ƿ����ĳһ�ַ�����boolean contains(String Str)
 * 3.3�����Ƿ�����ָ���ַ�����ͷ���ַ����� boolean startsWith(String Str)
 * 		�����Ƿ�����ָ���ַ�����β���ַ����� boolean endsWith(String Str)
 */
/* 4.�Ƚ�(������ֵ�ıȽ���>��<�ȵȵ������������ıȽ��÷������ַ����Ƕ��������÷������бȽ�)
 * 4.1�Ƚ��ַ����Ĵ�С��(����ᣬ�ص�����)  
 * 		��ASCII������Ϊ���Ӧ�����֣�Ȼ����бȽϡ����������ȣ��򷵻�ֵΪ0�����С��Ŀ���ַ�������Ϊ����������Ŀ���ַ�������Ϊ������
 * 		int compareTo(String Str) //��ÿ���ַ����бȽϣ������Ƚ���һ�ַ������ȣ��������������ٽ��к����ַ��ıȽ�
 * 		int compareToIgnoreCase(String Str)//���Դ�Сд���ַ������бȽϡ�
 */
// 5.1 String intern()//�����ַ�������Ĺ淶����ʾ�������÷������ַ����ؽ��в�����(�˷�������һ�㲻�ã������˽�)

public class c2_String��ĳ��ù��� {
	public static void main(String[] args) {
		String s = "abcd efag";

		System.out.println("length:" + s.length());// 1.1����Ҫע����ǣ��ո�Ҳ��һ���ַ�
		System.out.println("char:" + s.charAt(2));// 1.2
		// System.out.println("char:"+s.charAt(20));//1.2,StringIndexOutOfBoundsException
		// �ַ����ű�Խ��
		System.out.println("index:" + s.indexOf('a'));// 1.3
		// System.out.println("index:"+s.indexOf('k'));//1.3�������-1��˵���ַ�����û������ַ�
		System.out.println("lastindex:" + s.lastIndexOf("a"));// 1.3���ַ��õ����ţ��ַ�����˫���ţ���������Ϊֻ��һ��a�����Ե���˫��������
		System.out.println("substring:" + s.substring(2));// 1.4��
		System.out.println("substring:" + s.substring(2, s.length()));// 1.4��ͬ�ϵ�Ч����ʵȡ���Ǵ�2��s.length()-1
		System.out.println("substring2:" + s.substring(2, 6));// 1.4��ͬ��ȡ����2��5��

		String s1 = "ab����,����,����";

		String[] arr = s1.split(",");// 2.1
		// String[] arr=s1.split("\\.");
		// //�����Ҫ�е���.,��Ϊ����������ţ�����������ָ�ʽ(��ʱ�ȼ�ס)����������ͨ����(�漰���������)
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		char[] arr1 = s1.toCharArray();// 2.2
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		byte[] arr2 = s1.getBytes();// 2.3������ռ�����ֽڣ��������ֽ����飬�������ֽڻ�ֱ���룬����λ����1�������Ǹ���
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("Asd".toUpperCase());// 2.4
		System.out.println("Asd".toLowerCase());// 2.4
		System.out.println("java".replace('a', 'o'));// 2.5

		System.out.println("-" + "   a b   c   ".trim() + "-");// 2.6

		System.out.println("java".concat("se"));// 2.7�����ߵ�Ч��������õ��������˼�룬���Կ���ʱ���������
		System.out.println("java" + "se");// 2.7
		System.out.println(4 + 1);// 2.8
		System.out.println(String.valueOf(4) + 1);// 2.8

		String s2 = "abc";
		System.out.println(s2.equalsIgnoreCase("ABC")); // 3.1
		System.out.println(s2.contains("bc"));// 3.2

		String s3 = "ArrayDome.java";
		System.out.println(s3.startsWith("Array"));// 3.3��ʵ���ô����������������
		System.out.println(s3.endsWith(".java"));// 3.3��ʵ���ô�����������java�ļ�

		System.out.println(s2.compareTo(s3));// 4.1

		String s4 = new String("bcd");// 5.1�����Ƕ���s4��"bcd"��s4��˽������
		String s5 = s4.intern();// �ַ��������Ҳ���"bcd"�����ڳ��д���������
		System.out.println(s4 == s5);// һ���ڶ��ڴ�ĳ��У�һ���ڶ��ڴ�Ķ����У����ߵ�ַ��һ��
		System.out.println(s4.equals(s5));
	}
}
