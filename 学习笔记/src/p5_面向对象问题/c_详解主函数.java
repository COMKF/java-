package p5_�����������;

public class c_��������� {
	public static void main(String[] args){
		System.out.println(args);
		System.out.println(args.length);
		for(int i=0;i<args.length;i++) 
			System.out.println(args[i]);
		
	}
}
/* 
 ����������ʽ�̶�����jvmʶ��͵���
 public Ȩ����� 
 static ��̬������Ҫ����ֱ������������
 void û�з���ֵ�������з��ط��򣬳�������󷵻ظ�jvm
 main �����������ǹؼ��֣�ֻ�ǿ��Ա�jvm�Ĺ̶�������
 string[] args �������Ĳ����б������������Ԫ�����ַ���(���ǿ����Լ����ò�������main�У��ַ�����������ͨ�õ�����)
*/