package ʵ��;
/*�ýӿ���չ�ʼǱ����ܣ����պ����ʲô���ܲ���֪��
 * ����һ�������պ�����豸ֻҪ��������������������չ�ʼǱ��Ĺ���
 * ��java���������ͽ����ӿ�
 */

interface USB{  //�����ýӿڣ�Ϊ�Ժ��ܵ�������׼��(�ȶ������)
	public abstract void open();
	public abstract void close();
}

public class ���Խӿ�ʵ�ֹ��� {

	public static void main(String[] args) {
		//useUSB(null); 		//�ڽӿڻ�û�в���U�̻������ʱ����ʹ��USB�����Բ���Ϊnull
		useUSB(new Upan());	//�ӿڲ�����U�̣����Բ���Ϊ��Upan��ʵ�����󣬹��ܾ���չ��
	}
	public static void useUSB(USB u) {  //�ӿ����͵����ã�ָ��������ʵ�����Ķ���(��ʵ���Ƕ�̬�����潲)���൱��USB u=new Upan()
		u.open();
		u.close();
	}
}

//�����ǱʼǱ�����Ĺ���
class Upan implements USB{	//�����Ǻ�ʵ�ֵģ�����Ҫ���ϽӿڵĹ���(��ʵ�ֹ���)����������������Ե�����Ծͽ�����
	public void open() {
		System.out.println("U������");
	}
	public void close() {
		System.out.println("U�̰γ�");
	}
}
/*class USBMouse implements USB{  //��Ȼ���԰�USB��굱����չ�Ĺ���
	
}
*/
