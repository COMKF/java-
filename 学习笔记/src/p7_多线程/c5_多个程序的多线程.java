package p7_���߳�;
/* ���߳�ͨѶ�����̴߳���ͬһ��Դ��������ȴ��ͬ
 * ��������������ͬһ����
 */
class Resource{ //��Դ���ٴ�˵������Ҫ��static������Ҳ�ã�����Ҳ�ã�ǧ����static
	String name;
	String sex;
}
class Input implements Runnable{//����
	Resource r;
	Input(Resource r){//�ù��캯������Input��Output�����̴߳�����ͬ��r(��Դ)
		this.r=r;
	}
	//Object obj=new Object();//��֮ǰ�Ķ��߳̿����У�������obj�����������������ﲻ�У���Ϊ�����������൱��ÿ���������Լ���������
	public void run(){//����
		int x=0;
		while (true){//���ܰ�whileѭ������ͬ�������ͬ����һֱ������ط�תȦ
			synchronized (r) {//����ѡȡ��ͬ���еĶ���r����Ϊ��ͬ����������rҲ���ԣ�ֻҪ����ͬ�������ɣ�����������Ȼr�����㡣
				if (x==0) {
					r.name="xiaoqiang";
					r.sex="nan";
				}
				else{
					r.name="С��";
					r.sex="ŮŮŮ";
				}
				
			}
			x=(x+1)%2;
		}
	}
}
class Output implements Runnable{//���
	Resource r;
	Output(Resource r){//�ù��캯������Input��Output�����̴߳�����ͬ��r(��Դ)
		this.r=r;
	}
	//Object obj=new Object();//��֮ǰ�Ķ��߳̿����У�������obj�����������������ﲻ�У���Ϊ�����������൱��ÿ���������Լ���������
	public void run(){//���
		while (true){
			synchronized (r) {//����ѡȡ��ͬ���еĶ���r����Ϊ��ͬ����������rҲ���ԣ�ֻҪ����ͬ�������ɣ�����������Ȼr�����㡣
				System.out.println(r.name+"..."+r.sex);
				
			}
		}
	}
}

public class c5_�������Ķ��߳� {
	public static void main(String[] args) {
		//������Դ
		Resource r= new Resource();
		//��������
		Input in= new Input(r);
		Output out= new Output(r);
		//�����߳�
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}
}
