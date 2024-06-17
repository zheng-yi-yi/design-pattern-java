package cn.zhengyiyi.class2_structural_pattern.d1_facade;

// 子系统A
class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA operation");
    }
}

// 子系统B
class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB operation");
    }
}

// 子系统C
class SubsystemC {
    public void operationC() {
        System.out.println("SubsystemC operation");
    }
}

// 外观类
class Facade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;
    private final SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    // 外观方法，封装了对子系统的操作
    public void facadeOperation() {
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        // 创建外观对象
        Facade facade = new Facade();
        // 客户端通过外观类调用子系统的操作
        facade.facadeOperation();
    }
}