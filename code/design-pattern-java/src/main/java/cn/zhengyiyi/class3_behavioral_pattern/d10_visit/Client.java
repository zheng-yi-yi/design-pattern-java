package cn.zhengyiyi.class3_behavioral_pattern.d10_visit;

import java.util.ArrayList;
import java.util.List;

// 抽象访问者
interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

// 具体访问者A
class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitorA is visiting ConcreteElementA");
        element.operationA();
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitorA is visiting ConcreteElementB");
        element.operationB();
    }
}

// 具体访问者B
class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("ConcreteVisitorB is visiting ConcreteElementA");
        element.operationA();
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("ConcreteVisitorB is visiting ConcreteElementB");
        element.operationB();
    }
}

// 抽象元素
interface Element {
    void accept(Visitor visitor);
}

// 具体元素A
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() { // 具体操作A
        System.out.println("OperationA......");
    }
}

// 具体元素B
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() { // 具体操作B
        System.out.println("OperationB......");
    }
}

// 对象结构
class ObjectStructure {
    private final List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }

    public void remove(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());

        Visitor visitorA = new ConcreteVisitorA();
        objectStructure.accept(visitorA);
        System.out.println("=====================================");
        Visitor visitorB = new ConcreteVisitorB();
        objectStructure.accept(visitorB);
    }
}