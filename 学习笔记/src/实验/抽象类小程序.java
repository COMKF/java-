package ʵ��;
/* ��Աʾ����
 * ���󣺹�˾���г���Ա�����������������ţ�нˮ����������
 * ��Ŀ�������������������ţ�нˮ���������ݣ��ͽ���
 * �Ը���������н�ģ
 * 
 * ����������������У����ҳ���ƵĶ���
 * ͨ��������������
 * ����Ա��
 * 		���ԣ����������ţ�нˮ
 * 		��Ϊ������
 * ��Ŀ����
 * 		���ԣ����������ţ�нˮ������
 * 		��Ϊ������
 * 
 * ����Ա�;���������ֱ�Ӽ̳й�ϵ�����ǳ���Ա�;���ȴ���й������ݣ����Խ��г�ȡ��
 * ��Ϊ���Ƕ��ǹ�˾�Ĺ�Ա������Ա���߱����������ţ�нˮ�����ԣ���Ϳ��Խ��г�ȡ��������ϵ��
 */
abstract class Employee{//�Ƚ��� ��Ա �࣬���Ǹ�������
	private String name;
	private String id;
	private double pay;
	Employee(String name,String id,double pay){
		this.name=name;
		this.id=id;
		this.pay=pay;
	}
	public abstract void work();
}

class Programmer extends Employee{//���� ����Ա ��
	Programmer(String name,String id,double pay){
		super(name, id, pay);
	}
	public void work(){
		System.out.println("code...");
	}
}

class Manager extends Employee{//���� ��Ŀ���� ��
	private int bonus;
	Manager(String name,String id,double pay,int bonus){
		super(name, id, pay);
		this.bonus=bonus;
	}
	public void work(){
		System.out.println("manage...");
	}

}
public class ������С���� {
	public static void main(String[] args) {

	}

}
