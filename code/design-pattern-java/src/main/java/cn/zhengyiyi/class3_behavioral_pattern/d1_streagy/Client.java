package cn.zhengyiyi.class3_behavioral_pattern.d1_streagy;

/**
 * 策略模式
 *  定义：策略模式是一种行为设计模式，它允许一组算法在运行时互相替换，使得算法可以独立于使用它的客户端而变化。
 */

// 抽象策略
interface Strategy {
    void execute();
}

// 具体策略A
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategy A executed");
    }
}

// 具体策略B
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategy B executed");
    }
}

// 具体策略C
class ConcreteStrategyC implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategy C executed");
    }
}

// 上下文
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

public class Client {
    public static void main(String[] args) {
        // 创建具体策略对象
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        Strategy strategyC = new ConcreteStrategyC();

        // 创建上下文对象
        Context context = new Context(strategyA);

        // 使用策略A
        context.executeStrategy();

        // 更改策略为B
        context.setStrategy(strategyB);
        context.executeStrategy();

        // 更改策略为C
        context.setStrategy(strategyC);
        context.executeStrategy();
    }
}