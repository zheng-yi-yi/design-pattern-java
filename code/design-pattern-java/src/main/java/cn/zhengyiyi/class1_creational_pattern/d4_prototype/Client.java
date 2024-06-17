package cn.zhengyiyi.class1_creational_pattern.d4_prototype;

abstract class Prototype {  //角色1：抽象原型类Prototype
    protected String attribute;  //属性

    public Prototype(String attribute) { //构造器
        this.attribute = attribute;
    }

    public String getAttribute() {  //getter方法
        return attribute;
    }

    public abstract Prototype clone();  //抽象的克隆方法
}

class ConcretePrototypeA extends Prototype {  //角色2：具体原型类
    public ConcretePrototypeA(String attribute) {  //构造器
        super(attribute);  //调用父类的构造器
    }

    @Override
    public Prototype clone() {  //重写抽象的克隆方法
        //创建一个原型对象
        Prototype prototype = new ConcretePrototypeA(getAttribute());
        return prototype;  //返回一个原型对象
    }
}

class ConcretePrototypeB extends Prototype {
    public ConcretePrototypeB(String attribute) {
        super(attribute);
    }

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototypeB(getAttribute());
        return prototype;
    }
}

public class Client {
    static Prototype prototypeA, copyA;  //Client关联prototype
    static Prototype prototypeB, copyB;

    public static void main(String[] args) {
        prototypeA = new ConcretePrototypeA("原型对象A");
        copyA = prototypeA.clone();  //克隆原型对象
        System.out.println("原型对象：" + prototypeA.getAttribute());
        System.out.println("克隆对象：" + copyA.getAttribute());

        prototypeB = new ConcretePrototypeB("原型对象B");
        copyB = prototypeB.clone();
        System.out.println("原型对象：" + prototypeB.getAttribute());
        System.out.println("克隆对象：" + copyB.getAttribute());
    }
}