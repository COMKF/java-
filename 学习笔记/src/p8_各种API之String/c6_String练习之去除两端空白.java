package p8_����API֮String;
/* ȥ���ַ������˵Ŀհ�
 * ˼·��
 * 1.��������������һ��������Ϊ��ͷ��ʼ�ж��ַ����ո�ĽǱ꣬����++��һ��������Ϊ��β��ʼ�ж��ַ����ո�ĽǱ꣬����--��
 * 2.�жϵ����ǿո�Ϊֹ��ȡͷβ֮����ַ������ɡ�
 * 
 */
public class c6_String��ϰ֮ȥ�����˿հ� {

	public static void main(String[] args) {
		String s = "   a   b   c   ";
		System.out.println(s);
		
		s=myTrim(s);
		System.out.println(s);
	}

	private static String myTrim(String s) {
		int start=0,end=s.length()-1;
		while (start<=end&&s.charAt(start)==' ' ) {
			start++;
		}
		while (start<=end&&s.charAt(end)==' ' ) {
			end--;
		}
		return s.substring(start,end+1);
	}
}
