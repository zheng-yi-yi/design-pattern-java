package cn.zhengyiyi.class3_behavioral_pattern.d4_observer;
/**
 * 观察者模式：
 *  观察者模式是一种行为设计模式， 允许一个对象将其状态的改变通知其他对象。
 */

import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    public abstract void update();
}

abstract class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyToAll() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteObserver extends Observer {
    private final String name;
    private final ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        String state = subject.getState();
        System.out.println(name + " received: " + state);
    }
}

class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyToAll();
    }
}

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Observer 1", subject);
        Observer observer2 = new ConcreteObserver("Observer 2", subject);
        Observer observer3 = new ConcreteObserver("Observer 3", subject);

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.setState("New state");
    }
}