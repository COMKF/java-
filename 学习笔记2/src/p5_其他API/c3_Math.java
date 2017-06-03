package p5_����API;

import java.util.Random;

/*
 * Math�ṩ�˲�����ѧ����ķ��������Ǿ�̬�ġ�
 * 
 * ���÷�����
 * 1.���ؾ���ֵ  T abs(T a) //����������ʲô���ͣ��򷵻�ֵҲ��ʲô����
 * 2.���ش��ڲ�������С����   double ceil(double a)//����ֵ�Ͳ�������double��
 * 3.����С�ڲ������������   double floor(double a) //����ֵ�Ͳ�������double��
 * 4.�������������ֵ  long round(double a) //������double�ͣ�����ֵ��long��
 * 5.�����������Ľϴ�ֵ  T max(T a, T b)//����������ʲô���ͣ��򷵻�ֵҲ��ʲô����
 * 6.ȡ��a��b�η�  double pow(double a, double b) //����ֵ�Ͳ�������double��
 * 7.����һ��α�����  double random()  //����ֵ��double��
 */
public class c3_Math {

	public static void main(String[] args) {
//		show();
//		showrandom_1();
		showrandom_2();
		
	}

	private static void showrandom_2() {//��Random�ഴ�������
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
//			double d = (int)(r.nextDouble()*6+1);//ȡ��1��6�������
			int d = r.nextInt(6)+1;//ȡ��1��6�������,Ҳ����ֱ��дint�ͣ���������
			System.out.println(d);
		}
	}

	private static void showrandom_1() {//����ѧ�������������
			for (int i = 0; i < 10; i++) {
//			double d = Math.floor(Math.random()*10)+1;//ȡ��1��10�������
//			double d = Math.ceil(Math.random()*10);//ȡ��1��10�������
//			double d = (int)(Math.random()*10+1);//ȡ��1��10�������
			double d = (int)(Math.random()*6+1);//ȡ��1��6�������
			System.out.println(d);
		}
	}

	private static void show() {
		System.out.println(Math.abs(-2.2));
		System.out.println(Math.ceil(12.56));
		System.out.println(Math.floor(12.56));
		System.out.println(Math.round(12.56));
		System.out.println(Math.max(1, 2));
		System.out.println(Math.pow(10, 3));
	}
	
	

}
