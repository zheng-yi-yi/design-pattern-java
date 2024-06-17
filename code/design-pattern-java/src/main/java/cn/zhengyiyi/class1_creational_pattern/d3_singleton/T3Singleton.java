package cn.zhengyiyi.class1_creational_pattern.d3_singleton;

/**
 * 双重检查锁式单例模式
 */
public class T3Singleton {
    private volatile static T3Singleton instance;

    private T3Singleton() {}

    public static T3Singleton getInstance() {
        if (instance == null) {
            synchronized (T3Singleton.class) {
                if (instance == null) {
                    instance = new T3Singleton();
                }
            }
        }
        return instance;
    }
}