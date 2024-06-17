package cn.zhengyiyi.class1_creational_pattern.d2_abstract_factory;

abstract class AbstractProductA {  //角色1：抽象产品（电视）
    public abstract void methodA();  //播放
}

class ConcreteProductA1 extends AbstractProductA {  //角色2：具体产品（如海尔电视）
    @Override
    public void methodA() {
        System.out.println("海尔电视机播放中......");
    }
}

class ConcreteProductA2 extends AbstractProductA {  //角色2：具体产品（如TCL电视）
    @Override
    public void methodA() {
        System.out.println("TCL电视机播放中......");
    }
}

abstract class AbstractProductB {   //角色1：抽象产品（空调）
    public abstract void methodB();  //调温
}

class ConcreteProductB1 extends AbstractProductB {  //角色2：具体产品（如海尔空调）
	@Override
    public void methodB() {
        System.out.println("海尔空调温度改变中......");
    }
}

class ConcreteProductB2 extends AbstractProductB {  //角色2：具体产品（TCL空调）
	@Override
    public void methodB() {
        System.out.println("TCL空调温度改变中......");
    }
}

abstract class AbstractFactory { //角色3：抽象工厂
    public abstract AbstractProductA createProductA(); //生产电视
    public abstract AbstractProductB createProductB(); //生产空调
}

class ConcreteFactory1 extends AbstractFactory {   //角色4：具体工厂（海尔）
    @Override
    public AbstractProductA createProductA() {
        System.out.println("海尔工厂生产海尔电视机");
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        System.out.println("海尔工厂生产海尔空调");
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {  //角色4：具体工厂（TCL）
    @Override
    public AbstractProductA createProductA() {
        System.out.println("TCL工厂生产TCL电视机");
        return new ConcreteProductA2();
    }
    @Override
    public AbstractProductB createProductB() {
        System.out.println("TCL工厂生产TCL空调");
        return new ConcreteProductB2();
    }
}

public class Client {   //客户端
    public static void main(String args[]) {
        // 创建海尔工厂
        AbstractFactory haierFactory = new ConcreteFactory1();
        // 使用海尔工厂创建产品
        AbstractProductA haierTV = haierFactory.createProductA();
        AbstractProductB haierAirConditioner = haierFactory.createProductB();
        // 使用海尔产品
        haierTV.methodA();
        haierAirConditioner.methodB();

        // 创建TCL工厂
        AbstractFactory tclFactory = new ConcreteFactory2();
        // 使用TCL工厂创建产品
        AbstractProductA tclTV = tclFactory.createProductA();
        AbstractProductB tclAirConditioner = tclFactory.createProductB();
        // 使用TCL产品
        tclTV.methodA();
        tclAirConditioner.methodB();
    }
}