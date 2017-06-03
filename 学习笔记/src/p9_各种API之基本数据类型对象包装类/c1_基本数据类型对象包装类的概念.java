package p9_����API֮�����������Ͷ����װ��;

/* �����������Ͷ����װ��
 * Ϊ�˷������������������ֵ�������װ�ɶ����ڶ����ж��������Ժ���Ϊ�ḻ�˶Ը����ݵĲ��������������ö������ͻ��Ϊ�����������Ͷ����װ�ࡣ
 * 
 * ��������	�������Ͷ�Ӧ�Ķ����װ��
 * byte		Byte
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 * char		Character
 * boolean	Boolean
 * ��Ҫע����ǣ��������� �� �������Ͷ�Ӧ�Ķ����װ�� �ǲ�ͬ���࣬��ͬ�ĸ���ڲ����ϲ���ȫһ����
 * ���磬Ҫ��һ��int�����ݵĶ����Ʊ�ʾ��ʽ��int����û�������ķ��������Ե���Integer�ķ�������int������Ϊ������
 */
/* �ð�װ������Ҫ���ڻ������ͺ��ַ���֮���ת����
 * 
 * �������͡���>�ַ�������
 * 				1.����������ֵ+""
 * 				2.��String���о�̬����valueOf(����������ֵ)
 * 				3.��Integer�ľ�̬����toString(����������ֵ)��ע�⣬���������toString(int i, int radix)���岻һ����radix�ǻ���
 * �ַ������͡���>��������
 * 				1.ʹ�ð�װ���еľ�̬���� xxx parseXxx(string "xxx");//���磬 parseint�Ĺ����ǽ�������ɵ��ַ���ת��Ϊint������
 * 					ֻ��Characterû��parseXxx��������Ϊ���Ķ�����װ�ľ����ַ���
 * 				2.����ַ�����Integer�����˶���ķ�װ������ʹ����һ���Ǿ�̬�ķ�����intValue();��һ��Integer����ת�ɻ�����������ֵ��
 */
/* �����Ĳ�ͬ����ת����(������Integer�ķ���)
 * ʮ���ơ���>��������:
 * 		String toBinaryString(int i)//ת������
 * 		String toOctalString(int i)//ת�˽���
 * 		String toHexString(int i)//תʮ������
 * 		String toString(int i, int radix)//ת�������
 * �������ơ���>ʮ����
 * 		int parseInt(String s, int radix)//radix��������radix���Ƶ�sת��Ϊʮ������
 */
/* Integer����ķ�����
 * 		equals�������Ȱ���������ת��Ϊint�����ݣ��ٽ�����ֵ�Ƚϣ������true��false
 * 		compareTo�������Ȱ���������ת��Ϊint�����ݣ��ٽ��д�С�Ƚϣ������-1,0,1
 */
/* ��jdk1.5�汾֮��Integer��ĳЩ������intһ�£�������Զ�װ�䣬����д��
 */
public class c1_�����������Ͷ����װ��ĸ��� {

	public static void main(String[] args) {
		int num = -6;
		System.out.println(Integer.MAX_VALUE);// Integer�ľ�̬������ȡ��int�����ݵ����ֵ
		System.out.println(Integer.toBinaryString(num));// int����û��ת��Ϊ���������ķ����������Integer�ķ�������int������Ϊ������

		Integer i = new Integer("123");
		System.out.println(i.intValue() + 1);// Integer����ת��Ϊint��

		System.out.println(Integer.toBinaryString(12));// ת������
		System.out.println(Integer.toOctalString(12));// ת�˽���
		System.out.println(Integer.toHexString(12));// תʮ������

		System.out.println(Integer.toString(12, 3));// ת������

		System.out.println(Integer.toString(12 + 1) + 1);// ֻ��תΪ�ַ�������

		System.out.println(Integer.parseInt("60", 8));// �Ѱ˽��Ƶ�60ת��Ϊʮ������

		Integer a = new Integer("3");
		Integer b = new Integer(3);
		System.out.println(a == b);// �Ƚϵ��ǵ�ַ����Ȼ��false
		System.out.println(a.equals(b));// integer��equals���������˸�д���÷������Ȱ���������ת��Ϊint�����ݣ��ٽ�����ֵ�Ƚ�

		System.out.println(a.compareTo(10));

		Integer c = 4;// Integer a = new Integer(4);�Զ�װ�䣬����д
		c = c + 4;// c=new Integer(c.intValue()+4);�õ����Զ�������Զ�װ��
		Integer d = 127;
		Integer e = 127;
		System.out.println(d == e);// �����true�����װ�����һ���ֽڣ���ô�����ݻᱻ�����������¿��ٿռ䡣
	}

}
