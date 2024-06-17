package cn.zhengyiyi.class1_creational_pattern.d5_builder;
/**
 * 经典建造者写法
 */
class Product {// Product
    private String partA;
    private String partB;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                '}';
    }
}

interface Builder { // Builder
    void buildPartA();
    void buildPartB();
    Product getResult();
}

class ConcreteBuilder implements Builder { // ConcreteBuilder
    private Product product = new Product();

    public void buildPartA() {
        product.setPartA("Part A built");
    }

    public void buildPartB() {
        product.setPartB("Part B built");
    }

    public Product getResult() {
        return product;
    }
}

class Director { // Director
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getResult();
    }
}

public class Client1 {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}