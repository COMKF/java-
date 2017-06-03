package p8_����API֮String;

/* StringBuffer��String�ǲ�ͬ���࣬��Ϊ���ݲ��࣬��������String�İ���
 * StringBuffer���ַ��������������ڴ洢���ݵ�������
 * �ص㣺1.�����ǿɱ�ġ�2.�ɴ洢��ͬ���͵����ݡ�3.����Ҫת���ַ�������ʹ�á�4.�ɶ��ַ��������޸ġ�
 * ��Ȼ��һ������������Ӧ�þ߱�ʲô�����أ�
 * 1.���  StringBuffer  append��data��//�κ�����������ӵ�StringBuffer�����У�����ת��ΪStringBuffer����
 * 			 StringBuffer insert(int offset, String str)	//��ָ��λ�ÿ�ʼ�滻�ַ���
 * 2.ɾ��  StringBuffer  delete(int start, int end)//����ͷ��������β
 * 			StringBuffer  deleteCharAt(int index)//ɾ��ָ��λ�õ��ַ�
 * 3.���� char charAt(int index) //���Ҿ���ű��µ��ַ�
 * 			int indexOf(String str)//�����Ӵ����ַ����е�һ�γ��ֵ�λ��
 * 			int lastIndexOf(String str)//�����Ӵ����ַ��������һ�γ��ֵ�λ��
 * 4.�޸� StringBuffer replace(int start, int end, String str)//����ָ��λ���滻�ַ���
 * 			void setCharAt(int index, char ch)//��ָ��λ�ø����ַ�
 * ��ɾ�Ĳ飨C��creatr,U:update,R:read,D:delete���Ƕ����ݵĻ�������������Ҫ��
 * 5.���ó��� void setLength(int newLength)//���û������ĳ���
 * 6.��ת StringBuffer reverse()//���ַ������ַ�˳��ת
 */
/* StringBuffer���ȿɱ�ľ���ԭ��
 * ������һ��StringBufferʱ������Ĭ�ϳ�����16��
 * ����Ҫװ��17���ַ�ʱ��StringBuffer���ٴ���һ������Ϊ32��StringBuffer������������֮ǰStringBuffer�ڵ��ַ������ƽ�ȥ������ӵ�17���ַ���
 * ÿ����ӵ��ַ�������StringBuffer�ĳ���ʱ���ͻᴴ��һ���µ�StringBuffer�����ȱ�֮ǰ��StringBuffer��16.
 * 
 * ��ô�����ǲ���ֻ��Ҫ����һ��Ĭ�ϵ�StringBuffer�������أ�
 * ���ǵģ������������ȷ����������40���ڣ��Ǿ�ֱ�Ӵ���һ������Ϊ40��StringBuffer��
 * �����Ĭ�ϵĻ�����ഴ������StringBuffer�������ͻή��Ч�ʣ��˷�ʱ�䣬�˷��ڴ�ռ䡣
 */
public class c7_Stringbuffer�Ļ������� {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		// 1
		sb.append(4); // sb�������ݺ󣬽�����Ƿ��ظ�sb
		sb.append(true);
		System.out.println(sb);
		sb.append(false).append("haha");// ����������
		System.out.println(sb);
		sb.insert(2, "aaa");
		System.out.println(sb);
		// 2
		sb.delete(1, 3);
		System.out.println(sb);
		sb.deleteCharAt(3);
		System.out.println(sb);
		// sb.delete(0, sb.length());//��ջ�������������������û���ˣ����ǻ���������
		// System.out.println(sb);
		// 3
		System.out.println(sb.charAt(5));
		System.out.println(sb.indexOf("a"));
		System.out.println(sb.lastIndexOf("a"));
		// 4
		sb.replace(1, 3, "nba");
		System.out.println(sb);
		sb.setCharAt(0, 'h');
		System.out.println(sb);
		// 5
		sb.setLength(3);
		System.out.println(sb);
		sb.setLength(5);
		System.out.println(sb);
		// 6
		System.out.println(sb.reverse());

	}

}
