package p6_�쳣;
/* �쳣��Ҫ���������߲�׽��������һ���ɡ�
 * �����ķ�ʽ�Ѿ�ѧ������throws�ؼ��֣���public int method(int[] arr,int index) throws FushuIndexException������������ķ���
 * �����ǲ�׽�ķ�����try-catch����顣
 */
/* �쳣����Ĳ�׽�����ǿ��Զ��쳣��������Դ���ķ�ʽ��
 * �����ʽ��
 * try{
 * 		��Ҫ������쳣�Ĵ���
 * }
 * catch(�쳣�� ����){
 * 		�����쳣�Ĵ���
 * }
 * finally{
 * 		һ���ᱻִ�еĴ���
 * }
 * ԭ���ϣ��ܴ������try�����ܴ�������ס�
 */
public class c2_�쳣��׽����� {
	public static void main(String[] args){
		int arr[]=new int[3];
		Errortry e=new Errortry();
		//try-catch�ṹ
		try{
			int num=e.method(arr,30);
			//int num=e.method(null, 30);
			System.out.println("num="+num);
		}
		catch(FushuIndexException f){//�൱�� FushuIndexException f = new FushuIndexException("�Ǳ�Ϊ��");
			System.out.println("�Ǳ긺��������");	//catch����飬ʹ�����쳣��Ϣ����δ�׳�������ִ���ڲ����룬Ȼ����������
			System.out.println("Message:"+f.getMessage());//ʹ���쳣f��Ч��
			System.out.println(f.toString());//ʹ���쳣f��Ч��
			System.out.println(f);//ʹ���쳣f��Ч������ʵ������f.toString()����
			f.printStackTrace();//jvmĬ�ϵ��쳣������ƾ����ڵ����쳣������������
		}
		//��catch
		catch (ArrayIndexOutOfBoundsException f) {//��catch��ʹ��,���ϵ��������ж��쳣�������Ƿ��뵱ǰcatch���ϡ������ϣ���ִ�и�catch�Ĵ���
			System.out.println(f);
			//return;	//��ʹcatch����return��finally�Ĵ���Ҳ��ִ��
			//System.exit(0);//������������룬��finally�Ĵ��벻��ִ�У���Ϊ���������������˳�jvm
		}
		catch (NullPointerException f) {
			System.out.println(f);
		}
		catch (Exception ee){	//һ��ɲ�д�����쳣�����Ҫд��һ��Ҫд�������棬��Ϊ�����쳣�ɽ���һ���쳣���������ʧ��
			System.out.println(ee);
		}
		//catch��finally֮�䲻���д���
		finally{	//finally��һ���ᱻִ�е��Ĵ��� ,ͨ�����ڹر�(�ͷ�)��Դ
			System.out.println("finally");
		}
		System.out.println("over");
	}
}
/* �쳣�����ԭ��
 * 1.�������������Ҫ�׳���Ҫ�����쳣����ô�����ϱ���Ҫ�������������Ҫ�ں�������try-catch��׽���������ʧ�ܡ�
 * 2.��������������������쳣��Ҫôtry-catchҪôthrows���������ʧ�ܡ�
 * 3.�������ݿ��Խ������catch��������ˣ���throws���ߵ����ߣ��õ����߽����
 * 4.һ����������׳�����쳣����ô����ʱ�������ж��catch��������ԵĴ���
 * 		�ڲ��м�����Ҫ�����쳣�����׼����쳣���׳���������catch������ 
 */
/* ���г�����try-catch-finally���
 * 1.try-catch-finally(����)
 * 2.try-catch(�ɶ��) ��û����Դ��Ҫ�ͷ�ʱ�����Բ�����finally
 * 3.try-finally (����)û��catch��������쳣�Ĵ���ʽ�Ǳ������׳�(û��ֱ�Ӵ���)�����������쳣�������ϵ�Ŀ���ǣ�Ҫ�ر���Դ(�ǳ���Ҫ)
 */