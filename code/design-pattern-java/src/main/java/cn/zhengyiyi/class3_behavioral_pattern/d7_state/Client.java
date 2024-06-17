package cn.zhengyiyi.class3_behavioral_pattern.d7_state;

/**
 * 状态模式：
 * 状态模式是一种行为设计模式， 允许对象在内部状态改变时改变它的行为。
 */
// 抽象状态类
interface TrafficLightState {
    void handle(TrafficLight trafficLight);
}

// 具体状态类：红灯
class RedLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("红灯，禁止通行");
        trafficLight.setState(new YellowLightState());
    }
}

// 具体状态类：黄灯
class YellowLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("黄灯，准备通行");
        trafficLight.setState(new GreenLightState());
    }
}

// 具体状态类：绿灯
class GreenLightState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("绿灯，可以通行");
        trafficLight.setState(new RedLightState());
    }
}

// 环境类
class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        this.state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 3; i++) {
            trafficLight.request();
        }
    }
}