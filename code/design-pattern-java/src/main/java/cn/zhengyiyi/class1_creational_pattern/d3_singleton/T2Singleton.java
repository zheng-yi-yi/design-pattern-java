package cn.zhengyiyi.class1_creational_pattern.d3_singleton;

/**
 * 懒汉式单例模式
 */
public class T2Singleton {
    private static T2Singleton instance;

    private T2Singleton() {}

    public static synchronized T2Singleton getInstance() {
        if (instance == null) {
            instance = new T2Singleton();
        }
        return instance;
    }
}