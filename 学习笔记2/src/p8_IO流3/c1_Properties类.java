package p8_IO��3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/* Properties����ʾһ���־õ����Լ����ɱ��������л��ߴ����м���(��IO������ϵ����)��
 * 	�־û�������Ϣ������Ӳ���ϣ������洢��ʱ������������Ժ��ʹ�á�
 * Properties������Map�࣬��ϵΪMap-Hashtable-Properties
 * �ص㣺
 * 1.�����еļ���ֵ�����ַ�������
 * 2.�����е����ݿ��Ա��������У����ߴ����л�ȡ��
 * 
 * ͨ���ü������ڲ����Լ�ֵ����ʽ���ڵ������ļ���
 * 
 * ���з�����
 * 1.��  Object setProperty(String key, String value)	//����ֵ����Map���ϵĴ洢����������ǰһ����key������ֵ�����û���򷵻�null
 * 2.ȡ����Ԫ��  V get(Object key) //���������key������ֵ�����û�����key�򷵻�null
 * 3.ȡ����Ԫ��  ���� Set<String> stringPropertyNames() ������м��ļ��ϣ���ͨ������2��ȡ������Ӧ��ֵ
 * 
 * 4.��ӡ��ǰProperties�е�����Ԫ��  void list(PrintStream out)//��������ڵ��Ե�ʱ���õĽ϶࣬��Ϊ�������������ֱ���ڿ���̨�ϴ�ӡ���е�Ԫ�أ���ֱ��
 * 
 * 5.��Properties�е���Ϣ���浽�ļ���  void store(Writer writer, String comments)//������������һ������������ڶ�����key+value��˵������Ҫд����
 * 6.���ļ��е���Ϣ��ȡ��Properties��  void load(InputStream inStream)//�����Ƕ�ȡ��
 */
public class c1_Properties�� {

	public static void main(String[] args) throws IOException {
		//����һ��Properties����
		Properties pro = new Properties();
//		show1(pro);
//		show2(pro);
//		show3(pro);
		show4(pro);
	}

	private static void show1(Properties pro) {	//Properties�Ļ���������1��2��3
		//1.��
		pro.setProperty("zhangsan", "22");
		pro.setProperty("lisi", "26");
		pro.setProperty("wagnwu", "24");
		//�޸�Ԫ��
		pro.setProperty("wagnwu", "23"); //�õ���Ȼ�Ƿ���1
		//2.ȡ����
		System.out.println(pro.get("zhangsan"));
		//3.ȡ����
		Set<String> keys = pro.stringPropertyNames();
		for(String key : keys){	
			String value = pro.getProperty(key);	//2
			System.out.println(key+":"+value);
		}
	}

	private static void show2(Properties pro) {	//Properties�������ϵķ�����4
		pro = System.getProperties(); 
		//4.
		pro.list(System.out);
	}
	
	private static void show3(Properties pro) throws IOException {	//Properties�������ϵķ�����5
		//��Ҫ����Щ�����е��ַ�����ֵ����Ϣ�־û��洢���ļ��У���Ҫ������������õ���store����
		//1.��
		pro.setProperty("zhangsan", "22");
		pro.setProperty("lisi", "26");
		pro.setProperty("wagnwu", "24");
		//5.��Properties�е���Ϣ���浽�ļ���
		FileOutputStream fos = new FileOutputStream("info.txt");	//дFileWriterҲ����
		pro.store(fos,"name+age");	//5
		fos.close();	
	}
	
	private static void show4(Properties pro) throws IOException {	//�޸�������Ϣ
		//�����е����ݱ�������ͬһ�ļ������ļ��е����ݱ����Ǽ�ֵ��
		//��Ȼ����Ҫʹ�õ���ȡ�������ļ�
		File f = new File("info.txt");
		if (!f.exists()) {	//��׳���ж�
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);	//���������ֽ���
		//5.���ļ��е���Ϣ��ȡ��Properties��
		pro.load(fis);
		//�÷���1�޸�������Ϣ
		pro.setProperty("zhangsan", "21");
		pro.list(System.out);
		fis.close();
		
		//������������ѽ�Properties�е���Ϣ���浽�ļ���
		FileWriter fw = new FileWriter(f);	//���������ַ��������Կ������ֽ������ַ������������ͨ�ã�����ѡȡ���ʵ������в���
		//�÷���5
		pro.store(fw,"name+age");	//5
		fw.close();	
	}
}

/* ֪ʶ���䣺load����ԭ��
 * public static void MyLoad() throws IOException {	//ģ��load�����������ԭ��
		Properties pro = new Properties();
		BufferedReader bfr = new BufferedReader(new FileReader("info.txt"));
		String line = null;
		while((line = bfr.readLine())!=null){
			if(line.startsWith("#")) continue;	//���жϣ�������#��ͷ��ע����Ϣ
			String[] arr = line.split("=");	//��=��line�и�Ϊ������
			pro.setProperty(arr[0], arr[1]);
		}
		bfr.close();
		pro.list(System.out);
	}
 */

