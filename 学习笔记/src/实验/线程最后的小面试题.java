package ʵ��;
//С����1
/*
class ThreadTest implements Runnable{//Ϊʲô��������һ�У���ΪRunnable���Ǹ��ӿڣ����븲��run()��������Runnable�е�run�������޲�����
	public void run(Object obj){	//���run������Ȼ�ǲ��ܸ���Runnable�е�run�����ģ��������ThreadTest��ֻ���ǳ�����
	}								//���������1.��ǰ��abstract�ؼ��֣�ʹ���Ϊ������ 2.����run����
}
 */

public class �߳�����С������ {
	public static void main(String[] args) {
		//�˽�
		new Thread(){
			public void run(){
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName()+"..i="+i);
				}
			}
		}.start();//�����̵߳ķ���,�����߳�
		
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+"..i="+i);
		}
		
		Runnable r =new Runnable() {
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println(Thread.currentThread().getName()+"..i="+i);
				}
			}
		};
		new Thread(r).start();//�����̵߳ķ����������߳̽���Runnable�ӿ�
		
		//С����2
		new Thread(new Runnable() {//���ʲô����д����ִ��Thread�����run������Ҳ���ǿհ�
			public void run() {//Runnable�ӿڴ�����������run����
				System.out.println("Runnable...run");//
			}
		}){
			public void run(){//����ʵ������������run�������Ǹ���run����
				System.out.println("Thread...run");//����Thread��run����(����ӡ�������������������Ϊ����)
			}
		}.start();//����������⣬��δ�����û������ġ��ʣ�����ӡ����ʲô��
		//�����߳�ִ�е�˳����������Ϊ�������������Thread����run����
	}
				
}
