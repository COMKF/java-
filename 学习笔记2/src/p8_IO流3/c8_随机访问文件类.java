package p8_IO��3;

import java.io.IOException;
import java.io.RandomAccessFile;
/* ��������ļ��ࣺRandomAccessFile�࣬�������������ļ�������;߱���д�ķ�����
 * ���಻��IO�Ĵ���ϵ�е����ࡣIO�Ĵ���ϵ�ǣ�Reader��Writer��InputStream��OutputStream��
 * �ص㣺
 * 1.�ö�����ܶ�Ҳ��д��
 * 2.�ö����ڲ�ά����һ��byte���飬��ͨ��ָ����Բ��������е�Ԫ�ء�
 * 3.����ͨ��getFilePointer������ȡָ���λ�ã���ͨ��seek��������ָ���λ�á�
 * 4.��ʵ�ö�����ǽ��ֽ�������������������˷�װ��(Ҫ��Ȼƾʲô���Զ���д��)
 * 5.�ö����Դ����Ŀ��ֻ�����ļ���ͨ�����캯���Ϳ��Կ�����
 * 
 * ���캯����
 * 1.RandomAccessFile(String name, String mode)	//������������һ�����ļ������ڶ�����ģʽ����4��ֵ��r��rw��rws��rwd��ָ�����ļ��Ĳ�������
 * 2.RandomAccessFile(File file, String mode)	//������������һ�����ļ�����
 * 
 * ���÷�����
 * 1.��ȡread��д��write�����ٲ���
 * 
 */
public class c8_��������ļ��� {

	public static void main(String[] args) throws IOException {
//		wrifile();
//		reafile();
		wrifile2();
		
	}

	private static void wrifile() throws IOException {
		//ʹ��RandomAccessFileд��һЩ��Ա��Ϣ���������������䡣
		//����ļ������ڣ��򴴽�������ļ����ڣ��򲻴���
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("����".getBytes());
//		raf.write(97);	
//		raf.write(609);	//˵��д��int������ʱ��int��������Ȼ��4���ֽڣ���ֻ��д�����һ���ֽڣ������8λ��
		raf.writeInt(97);	//���������д��ľ���int�����ݵ�4���ֽڣ�������������int�����ݡ�
//		raf.writeChars("С��");	//���Ƶķ�������writeChars�ȣ��������д���ַ��������ַ�������֤�����ݵ������ԡ����п�������������롣
//		raf.writeBytes("С��");	//��Ϊ���ݱ���ʵ�ģ������ı����ˣ�����txt���ܽ����������������������
		raf.write("Сǿ".getBytes());
		raf.writeInt(99);
		raf.close();
	}
	
	private static void reafile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);	//��ȡһ���ֽ����������
		System.out.println(name);
		int age = raf.readInt();	//��ȡ�ĸ��ֽڣ���ת��Ϊint������
		System.out.println(age);
		
		System.out.println(raf.getFilePointer());	//��ȡ��ǰ��ָ��λ��
		//ͨ��seek����ָ���λ�ã�����ȡСǿ����ֱ�Ӷ�ȡСǿ������
		raf.seek(12);	//����ָ��λ�ã�����������ȡ������Ķ��ʹ��Ķ���ֻ��Ҫָ��ָ���λ�ü���
		
		int age2 = raf.readInt();	//
		System.out.println(age2);

		raf.close();
	}
	
	private static void wrifile2() throws IOException {	//�����д��˼�룬��д�ļ�
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("�����".getBytes());
		raf.writeInt((int)(Math.random()*6+97));
		raf.seek((int) raf.length());	//ֱ������ָ��λ�õ��ļ�ĩβ����ĩβ��ʼд
		raf.write("����".getBytes());
		raf.writeInt(101);
		raf.close();
		/* ��ʵ�ϣ�ÿ����RandomAccessFile���ļ����ļ�ָ�붼���ڵ�һλ����֮ǰ���������Ҳ����䡣
		 * �����ʱ��write���������Ḳ��֮ǰ�����ݡ�ʣ�µ�û�и��ǵ������ݣ�����ı䡣
		 */
		//����࣬ʵ�õĵط��ڣ���һ���ļ������и�ʱ�����Կ������̣߳��ö������ͬʱ�иֻҪ���ú��ļ�ָ�뼴�ɣ�����Ҫ�õ�����������ʡʱ�䡣
	}

}
