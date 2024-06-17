package cn.zhengyiyi.class3_behavioral_pattern.d9_chain;

// Handler: 定义处理请求的接口
interface Handler {
    void setNext(Handler handler);
    void handleRequest(String request);
}

// ConcreteHandler: 具体处理者1
class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if ("request1".equals(request)) {
            System.out.println("ConcreteHandler1 handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// ConcreteHandler: 具体处理者2
class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(String request) {
        if ("request2".equals(request)) {
            System.out.println("ConcreteHandler2 handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Client: 使用 Handler
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNext(handler2);

        handler1.handleRequest("request1");
        handler1.handleRequest("request2");
    }
}