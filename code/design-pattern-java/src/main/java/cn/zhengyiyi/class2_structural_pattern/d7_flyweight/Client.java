package cn.zhengyiyi.class2_structural_pattern.d7_flyweight;

import java.util.HashMap;
import java.util.Map;

// 抽象享元角色 - Flyweight
interface Flyweight {
    void operation(String externalState);
}

// 具体享元角色 - ConcreteFlyweight
class ConcreteFlyweight implements Flyweight {
    private final String intrinsicState; // 内部状态

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String externalState) {
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("External State = " + externalState);
    }
}

// 非共享具体享元角色 - UnsharedConcreteFlyweight
class UnsharedConcreteFlyweight implements Flyweight {
    private final String allState; // 所有状态

    public UnsharedConcreteFlyweight(String allState) {
        this.allState = allState;
    }

    @Override
    public void operation(String externalState) {
        System.out.println("All State = " + this.allState);
        System.out.println("External State = " + externalState);
    }
}

// 享元工厂角色 - FlyweightFactory
class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (flyweight == null) {
            // 如果对象不存在则创建一个新的Flyweight对象
            flyweight = new ConcreteFlyweight(key);
            // 把这个新的Flyweight对象添加到缓存中
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}


public class Client {
    public static void main(String[] args) {
        // 创建一个享元工厂
        FlyweightFactory factory = new FlyweightFactory();

        // 通过享元工厂获取两个享元对象
        Flyweight flyweight1 = factory.getFlyweight("A");
        Flyweight flyweight2 = factory.getFlyweight("A");

        // 检查这两个享元对象是否相同
        System.out.println(flyweight1 == flyweight2); // 输出：true

        // 使用享元对象
        flyweight1.operation("External State1");
        flyweight2.operation("External State2");

        // 获取并使用非共享的享元对象
        Flyweight unsharedFlyweight = new UnsharedConcreteFlyweight("All State");
        unsharedFlyweight.operation("External State3");
    }
}