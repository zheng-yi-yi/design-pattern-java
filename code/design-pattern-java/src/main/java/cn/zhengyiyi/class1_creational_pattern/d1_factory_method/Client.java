package cn.zhengyiyi.class1_creational_pattern.d1_factory_method;

// 抽象产品 - 电视机
interface Television {
    void play();
}

// 具体产品 - 海尔电视机
class HaierTelevision implements Television {
    public void play() {
        System.out.println("Playing Haier Television");
    }
}

// 具体产品 - 小米电视机
class XiaomiTelevision implements Television {
    public void play() {
        System.out.println("Playing Xiaomi Television");
    }
}

// 抽象工厂 - 电视机工厂
interface TelevisionFactory {
    Television createTelevision();
}

// 具体工厂 - 海尔电视机工厂
class HaierTelevisionFactory implements TelevisionFactory {
    public Television createTelevision() {
        return new HaierTelevision();
    }
}

// 具体工厂 - 小米电视机工厂
class XiaomiTelevisionFactory implements TelevisionFactory {
    public Television createTelevision() {
        return new XiaomiTelevision();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        TelevisionFactory haierFactory = new HaierTelevisionFactory();
        Television haierTelevision = haierFactory.createTelevision();
        haierTelevision.play();

        TelevisionFactory xiaomiFactory = new XiaomiTelevisionFactory();
        Television xiaomiTelevision = xiaomiFactory.createTelevision();
        xiaomiTelevision.play();
    }
}