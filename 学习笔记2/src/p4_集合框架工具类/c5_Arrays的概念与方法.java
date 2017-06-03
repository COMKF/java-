package p4_���Ͽ�ܹ�����;

import java.util.List;
import java.util.Arrays;

/* Arrays�����鹤���࣬����ķ������Ǿ�̬�ġ�
 * �����������Arrays�ĸ��ַ�����
 * Arrays�ķ����У�
 * 1.���ֲ���	binarySearch
 * 2.����copyOf
 * 3.��Χ����	copyOfRange
 * 4.�ж����������Ƿ���ͬ equals
 * 5.��������Ԫ���滻��ָ��Ԫ�� fill
 * 6.���������ϣֵ hashCode
 * 7.�������� sort
 * 8.��ȱȽ� deepEquals	//����������Ƕ�����Ƚ϶��������Ƿ���ͬ
 * 9.���������ַ�����ʽ toString
 * 10.����ת����List���� 	List<T> asList(T... a) //��asList������Դ������Կ�������ʹ����(�ɱ��������)
 */
public class c5_Arrays�ĸ����뷽�� {
	public static void main(String[] args) {
		int [] iarr = {3,3,1,5,6};
		
		System.out.println(Arrays.toString(iarr));	//��Arrays.toString�����������Ԫ��
		System.out.println(iarr);	//�Ƚ�һ�£����ֱ������Ļ�����ʵ�������arr�ĵ�ַ		
		
		/* �ص㣺asList������ԭ����Ϊ����Ͼ��������ޣ�����ת�ɼ��Ϻ󣬷�����չ�����ܸ���
		 * 
		 * �ô�������ʹ�ü��ϵķ������������е�Ԫ��
		 * ע�⣺����ĳ����ǹ̶��ģ����Զ��ڼ��ϵ���ɾ�����ǲ���ʹ�õģ�����ᱨ��
		 * 
		 * ��������д洢��Ԫ���Ƕ�����ת�ɼ���ʱ��ֱ�ӽ������е�Ԫ����Ϊ�����е�Ԫ�ؽ��д洢
		 * ��������д洢��Ԫ���ǻ����������ͣ���ת�ɼ���ʱ���Ὣ��������Ϊ�����е�Ԫ�ؽ��д洢
		 */
		
//		String [] sarr = {"abc","nba","xixi","hehe"};
//		List<String> list= Arrays.asList(sarr);
		List<String> list= Arrays.asList("abc","nba","xixi","hehe");	//����д�õ���(�ɱ��������)��������д
		boolean b = list.contains("xixi");
		System.out.println(b);
		System.out.println(list);	//ת����Ч��
		
		List<int []> list2 = Arrays.asList(iarr);	//��Ϊiarr�д洢���ǻ����������ͣ���list2�д洢����iarr������iarr�ĵ�ֵַ��ע���ʱ�ķ���
		System.out.println(list2);
		
		Integer [] iarr2 = {1,5,3,9,7};		
		List<Integer> list3 = Arrays.asList(iarr2);
		System.out.println(list3);	//ע��Ƚ�	
		
		//����ת���鷽����ʹ��Collection�ӿ�(ע�⣬���Ǽ��Ͽ��Collections)�е�toArray������תΪ����󣬲��ܽ�����ɾ������
//		String[] sarr2 = list.toArray(new String[1]);	//toArray��Ҫ��������� ������ʽΪ new ����[����]	(Ϊ��ָ���������ͺ����鳤��)
		//�������С�ڼ��ϵ�size����ô�÷�������������ĳ��Ȼ��뼯�ϵ�size��ͬ��������ȴ��ڼ��ϵ�size����ô�����ж��༯�ϵ�size��λ�û�Ĭ��Ϊnull��
		String[] sarr2 = list.toArray(new String[list.size()]);	//�Ż���Ĵ��룬���鳤�Ⱦ�ֱ��ָ��Ϊ�����ϵ�size
		System.out.println(Arrays.toString(sarr2));
	}	
}
