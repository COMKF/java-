package ʵ��;
 class Single{
	private static Single s= new Single();//����ʽ������ʱ��������࣬��Ϊ�򵥰�
	private Single(){}
	public static Single getSingle(){//���ﲻ��Ҫͬ������飬��Ϊ�Ѿ�������Ψһ��һ������
			return s;
		}
 }
/*
class Single {
	private static Single s= null;//����ʽ������ʱ������ּ��ʸߣ���Ϊ����Ҫ���
	private Single(){}
	public static Single getSingle(){
		if(s==null){	//���֮ǰ���߳��Ѿ������˶���������if���������߳��ж�ͬ��������һ���������Ч�ʡ�˫���жϽ��������ʽ��Ч�ʺͰ�ȫ����
			synchronized (Single.class) {//ͬ������飬�������ֽ����ļ���Ϊ������ΪgetSingle�ķ����Ǿ�̬�ġ�
				if(s==null) s=new Single();
			}
		}
		return s;
	}
}
 */

public class ���ڶ��̵߳ĵ������ģʽ {

	public static void main(String[] args) {

	}

}
