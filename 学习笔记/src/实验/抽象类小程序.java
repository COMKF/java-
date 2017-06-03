package 实验;
/* 雇员示例：
 * 需求：公司中有程序员，属性有姓名，工号，薪水，工作能容
 * 项目经理属性有姓名，工号，薪水，工作能容，和奖金
 * 对给出需求进行建模
 * 
 * 分析：在这个问题中，先找出设计的对象。
 * 通过名词提炼法。
 * 程序员：
 * 		属性：姓名，工号，薪水
 * 		行为：工作
 * 项目经理：
 * 		属性：姓名，工号，薪水，奖金
 * 		行为：工作
 * 
 * 程序员和经理不存在着直接继承关系，但是程序员和经理却具有共性内容，可以进行抽取。
 * 因为他们都是公司的雇员，而雇员都具备姓名，工号，薪水等属性，这就可以进行抽取，建立体系。
 */
abstract class Employee{//先建立 雇员 类，这是个抽象类
	private String name;
	private String id;
	private double pay;
	Employee(String name,String id,double pay){
		this.name=name;
		this.id=id;
		this.pay=pay;
	}
	public abstract void work();
}

class Programmer extends Employee{//建立 程序员 类
	Programmer(String name,String id,double pay){
		super(name, id, pay);
	}
	public void work(){
		System.out.println("code...");
	}
}

class Manager extends Employee{//建立 项目经理 类
	private int bonus;
	Manager(String name,String id,double pay,int bonus){
		super(name, id, pay);
		this.bonus=bonus;
	}
	public void work(){
		System.out.println("manage...");
	}

}
public class 抽象类小程序 {
	public static void main(String[] args) {

	}

}
