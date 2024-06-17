package cn.zhengyiyi.class2_structural_pattern.d2_adapter.class_;

/**
 * 类适配器模式
 * 要点：
 * 		1. 适配器模式是一种结构型设计模式，它使接口不兼容的对象能够相互合作。
 * 			适配器模式的关键是适配器类，它在接口之间起到转换的作用。
 */

//角色1：适配者类 (已有的、需要被适配的类)
class Adaptee {
	public void specificRequest() {
		System.out.println("Specific request...");
	}
}

//角色2：目标接口 (我们期望的接口)
interface Target {
	void request();
}

//角色3：适配器类 (继承了Adaptee并实现Target接口，解决接口不兼容的问题)
class Adapter extends Adaptee implements Target {
	@Override
	public void request() {
		super.specificRequest(); //调用基类方法
	}
}

public class Client {
	public static void main(String[] args) {
		Target adapter = new Adapter();  // 可选择不同类型的适配器
		adapter.request(); // 调用接口方法
	}
}