package p2_������ѧʾ��;

public class ������ѧʾ��{
	public static void main(String args[])
	{                    //���ֺ�����ͬ���ģ����Բ�����һ�������ж�����һ���������粻����main�����ж���add����
		int a= add(3,4); //main������Ҫ��ͨ��������������ʵ�ָ��ֹ��ܵģ����Ը��ֹ���Ӧ������װ��һ��������д��main������
		//  a= add(3,4); //���main�����е�����add��������Ϊmain�����Ǿ�̬��(��static����)������add��������Ҳ�Ǿ�̬��
		System.out.println("a="+a);
		myPrint();
		draw(4,5);
	}
	
	static int add(int x,int y) //������ʽ�����δ�  ����ֵ����  ������(��������  ��ʽ����1����������  ��ʽ����2......) 
	{
		int z;
		z=x+y;
		return z; //return ����ֵ�ز����� �����Ǹú�����void���ͣ���ʱreturn��ֱ��д�ֺ� 
	}  //return�����ã�1.����ֵ  2.�����ú���������ִ����������(����java��˵�������д��ִ�в�������䣬�ͻᱨ��
	static void myPrint()  //��������д�淶����һ��������Сд���ӵڶ�������֮������ĸ���ô�д
	{
		System.out.println("hello world");  //void���ͺ��� return����ǿ��Բ�д��
	}
	
	static void draw(int x,int y) //void����ʾ��
	{
		for(int m=0;m<x;m++)
			{
				for(int n=0;n<y;n++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		//return ;  // ��д�ɲ�д
	}
}
//main����ʾ��    public static�����δ�     void�Ƿ���ֵ  main�Ǻ����� String�ǲ�������  args[]����ʽ����