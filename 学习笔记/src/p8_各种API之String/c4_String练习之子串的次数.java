package p8_����API֮String;

/* һ���Ӵ��������г��ֵĴ���
 * ˼·��
 * 1.Ҫ�ҵ��Ӵ��Ƿ���ڣ�������ڣ���ȡ����ֵ�λ�ã��������ʹ��indexOf���
 * 2.����ҵ��ˣ���ô�ͼ�¼���ֵ�λ�ò���ʣ����ַ����м������Ҹ��Ӵ�����ʣ���ַ�������ʼλ���ǳ���λ��+�Ӵ��ĳ��ȡ�
 * 3.�Դ����ƣ�ͨ��ѭ����ɲ��ң�����Ҳ�������-1������ÿ���ҵ��ü�������¼��
 * 
 */
public class c4_String��ϰ֮�Ӵ��Ĵ��� {

	public static void main(String[] args) {
		String str = "nbajkl'nbajkl;nbahjklnbahjklnbajjnbajj";
		String key = "nba";
		// int count = getKeyStringCount(str, key);
		int count = getKeyStringCount2(str, key);
		System.out.println("count=" + count);

	}

	private static int getKeyStringCount(String str, String key) {
		// 1.���������
		int count = 0;
		// 2.���������¼key���ֵ�λ��
		int index = 0;
		while ((index = str.indexOf(key)) != -1) {
			str = str.substring(index + key.length()); // ���ְ취�ǽ�ȡ�ַ�����ÿ�ζ������ַ����������в����µ��ַ�������̫��
			count++;
		}
		return count;
	}

	private static int getKeyStringCount2(String str, String key) {
		// 1.���������
		int count = 0;
		// 2.���������¼key���ֵ�λ��
		int index = 0;
		while ((index = str.indexOf(key, index)) != -1) { // ���ְ취��str.indexOf��λ������,���ù�������ַ����������������ַ�������
			index = index + key.length();
			count++;
		}
		return count;
	}
}
