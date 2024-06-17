package cn.zhengyiyi.class2_structural_pattern.d2_adapter.object_;

/**
 * 对象适配器模式
 * 要点：
 * 			1. 适配器模式是一种结构型设计模式，它使接口不兼容的对象能够相互合作。
 * 				适配器模式的关键是适配器类，它在接口之间起到转换的作用。
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

//角色3：适配器类 (聚合Adaptee类，实现Target接口，解决接口不兼容的问题)
class Adapter implements Target {

	private Adaptee adaptee; // 持有一个 Adaptee 的实例

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.specificRequest(); // 调用成员对象的方法，实现接口兼容
	}
}


public class Client {
	public static void main(String[] args) {
		Target adapter = new Adapter(new Adaptee());
		adapter.request();
	}
}