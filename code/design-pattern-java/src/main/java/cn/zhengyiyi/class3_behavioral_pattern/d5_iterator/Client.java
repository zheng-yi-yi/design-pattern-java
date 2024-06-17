package cn.zhengyiyi.class3_behavioral_pattern.d5_iterator;

import java.util.Iterator;

// 聚合对象接口
interface Aggregate {
    Iterator<String> createIterator();
}

// 具体聚合对象
class ConcreteAggregate implements Aggregate {
    private final String[] items;

    public ConcreteAggregate(String[] items) {
        this.items = items;
    }

    @Override
    public Iterator<String> createIterator() {
        return new ConcreteIterator();
    }

    // 具体迭代器
    private class ConcreteIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public String next() {
            return hasNext() ? items[index++] : null;
        }
    }
}

public class Client {
    public static void main(String[] args) {
        String[] items = {"Apple", "Banana", "Cherry"};
        Aggregate aggregate = new ConcreteAggregate(items);
        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}