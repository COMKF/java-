package p7_���߳�;
//����private���ԣ�����set��get��������߰�ȫ��
//��ʵ������Ӧ����������
class Resource2{ //��Դ
	private String name;
	private String sex;
	private boolean flag=false;
	
	public synchronized void set(String name,String sex) {//ֱ������������ͬ������
		if (flag) {
			try {this.wait();}//this��ʡ�ԣ���Ϊͬ�����������Ѿ�Ĭ��Ϊ�������е��������
			catch (InterruptedException e) {}
		}
		this.name = name;
		this.sex = sex;
		flag=true;
		this.notify();//this��ʡ�ԣ���Ϊͬ�����������Ѿ�Ĭ��Ϊ�������е��������
	}
	
	
	public synchronized void get(){//ֱ������������ͬ������
		if (!flag) {
			try {wait();}
			catch (InterruptedException e) {}
		}
		System.out.println(name+"..."+sex);
		flag=false;
		notify();
	}
}
class Input2 implements Runnable{//����
	Resource2 r;
	Input2(Resource2 r){
		this.r=r;
	}
	public void run(){//����
		int x=0;
		while (true){//���ܰ�whileѭ������ͬ�������ͬ����һֱ������ط�תȦ
			if (x==0) {
				r.set("xiaoqiang", "nan");
			}
			else{
				r.set("С��", "ŮŮŮ");
			}
			x=(x+1)%2;
		}
	}
}
class Output2 implements Runnable{//���
	Resource2 r;
	Output2(Resource2 r){
		this.r=r;
	}
	public void run(){//���
		while (true){
			r.get();
		}
	}
}

public class c7_��Զ������߳��µ�wait��notify���Ż�  {
	public static void main(String[] args) {
		//������Դ
		Resource2 r= new Resource2();
		//��������
		Input2 in= new Input2(r);
		Output2 out= new Output2(r);
		//�����߳�
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}

}
