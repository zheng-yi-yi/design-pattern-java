package cn.zhengyiyi.class2_structural_pattern.d3_composite.safe;

import java.util.ArrayList;
import java.util.List;

// 组件接口
interface Component {
    void operation();
}

// 叶子节点
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// 组合节点
class Composite implements Component {
    private String name;
    private List<Component> components;

    public Composite(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite: " + name);
        for (Component component : components) {
            component.operation();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        // 创建根容器组件
        Composite university = new Composite("清华大学");

        // 创建子容器组件
        Composite computerCollege = new Composite("计算机学院");
        university.add(computerCollege);
        Composite infoEngineerCollege = new Composite("信息工程学院");
        university.add(infoEngineerCollege);

        // 创建叶子组件并添加到相应的容器组件
        computerCollege.add(new Leaf("软件工程系"));
        computerCollege.add(new Leaf("网络工程系"));
        computerCollege.add(new Leaf("计算机科学与技术系"));
        infoEngineerCollege.add(new Leaf("通信工程系"));
        infoEngineerCollege.add(new Leaf("电子工程系"));

        university.operation(); // 调用递归方法，遍历根容器组件
    }
}