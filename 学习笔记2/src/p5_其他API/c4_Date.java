package p5_����API;
/* Date�࣬ʱ���ࡣ
 * 
 * �����췽����
 * 1.new Date();	//����ǰ���ں�ʱ���װ��Date����
 * 2.new Date(long date)	//��ָ������ֵ��װ��Date����
 * 
 * ���÷�����
 * 3.�жϴ������Ƿ���ָ������֮��  boolean after(Date when)
 * 4.�жϴ������Ƿ���ָ������֮ǰ  boolean before(Date when)
 * 5.����ֵת��Ϊ���ڶ���  void setTime(long time) //�޷���ֵ��ֱ���޸���ԭ������
 * 6.���ڶ���ת��Ϊ����ֵ  long getTime()
 * 7.�ж����������Ƿ����  boolean equals(Object obj)
 * 8.�Ƚ��������ڵ�˳��  int compareTo(Date anotherDate)
 */
import java.util.Date;

public class c4_Date {

	public static void main(String[] args) {
		Date date = new Date();	//1
		System.out.println(date);
		long time = System.currentTimeMillis();//��ȡ��ǰʱ��ĺ���ֵ����ʵnew Date()Ҳ�ǵ������������
		System.out.println(time); //2
		System.out.println(new Date(time)); //2
		/* ���ڶ���ͺ���ֵ֮���ת�� :����ͨ��Date����ķ����������еĸ����ֶ�(�����յ�)���в���
		 * ����ֵ-->���ڶ���
		 * 1.ͨ��Date����Ĺ��췽��new Date(long date)
		 * 2.������ͨ��setTime����
		 * 
		 * ���ڶ���-->����ֵ:����ͨ���������ֵ��������
		 * 1.getTime����
		 */
		long date_time = date.getTime();	//6
		System.out.println(date_time);
		date.setTime(146038419876l);	//5
		System.out.println(date);
	}
}
