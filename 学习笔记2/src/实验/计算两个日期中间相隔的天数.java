package ʵ��;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* ��ϰ��
 * str_date1 = "2016-3-25"
 * str_date2 = "2016-4-08"
 * ���������м��ж����죿
 */

public class �������������м���������� {

	public static void main(String[] args) throws ParseException {
		String str_date1 = "2016-3-25";
		String str_date2 = "2016-4-08";
		int num = sub(str_date1,str_date2);
		System.out.println("�������"+num+"��");
	}

	private static int sub(String str_date1, String str_date2) throws ParseException {
		//1.�ȴ���Ĭ�ϵ����ڸ�ʽ��
		DateFormat dateFormat = DateFormat.getDateInstance();
		//2.ͨ��DateFormatd��parse������ȡ��Ӧ�����ڶ���
		Date date1 = dateFormat.parse(str_date1);
		Date date2 = dateFormat.parse(str_date2);
		//3.��ȡ�������ڶ���ĺ���ֵ
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		//4.��ȡ��������ֵ֮��Ĳ�ֵ
		long time = Math.abs(time1 - time2);	//�õ�Math��ľ���ֵ����
		//5.����ֵת��Ϊ����
		int num = (int)(time/1000/60/60/24);
		return num;
	}

}
