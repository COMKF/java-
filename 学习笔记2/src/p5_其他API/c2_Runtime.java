package p5_����API;

import java.io.IOException;

/* ÿ��java������һ��Runtime��ʵ������Ӧ�ó������������л���������(����Ӧ�ó���Ľ��̺Ϳռ����Դ)������ͨ��getRuntime������ȡ��ǰ����ʱ��
 * Runtime��û�й��췽��ժҪ��˵�����಻���Դ��������ַ��ֻ��зǾ�̬������
 * ˵������Ӧ�����ṩ��̬�ķ��ظ������ķ���������ֻ��һ����˵��ʹ���˵������ģʽ��
 * 
 * Runtime��ĳ��ù��ܣ�
 * 1.��������  Process exec(String command)//��������ΪProcess��ʵ������һ������
 * 
 * Process��ĳ��ù��ܣ�
 * 1.ɱ���ӽ���  void destroy();
 * 
 */
public class c2_Runtime {

	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("notepad.exe 1.txt");//����exec������Ҫ�׳����߲�׽�쳣���쳣ΪIOException(��������쳣)���ӵ�ǰ·����Path·������
//		r.exec("E:\\QQ\\Bin\\QQ.exe");//����дҲ�ǿ��Եģ������õ��Ǿ���·����ע�⣺\Ϊת�������\t���Ʊ��������������\\��Ϊ�ļ��ָ���
//		r.exec("notepad.exe 1.txt");//����д���������ǣ���ǰһ��exe���������һ���ļ�������Ҫע��������ƥ�䡣��palyer.exe  XX.avi
		Thread.sleep(5000);
		p.destroy();//ע�⣬destroyֻ��ɱ���Լ��Ľ��̣�������ɱ�������Ľ��̡�
	}

}
