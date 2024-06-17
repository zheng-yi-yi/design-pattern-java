package cn.zhengyiyi.class3_behavioral_pattern.d3_mediator;

/**
 * 中介者模式：
 *  中介者模式是一种行为设计模式，它允许你减少对象之间混乱无序的依赖关系。
 */

import java.util.ArrayList;
import java.util.List;

// 抽象中介者
interface Mediator {
    void register(Colleague colleague);

    void relay(Colleague colleague, String message);
}

// 具体中介者
class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void relay(Colleague colleague, String message) {
        for (Colleague c : colleagues) {
            if (!c.equals(colleague)) {
                c.receive(message);
            }
        }
    }
}

// 抽象同事类
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

// 具体同事类1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.relay(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague1 received: " + message);
    }
}

// 具体同事类
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.relay(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague2 received: " + message);
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new ConcreteMediator();
        // 创建同事对象
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        // 注册同事对象到中介者
        mediator.register(colleague1);
        mediator.register(colleague2);
        // 同事对象之间发送消息
        colleague1.send("Hello from Colleague1!");
        colleague2.send("Hi from Colleague2!");
    }
}