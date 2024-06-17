package cn.zhengyiyi.class3_behavioral_pattern.d2_template_method;

abstract class AbstractClass {
    // 模板方法，用来控制算法的流程
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
    }

    // 基本方法，由子类实现
    protected abstract void primitiveOperation1();

    // 基本方法，由子类实现
    protected abstract void primitiveOperation2();
}

class ConcreteClass extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("具体类的操作1");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("具体类的操作2");
    }
}

public class Main {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}