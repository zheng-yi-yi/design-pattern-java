package cn.zhengyiyi.class1_creational_pattern.d3_singleton;

/**
 * 饿汉式单例模式
 */
public class T1Singleton {
    private static T1Singleton instance = new T1Singleton();

    private T1Singleton() {}

    public static T1Singleton getInstance() {
        return instance;
    }
}