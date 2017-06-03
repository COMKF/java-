package p5_����API;

import java.util.Calendar;

/* Calendar�ࣺ�����࣬�ж��ֹ������ڵ��ֶΡ�
 * 
 */
public class c6_Calendar {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();//Ĭ��ʹ�õ�ǰʱ����Ϊ�����Ĳ���
		showDate(c);
		int year = 2000;
		setDate(c,year);
	}

	private static void setDate(Calendar c,int year) {
		c.set(year,2,1);	//������set��������c��ʱ��,�·ݵļ���������11����ʵ��12�£�ԭ�����µļ����Ǵ�0��ʼ����11������
		c.add(Calendar.YEAR, 3);//���ڵ�ƫ�ƣ�set������������������һ�����ֶΣ��ڶ�����ƫ����
		c.add(Calendar.YEAR, -3);
		c.add(Calendar.MONTH,0);
		c.add(Calendar.DAY_OF_MONTH,-1);	//ͨ���˷�������ֱ�ӿ����������ݵĶ����ж�����
		showDate(c);
	}

	private static void showDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MARCH)+1;	//��Ϊ�µļ����Ǵ�0��ʼ����11���������Ժ�����Ҫ+1
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getWeek(c.get(Calendar.DAY_OF_WEEK));	//������ı�����������1������һ��2���Դ�����
		System.out.println(year+"��"+month+"��"+day+"��"+" "+week);
	}

	private static String getWeek(int i) {
		String[] week = {"","������","����һ","���ڶ�","������","������","������","������"};
		return week[i];
	}

}
