package p7_���߳�;
//��������������������ľ��裬���Ա�����
//�����������龰֮һ��ͬ����Ƕ��
class Deadlock implements Runnable{
	private boolean flag;
	Deadlock(boolean flag){
		this.flag=flag;
	}
	public void run(){
		if(flag){
			while(true){//С�ģ������ѭ����true�����ѭ����һֱִ�У���Ҫ�ֶ�ֹͣ��������õ��Ա俨��Ȼ������
				synchronized(MyLock.locka){
					System.out.println(Thread.currentThread().getName()+"...if locka....");
					synchronized (MyLock.lockb) {
						System.out.println(Thread.currentThread().getName()+"...if lockb....");
					}
				}
				
			}
		}
		
		else {
			while(true){//С�ģ������ѭ����true�����ѭ����һֱִ�У���Ҫ�ֶ�ֹͣ��������õ��Ա俨��Ȼ������
				synchronized(MyLock.lockb){
					System.out.println(Thread.currentThread().getName()+"...else lockb....");
					synchronized (MyLock.locka) {
						System.out.println(Thread.currentThread().getName()+"...else locka....");
					}
				}
				
			}
		}
	}
}
class MyLock{
	public static final Object locka=new Object();//������������
	public static final Object lockb=new Object();
}

public class c4_���̵߳����� {
	public static void main(String[] args) {
		Deadlock a=new Deadlock(true);
		Deadlock b=new Deadlock(false);
		
		Thread t1= new Thread(a);//aȥ��locka������Ҫ���½��У���Ҫlockb�����ȴ�b�ͷ�lockb��
		Thread t2= new Thread(b);//bȥ��lockb������Ҫ���½��У���Ҫlocka�����ȴ�a�ͷ�locka��
		t1.start();
		t2.start();
	}

}
