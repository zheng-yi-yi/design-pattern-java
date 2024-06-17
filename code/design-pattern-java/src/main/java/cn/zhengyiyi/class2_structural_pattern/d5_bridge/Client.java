package cn.zhengyiyi.class2_structural_pattern.d5_bridge;

/**
 * 桥接模式：
 *  将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 */

// Implementor
interface Color {
    void applyColor();
}

// ConcreteImplementor
class RedColor implements Color {
    public void applyColor(){
        System.out.println("red.");
    }
}

class BlueColor implements Color {
    public void applyColor(){
        System.out.println("blue.");
    }
}

// Abstraction
abstract class Shape {
    protected Color color;
    public Shape(Color color){
        this.color = color;
    }
    abstract public void applyColor();
}

// RefinedAbstraction
class Triangle extends Shape {
    public Triangle(Color color){
        super(color);
    }
    public void applyColor(){
        System.out.print("Triangle filled with color ");
        color.applyColor();
    } 
}

class Circle extends Shape {
    public Circle(Color color){
        super(color);
    }
    public void applyColor(){
        System.out.print("Circle filled with color ");
        color.applyColor();
    } 
}

public class Client {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape cir = new Circle(new BlueColor());
        cir.applyColor();
    }
}