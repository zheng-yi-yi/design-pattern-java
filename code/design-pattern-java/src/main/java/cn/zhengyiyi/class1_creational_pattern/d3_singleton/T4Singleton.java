package cn.zhengyiyi.class1_creational_pattern.d3_singleton;

/**
 * 静态内部类式单例模式
 */
public class T4Singleton {
    private static class SingletonHolder {
        private static final T4Singleton INSTANCE = new T4Singleton();
    }

    private T4Singleton() {}

    public static T4Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}