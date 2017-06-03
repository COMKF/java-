package p5_����API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * DateFormat�ࣺ���ڸ�ʽ����������ʽ��(����-->�ı�)�ͽ��������ַ���(�ı�-->����)����һ������SimpleDateFormat������������ڴ����Զ����� 
 * 
 * ���÷�����
 * 1.��ȡ���ڸ�ʽ��  DateFormat getDateInstance()//��̬����������һ��DateFormat��Ķ���
 * 2.��ȡ����ʱ���ʽ��  DateFormat getDateTimeInstance()//��̬����������һ��DateFormat��Ķ���
 * 3.ȡ�ø�ʽ�������ڻ���ʱ��  String format(Date date)//����Ϊdate���󣬷���ֵΪString
 * 4.�ڻ�ȡ���ڸ�ʽ���ľ�̬�����п���ͨ�������ֶ���Ϊ���������ø����ĸ�ʽ������ֶ��У�FULL(ȫ)  LONG(��)  SHORT(��)    MEDIUM(Ĭ��)
 * 5.ȡ�ö�Ӧ�����ڶ���  Date parse(String source)//����ΪString������ֵΪdate������format�����෴
 */

public class c5_DateFormat {

	public static void main(String[] args) throws ParseException {
//		show1();
		show2();
	}

	private static void show2() throws ParseException {	//���������ַ���(�ı�-->����)��ʹ�õ���DateFormat���е�parse����
		String str_date = "2016-04-11";
		str_date = "2016��04��11��";
		str_date = "2016--04--11";
		
		
		DateFormat dateFormat = DateFormat.getDateInstance();//2016-04-11��Ĭ�Ϸ��ģ�ֱ������������ڸ�ʽ���Ϳ�����ɽ���
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);//2016��04��11����LONG���ģ����ֶ�LONG��Ϊ�������뼴����ɽ���
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");//2016--04--11���Զ�������Ҫ����SimpleDateFormat����󣬲������Զ����ʽ�Ĳ���
		Date date = dateFormat.parse(str_date);	//5��parse������Ҫ�׳��쳣�����쳣��ParseException
		System.out.println(date);
		
	}

	private static void show1() {	//��ʽ��(����-->�ı�)��ʹ�õ���DateFormat���е�format����
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance();	//1��ͨ����̬������ȡ���ڸ�ʽ�����߱�Ĭ�ϵķ��
		dateFormat = DateFormat.getDateInstance(DateFormat.FULL);	//4��ͨ����̬������ȡ���ڸ�ʽ�������������ΪFULL
		dateFormat = DateFormat.getDateTimeInstance();	//2��ͨ����̬������ȡ���ڼ�ʱ���ʽ�����߱�Ĭ�ϵķ��
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.LONG);	//4��ͨ����̬������ȡ���ڼ�ʱ���ʽ��
						//���������������񣬵�һ���������ڽ������ã��ڶ�������ʱ���������(����������)
	
		//����ƶ��Զ����ʽ��
		dateFormat = new SimpleDateFormat("yyyy--MM--dd");//ֱ�Ӵ���SimpleDateFormat��Ķ��󣬲�����String�������Ҳ�����һ���ĸ�ʽ
		
		String str_date =  dateFormat.format(date);	//3���������ڸ�ʽ����format����������Ϊdate���󣬷���ֵΪString
		System.out.println(str_date);
	}

}
