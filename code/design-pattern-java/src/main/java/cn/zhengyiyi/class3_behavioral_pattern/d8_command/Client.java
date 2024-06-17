package cn.zhengyiyi.class3_behavioral_pattern.d8_command;

// 命令接口
interface Command {
    void execute();
}

// 具体命令
class ConcreteCommand implements Command {
    private final Receiver receiver;

    ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

// 请求者
class Invoker {
    private final Command command;

    Invoker(Command command) {
        this.command = command;
    }

    void call() {
        command.execute();
    }
}

// 接收者
class Receiver {
    void action() {
        System.out.println("执行请求！");
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}