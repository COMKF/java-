package p7_���߳�;
/* �Զ������Ķ��߳̽����Ż���ʹ������һ��֮������һ����
 * ��Ҫʹ�õ��ȴ�/���ѻ���
 * ��Ƶķ�����
 * 1.wait()�ȴ������̴߳��ڶ���״̬����wait���̻߳ᱻ�洢���߳�ʹ�õ������̳߳���
 * 2.notify()�����̳߳���һ�߳�
 * 3.notifyAll()�����̳߳�ȫ���߳�
 * ������������������object���У�ʹ������ʱ��Ҫ�м�������������������������̵߳�����״̬
 * ��Щ���������붨����ͬ���У���Ϊ��Щ�����������ڲ����̵߳ķ���������Ҫ��ȷ���ײ����ĸ������ĸ��߳�
 * 
 * Ϊʲô������������������object�У���Ϊ��Щ�������Ǽ�����������
 * ��������������󣬶��������ķ���һ��������object��
 */
/* С֪ʶ��
 * wait()��sleep()������
 * 1.wait����ָ��ʱ��Ҳ���Բ�ָ��ʱ�䣬sleep����ָ��ʱ��
 * 2.wait���ͷ�ִ��Ȩ���ͷ����� sleep���ͷ�ִ��Ȩ�����ͷ�����
 */
class Resource1{ //��Դ
	String name;
	String sex;
	boolean flag=false;
}
class Input1 implements Runnable{//����
	Resource1 r;
	Input1(Resource1 r){
		this.r=r;
	}
	public void run(){//����
		int x=0;
		while (true){//���ܰ�whileѭ������ͬ�������ͬ����һֱ������ط�תȦ
			synchronized (r) {//r������Ҳ���Ƕ��������
				if (r.flag) {//r��flag����
					try {r.wait();}//ʹ��wait��notify�����ü��������ã���r.wait()��r.notify()������֮���̻߳ᱻ���ᣬ�洢����r���̳߳���
					catch (InterruptedException e) {}//wait��sleep����Ҫ��׽�쳣�������ǵ��쳣����ͬ������InterruptedException
				}
					if (x==0) {
						r.name="xiaoqiang";
						r.sex="nan";
					}
					else{
						r.name="С��";
						r.sex="ŮŮŮ";
					}
				r.flag=true;
				r.notify();
			}
			x=(x+1)%2;
		}
	}
}
class Output1 implements Runnable{//���
	Resource1 r;
	Output1(Resource1 r){
		this.r=r;
	}
	public void run(){//���
		while (true){
			synchronized (r) {
				if (!r.flag) {
					try {r.wait();}
					catch (InterruptedException e) {}
				}
				System.out.println(r.name+"..."+r.sex);
				r.flag=false;
				r.notify();
			}
		}
	}
}

public class c6_�������߳��µ�wait��notify {
	public static void main(String[] args) {
		//������Դ
		Resource1 r= new Resource1();
		//��������
		Input1 in= new Input1(r);
		Output1 out= new Output1(r);
		//�����߳�
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}

}
