package p6_IO��_1;
/* �������������Ĺ��ܽ�������ǿ��ʵ����ʹ�õ���װ�����ģʽ��
 * װ�����ģʽ������һ�������й�����ǿʱ���Ϳ���ʹ�ø����ģʽ������⡣
 * 
 * �ɼ����̳к�װ�ζ���ʵ�ֹ��ܵ���չ����ǿ����ʲô�����أ�
 * 
 * ��ô���ǿ��Լ���һ�£������Buffered�Լ̳е���ʽ���з�װ���������������ϵ��
 * ��WriterΪ����
 * |��������Writer������
 * 		|��������TextWriter��Writer�����࣬���������ı�
 * 				|��������BufferedTextWriter��TextWriter�����࣬������ǿTextWrite�Ĺ���
 * 		|��������MediaWriter��Writer�����࣬��������ý��
 * 				|��������BufferedMediaWriter��MediaWriter�����࣬������ǿMediaWriter�Ĺ���
 * ������ģ��ѻ��������������ʽ���й��ܵ���ǿ���ɼ���Writer��ÿһ��ֱ�������£�ÿһ�����඼��Ҫһ���ض���Buffered��������ǿ���ܡ�
 * ����Ժ�Writer���ָ��ָ�����ֱ�����࣬��ô��Ӧ�Ļ���Ҫ���������Buffered���࣬�ȼӴ����Ա�Ĺ�������Ҳ��ʹ������ϵԽ��Խӷ�ס�
 * 
 * 
 * ��ôjava���ʦ�������Ƶ��أ�
 * ��WriterΪ����
 * |��������Writer������
 * 		|��������TextWriter��Writer�����࣬���������ı�
 * 		|��������MediaWriter��Writer�����࣬��������ý��
 * 		|��������BufferedWriter��Writer�����࣬ר��������ǿ���ܡ�
 * ����������ӿ��Կ�����BufferedTextWriter��BufferedMediaWriterʹ�õĶ��ǻ��弼�����������ϳ�ȡ�����е����ķ�װ���γ��µ���BufferedWriter��
 * BufferedWriter��ΪWriter��ֱ�����࣬��Writer�������������Writer�ĸ���ֱ�����࣬��TextWriter��MediaWriter������Ƕ�̬���������á�
 * �ɼ���װ�αȼ̳и�����
 * �ص㣺װ����ͱ�װ�����������ͬһ���ӿڻ��߸��ࡣ
 * 
 * ��ô���ǰ�bean.MyBufferedReader�ٽ��н�һ���Ż��ɣ���� MyBufferedReader_optimize��(�Ż���MyBufferedReader)
 */
public class c9_װ�����ģʽ {

	public static void main(String[] args) {
		Person p = new Person();
//		p.chifan();
		NewPerson p1 = new NewPerson(p);
		p1.chifan();	//�������װ�����ģʽ��ʵ�����õĻ���Person�࣬������Person��Ļ����Ͻ��й��ܵ���ǿ�� ���뷿�ӵ�װ��һ��
		
		
		NewPerson2 p2 = new NewPerson2();
		p2.chifan();
	}
}

class Person{
	void chifan(){
		System.out.println("�Է�");
	}
}

class NewPerson{	//װ�����ģʽ��ʾ���൱���ַ���������Buffered��ʵ���ϸ������͵�Buffered���õĴ�඼��װ�����ģʽ��
	private Person p;
	public NewPerson(Person p) {
		this.p = p;
	}
	void chifan(){
		System.out.println("��θ��");
		p.chifan();
		System.out.println("���");
	}
}

class NewPerson2 extends Person{	//�̳У���װ�����ģʽһ��������ʵ����ǿ���ܵ�Ч��
	void chifan(){
		System.out.println("��θ��");
		super.chifan();
		System.out.println("���");
	}
}
