package cn.zhengyiyi.class2_structural_pattern.d3_composite.transparent;

import java.util.ArrayList;
import java.util.List;

// 抽象构件，表示抽象的根结果
abstract class Component {
    protected String name;  // 组件名称

    public Component(String name) {  // 构造方法
        this.name = name;
    }

    protected abstract void operation();  // 业务方法
    protected void add(Component c) {  // 添加成员
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}

// 叶子构件
class Leaf extends Component {
    public Leaf(String name) {
        super(name);  // 调用父类构造方法
    }

    @Override
    protected void operation() {  // 打印组件名称
        System.out.println("Leaf: " + name);
    }
}

// 容器构件
class Composite extends Component {
    protected List<Component> components;

    public Composite(String name) { // 构造器
        super(name);
        components = new ArrayList<>();
    }

    @Override
    public void add(Component c) {  // 添加子组件
        components.add(c);
    }
    
    @Override
    protected void operation() {
        System.out.println("Composite: " + name);
        for (Component c : components) {  // 遍历子组件
            c.operation();  // 方法递归调用
        }
    }
}

public class Client {  // 客户端
    public static void main(String[] args) {
        // 创建根容器组件
        Component university = new Composite("清华大学");
        
        // 创建子容器组件
        Component computerCollege = new Composite("计算机学院");
        university.add(computerCollege);
        Component infoEngineerCollege = new Composite("信息工程学院");
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