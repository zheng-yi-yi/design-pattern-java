package cn.zhengyiyi.class2_structural_pattern.d4_proxy.static_;

// Target接口
interface Target {
    void request();
}

// 实际对象类
class RealObject implements Target {
    @Override
    public void request() {
        System.out.println("RealObject is handling the request.");
    }
}

// 代理类
class ProxyObject implements Target {
    private final RealObject realObject;

    public ProxyObject() {
        this.realObject = new RealObject();
    }

    @Override
    public void request() {
        System.out.println("ProxyObject is preparing for the request.");
        realObject.request();
        System.out.println("ProxyObject is finishing the request.");
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Target target = new ProxyObject();
        target.request();
    }
}