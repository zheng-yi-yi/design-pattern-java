package cn.zhengyiyi.class2_structural_pattern.d4_proxy.dynamic_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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

// 动态代理处理器
class DynamicProxyHandler implements InvocationHandler {
    private final Object realObject;

    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxyHandler is preparing for the request.");
        Object result = method.invoke(realObject, args);
        System.out.println("DynamicProxyHandler is finishing the request.");
        return result;
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        Target proxy = (Target) Proxy.newProxyInstance(
            RealObject.class.getClassLoader(),
            RealObject.class.getInterfaces(),
            new DynamicProxyHandler(realObject)
        );
        proxy.request();
    }
}