package p2_����API֮����;

//���	ʵ�����Ĳ���Person�ķ��͹�����
import bean.Student;
import bean.Worker;
import ʵ��.����Person�ķ��͹�����;

public class c3_������ {

	public static void main(String[] args) {
		����Person�ķ��͹�����<Student> tool = new ����Person�ķ��͹�����<Student>(); // ��Student����EE��Ϊ����������������

		tool.setE(new Student("lihua", 19));
		// /tool.setE(new Worker()); //���˷���������ƣ����ﲻ���ٴ���Worker����ֱ�ӱ���
		Student stu = tool.getE(); // Ҳʡȥ��ǿת���鷳

		tool.show(4); // �������show(4),����Ϊ���Ͷ����ڷ����ϣ�ͬʱ������װ�䣬ʵ���ϴ������new Integer(4)
		// tool.print(4);	//���ﲻ��print(4)������Ϊʹ�õĲ�����EE����EE�Ѿ�ȷ���ˣ���Student���ٴ���Integer����ͻᱨ��
		// ͨ��������ӣ�Ҫ���׷��͵�ʵ��
		tool.method(new Integer(4));
	}

}
