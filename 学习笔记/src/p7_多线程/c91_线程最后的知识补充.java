package p7_���߳�;
/* ֹͣ�̣߳�1.stop�������ѹ�ʱ��������˵��2.run����������
 * 
 * ��ô�����߳����������  �����ж�����ѭ���ṹ��ֻҪ����סѭ���Ϳ��Խ�������ͨ���ö���������ɡ�
 * ΪʲôҪ�����̣߳���ִ�еĴ���鸴�ӣ�ͨ����ѭ����������ʱ��Ӱ�쵽��������ִ�У���ʱϣ����������ͬʱִ�У�������������ʺϿ����̡߳�
 * ���ڼ򵥵Ĵ���û��Ҫ�����̡߳�
 * 
 * ���Ǳ�ǲ��ܽ��ȫ���������
 * ���磬�̴߳��ڶ���״̬�����޷���ȡ��ǵģ���ʱ���������ڵȴ�״̬���޷�����Ҳ����������ô����
 * 
 * interrupt�������ж��̣߳������ǽ��̴߳Ӷ���״̬ǿ�ƻظ�������״̬�����߳̾߱�CPU��ִ���ʸ�
 * �������ǿ�ƶ����ᵼ��InterruptedException�쳣������Ҫ����
 * 
 * setDaemon(boolean on)���������̱߳��Ϊ�ػ��߳�(��̨�߳�)���û��̡߳�
 * ֮ǰд���̶߳���ǰ̨�̡߳�
 * ��̨�̵߳������ǣ�����ǰ̨�̶߳������Ļ�����̨�߳��Զ�������
 */
//���·��������˽⼴��
/* join�������ǵȴ����߳���ֹ���߳�������벢���У���ʱ����һ���߳�����ʱ����ʹ��join������
 * 	���ã����߳��ͷ�ִ��Ȩ���ͷ�ִ���ʸ񣬵�ͬ�ڴ��ڶ���״̬(�������쳣)���ȴ�join�߳����н��������̲߳�������CPUִ��Ȩ��
 * toString���������ظ��̵߳��ַ�����ʽ�������߳��������ȼ����߳��顣
 * ���ȼ���ָ�����̻߳�ȡCPUִ��Ȩ�ļ��ʣ����ȼ�Խ�󣬻��CPUִ��Ȩ��Ƶ��Խ�ߡ���Χ��1-10�С�
 * ���ȼ��ֶΣ�MAX_PRIORITY��MIN_PRIORITY��NORM_PRIORITY���÷�������
 * 
 * �߳��飺��ʾһ���̵߳ļ��ϡ��ô����ڿ��ԶԴ���һ�����ڵ������̹߳�ͬ���������磬�ȴ������ѣ��ж��̣߳�����Ϊ��̨�̵߳ȵȡ�
 * 
 * 
 * yield��������ͣ��ǰ����ִ�е��̣߳��ͷ�ִ��Ȩ�������Ǿ߱�ִ���ʸ�
 */

class StopTest implements Runnable{
	private boolean flag=true;
	public synchronized void run() {
		while(flag){//���flag���ǿ���ѭ���ı��
			try {wait();}
			catch (InterruptedException e){	//�ܵ���wait�ķ���������ͬ���ķ���
				System.out.println(Thread.currentThread().getName()+"....e");
				setflag();//���԰�setflag()��������catch���Ϊ�쳣����Ĵ�ʩ���в��ȣ�����very nice�ģ����run�������Խ���
			}
			System.out.println(Thread.currentThread().toString()+"........run");
			//Thread.yield();	//�õĲ��࣬�˽⼴��
		}
	}
	public void setflag(){
		flag=false;
	}
	
}
public class c91_�߳�����֪ʶ���� {

	public static void main(String[] args)  throws InterruptedException {//�����join�������쳣��Ϊ�˷��㣬����ѡ���׳�
		//ThreadGroup g=new  ThreadGroup("xx");//����һ���߳���
		StopTest s= new StopTest();
		Thread t1=new Thread(s);
		Thread t2=new Thread(s);
		t1.start();
		//t1.setPriority(Thread.MAX_PRIORITY);//���ȼ������ã��������10
		//t1.setPriority(Thread.MIN_PRIORITY);//���ȼ������ã�������С��1
		//t1.setPriority(Thread.NORM_PRIORITY);//���ȼ������ã�����������Ҳ��Ĭ�ϣ�5
		//t1.join();//���ﲻ����ʾ��ֻ��˵������main���е�����ʱ�������½��У��ȴ�t1���н��������������С���ʹt2��û�п�����
		t2.setDaemon(true);//����t2Ϊ�ػ��̣߳�������t2����ǰ����
		t2.start();
		//t1.join();//����t2�Ѿ����������Դ�ʱ���̶߳��ᣬt1��t2��ͬ����CPUִ��Ȩ�����t1������t2δ�����������̺߳�t2��ͬ����CPUִ��Ȩ��
					//˵�����߳�ֻ�ǵȴ�t1��������t2�޹ء�
		
		int num=1;
		for (; ;) {//��ѭ��
			if (++num==50) {
				//s.setflag();//��ѭ������ǰ������flagΪfalse���Ϳ������߳��е�ѭ��
				t1.interrupt();//����˶���״̬���������ֻ����ǲ����������ѣ���ǿ�ƻ��ѣ��ᷢ���쳣
				//t2.interrupt();//����˶���״̬���������ֻ����ǲ����������ѣ���ǿ�ƻ��ѣ��ᷢ���쳣
				
				break;
			}
			System.out.println("main...."+num);
		}
		System.out.println("over");
	}

}
