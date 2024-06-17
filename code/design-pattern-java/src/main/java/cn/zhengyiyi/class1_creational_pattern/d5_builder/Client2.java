package cn.zhengyiyi.class1_creational_pattern.d5_builder;

/**
 * 流式建造者写法
 */
public class Client2 {
    static class Builder { // Builder
        private final Product product = new Product();

        public Builder buildPartA(String partA) {
            product.setPartA(partA);
            return this;
        }

        public Builder buildPartB(String partB) {
            product.setPartB(partB);
            return this;
        }

        public Product build() {
            return product;
        }
    }

    public static void main(String[] args) {
        Product product = new Builder()
                .buildPartA("Part A built")
                .buildPartB("Part B built")
                .build();
        System.out.println(product);
    }
}